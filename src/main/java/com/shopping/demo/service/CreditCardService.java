package com.shopping.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.shopping.demo.model.CreditCard;
import com.shopping.demo.model.CreditCardStrategy;
import com.shopping.demo.repository.CreditCardRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@ComponentScan("com.shopping.demo.repository")
@Service
public class CreditCardService {

	@Autowired
	CreditCardRepository creditCardRepository;

	@Autowired
	CreditCardStrategyService creditCardStrategyService;

	@Autowired
	ShoppingCartService shoppingCartService;

	public List<CreditCard> findAll() {
		log.info("Implementing findAll method for creditCard");
		return creditCardRepository.findAll();
	}

	public CreditCard findById(String name) {
		log.info("Implementing find by Id method for creditCard");
		if (creditCardRepository.findById(name).isPresent()) {
			return creditCardRepository.findById(name).get();
		}
		return null;
	}

	public void save(CreditCard creditCard) {
		log.info("Implementing save method for creditCard");
		creditCardRepository.save(creditCard);
	}

	public void delete(String name) {
		log.info("Implementing delete method for creditCard");
		CreditCard creditCard = findById(name);
		creditCardRepository.delete(creditCard);
	}

	public String pay(CreditCardStrategy cs, int total) {
		List<CreditCard> creditCardAccounts = findAll();
		List<String> cardNumbers = creditCardAccounts.stream().map(c -> c.getCardNumber()).collect(Collectors.toList());
		if (cardNumbers.contains(cs.getCardNumber())) {
			CreditCard creditCardAccount = findById(cs.getCardNumber());
			if (creditCardAccount.getCvv().equals(cs.getCvv()) && creditCardAccount.getName().equals(cs.getName())
					&& creditCardAccount.getDateOfExpiry().equals(cs.getDateOfExpiry())) {
				int b = creditCardAccount.getBalance();
				if (b >= total) {
					creditCardAccount.setBalance(b - total);
					save(creditCardAccount);
					creditCardStrategyService.delete(cs.getCardNumber());
					shoppingCartService.delete(cs.getCart().getShoppingNumber());
					log.info("Payment is successful.");
					return "Payment is successful.";
				} else {
					log.info("Balance isn't enough!!");
					return "Balance isn't enough!!";
				}
			} else {
				log.info("Credentials Entered are incorrect!");
				return "Credentials Entered are incorrect!";
			}
		}
		log.info("No available account with the provided email.");
		return "No available account with the provided email.";
	}
}
