package com.example.sec;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;


@RestController

public class Controller {

    @Autowired
    private ServiceImp service;
    
    @GetMapping
    public List<EmployeeResponseDTO> getAllEmployees() {
   
    
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeResponseDTO getEmployee(@PathVariable int id) {
        return service.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    public EmployeeResponseDTO updateEmployee(@PathVariable int id, @RequestBody EmployeeRequestDTO emp) {
        return service.updateEmployee(id, emp);
    }
  @PostMapping("/employees")
public ResponseEntity<EmployeeResponseDTO> createEmployee(@Valid @RequestBody EmployeeRequestDTO dto) {
    EmployeeResponseDTO response = service.addEmployee(dto);
    return ResponseEntity.ok(response);
}


    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id) {
        
        service.deleteEmployee(id);
    }
}
