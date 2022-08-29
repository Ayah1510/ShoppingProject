package com.shopping.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.shopping.demo.model.PayPal;
import com.shopping.demo.model.PaypalStrategy;
import com.shopping.demo.repository.PayPalRepository;
import com.shopping.demo.repository.ShoppingCartRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@ComponentScan("com.shopping.demo.repository")
@Service
public class PayPalService {

	@Autowired
	PayPalRepository payPalRepository;

	@Autowired
	PayPalStrategyService payPalStrategyService;
	
	@Autowired
	ShoppingCartService shoppingCartService;
	
	public List<PayPal> findAll() {
		log.info("Implementing findAll method for paypal");
		return payPalRepository.findAll();
	}

	public PayPal findById(String name) {
		log.info("Implementing find by Id method for paypal");
		if (payPalRepository.findById(name).isPresent()) {
			return payPalRepository.findById(name).get();
		}
		return null;
	}

	public void save(PayPal payPal) {
		log.info("Implementing save method for paypal");
		payPalRepository.save(payPal);
	}

	public void delete(String name) {
		log.info("Implementing delete method for paypal");
		PayPal payPal = findById(name);
		payPalRepository.delete(payPal);
	}

	public String pay(PaypalStrategy ps, int total) {
		List<PayPal> payPalAccounts = findAll();
		List<String> emails = payPalAccounts.stream().map(p -> p.getEmailId()).collect(Collectors.toList());
		if (emails.contains(ps.getEmailId())) {
			PayPal payPalAccount = findById(ps.getEmailId());
			if (payPalAccount.getPassword().equals(ps.getPassword())) {
				int b = payPalAccount.getBalance();
				if (b >= total) {
					payPalAccount.setBalance(b - total);
					save(payPalAccount);
					payPalStrategyService.delete(ps.getEmailId());
					shoppingCartService.delete(ps.getCart().getShoppingNumber());
					log.info("Payment is successful");
					return "Payment is successful";
				} else {
					log.info("Balance isn't enough!!");
					return "Balance isn't enough!!";
				}
			} else {
				log.info("Wrong Password");
			return "Wrong Password";
		}
		}
		log.info("No available account with the provided email");
		return "No available account with the provided email";
	}
}
