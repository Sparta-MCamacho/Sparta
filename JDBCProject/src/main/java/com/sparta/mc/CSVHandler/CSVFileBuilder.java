package com.sparta.mc.CSVHandler;

import com.sparta.mc.DataVerification.EmployeeTracker;
import com.sparta.mc.Employee;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVFileBuilder {

    String fileName;
    BufferedWriter bufferedWriter;

    //Constructor which sets the filePath to write to
    public CSVFileBuilder (String fileName) throws IOException {
        this.fileName = fileName;
        bufferedWriter = new BufferedWriter(new FileWriter(fileName, false));
    }

    //Writes a single record, with the message, to the specified filePath
    public void writeRecordToFile(Employee employee, String message) throws IOException{
        String record = employee.getEmployeeID() +
                "," + employee.getNamePrefix() +
                "," + employee.getFirstName() +
                "," + employee.getMiddleInitial() +
                "," + employee.getLastName() +
                "," + employee.getGender() +
                "," + employee.getEmail() +
                "," + employee.getDateOfBirth()+
                "," + employee.getDateOfJoining() +
                "," + employee.getSalary() +
                "," + message + "\n";
        bufferedWriter.write(record);
    }

    //Writes all records with messages from the EmployeeTracker to the file
    public void writeAllInvalidRecordsToFile() throws IOException{
        List<Employee> invalidEmployees = EmployeeTracker.getInvalidEmployees();
        List<String> messages = EmployeeTracker.getMessages();

        for (int i = 0;i < invalidEmployees.size();i++) {
            writeRecordToFile(invalidEmployees.get(i),messages.get(i));
        }

    }

    //Writes the csv String straight to the file
    public void writeStringRecordToFile(String record) throws IOException {
        bufferedWriter.write(record);
    }

    //Close the writer object
    public void close() throws IOException {
        bufferedWriter.close();
    }

}
