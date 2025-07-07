package com.example.sec;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data 
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequestDTO {

    
   @NotBlank(message="must share name")
    private String name;

    private String designation;
    
    private int age;
    private double salary;

  
}
