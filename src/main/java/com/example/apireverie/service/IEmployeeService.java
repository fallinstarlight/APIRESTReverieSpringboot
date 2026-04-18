package com.example.apireverie.service;

import com.example.apireverie.model.response.EmployeeResponse;

import java.util.List;

public interface IEmployeeService {
    List<EmployeeResponse> getEmployees();
}
