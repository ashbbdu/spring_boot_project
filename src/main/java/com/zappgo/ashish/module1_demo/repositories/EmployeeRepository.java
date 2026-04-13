package com.zappgo.ashish.module1_demo.repositories;


import com.zappgo.ashish.module1_demo.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface EmployeeRepository extends JpaRepository<EmployeeEntity , Long> {


}

