package com.customerserviceclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.customerservice.bean.Customer;
import com.google.gson.Gson;

public class App {

	private static Logger LOGGER = LoggerFactory.getLogger(App.class);
	
	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml")) {
			CustomerServiceClient customerServiceClient = (CustomerServiceClient)context.getBean("customerServiceClient");
			Customer customer = customerServiceClient.getCustomer(1);
			System.out.println(customer);
			Customer newCustomer = customerServiceClient.createCustomer(2, "seeta", "midhila");
			System.out.println(newCustomer);
			String customerPostPathParam = customerServiceClient.getCustomerPostPathParam(1);
			String customerPostQueryParam = customerServiceClient.getCustomerPostQueryParam(1);
			Gson gson = new Gson();
			String customerJson = gson.toJson(newCustomer);
			Customer customerPostRequestBody = customerServiceClient.getCustomerPostRequestBody(customerJson);
			Customer customerPostRequestBodyXml = customerServiceClient.getCustomerPostRequestBodyXml(newCustomer);
			System.out.println(customerPostPathParam);
			System.out.println(customerPostQueryParam);
			System.out.println(customerPostRequestBody);
			System.out.println(customerPostRequestBodyXml);
			}catch (Exception e) {
				LOGGER.error("error :: " + e);
			}
		
		
	}

}
