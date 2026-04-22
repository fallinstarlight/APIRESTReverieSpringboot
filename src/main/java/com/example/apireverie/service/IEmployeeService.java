package com.example.apireverie.service;

import com.example.apireverie.model.request.EmployeeRequest;
import com.example.apireverie.model.response.EmployeeResponse;

import java.util.List;

public interface IEmployeeService {
    List<EmployeeResponse> getEmployees();
    void createEmployee(EmployeeRequest request);
    void updateEmployee(int id, EmployeeRequest request);
    void deleteEmployee(Integer id);
}