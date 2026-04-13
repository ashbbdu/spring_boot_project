package com.zappgo.ashish.module1_demo.controllers;

import com.zappgo.ashish.module1_demo.dto.EmployeeDTO;
import com.zappgo.ashish.module1_demo.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

    public final EmployeeService employeeService;

    EmployeeController (EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    List<EmployeeDTO> employeesList = new ArrayList<>();
    @GetMapping(path = "/get-secret-message")
    public String getMySuperSecretMessage () {
        return "9089*_i29__";
    }


    @GetMapping(path = "/employees")
    public List<EmployeeDTO> getAllEmployees () {
        return employeeService.getALlEmployees();
    }

    @GetMapping(path = "/employees/{employeeId}")
    public EmployeeDTO getEmployeeById (@PathVariable Long employeeId) {
//      EmployeeDTO ne =  new EmployeeDTO(employeeId , "ashish" , "ashishsrivastava.bbdu@gmail.com" , 21 , LocalDate.of(2024 , 12 ,21) , true);
//      employeesList.add(ne);
      return employeeService.getEmployeeById(employeeId);
    }

    @PostMapping(path = "/add")
    public EmployeeDTO addEmployee (@RequestBody EmployeeDTO employee) {
       return employeeService.addEmployee(employee);
//       return employee;
//        Series Name:-Ayyana Mane

    }

    @PutMapping(path = "/{employeeId}")
    public EmployeeDTO updateEmployeeById (@RequestBody EmployeeDTO employee , @PathVariable Long employeeId) {
       return employeeService.updateEmployeeById(employee , employeeId);
    }
}
