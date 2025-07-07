package com.example.sec;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
@EnableScheduling
@Service
public class ServiceImp implements EmpService {

    private static final Logger log =LoggerFactory.getLogger(ServiceImp.class);
  
    @Autowired
    private Res repo;

    @Override
    @Scheduled(initialDelay=22000)
    public List<EmployeeResponseDTO> getAllEmployees() {
//         log.info("fetching data");
//         log.error("error not came ");
//         log.warn("just warning");
//         log.debug("Received DTO: {}");
// log.trace("Detailed trace for DTO conversion logic");
        return repo.findAll().stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeResponseDTO getEmployeeById(int id) {
        return convertToResponseDTO(
            repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"))
        );
    }

    @Override
    public EmployeeResponseDTO addEmployee(EmployeeRequestDTO dto) {
        Employee emp = new Employee();
        emp.setName(dto.getName());
        emp.setAge(dto.getAge());
        emp.setDesignation(dto.getDesignation());
        emp.setSalary(dto.getSalary());
        emp.setTimeLine("EMP" + System.currentTimeMillis());
        log.info("Service started");
log.debug("Received DTO: {}", dto);
log.trace("Detailed trace for DTO conversion logic");
        Employee saved = repo.save(emp);
        return convertToResponseDTO(saved);
    }

    @Override
    public EmployeeResponseDTO updateEmployee(int id, EmployeeRequestDTO dto) {
        Employee existingEmp = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        existingEmp.setName(dto.getName());
        existingEmp.setAge(dto.getAge());
        existingEmp.setDesignation(dto.getDesignation());
        existingEmp.setSalary(dto.getSalary());
     existingEmp.setTimeLine("EMP" + System.currentTimeMillis());
        Employee updated = repo.save(existingEmp);
        return convertToResponseDTO(updated);
    }

    @Override
    public EmployeeResponseDTO postupdateEmployee(int id, EmployeeRequestDTO dto) {
        Employee existingEmp = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        if (dto.getName() != null)
            existingEmp.setName(dto.getName());
        if (dto.getAge() > 0)
            existingEmp.setAge(dto.getAge());
        if (dto.getDesignation() != null)
            existingEmp.setDesignation(dto.getDesignation());
        if (dto.getSalary() > 0)
            existingEmp.setSalary(dto.getSalary());
        existingEmp.setTimeLine("EMP" + System.currentTimeMillis());
        Employee updated = repo.save(existingEmp);
        return convertToResponseDTO(updated);
    }

    @Override
    public void deleteEmployee(int id) {
        repo.deleteById(id);
    }

    // ✅ Helper method to convert Entity to ResponseDTO
    private EmployeeResponseDTO convertToResponseDTO(Employee emp) {
        // Update the constructor arguments to match EmployeeResponseDTO's definition
                // Use the available constructor: EmployeeResponseDTO(String name, String designation, int age)
                return new EmployeeResponseDTO(
                    emp.getName(),
                    emp.getDesignation(),
                    emp.getAge(),emp.getSalary()
                );
    }

}