/**
 * 
 */
package com.chef.service;

import java.util.List;

import com.chef.dto.EmployeeDTO;

/**
 * 
 */
public interface EmployeeService {
	/*
	 * 
	 */
	public void insert(EmployeeDTO emp);
	/*
	 * 
	 */
	public void delete(int empId);
	
	/**
	 * 
	 */
	public List<EmployeeDTO> getAllEmployees();
	
}
