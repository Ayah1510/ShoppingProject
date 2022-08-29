package com.shopping.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.shopping.demo.model.CreditCardStrategy;
import com.shopping.demo.model.PaypalStrategy;
import com.shopping.demo.repository.CreditCardStrategyRepository;
import com.shopping.demo.repository.PayPalStrategyRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@ComponentScan("com.shopping.demo.repository")
@Service
public class CreditCardStrategyService {

	@Autowired
	CreditCardStrategyRepository creditCardStrategyRepository;

	public List<CreditCardStrategy> findAll() {
		log.info("Implementing findAll method for credit card strategy");
		return creditCardStrategyRepository.findAll();
	}

	public CreditCardStrategy findById(String name) {
		log.info("Implementing find by Id method for  credit card strategy");
		if (creditCardStrategyRepository.findById(name).isPresent()) {
			return creditCardStrategyRepository.findById(name).get();
		}
		return null;
	}

	public void save(CreditCardStrategy creditCardStrategy) {
		log.info("Implementing save method for  credit card strategy");
		creditCardStrategyRepository.save(creditCardStrategy);
	}

	public void delete(String name) {
		log.info("Implementing delete method for  credit card strategy");
		CreditCardStrategy creditCardStrategy = findById(name);
		creditCardStrategyRepository.delete(creditCardStrategy);
	}

}
