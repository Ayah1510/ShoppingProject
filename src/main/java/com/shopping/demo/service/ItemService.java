package com.shopping.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.shopping.demo.model.Item;
import com.shopping.demo.repository.ItemsRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@ComponentScan("com.shopping.demo.repository")
@Service
public class ItemService {

	@Autowired
	ItemsRepository itemsRepository;

	public List<Item> findAll() {
		log.info("Implementing findAll method for item");
		return itemsRepository.findAll();
	}

	public Item findById(String name) {
		log.info("Implementing find by Id method for item");
		if (itemsRepository.findById(name).isPresent()) {
			return itemsRepository.findById(name).get();
		}
		return null;
	}

	public void save(Item item) {
		log.info("Implementing save method for item");
		itemsRepository.save(item);
	}

	public void delete(String name) {
		log.info("Implementing delete method for item");
		Item item = findById(name);
		itemsRepository.delete(item);
	}
}
