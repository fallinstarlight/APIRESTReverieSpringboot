package com.example.apireverie.model.request;

import lombok.Data;

@Data
public class EmployeeRequest {
    private String name;
    private String surname;
    private String username;
    private String passwordHash;
    private String shift;
    private String phone;
    private String photo;
    private String role;


}