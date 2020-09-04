package com.sparta.mc.CSVHandler;

import com.sparta.mc.DataVerification.EmployeeTracker;
import com.sparta.mc.DataVerification.EmployeeVerifier;
import com.sparta.mc.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDTO {

    private List<Employee> employeeList;

    //Empty constructor to initialise the ArrayList
    public EmployeeDTO() {
        employeeList = new ArrayList<Employee>();
    }

    //Creates a new Employee object and adds it to the ArrayList from a csv line
    public void addEmployeeFromCSV(String csvLine) {
        //Emp ID,Name Prefix,First Name,Middle Initial,Last Name,Gender,E Mail,Date of Birth,Date of Joining,Salary
        String[] unVerifiedEmployeeDetails = csvLine.split(",");
        String[] employeeDetails = EmployeeVerifier.verifyEmployeeData(unVerifiedEmployeeDetails);

        Employee employee = new Employee();
        employee.setEmployeeID(employeeDetails[0]);
        employee.setNamePrefix(employeeDetails[1]);
        employee.setFirstName(employeeDetails[2]);
        employee.setMiddleInitial(employeeDetails[3]);
        employee.setLastName(employeeDetails[4]);
        employee.setGender(employeeDetails[5]);
        employee.setEmail(employeeDetails[6]);
        employee.setDateOfBirth(employeeDetails[7]);
        employee.setDateOfJoining(employeeDetails[8]);
        employee.setSalary(employeeDetails[9]);

        if (!EmployeeVerifier.verifyOrderOfDates(employeeDetails[7], employeeDetails[8])) {
            EmployeeTracker.addInvalidEmployee(employee, "Date of joining comes before date of birth");
        } else {
            boolean correctData = true;
            for (String data : employeeDetails) {
                if (data == null) {
                    EmployeeTracker.addInvalidEmployee(employee, "One of the data values did meet the criteria");
                    correctData = false;
                }
            }
            if (correctData) {
                employeeList.add(employee);
            }

        }

    }

    //Returns the employeeList so far
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

}
