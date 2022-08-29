package com.shopping.demo.model;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.shopping.demo.service.CreditCardService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Entity
@Table(name = "Creditcardstrategy")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreditCardStrategy implements PaymentStrategy {

	@Id
	@Column(name = "cardnumber", unique = true, nullable = false)
	private String cardNumber;

	@Column(name = "name")
	private String name;

	@Column(name = "cvv")
	private String cvv;

	@Column(name = "dateofexpiry")
	private String dateOfExpiry;

	@OneToOne
	private ShoppingCart cart;

	@Override
	public void pay(int total) {
		// TODO Auto-generated method stub

		CreditCardService creditCardService = null;
		List<CreditCard> creditCardAccounts = creditCardService.findAll();

		List<String> cardNumbers = creditCardAccounts.stream().map(c -> c.getCardNumber()).collect(Collectors.toList());

		if (cardNumbers.contains(this.cardNumber)) {
			CreditCard creditCardAccount = creditCardService.findById(this.cardNumber);
			if (creditCardAccount.getName().equals(this.name) && creditCardAccount.getCvv().equals(this.cvv)
					&& creditCardAccount.getDateOfExpiry().equals(this.dateOfExpiry)) {
				int b = creditCardAccount.getBalance();
				if (b >= total) {
					creditCardAccount.setBalance(b - total);
					creditCardService.delete(this.cardNumber);
					creditCardService.save(creditCardAccount);
				} else
					log.info("Balance isn't enough!!");

			} else
				log.info("Credentials Entered are incorrect");
		}
	}

}
