package com.app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.app.entity.Employee;

public interface EmployeeService {
	
	
	public String saveData(Employee emp);
	
	
	public List<Employee> showAll();

}
