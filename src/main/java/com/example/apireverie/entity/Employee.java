package com.example.apireverie.entity;

import jakarta.persistence.*;
import lombok.Data;

/* Tabla de empleados, basada en la vista de vwEmployee en la base de datos */
@Data
@Entity
@Table(name="vwEmployee")
public class Employee {
    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "Name", nullable = false, length = 50)
    private String name;

    @Column(name = "Total Sales", nullable = false,length = 50)
    private Float totalSales;

    @Column(name = "Today Sales", length = 50)
    private Float todaySales;

    @Column(name = "Photo", length = 255)
    private String profilePhoto;

    @Column(name = "Role", nullable = false, length = 20)
    private String role;

    @Column(name = "Shift", nullable = false, length = 30)
    private String shift;
}
