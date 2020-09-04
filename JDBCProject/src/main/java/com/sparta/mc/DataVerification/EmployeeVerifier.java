package com.sparta.mc.DataVerification;

import com.sparta.mc.Employee;

public class EmployeeVerifier {

    public static String[] verifyEmployeeData(String[] employeeData) {

        employeeData[0] = verifyEmployeeID(employeeData[0]);
        employeeData[1] = verifyPrefix(employeeData[1]);
        employeeData[2] = verifyName(employeeData[2]);
        employeeData[3] = verifyMiddleIndex(employeeData[3]);
        employeeData[4] = verifyName(employeeData[4]);
        employeeData[5] = verifyGender(employeeData[5]);
        employeeData[6] = verifyEmail(employeeData[6]);
        employeeData[7] = verifyDateOfBirth(employeeData[7]);
        employeeData[8] = verifyDateOfJoining(employeeData[8]);
        employeeData[9] = verifySalary(employeeData[9]);

        return employeeData;
    }

    //Verifies that the employeeID is correct, returns null otherwise
    public static String verifyEmployeeID(String employeeID) {

        if (employeeID.matches("^[0-9]*$")) {
            try {
                int employeeId = Integer.parseInt(employeeID);
            } catch (Exception e) {
                System.err.println(e.getMessage());
                return null;
            }

        }
        return employeeID;
    }

    public static String verifyPrefix(String prefix) {

        if (!prefix.equals("Mr.") && !prefix.equals("Mrs.")
                && !prefix.equals("Hon.") && !prefix.equals("Prof.")
                && !prefix.equals("Dr.") && !prefix.equals("Ms.")
                && !prefix.equals("Drs.")) {
            return null;
        }

        return prefix;
    }

    public static String verifyName(String name) {
        if ( name.toLowerCase().matches("[a-zA-Z]+") ) {
            char[] nameCharArray = name.toLowerCase().toCharArray();
            nameCharArray[0] = Character.toUpperCase(nameCharArray[0]);
            name = new String(nameCharArray);
            return name;
        }
        return null;
    }

    public static String verifyMiddleIndex(String middleIndex) {

        if ( middleIndex.toUpperCase().matches("[a-zA-Z]+") && middleIndex.length() == 1) {
            return middleIndex.toUpperCase();
        }

        return null;
    }

    public static String verifyGender(String gender) {

        if (gender.equals("M") || gender.equals("F")) {
            return gender;
        }

        return null;
    }

    public static String verifyEmail(String email) {

        String[] splitEmail = email.split("@");
        if (splitEmail.length == 2) {
            if (splitEmail[0].replace(".", "").matches("[a-zA-Z0-9]+") &&
                    splitEmail[0].replace(".", "").matches("[a-zA-Z0-9]+")) {
                return email;
            }
        }

        return null;
    }

    public static String verifyDateOfBirth(String dateOfBirth) {
        String[] dateInfo = dateOfBirth.split("/");
        if (dateInfo[1].length() == 1) {
            dateInfo[1] = "0" + dateInfo[1];
        }
        if (dateInfo[0].length() == 1) {
            dateInfo[0] = "0" + dateInfo[0];
        }

        return dateInfo[2]+"/"+dateInfo[0]+"/"+dateInfo[1];
    }

    public static String verifyDateOfJoining(String dateOfJoining) {
        String[] dateInfo = dateOfJoining.split("/");
        if (dateInfo[1].length() == 1) {
            dateInfo[1] = "0" + dateInfo[1];
        }
        if (dateInfo[0].length() == 1) {
            dateInfo[0] = "0" + dateInfo[0];
        }

        return dateInfo[2]+"/"+dateInfo[0]+"/"+dateInfo[1];
    }

    public static boolean verifyOrderOfDates(String dateOfBirth, String dateOfJoining) {
        return dateOfBirth.compareTo(dateOfJoining) < 0;
    }

    //Verifies that the salary contains only numerics, returns null otherwise
    public static String verifySalary(String salary) {

        if (salary.matches("^[0-9]*$")) {
            try {
                int employeeId = Integer.parseInt(salary);
            } catch (Exception e) {
                return null;
            }

        }
        return salary;
    }

    public static boolean hasNoNullFields(Employee employee) {
        return (employee.getEmployeeID() != null &&
                employee.getNamePrefix() != null &&
                employee.getFirstName() != null &&
                employee.getMiddleInitial() != null &&
                employee.getLastName() != null &&
                employee.getGender() != null &&
                employee.getEmail() != null &&
                employee.getDateOfBirth() != null &&
                employee.getDateOfJoining() != null &&
                employee.getSalary() != null);
    }

}
