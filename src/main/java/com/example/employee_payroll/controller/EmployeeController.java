package com.example.employee_payroll.controller;

import com.example.employee_payroll.model.Employee;
import com.example.employee_payroll.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")

public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    // GET All Employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    // GET Employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST Create New Employee
    @PostMapping
    public Employee createEmployee(@RequestBody Employee emp) {
        return repository.save(emp);
    }

    // PUT Update Employee
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee empDetails) {
        return repository.findById(id).map(emp -> {
            emp.setName(empDetails.getName());
            emp.setSalary(empDetails.getSalary());
            return ResponseEntity.ok(repository.save(emp));
        }).orElse(ResponseEntity.notFound().build());
    }

    // DELETE Employee
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable Long id) {
        return repository.findById(id).map(emp -> {
            repository.delete(emp);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }


}
