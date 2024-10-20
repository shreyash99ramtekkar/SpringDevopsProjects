/**
 * 
 */
package com.chef.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.chef.dto.EmployeeDTO;

/**
 * 
 */
@Repository("employeeRepository")
@Scope("singleton")
public class EmployeeRepositoryImpl implements EmployeeRepository {

	/**
	 * Employee List
	 */
	List<EmployeeDTO> employee;
	
	public EmployeeRepositoryImpl() {
		// TODO Auto-generated constructor stub
		this.employee =new ArrayList<EmployeeDTO>();
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setEmpId(101);
		employeeDTO.setEmpName("Jack");
		employeeDTO.setDepartment("ETA");
		employee.add(employeeDTO);
	}
	

	
	@Override
	public void insertEmployee(EmployeeDTO emp) {
		this.employee.add(emp);

	}

	@Override
	public void deleteEmployee(int empID) {
		this.employee.remove(empID);

	}

	@Override
	public List<EmployeeDTO> fetchEmployees() {
		// TODO Auto-generated method stub
		return this.employee;
	}

}
