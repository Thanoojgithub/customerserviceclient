package com.customerserviceclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.customerservice.bean.Customer;

public class App {

	private static Logger LOGGER = LoggerFactory.getLogger(App.class);
	
	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml")) {
			CustomerServiceClient customerServiceClient = (CustomerServiceClient)context.getBean("customerServiceClient");
			Customer customer = customerServiceClient.getCustomer(1);
			System.out.println(customer);
			Customer newCustomer = customerServiceClient.createCustomer(2, "seeta", "midhila");
			System.out.println(newCustomer);
			}catch (Exception e) {
				LOGGER.error("error :: " + e);
			}
		
		
	}

}
