package com.zappgo.ashish.module1_demo.controllers;

import com.zappgo.ashish.module1_demo.dto.EmployeeDTO;
import com.zappgo.ashish.module1_demo.entities.EmployeeEntity;
import com.zappgo.ashish.module1_demo.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RestController
public class EmployeeController {

    public final EmployeeService employeeService;

    EmployeeController (EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    List<EmployeeDTO> employeesList = new ArrayList<>();
    @GetMapping(path = "/get-secret-message")
    public ResponseEntity<String>  getMySuperSecretMessage () {
        return  new ResponseEntity<>("9089*_i29__" , HttpStatus.OK) ;
    }


    @GetMapping(path = "/employees")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees () {
        List<EmployeeDTO> l = employeeService.getALlEmployees();
//        return new ResponseEntity<>(l , HttpStatus.OK); older way
//        return ResponseEntity.ok(employeeService.getALlEmployees());
        return ResponseEntity.ok(l); // both are correct

    }

    @GetMapping(path = "/employees/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployeeById (@PathVariable Long employeeId) {
//      EmployeeDTO ne =  new EmployeeDTO(employeeId , "ashish" , "ashishsrivastava.bbdu@gmail.com" , 21 , LocalDate.of(2024 , 12 ,21) , true);
//      employeesList.add(ne);
        Optional<EmployeeDTO> employee = employeeService.getEmployeeById(employeeId);
        return employee
                .map(e -> ResponseEntity.ok(e))
                .orElseThrow(() -> new NoSuchElementException("No such employee found !"));
    }



    @PostMapping(path = "/add")
        public ResponseEntity<EmployeeDTO> addEmployee (@RequestBody @Valid EmployeeDTO employee) {
        EmployeeDTO e = employeeService.addEmployee(employee);
        return new ResponseEntity<>(e , HttpStatus.CREATED);
//       return employee;
//        Series Name:-Ayyana Mane

    }

    @PutMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> updateEmployeeById (@RequestBody EmployeeDTO employee , @PathVariable Long employeeId) {
       EmployeeDTO employeeDetails = employeeService.updateEmployeeById(employee , employeeId);
        return new ResponseEntity<>(employeeDetails , HttpStatus.OK);
    }

    @PatchMapping("/{employeeId}")
    public EmployeeDTO updatePartialUpdateById (@RequestBody Map<String , Object> updates , @PathVariable Long employeeId) {
        return employeeService.updatePartialUpdateById(updates , employeeId);
    }



}
