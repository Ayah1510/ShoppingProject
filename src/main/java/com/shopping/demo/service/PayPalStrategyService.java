package com.shopping.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.shopping.demo.model.PayPal;
import com.shopping.demo.model.PaypalStrategy;
import com.shopping.demo.repository.PayPalRepository;
import com.shopping.demo.repository.PayPalStrategyRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@ComponentScan("com.shopping.demo.repository")
@Service
public class PayPalStrategyService {

	@Autowired
	PayPalStrategyRepository payPalStrategyRepository;

	public List<PaypalStrategy> findAll() {
		log.info("Implementing findAll method for Paypal strategy");
		return payPalStrategyRepository.findAll();
	}

	public PaypalStrategy findById(String name) {
		log.info("Implementing find by Id method for paypal strategy");
		if (payPalStrategyRepository.findById(name).isPresent()) {
			return payPalStrategyRepository.findById(name).get();
		}
		return null;
	}

	public void save(PaypalStrategy paypalStrategy) {
		log.info("Implementing save method for paypal strategy");
		payPalStrategyRepository.save(paypalStrategy);
	}

	public void delete(String name) {
		log.info("Implementing delete method for paypal strategy");
		PaypalStrategy paypalStrategy = findById(name);
		payPalStrategyRepository.delete(paypalStrategy);
	}

}
