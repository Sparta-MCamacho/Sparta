package com.sparta.mc.EmployeeDAO;

import com.sparta.mc.DataVerification.EmployeeTracker;
import com.sparta.mc.Employee;

import java.sql.*;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO{

    Connection connection;
    Statement statement;

    //Public constructor which
    public EmployeeDAOImpl(String databaseAddress, String username, String password) throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql:" + databaseAddress + "?serverTimezone=GMT", username, password);
        statement = connection.createStatement();
    }


    //Will insert an Employee into the database
    //Method wil expect the Employee to be already validated and in correct form
    public boolean insertEmployee(Employee employee) throws SQLException {

        try {

            //Generating the SQL command ot insert the new row
            String sqlCommand = "INSERT INTO Employees VALUES ("
                    + employee.getEmployeeID() + ", '"
                    + employee.getNamePrefix() + "', '"
                    + employee.getFirstName() + "', '"
                    + employee.getMiddleInitial() + "', '"
                    + employee.getLastName() + "', '"
                    + employee.getGender() + "', '"
                    + employee.getEmail() + "', '"
                    + employee.getDateOfBirth() + "', '"
                    + employee.getDateOfJoining() + "', "
                    + employee.getSalary()
                    +")";


            //Executing the SQL command on the specified database
            statement.executeUpdate(sqlCommand);
            EmployeeTracker.addValidEmployee(employee);
            EmployeeTracker.incrementValidEmployeeCount();
        } catch (SQLIntegrityConstraintViolationException e) {
            EmployeeTracker.addInvalidEmployee(employee, "Duplicate Primary Key value in database");
            return false;
        }  catch (Exception e) {
            EmployeeTracker.addInvalidEmployee(employee, e.getMessage());
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean insertEmployeesBetweenTwoIndexes(List<Employee> employees, int index1, int index2) throws SQLException{
        for (int i = index1;i < index2;i++) {
            insertEmployee(employees.get(i));
        }
        return true;
    }

    //Method which can insert all validated employees in a list to the database
    public boolean insertAllEmployees(List<Employee> employeeList) throws SQLException{
        for (Employee employee: employeeList) {
            insertEmployee(employee);
        }
        return true;
    }

}
