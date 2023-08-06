package com.myt.employee.controller;

import com.myt.employee.model.Employee;
import com.myt.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee){
       return  employeeService.addEmpoyee(employee);


    }
    @GetMapping("/getallemployee")
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }
    @GetMapping("/employee/{empId}")
    public Employee getEmployeeById(@PathVariable("empId") Long empId){
        return employeeService.getEmployeeById(empId);
    }
    @PutMapping("/update/{empId}")
    public Employee updateEmployeeById(@RequestBody Employee employee ){
         return employeeService.updateEmpoyee(employee);
    }
    @DeleteMapping("/delete/{empId}")
    public void deleteEmployeeById(@PathVariable("empId") Long empId){
        employeeService.deleteEmployeeById(empId);
    }

    @GetMapping("/getemployeebyfirstname")
    public List<Employee> getEmployeeByFirstName(@RequestParam("firstName") String firstName){
        return employeeService.getEmployeeByFirstName(firstName);
    }

}
