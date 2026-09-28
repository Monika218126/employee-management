package com.wipro.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.employee.entity.Employee;
import com.wipro.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    // CREATE
    public Employee addEmployee(Employee employee) {

        return employeeRepository.save(employee);
    }


    // READ ALL
    public List<Employee> getAllEmployees() {

        return employeeRepository.findAll();
    }


    // READ BY ID
    public Employee getEmployeeById(int id) {

        return employeeRepository.findById(id).orElse(null);
    }


    // UPDATE
    public Employee updateEmployee(int id, Employee employee) {

        Employee existingEmployee =
                employeeRepository.findById(id).orElse(null);

        if (existingEmployee == null) {
            return null;
        }

        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setSalary(employee.getSalary());
        existingEmployee.setDepartment(employee.getDepartment());

        return employeeRepository.save(existingEmployee);
    }


    // DELETE
    public void deleteEmployee(int id) {

        employeeRepository.deleteById(id);
    }


    // SEARCH BY DEPARTMENT
    public List<Employee> getEmployeesByDepartment(String department) {

        return employeeRepository.findByDepartment(department);
    }


    // SEARCH BY SALARY
    public List<Employee> getEmployeesBySalary(double salary) {

        return employeeRepository.findBySalaryGreaterThan(salary);
    }


    // CUSTOM QUERY
    public List<Employee> getHighSalaryEmployees() {

        return employeeRepository.findHighSalaryEmployees();
    }
}