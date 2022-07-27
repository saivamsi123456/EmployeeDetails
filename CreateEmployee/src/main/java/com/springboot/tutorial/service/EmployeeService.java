package com.springboot.tutorial.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.springboot.tutorial.entity.Employee;
public interface EmployeeService {

	void importToDb(List<MultipartFile> multipartfiles);
	List<Employee> listAll();

 	Employee saveEmployee(Employee emp);
	Employee updateEmployee(Employee emp);
	String deleteEmployee(Integer id);
}
