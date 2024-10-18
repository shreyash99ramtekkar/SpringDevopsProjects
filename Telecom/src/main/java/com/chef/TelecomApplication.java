package com.chef;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.AbstractApplicationContext;

import com.chef.service.CustomerService;
import com.chef.service.CustomerServiceImpl;

@SpringBootApplication
@ComponentScan
public class TelecomApplication {

	public static void main(String[] args) {
	    AbstractApplicationContext context = (AbstractApplicationContext)SpringApplication.run(TelecomApplication.class, args);
	    CustomerService customerService = context.getBean(CustomerServiceImpl.class);
	    System.out.println(customerService.createCustomer());
	}

}
