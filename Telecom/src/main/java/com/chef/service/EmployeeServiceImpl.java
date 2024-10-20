package com.chef.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.chef.dao.EmployeeRepository;
import com.chef.dao.EmployeeRepositoryImpl;
import com.chef.dto.EmployeeDTO;

@Service("employeeService")
@Scope("prototype")
public class EmployeeServiceImpl implements EmployeeService {
 // For this exercise no need to have EmployeeRepository  we will implement repository later in this course
//	@Autowired
	
    private EmployeeRepository employeeDAO = null;
	
    /**
     * Setter dependency injection using autowired
     * @param employeeRepository
     */
//    @Autowired
//	private void setEmployeeDAO(EmployeeRepository employeeRepository){
//		this.employeeDAO = employeeRepository;
//	}
//	
    /**
     * Constructor dependency injection
     * @param employeeRepository
     */
    @Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		// TODO Auto-generated constructor stub
    	this.employeeDAO = employeeRepository;
	}
	
	@Override
	public void insert(EmployeeDTO emp) {
		this.employeeDAO.insertEmployee(emp);
	}
	
	public EmployeeRepository getEmployeeDAO() {
		return employeeDAO;
	}

	public void setEmployeeDAO(EmployeeRepository employeeDAO) {
		this.employeeDAO = employeeDAO;
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