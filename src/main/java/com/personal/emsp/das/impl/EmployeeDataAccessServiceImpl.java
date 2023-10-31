package com.personal.emsp.das.impl;

import com.personal.emsp.das.EmployeeDataAccessService;
import com.personal.emsp.das.entity.Birds;
import com.personal.emsp.das.rowMapper.EmployeeRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("employeeDataAccessService")
public class EmployeeDataAccessServiceImpl implements EmployeeDataAccessService {

    @Autowired
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
    public int insertEmployee(Birds emp){
        String qry="insert into employee values(?,?,?,?,?)";
        return jdbcTemplate.update(qry,emp.getId(),emp.getFirstName(),emp.getLastName(),emp.getEmail(),emp.getPassword());
    }

    @Override
    public int updateEmployee(Birds emp) {
        String qry = "update employee set firstName=?,lastName=?,email=?,password=? where id=?";
        return jdbcTemplate.update(qry,emp.getFirstName(),emp.getLastName(),emp.getEmail(),emp.getPassword(),emp.getId());   //returning the number of rows affected
    }

    @Override
    public Boolean deleteEmployee(int id) {
        String qry="delete from employee where id=?";
        return jdbcTemplate.update(qry,id)==1;
    }

    @Override
    public Birds getEmployee(int id) {
        String qry= "select * from employee where id=?";
        return jdbcTemplate.queryForObject(qry,new EmployeeRowMapper(),id);
    }

    @Override
    public List<Birds> getAllEmployees() {
        String qry= "select * from employee";
        return jdbcTemplate.query(qry,new EmployeeRowMapper());    }
}
