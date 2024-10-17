package com.chef;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.chef.dto.EmployeeDTO;
import com.chef.service.CustomerServiceImpl;
import com.chef.service.EmployeeServiceImpl;
import com.chef.util.SpringConfiguration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        CustomerServiceImpl service = null;
        EmployeeServiceImpl empService = null;
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        service = (CustomerServiceImpl)context.getBean("customerService");
        service = context.getBean("customerService", CustomerServiceImpl.class);
        empService = context.getBean("employeeService",EmployeeServiceImpl.class);
    	EmployeeDTO empDto = new EmployeeDTO();
		empDto.setEmpId(1);
		empDto.setDepartment("Finance");
		empDto.setEmpName("Itachi");
		
		empService.insert(empDto);
		
		for(EmployeeDTO emp: empService.getAllEmployees()) {
		    System.out.println(emp.toString());
		}
		empService.delete(0);
        System.out.println(service.createCustomer());
        context.close();
    }
}
