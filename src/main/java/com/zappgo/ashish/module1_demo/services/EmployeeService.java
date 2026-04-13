package com.zappgo.ashish.module1_demo.services;

import com.zappgo.ashish.module1_demo.dto.EmployeeDTO;
import com.zappgo.ashish.module1_demo.entities.EmployeeEntity;
import com.zappgo.ashish.module1_demo.repositories.EmployeeRepository;
import org.apache.catalina.mapper.Mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }





    public EmployeeDTO getEmployeeById (Long employeeId) {
        EmployeeEntity employee = employeeRepository.findById(employeeId).orElse(null);
//        ModelMapper model = new ModelMapper();
//        return model.map(employee , EmployeeDTO.class); // commented this because we have created a config class
        return modelMapper.map(employee , EmployeeDTO.class);

    }



    public EmployeeDTO addEmployee (EmployeeDTO employee) {
//        first change the DTO to Entity and then save
        EmployeeEntity emp = modelMapper.map(employee , EmployeeEntity.class);
        EmployeeEntity savedEmp =  employeeRepository.save(emp);
        return modelMapper.map(savedEmp , EmployeeDTO.class);
    }

    public List<EmployeeDTO> getALlEmployees () {
        List<EmployeeEntity> employees = employeeRepository.findAll();
        return  employees.stream().map(employee -> modelMapper.map(employee , EmployeeDTO.class))
                .collect(Collectors.toList());


    }
}
