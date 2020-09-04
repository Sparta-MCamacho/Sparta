package com.sparta.mc.EmployeeDAO;

import com.sparta.mc.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {

    boolean insertEmployee(Employee employee) throws SQLException;
    boolean insertAllEmployees(List<Employee> employees) throws  SQLException;
    public boolean insertEmployeesBetweenTwoIndexes(List<Employee> employees, int index1, int index2) throws SQLException;
}
