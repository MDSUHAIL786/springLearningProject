package com.personal.emsp.das.impl;

import com.personal.emsp.das.EmployeeDataAccessService;
import com.personal.emsp.das.entity.Employee;
import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDataAccessServiceImpl implements EmployeeDataAccessService {

    public JdbcTemplate jdbcTemplate;

    public EmployeeDataAccessServiceImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertEmployee(Employee emp){
        String qry="insert into employee values(?,?,?,?,?)";
        return jdbcTemplate.update(qry,emp.getId(),emp.getFirstName(),emp.getLastName(),emp.getEmail(),emp.getPassword());
    }

    @Override
    public int updateEmployee(Employee emp) {
        String qry = "update employee set firstName=?,lastName=?,email=?,password=? where id=?";
        return jdbcTemplate.update(qry,emp.getFirstName(),emp.getLastName(),emp.getEmail(),emp.getPassword(),emp.getId());   //returning the number of rows affected
    }

    @Override
    public Boolean deleteEmployee(int id) {
        String qry="delete from employee where id=?";
        return jdbcTemplate.update(qry,id)==1;
    }
}
