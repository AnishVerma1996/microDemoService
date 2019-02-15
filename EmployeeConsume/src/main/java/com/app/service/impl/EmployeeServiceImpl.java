package com.app.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.app.entity.Employee;
import com.app.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private String url="http://localhost:4343/";
	
	public String saveData(Employee emp)
	{
		
		
		RestTemplate 	restTemplate=new RestTemplate();
		 HttpEntity<Employee> employee=new HttpEntity<Employee>(emp);
		 ResponseEntity<String> entity= restTemplate.exchange(url+"save",HttpMethod.POST,employee,String.class);
		 String response=entity.getBody();
		
		return response;
	}


	public List<Employee> showAll() {
		RestTemplate rest=new RestTemplate();
		Employee[] allempolyeedata=  rest.getForObject(url+"get",Employee[].class);
		return Arrays.asList(allempolyeedata);
	}
	
	

}
