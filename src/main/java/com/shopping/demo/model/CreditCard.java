package com.shopping.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="creditcard")
public class CreditCard {

	@Id
	@Column(name = "cardnumber", unique=true, nullable = false)
	private String cardNumber;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "cvv")
	private String cvv;
	
	@Column(name = "dateofexpiry")
	private String dateOfExpiry;
	
	@Column(name = "balance")
	private int balance;
}
