package com.example.transaction;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TransactionController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	TransactionService transactionService;
	
	@Autowired
	RabbitMqSender rabbitMqSender;
	
	@RequestMapping("/transaction")
	List<Transaction> getTransactions() {
		return transactionService.getTransactions();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/transaction")
	void recordTransction(@RequestBody TransactionPayload transactionPayload) throws Exception {
		Customer c=restTemplate.getForObject("http://customer-service/customer/"+transactionPayload.getEmail_id(), Customer.class);
		transactionService.insertTransaction(new Transaction(c.getAccount_id(),transactionPayload.getTransaction_type(),transactionPayload.getAmount()));
		rabbitMqSender.send(new Transaction(c.getAccount_id(),transactionPayload.getTransaction_type(),transactionPayload.getAmount()));
	}

}
