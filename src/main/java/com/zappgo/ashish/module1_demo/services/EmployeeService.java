package com.zappgo.ashish.module1_demo.services;

import com.zappgo.ashish.module1_demo.entities.EmployeeEntity;
import com.zappgo.ashish.module1_demo.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    EmployeeService (EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Optional<EmployeeEntity> getEmployeeById (Long employeeId) {
        return employeeRepository.findById(employeeId);
    }

    public void addEmployee (EmployeeEntity employee) {
        employeeRepository.save(employee);
    }

    public List<EmployeeEntity> getALlEmployees () {
        return employeeRepository.findAll();
    }
}
