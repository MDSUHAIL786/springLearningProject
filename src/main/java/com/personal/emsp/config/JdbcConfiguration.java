package com.personal.emsp.config;

import com.personal.emsp.das.EmployeeDataAccessService;
import com.personal.emsp.das.impl.EmployeeDataAccessServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class JdbcConfiguration {

    @Bean(name={"ds"})
    public DataSource getDataSource(){
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/sys?autoReconnect=true&useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("9091");
        return dataSource;
    }

    @Bean(name = {"jdbcTemplate"})
    public JdbcTemplate getJdbcTemplate(){
        return new JdbcTemplate(this.getDataSource());
    }

    @Bean("dataAccessService")
    public EmployeeDataAccessService getEmployeeDataAccessServiceImpl(){
        return new EmployeeDataAccessServiceImpl(this.getJdbcTemplate());
    }
}
