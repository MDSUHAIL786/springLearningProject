package com.personal.emsp.das.entity;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "first_name")
    private String firstName;


    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;


//    @Size(min = 8, message = "Password must be of more than equal to 8 characters")
    @Column(name = "password")
    private String password;
}
