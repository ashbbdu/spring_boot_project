package com.zappgo.ashish.module1_demo.controllers;

import com.zappgo.ashish.module1_demo.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {


    List<EmployeeDTO> employeesList = new ArrayList<>();
    @GetMapping(path = "/get-secret-message")
    public String getMySuperSecretMessage () {
        return "9089*_i29__";
    }


    @GetMapping(path = "/employees")
    public List<EmployeeDTO> getAllEmployees () {
        return employeesList;
    }

    @GetMapping(path = "/employees/{employeeId}")
    public List<EmployeeDTO> getEmployeeById (@PathVariable Long employeeId) {
      EmployeeDTO ne =  new EmployeeDTO(employeeId , "ashish" , "ashishsrivastava.bbdu@gmail.com" , 21 , LocalDate.of(2024 , 12 ,21) , true);
      employeesList.add(ne);
      return employeesList;
    }

    @PostMapping(path = "/add-employee")
    public EmployeeDTO addEmployee (@RequestBody EmployeeDTO employee) {
        employeesList.add(employee);
        return employee;
    }
}
