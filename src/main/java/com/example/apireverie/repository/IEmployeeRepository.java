package com.example.apireverie.repository;

import com.example.apireverie.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

}
