package com.example.apireverie.controller;

import com.example.apireverie.model.request.EmployeeRequest;
import com.example.apireverie.model.response.EmployeeResponse;
import com.example.apireverie.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private IEmployeeService iEmployeeService;

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeResponse>> getAllSubjects() {
        List<EmployeeResponse> employees = iEmployeeService.getEmployees();
        return ResponseEntity.ok(employees);
    }

    @PostMapping("/add")
    public ResponseEntity<String> createEmployee(@RequestBody EmployeeRequest request) {
        try {
            iEmployeeService.createEmployee(request);
            return ResponseEntity.status(HttpStatus.CREATED).body("Employee created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(
            @PathVariable int id,
            @RequestBody EmployeeRequest request
    ) {
        try {
            iEmployeeService.updateEmployee(id, request);
            return ResponseEntity.ok("Employee updated successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Integer id) {
        try {
            iEmployeeService.deleteEmployee(id);
            return ResponseEntity.ok("Employee deactivated successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}