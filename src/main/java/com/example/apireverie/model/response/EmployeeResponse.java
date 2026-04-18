package com.example.apireverie.model.response;

import lombok.Data;

@Data
public class EmployeeResponse {
/* Valores que se devuelven en la respuesta*/
    private Integer ID;
    private String Name;
    private Float totalSales;
    private Float todaySales;
    private String Role;
    private String Shift;
    private String Photo;
}
