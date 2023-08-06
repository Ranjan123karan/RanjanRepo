package com.myt.employee.model;

import lombok.Data;

@Data
public class Employee {
    private Long empId;
    private String empFirstName;
    private String empLastName;
    private String empEmail;
}
