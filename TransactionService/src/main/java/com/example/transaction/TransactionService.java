package com.example.transaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
	
	@Autowired
	TransactionRepository transactionRepository;

	public List<Transaction> getTransactions() {
		return (List<Transaction>)transactionRepository.findAll();
	}

	public void insertTransaction(Transaction transaction) {
		transactionRepository.insert(transaction);
	}
	
	
	

}
