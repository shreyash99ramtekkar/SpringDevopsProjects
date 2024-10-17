package com.chef.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chef.dao.EmployeeRepository;
import com.chef.dao.EmployeeRepositoryImpl;
import com.chef.dto.EmployeeDTO;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
 // For this exercise no need to have EmployeeRepository  we will implement repository later in this course
    EmployeeRepository employeeDAO = null;
	
	public EmployeeServiceImpl(EmployeeRepository empRepo) {
		// TODO Auto-generated constructor stub
		this.employeeDAO = empRepo;
	}
	
	@Override
	public void insert(EmployeeDTO emp) {
		this.employeeDAO.insertEmployee(emp);
	}
	
	public void delete(int empId) {
		this.employeeDAO.deleteEmployee(empId);
	}

	@Override
	public List<EmployeeDTO> getAllEmployees() {
		// TODO Auto-generated method stub
		return this.employeeDAO.fetchEmployees();
	}
}