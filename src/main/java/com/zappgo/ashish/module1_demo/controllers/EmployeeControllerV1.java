package com.zappgo.ashish.module1_demo.controllers;

import com.zappgo.ashish.module1_demo.dto.EmployeeDTO;
import com.zappgo.ashish.module1_demo.entities.EmployeeEntity;
import com.zappgo.ashish.module1_demo.repositories.EmployeeRepository;
import com.zappgo.ashish.module1_demo.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee-v1")
public class EmployeeControllerV1 {
    private final EmployeeService employeeService;


    public EmployeeControllerV1 (EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/{employeeId}")
    public Optional<EmployeeEntity> getEmployeeById (@PathVariable Long employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    @GetMapping("/list")
    public List<EmployeeEntity> getALlEmployees () {
        return employeeService.getALlEmployees();
    }

    @PostMapping("/add")
    public void addEmployee (@RequestBody EmployeeEntity employee) {
        employeeService.addEmployee(employee);
    }


}
