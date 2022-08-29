package com.shopping.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name="paypal")
public class PayPal {

	@Id
	@Column(name = "emailid", unique=true, nullable = false)
	private String emailId;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "balance")
	private int balance;
}
