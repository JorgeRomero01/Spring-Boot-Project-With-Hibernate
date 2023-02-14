package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import org.springframework.ui.context.Theme;

import com.luv2code.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee thEmployee);
	
	public void delete(int theId);
	
	
}
