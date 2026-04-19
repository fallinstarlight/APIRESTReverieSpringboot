package com.example.apireverie.repository;

import com.example.apireverie.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    /* Llama al procedimiento inEmployee de la base de datos */
    @Procedure(procedureName = "inEmployee")
    void insertEmployee(
            @Param("in_name") String name,
            @Param("in_surname") String surname,
            @Param("in_username") String username,
            @Param("in_passwordHash") String passwordHash,
            @Param("in_shift") String shift,
            @Param("in_phone") String phone,
            @Param("in_photo") String photo
    );
}