package com.sparta.mc;

import com.sparta.mc.DataVerification.EmployeeVerifier;

public class Scratch {

    public static void main(String[] args) {

        String dateOfBirth = "2018/09/16";
        String dateOfJoin = "2018/09/15";
        String test = "444";
        String name = "name@gmail.co.uk";
        String csvLine = "198429,Mrs.,Serafina,I,Bumgarner,F,serafina.bumgarner@exxonmobil.com,9/21/1982,02/01/2008,69294";
        String[] split = csvLine.split(",");
        String[] employeeDetails = EmployeeVerifier.verifyEmployeeData(split);

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


        System.out.println(employee.toString());
        System.out.println(EmployeeVerifier.hasNoNullFields(employee));

    }

}
