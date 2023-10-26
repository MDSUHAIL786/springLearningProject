package com.personal.emsp.das.rowMapper;

import com.personal.emsp.das.entity.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


//rowMapper is used to map the resultset to the entity class need to implement RowMapper interface with the entity class
public class EmployeeRowMapper implements RowMapper<Employee> {


    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee emp=new Employee();
        emp.setId(rs.getInt(1));                //setting the values from the resultset to the entity class by giving the column number
        emp.setFirstName(rs.getString(2));
        emp.setLastName(rs.getString(3));
        emp.setEmail(rs.getString(4));
        emp.setPassword(rs.getString(5));

        //we can set the values by giving the column name also like following
        //emp.setId(rs.getInt("id"));
        //emp.setFirstName(rs.getString("firstName"));


        return emp;
    }
}
