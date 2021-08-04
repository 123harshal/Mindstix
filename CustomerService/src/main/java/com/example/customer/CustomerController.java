package com.example.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping("/customer")
	public List<Customer> getAllCustomer()
	{
		return customerService.getAllCustomers();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/customer")
	public void addCustomer(@RequestBody Customer customer)
	{
		 customerService.addCustomer(customer);
	}
	
	@RequestMapping("/customer/{email_id}")
	public Customer getCustomerByEmail(@PathVariable String email_id)
	{
		return customerService.getCustomerByEmail(email_id);
	}
	

}
