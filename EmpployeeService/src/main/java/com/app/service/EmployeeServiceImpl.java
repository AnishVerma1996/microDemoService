package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.EmployeeRepository;
import com.app.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService
{



	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	
	@Override
	public boolean AddEmp(Employee e) 
	{
		boolean b=false;
		try
		{
			System.out.println(e);
			employeeRepository.save(e);
			b=true;
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
		return b;
	}
	@Override
		public List<Employee> AllEmp() 
	    {
		   
			List<Employee> list=employeeRepository.findAll();
		   
			return list;
		}
	@Override
		public boolean DeleteEmp(int eid) 
	    {
		    boolean b=false;
			try
			{
				employeeRepository.delete(eid);
				b=true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return b;
		}
	@Override
		public boolean UpdateEmp(Employee e) {
			// TODO Auto-generated method stub
		 boolean b=false;
		  try
		  {
			  
			 Employee emp=employeeRepository.saveAndFlush(e);
			  if(emp!=null)
			  {
				  employeeRepository.save(e);
			  }
			  
		  }
		  catch(Exception e1)
		  {
			  e1.printStackTrace();
		  }
			return b;
		}
	}
	

