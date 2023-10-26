package com.personal.emsp.das.impl;

import com.personal.emsp.das.EmployeeDataAccessService;
import com.personal.emsp.das.entity.Employee;
import com.personal.emsp.das.rowMapper.EmployeeRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

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

    @Override
    public Employee getEmployee(int id) {
        String qry= "select * from employee where id=?";
        return jdbcTemplate.queryForObject(qry,new EmployeeRowMapper(),id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        String qry= "select * from employee";
        return jdbcTemplate.query(qry,new EmployeeRowMapper());    }
}
