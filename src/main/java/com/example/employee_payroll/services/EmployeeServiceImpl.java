package com.example.employee_payroll.services;

import com.example.employee_payroll.dto.EmployeeDto;
import com.example.employee_payroll.model.Employee;
import com.example.employee_payroll.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    private EmployeeDto mapToDTO(Employee emp) {
        EmployeeDto dto = new EmployeeDto();
        dto.setName(emp.getName());
        dto.setSalary(emp.getSalary());
        dto.setGender(emp.getGender());
        dto.setStartDate(emp.getStartDate());
        return dto;
    }

    private Employee mapToEntity(EmployeeDto dto) {
        Employee emp = new Employee();
        emp.setName(dto.getName());
        emp.setSalary(dto.getSalary());
        emp.setGender(dto.getGender());
        emp.setStartDate(dto.getStartDate());
        return emp;
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto dto) {
//        log.info("Created Employee");
//        return mapToDTO(repository.save(mapToEntity(dto)));

        if(dto.getSalary() < 0 || dto.getName()==null){
            log.error("Failed to add employee");
            return null;
        }
        else {
            log.info("Employee added successfully");

        }
        return mapToDTO(repository.save(mapToEntity(dto)));

    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        return repository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        return repository.findById(id).map(this::mapToDTO).orElse(null);
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto dto) {
        return repository.findById(id).map(emp -> {
            emp.setName(dto.getName());
            emp.setSalary(dto.getSalary());
            return mapToDTO(repository.save(emp));
        }).orElse(null);
    }

    @Override
    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }


}
