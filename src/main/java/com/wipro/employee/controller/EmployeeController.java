package com.wipro.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.employee.entity.Employee;
import com.wipro.employee.service.EmployeeService;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "http://localhost:5174")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    // CREATE
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {

        return employeeService.addEmployee(employee);
    }


    // READ ALL
    @GetMapping
    public List<Employee> getAllEmployees() {

        return employeeService.getAllEmployees();
    }


    // READ BY ID
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {

        return employeeService.getEmployeeById(id);
    }


    // UPDATE
    @PutMapping("/{id}")
    public Employee updateEmployee(
            @PathVariable int id,
            @RequestBody Employee employee) {

        return employeeService.updateEmployee(id, employee);
    }


    // DELETE
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {

        employeeService.deleteEmployee(id);

        return "Employee deleted successfully";
    }


    // SEARCH BY DEPARTMENT
    @GetMapping("/department/{department}")
    public List<Employee> getByDepartment(
            @PathVariable String department) {

        return employeeService.getEmployeesByDepartment(department);
    }


    // SALARY GREATER THAN
    @GetMapping("/salary/{salary}")
    public List<Employee> getBySalary(
            @PathVariable double salary) {

        return employeeService.getEmployeesBySalary(salary);
    }


    // CUSTOM QUERY
    @GetMapping("/high-salary")
    public List<Employee> getHighSalaryEmployees() {

        return employeeService.getHighSalaryEmployees();
    }
}