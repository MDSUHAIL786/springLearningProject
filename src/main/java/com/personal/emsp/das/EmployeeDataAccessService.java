package com.personal.emsp.das;

import com.personal.emsp.das.entity.Employee;

public interface EmployeeDataAccessService {

    public int insertEmployee(Employee emp);
    public int updateEmployee(Employee updatedEmp);
    public Boolean deleteEmployee(int id);
}

