package com.example.apireverie.repository;

import com.example.apireverie.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Modifying
    @Transactional
    @Query(value = "CALL updateEmployee(:id, :name, :surname, :username, :passwordHash, :shift, :phone, :photo, :role)", nativeQuery = true)
    void updateEmployee(
            @Param("id") int id,
            @Param("name") String name,
            @Param("surname") String surname,
            @Param("username") String username,
            @Param("passwordHash") String passwordHash,
            @Param("shift") String shift,
            @Param("phone") String phone,
            @Param("photo") String photo,
            @Param("role") String role
    );

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM employees WHERE employee_id = :id", nativeQuery = true)
    void deactivateEmployee(@Param("id") Integer id);

    @Query(value = "SELECT employee_id AS ID, " +
            "CONCAT(e_name, ' ', e_surname) AS Name, " +
            "e_totalSales AS 'Total Sales', " +
            "e_todaySales AS 'Today Sales', " +
            "e_profilePhoto AS Photo, " +
            "e_role AS Role, " +
            "e_shift AS Shift " +
            "FROM employees WHERE state = 'alive'", nativeQuery = true)
    List<Employee> findActiveEmployees();
}