package com.myt.employee.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "EMPLOYEE")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EMP_ID")
    private Long empId;
    @Column(name = "EMP_FIRST_NAME")
    private String empFirstName;
    @Column(name = "EMP_LAST_NAME")
    private String empLastName;
    @Column(name = "EMP_EMAIL")
    private String empEmail;

}
