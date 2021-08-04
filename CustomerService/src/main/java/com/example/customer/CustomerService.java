package com.example.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	public List<Customer> getAllCustomers() {
		return (List<Customer>) customerRepository.findAll();
	}

	public void addCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	public Customer getCustomerByEmail(String email_id) {
		 return ((List<Customer>)customerRepository.findAll()).stream().filter(c->c.getEmail_id().equals(email_id)).findFirst().get();
	}

}
