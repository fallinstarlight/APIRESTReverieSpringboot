package com.example.apireverie.controller;

import com.example.apireverie.model.response.EmployeeResponse;
import com.example.apireverie.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;

    /* Ruta para obtener a todos los empleados,GET:  localhost:8080/employees/all*/
    /* Devuelve una lista con todos los empleados que haya en la base de datps */
    @GetMapping("/all")
    public ResponseEntity<List<EmployeeResponse>> getAllSubjects() {
        List<EmployeeResponse> employees = iEmployeeService.getEmployees();
        return ResponseEntity.ok(employees);
    }
}
