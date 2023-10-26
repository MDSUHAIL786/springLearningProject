package com.personal.emsp.das;

import com.personal.emsp.das.entity.Employee;

import java.util.List;

public interface EmployeeDataAccessService {

    int insertEmployee(Employee emp);
    int updateEmployee(Employee updatedEmp);
    Boolean deleteEmployee(int id);
    Employee getEmployee(int id);
    List<Employee> getAllEmployees();
}

