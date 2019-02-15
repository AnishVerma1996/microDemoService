package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Employee;
import com.app.service.EmployeeServiceImpl;

@RestController
public class EmployeeController {

		@Autowired
		private EmployeeServiceImpl employeeServiceImpl;
		@PostMapping(value="/save")
		public ResponseEntity<String> saveEmployee(@RequestBody Employee e)
		{
			
	        boolean b=employeeServiceImpl.AddEmp(e);
	        if(b)
	        {
	        
	        	return new ResponseEntity<>("Save SucessFully",HttpStatus.OK);
	        }
	        else
	        
	        return new ResponseEntity<>("Unsucessfully",HttpStatus.BAD_REQUEST);
		}
		@GetMapping(value="/get")
		public List<Employee> ListEmployees(ModelMap  map)
		{
			
			List<Employee> list=employeeServiceImpl.AllEmp();
	        return list;	
			
		}

		@DeleteMapping(value="/delete/{eid}")
		public ResponseEntity<String> deleteEmployee(@RequestParam int eid)
		{
			Boolean b=employeeServiceImpl.DeleteEmp(eid);
			if(b)
			{
			
				return new ResponseEntity<>("Delete  Emp Successfully",HttpStatus.OK);
			}
			else
			{
				
				return new ResponseEntity<>("Not Delete  Successfully",HttpStatus.BAD_REQUEST);
			}
			
		}
		@PutMapping(value="/edit")
		public ResponseEntity<String> UpdateEmployee(@RequestBody Employee e)
		{
			boolean b=employeeServiceImpl.UpdateEmp(e);
			if(b)
			{
				return new ResponseEntity<>("Successfully Updated",HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<>("Not Updated",HttpStatus.BAD_REQUEST);
			}
		}
	}


