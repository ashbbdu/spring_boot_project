package com.zappgo.ashish.module1_demo.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

//ConstraintValidator will take EmployeeRoleValidation which is the interface/ the Name of annotation second is the type of field which you want to validate
public class EmployeeRoleValidator implements ConstraintValidator<EmployeeRoleValidation , String> {
    @Override
    public boolean isValid(String inputRole, ConstraintValidatorContext constraintValidatorContext) {
        List<String> roles = List.of("ADMIN" , "USER");
        return roles.contains(inputRole);
    }
}
