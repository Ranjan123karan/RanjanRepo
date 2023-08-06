package com.myt.employee.service;

import com.myt.employee.exception.EmployeeException;
import com.myt.employee.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmpoyee(Employee employee)  throws EmployeeException;
    Employee updateEmpoyee(Employee employee)throws EmployeeException;
    Employee getEmployeeById(Long empId)throws EmployeeException;
    void deleteEmployeeById(Long empId)throws EmployeeException;
    List<Employee> getAllEmployee()throws EmployeeException;

    List<Employee> getEmployeeByFirstName(String firstName);
}
