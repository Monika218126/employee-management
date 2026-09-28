package com.wipro.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wipro.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // Find employees by department
    List<Employee> findByDepartment(String department);

    // Find employees whose salary is greater than given value
    List<Employee> findBySalaryGreaterThan(double salary);

    // JPQL query
    @Query("SELECT e FROM Employee e WHERE e.salary > 30000")
    List<Employee> findHighSalaryEmployees();

}