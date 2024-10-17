/**
 * 
 */
package com.chef.dao;

import java.util.List;

import com.chef.dto.EmployeeDTO;

/**
 * 
 */

public interface EmployeeRepository {
	
	/**
	 * Insert the employee into the database
	 * @param emp
	 */
	public void insertEmployee(EmployeeDTO emp);
	
	/**
	 * Delete the employee based on the employee id
	 * @param empID
	 */
	public void deleteEmployee(int empID);
	
	/**
	 * Featch all the records of the employee
	 * @return
	 */
	public List<EmployeeDTO> fetchEmployees();
	

}
