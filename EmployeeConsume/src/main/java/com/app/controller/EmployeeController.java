package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.entity.Employee;
import com.app.service.EmployeeService;

@Controller
public class EmployeeController {
   
	private String url="http://localhost:4343/";
	
	@Qualifier("employeeServiceImpl")
	@Autowired
	private EmployeeService employeeServiceImpl;
	
	
	@RequestMapping(value="/saveEmp")
	public ModelAndView saveEmp(@ModelAttribute Employee emp)
	{
		
	 String response=employeeServiceImpl.saveData( emp);
	 System.out.println(response);
     return new ModelAndView("index","result",response);	 
	}
	
	
	@RequestMapping(value="/get")
	public ModelAndView allEmployees()
	{
		
		 List<Employee> allList =employeeServiceImpl.showAll();
		
		 return new ModelAndView("index","allList",allList);
		
		
		
		
		
		
	}
}
