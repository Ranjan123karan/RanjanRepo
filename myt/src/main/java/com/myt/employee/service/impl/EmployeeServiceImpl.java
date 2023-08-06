package com.myt.employee.service.impl;

import com.myt.employee.entity.EmployeeEntity;
import com.myt.employee.exception.EmployeeException;
import com.myt.employee.model.Employee;
import com.myt.employee.repository.EmployeeRepository;
import com.myt.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Employee addEmpoyee(Employee employee) throws EmployeeException {
        // Create a new EmployeeEntity and set its properties using the data from the provided 'employee' parameter
        EmployeeEntity newEmployeeEntity = new EmployeeEntity();
        newEmployeeEntity.setEmpFirstName(employee.getEmpFirstName());
        newEmployeeEntity.setEmpLastName(employee.getEmpLastName());
        newEmployeeEntity.setEmpEmail(employee.getEmpEmail());
        // Set other properties if needed

        // Save the new EmployeeEntity to the database
        EmployeeEntity savedEmployeeEntity = employeeRepository.save(newEmployeeEntity);

        // Convert the saved EmployeeEntity back to an Employee object and return it
        Employee savedEmployee = new Employee();
        savedEmployee.setEmpId(savedEmployeeEntity.getEmpId());
        savedEmployee.setEmpFirstName(savedEmployeeEntity.getEmpFirstName());
        savedEmployee.setEmpLastName(savedEmployeeEntity.getEmpLastName());
        savedEmployee.setEmpEmail(savedEmployeeEntity.getEmpEmail());
        // Set other properties if needed

        return savedEmployee;
    }

    @Override
    public Employee updateEmpoyee(Employee employee) throws EmployeeException {
        Long empId = employee.getEmpId();
        Optional<EmployeeEntity> empOptional = employeeRepository.findById(empId);

        if (empOptional.isPresent()) {
            // If the employee exists, update its properties with the data from the provided 'employee' parameter
            EmployeeEntity existingEmployeeEntity = empOptional.get();
            existingEmployeeEntity.setEmpFirstName(employee.getEmpFirstName());
            existingEmployeeEntity.setEmpLastName(employee.getEmpLastName());
            existingEmployeeEntity.setEmpEmail(employee.getEmpEmail());
            // Set other properties if needed

            // Save the updated employee back to the database
            EmployeeEntity updatedEmployeeEntity = employeeRepository.save(existingEmployeeEntity);

            // Convert the updated EmployeeEntity back to an Employee object and return it
            Employee updatedEmployee = new Employee();
            updatedEmployee.setEmpId(updatedEmployeeEntity.getEmpId());
            updatedEmployee.setEmpFirstName(updatedEmployeeEntity.getEmpFirstName());
            updatedEmployee.setEmpLastName(updatedEmployeeEntity.getEmpLastName());
            updatedEmployee.setEmpEmail(updatedEmployeeEntity.getEmpEmail());
            // Set other properties if needed

            return updatedEmployee;
        } else {
            throw new EmployeeException("Employee with ID " + empId + " not found");
        }
    }

    @Override
    public Employee getEmployeeById(Long empId) throws EmployeeException {
        Optional<EmployeeEntity> empById = employeeRepository.findById(empId);
        if (empById.isPresent()) {
            EmployeeEntity employeeEntity = empById.get();
            Employee employee = new Employee();
            employee.setEmpId(employeeEntity.getEmpId());
            employee.setEmpFirstName(employeeEntity.getEmpFirstName());
            employee.setEmpLastName(employeeEntity.getEmpLastName());
            employee.setEmpEmail(employeeEntity.getEmpEmail());
            // Set other properties if needed

            return employee;
        } else {
            throw new EmployeeException("Employee with ID " + empId + " not found");
        }
    }

    @Override
    public void deleteEmployeeById(Long empId) throws EmployeeException {
        employeeRepository.deleteById(empId);

    }

    @Override
    public List<Employee> getAllEmployee() throws EmployeeException {

        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        List<Employee>employees=new ArrayList<>();
        for (EmployeeEntity empEntity:employeeEntities){
            Employee employee = new Employee();
            employee.setEmpFirstName(empEntity.getEmpFirstName());
            employee.setEmpLastName(empEntity.getEmpLastName());
            employee.setEmpEmail(empEntity.getEmpEmail());
            employees.add(employee);

        }
        return employees;

    }

    @Override
    public List<Employee> getEmployeeByFirstName(String firstName) {
        List<EmployeeEntity> employeeEntities = employeeRepository.findByEmpFirstNameLike(firstName);
        List<Employee>employees=new ArrayList<>();
        for (EmployeeEntity empEntity:employeeEntities){
            Employee employee = new Employee();
            employee.setEmpFirstName(empEntity.getEmpFirstName());
            employee.setEmpLastName(empEntity.getEmpLastName());
            employee.setEmpEmail(empEntity.getEmpEmail());
            employees.add(employee);
        }
        return employees;

    }
}
