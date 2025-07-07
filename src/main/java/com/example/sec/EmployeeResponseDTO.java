package com.example.sec;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseDTO {
    
    private String name;
    private String designation;
    private int age;
    private double salary;

    
}
