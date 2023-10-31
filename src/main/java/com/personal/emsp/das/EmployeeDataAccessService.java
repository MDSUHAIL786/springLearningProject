package com.personal.emsp.das;

import com.personal.emsp.das.entity.Birds;

import java.util.List;

public interface EmployeeDataAccessService {

    int insertEmployee(Birds emp);
    int updateEmployee(Birds updatedEmp);
    Boolean deleteEmployee(int id);
    Birds getEmployee(int id);
    List<Birds> getAllEmployees();
}

