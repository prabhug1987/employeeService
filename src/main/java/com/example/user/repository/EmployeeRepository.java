package com.example.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.user.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
