package com.example.employee_payroll.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Entity
public @Data class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    private String name;
    private double salary;
    private String gender;
    private LocalDate startDate;

//    public void setId(Long id) {
//        this.employeeId = id;
//    }
//
//    public Long getId() {
//        return employeeId;
//    }
//    public String getName() {
//        return name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
//    public String getSalary() {
//        return salary;
//    }
//    public void setSalary(String salary) {
//        this.salary = salary;
//    }

    // default constructor
    public Employee() {
    }

//    parameterised constructor
    public Employee(Long id, String name, double salary, String gender, LocalDate startDate) {
        this.employeeId = id;
        this.name = name;
        this.salary = salary;
        this.gender = gender;
        this.startDate = startDate;
    }


}
