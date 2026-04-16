package com.zappgo.ashish.module1_demo.services;

import com.zappgo.ashish.module1_demo.dto.EmployeeDTO;
import com.zappgo.ashish.module1_demo.entities.EmployeeEntity;
import com.zappgo.ashish.module1_demo.repositories.EmployeeRepository;
import org.apache.catalina.mapper.Mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }





//    public EmployeeDTO getEmployeeById (Long employeeId) {
////        EmployeeEntity employee = employeeRepository.findById(employeeId).orElse(null);
////        ModelMapper model = new ModelMapper();
////        return model.map(employee , EmployeeDTO.class); // commented this because we have created a config class
////        return modelMapper.map(employee , EmployeeDTO.class);
//
//        EmployeeEntity employee = employeeRepository.findById(employeeId)
//                .orElseThrow(() -> new RuntimeException("Employee not found"));
//
//        return modelMapper.map(employee, EmployeeDTO.class);
//    }

//updated function of above function
public Optional<EmployeeDTO> getEmployeeById (Long employeeId) {

    Optional<EmployeeEntity> employee = employeeRepository.findById(employeeId);

    return employee.map(e -> modelMapper.map(e , EmployeeDTO.class));
}



    public EmployeeDTO addEmployee (EmployeeDTO employee) {
//        first change the DTO to Entity and then save
        EmployeeEntity emp = modelMapper.map(employee , EmployeeEntity.class);
        EmployeeEntity savedEmp =  employeeRepository.save(emp);
        return modelMapper.map(savedEmp , EmployeeDTO.class);
    }

    public List<EmployeeDTO> getALlEmployees () {
        List<EmployeeEntity> employees = employeeRepository.findAll();
        return employees.stream().map(employee -> modelMapper.map(employee , EmployeeDTO.class))
                .collect(Collectors.toList());

    }

    public EmployeeDTO updateEmployeeById(EmployeeDTO employee, Long employeeId) {
//    handling exception here not in the contoller for this service
        EmployeeEntity currentEmployee = employeeRepository.findById(employeeId).orElseThrow(() ->  new NoSuchElementException("Employee Not Found !"));
        currentEmployee.setName(employee.getName());
        currentEmployee.setEmail(employee.getEmail());
        currentEmployee.setAge(employee.getAge());
//        currentEmployee.isActive(employee.getActive()); look this why this is not working
        currentEmployee.setDateOfJoining(employee.getDateOfJoining());

       EmployeeEntity updatedEmployee =  employeeRepository.save(currentEmployee);

       return modelMapper.map(updatedEmployee , EmployeeDTO.class);

    }

    public EmployeeDTO updatePartialEmployeeById(Long employeeId, Map<String, Object> updates) {
     

        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId).get();

        updates.forEach((field, value) -> {
            Field fieldToBeUpdated = ReflectionUtils.findField(EmployeeEntity.class, field);
            fieldToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldToBeUpdated, employeeEntity, value);
        });

        return modelMapper.map(employeeRepository.save(employeeEntity), EmployeeDTO.class);
    }

    public EmployeeDTO updatePartialUpdateById(Map<String, Object> updates, Long employeeId) {
        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId).get();

        updates.forEach((field, value) -> {
            Field fieldToBeUpdated = ReflectionUtils.findField(EmployeeEntity.class, field);
            fieldToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldToBeUpdated, employeeEntity, value);
        });

        return modelMapper.map(employeeRepository.save(employeeEntity), EmployeeDTO.class);
    }
}
