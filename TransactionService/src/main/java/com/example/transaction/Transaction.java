package com.example.transaction;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Transactions")
public class Transaction {
//	@Id
//	private ObjectId _id;
	private int account_id;
	private String transaction_type;
	private int amount;

	public Transaction() {
	}

	public Transaction( int account_id, String transaction_type, int amount) {
		this.account_id = account_id;
		this.transaction_type = transaction_type;
		this.amount = amount;
	}
	
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public String getTransaction_type() {
		return transaction_type;
	}
	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	

}
