package com.sparta.mc.DataVerification;

import com.sparta.mc.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeTracker {

    private static int validEmployeeCount = 0;
    private static List<Employee> validEmployees = new ArrayList<>();
    private static List<Employee> invalidEmployees = new ArrayList<>();
    private static List<String> messages = new ArrayList<>();

    private EmployeeTracker() {

    }

    public synchronized static void addValidEmployee(Employee validEmployee) {
        validEmployees.add(validEmployee);
    }

    public synchronized static void addInvalidEmployee(Employee invalidEmployee, String message) {
        invalidEmployees.add(invalidEmployee);
        messages.add(message);
    }

    public synchronized static void incrementValidEmployeeCount() {
        validEmployeeCount++;
    }

    public static List<Employee> getInvalidEmployees() {
        return invalidEmployees;
    }

    public static List<Employee> getValidEmployees() { return validEmployees; }

    public static List<String> getMessages() {
        return messages;
    }

    public static int getValidEmployeeCount() {
        return validEmployeeCount;
    }

}
