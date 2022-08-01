package com.springboot.tutorial.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.tutorial.entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	
}
