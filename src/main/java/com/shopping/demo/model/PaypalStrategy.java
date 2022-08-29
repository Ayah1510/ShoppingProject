package com.shopping.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "paypalstrategy")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaypalStrategy implements PaymentStrategy {

	@Id
	@Column(name = "emailid", unique = true, nullable = false)
	private String emailId;

	@Column(name = "password")
	private String password;

	@OneToOne
	private ShoppingCart cart;
	
	@Override
	public void pay(int total) {
		// TODO Auto-generated method stub
//		
//		List<PayPal> payPalAccounts = payPalService.findAll();
//		List<String> emails = payPalAccounts.stream().map(p -> p.getEmailId()).collect(Collectors.toList());
//
//		if (emails.contains(this.emailId)) {
//			PayPal payPalAccount = payPalService.findById(this.emailId);
//			if (payPalAccount.getPassword().equals(this.password)) {
//				int b = payPalAccount.getBalance();
//				if (b >= total) {
//					payPalAccount.setBalance(b - total);
//					payPalService.save(payPalAccount);
//				} else
//					log.info("Balance isn't enough!!");
//
//			} else
//				log.info("Wrong Password");
//		}

	}

}
