package com.example.employee_payroll.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    private String name;
    private String salary;

    public void setId(Long id) {
        this.employeeId = id;
    }

    public Long getId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSalary() {
        return salary;
    }
    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Employee() {
    }

    public Employee(Long id, String name, String salary) {
        this.employeeId = id;
        this.name = name;
        this.salary = salary;
    }


}
