package com.example.sec;

import java.util.List;

public interface EmpService {
    List<EmployeeResponseDTO> getAllEmployees();
    EmployeeResponseDTO getEmployeeById(int id);
    EmployeeResponseDTO addEmployee(EmployeeRequestDTO emp);
    EmployeeResponseDTO updateEmployee(int id, EmployeeRequestDTO emp);
     EmployeeResponseDTO postupdateEmployee(int id, EmployeeRequestDTO emp);
    void deleteEmployee(int id);
}
