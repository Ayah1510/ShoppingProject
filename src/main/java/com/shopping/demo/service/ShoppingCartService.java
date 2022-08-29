package com.shopping.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import com.shopping.demo.model.ShoppingCart;
import com.shopping.demo.repository.ShoppingCartRepository;
import lombok.extern.log4j.Log4j2;

@Log4j2
@ComponentScan("com.shopping.demo.repository")
@Service
public class ShoppingCartService {

	@Autowired
	ShoppingCartRepository shoppingCartRepository;

	public List<ShoppingCart> findAll() {
		log.info("Implementing findAll method for shoppingCart");
		return shoppingCartRepository.findAll();
	}

	public ShoppingCart findById(int name) {
		log.info("Implementing find by Id method for shoppingCart");
		if (shoppingCartRepository.findById(name).isPresent()) {
			return shoppingCartRepository.findById(name).get();
		}
		return null;
	}

	public void save(ShoppingCart shoppingCart) {
		log.info("Implementing save method for shoppingCart");
		shoppingCartRepository.save(shoppingCart);
	}

	public void delete(int name) {
		log.info("Implementing delete method for shoppingCart");
		ShoppingCart shoppingCart = findById(name);
		shoppingCartRepository.delete(shoppingCart);
	}
	
}
