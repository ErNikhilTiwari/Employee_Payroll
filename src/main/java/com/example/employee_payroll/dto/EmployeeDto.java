package com.example.employee_payroll.dto;

public class EmployeeDto {

    private String name;
    private String salary;

    public EmployeeDto() {
    }

    public EmployeeDto(String name, String salary) {
        this.name = name;
        this.salary = salary;
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




}
