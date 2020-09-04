package com.sparta.mc.Concurrency;

import com.sparta.mc.Employee;
import com.sparta.mc.EmployeeDAO.EmployeeDAO;

import java.util.List;

public class SQLThread extends Thread{

    EmployeeDAO employeeDAO;
    List<Employee> employeeList;
    int firstIndex;
    int secondIndex;

    public SQLThread(EmployeeDAO employeeDAO, List<Employee> employeeList, int firstIndex, int secondIndex) {
        this.employeeDAO = employeeDAO;
        this.employeeList = employeeList;
        this.firstIndex = firstIndex;
        this.secondIndex = secondIndex;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.getName()+" has started adding records");
            employeeDAO.insertEmployeesBetweenTwoIndexes(employeeList, firstIndex, secondIndex);
            System.out.println(this.getName()+" has finished adding records");

        } catch (Exception e) {

        }
        SQLThreadManager.incrementThreadCount();
    }
}
