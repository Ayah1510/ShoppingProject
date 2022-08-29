package com.shopping.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Shoppingcart")
public class ShoppingCart {

	@Id
	@Column(name = "shoppingnumber")
	int shoppingNumber;
	
	@Column(name = "items")
	@ManyToMany()
	private List<Item> items;

	public void addItem(Item item) {
		items.add(item);
	}

	public void removeItem(Item item) {
		items.remove(item);
	}

	public int calculateTotal() {
		int total = 0;
		for (Item item : items)
			total += item.getPrice();
		return total;
	}

	public void pay(PaymentStrategy paymentStrategy) {
		paymentStrategy.pay(calculateTotal());
	}
}
