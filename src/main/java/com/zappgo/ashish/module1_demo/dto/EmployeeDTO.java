package com.zappgo.ashish.module1_demo.dto;

import com.zappgo.ashish.module1_demo.annotations.EmployeeRoleValidation;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;
@Data
public class EmployeeDTO {
    private Long id;
    @NotNull(message = "Name is required !")
    private String name;
    private String email;
    private Integer age;

    @PastOrPresent(message = "Date of joining can not be in future")
    private LocalDate dateOfJoining;
    private Boolean isActive;

    @NotBlank(message = "Role is required !")
//    @Pattern(regexp = "^(ADMIN|USER)$" , message = "Role of Employee can be ADMIN or USER ")
    @EmployeeRoleValidation
    private String role;

    @NotNull
    @Digits(integer = 6 , fraction = 2)
    @Positive(message = "Should be greater than 0")
    private Double salary;

//    public EmployeeDTO () {
//
//    }
//
//
//    public EmployeeDTO(Long id, String name, String email, Integer age, LocalDate dateOfJoining, Boolean isActive , String role , Double salary) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//        this.age = age;
//        this.dateOfJoining = dateOfJoining;
//        this.isActive = isActive;
//        this.role = role;
//        this.salary = salary;
//
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//
//    public LocalDate getDateOfJoining() {
//        return dateOfJoining;
//    }
//
//    public void setDateOfJoining(LocalDate dateOfJoining) {
//        this.dateOfJoining = dateOfJoining;
//    }
//
//    public Boolean getActive() {
//        return isActive;
//    }
//
//    public void setActive(Boolean active) {
//        isActive = active;
//    }
//
//    public String getRole() {
//        return role;
//    }
//
//    public void setRole(String role) {
//        this.role = role;
//    }
//
//    public Double getSalary() {
//        return salary;
//    }
//
//    public void setSalary(Double salary) {
//        this.salary = salary;
//    }

}
