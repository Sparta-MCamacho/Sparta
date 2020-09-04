package com.sparta.mc;

import com.sparta.mc.CSVHandler.CSVFileBuilder;
import com.sparta.mc.CSVHandler.CSVReader;
import com.sparta.mc.CSVHandler.EmployeeDTO;
import com.sparta.mc.Concurrency.SQLThread;
import com.sparta.mc.Concurrency.SQLThreadManager;
import com.sparta.mc.DataVerification.EmployeeTracker;
import com.sparta.mc.DataVerification.PropertiesReader;
import com.sparta.mc.EmployeeDAO.EmployeeDAOImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class ComponentController {

    private static final Logger logger = LogManager.getLogger(ComponentController.class);
    private static int numberOfThreads = 10;
    private static PropertiesReader properties;

    public static void beginCSVMigration() {

        try {
            //Reading properties details from Properties file
            properties = new PropertiesReader();
            logger.info("Successfully read from properties files");

            //Initialising all objects needed for migration
            CSVReader csvReader = new CSVReader(properties.getCsvFilePath());
            logger.info("Reader object has been set up to the file path: " + csvReader.getFilePath());
            CSVFileBuilder csvFileBuilder = new CSVFileBuilder("src/main/resources/InvalidEmployees.csv");
            EmployeeDTO employeeDTO = new EmployeeDTO();
            EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl(properties.getDatabaseAddress(),
                    properties.getUsername(), properties.getPassword());
            logger.info("Connection to "+properties.getDatabaseAddress()+" has been successful with username: "
                    +properties.getUsername()+" and password: "+properties.getPassword());


            //Start migration from .csv file to Java objects
            long timeFromCSVToJava = migrateFromCSVToJava(csvReader, employeeDTO);
            logger.info("Migrated from CSV to Java in: " + (double) timeFromCSVToJava/1000000 + " milliseconds");


            //Start migration from Java objects to the SQL database
            logger.info("Attempting to migrate " + employeeDTO.getEmployeeList().size() + " records to the SQL database");
            long timeFromJavaToSQL = migrateThreadedJavaToSQL(properties, employeeDTO);
            logger.info("Migrated "+EmployeeTracker.getValidEmployeeCount()+" records from Java to SQL in: "+(double) timeFromJavaToSQL/1000000+" milliseconds");
            logger.info("Number of invalid records are: " + EmployeeTracker.getInvalidEmployees().size());


            //Writing all records which could not be migrated to a csv file
            csvFileBuilder.writeAllInvalidRecordsToFile();
            logger.info("FileWriter object wrote "+EmployeeTracker.getInvalidEmployees().size()+" records which were unable to be migrated");


            //Closing reader and writer objects
            csvReader.close();
            csvFileBuilder.close();

            logger.info("Migration complete");

        } catch (ArrayIndexOutOfBoundsException e) {
            logger.fatal("Properties file does not have correct structure or has missing information");
            logger.info("Migration failed");
        } catch (SQLException e) {
            logger.fatal("Could not connect to "+properties.getDatabaseAddress()+" with username: "+properties.getUsername()+" and password: "+properties.getPassword());
            logger.info("Migration failed");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static long migrateThreadedJavaToSQL(PropertiesReader propertiesReader, EmployeeDTO employeeDTO) {

        long startTime = System.nanoTime();

        try {
            startTime = System.nanoTime();

            List<Employee> employees = employeeDTO.getEmployeeList();
            if (employees.size() < numberOfThreads) {
                logger.info("Performing migration process using 1 thread");
                EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl(propertiesReader.getDatabaseAddress(),
                        propertiesReader.getUsername(), propertiesReader.getPassword());
                employeeDAO.insertAllEmployees(employeeDTO.getEmployeeList());
            } else {
                logger.info("Performing migration process using "+numberOfThreads+" threads");
                int[] indexes = getPartitionIndexes(employees.size());
                for (int i = 0;i < numberOfThreads;i++) {
                    EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl(propertiesReader.getDatabaseAddress(),
                            propertiesReader.getUsername(), propertiesReader.getPassword());
                    SQLThread sqlThread = new SQLThread(employeeDAO, employees, indexes[i], indexes[i+1]);

                    sqlThread.start();
                }

                while(SQLThreadManager.getThreadCount() < numberOfThreads) {
                    Thread.sleep(50);
                }

                System.out.println("All Threads have terminated");
            }

            long runTime = System.nanoTime() - startTime;
            return runTime;
        } catch (Exception e) {

        }
        return (System.nanoTime() - startTime);

    }

    public static long migrateFromJavaToSQL(EmployeeDAOImpl employeeDAO, EmployeeDTO employeeDTO) {
        long startTime = System.nanoTime();

        try {
            startTime = System.nanoTime();
            employeeDAO.insertAllEmployees(employeeDTO.getEmployeeList());
            long runTime = System.nanoTime() - startTime;
            return runTime;
        } catch (Exception e) {

        }
        return (System.nanoTime() - startTime);
    }

    public static long migrateFromCSVToJava(CSVReader csvReader, EmployeeDTO employeeDTO) {
        //Note the start time of the method and initialise a holder variable for the incoming data
        long startTime = System.nanoTime();
        String nextEmployee;

        try {
            startTime = System.nanoTime();

            //Read all lines from csv and add them to the arrayList
            while ((nextEmployee = csvReader.getNextCSVLine()) != null) {
                employeeDTO.addEmployeeFromCSV(nextEmployee);
            }

            long runTime = System.nanoTime() - startTime;

            return runTime;
        } catch (Exception e) {

        }

        return (System.nanoTime() - startTime);
    }

    public static int[] getPartitionIndexes(int length) {
        int[] partitionIndexes = new int[numberOfThreads+1];
        partitionIndexes[0] = 0;

        int remainder = length % numberOfThreads;
        int counter = 1;
        int blockLength = length/numberOfThreads;

        for (int i = 1;i <= numberOfThreads;i++) {
            if (counter >= remainder) {
                partitionIndexes[i] = blockLength*i + (remainder);
            } else {
                partitionIndexes[i] = blockLength*i + (counter);
                counter++;
            }

        }

        return partitionIndexes;
    }


}
