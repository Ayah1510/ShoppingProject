package com.shopping.demo.model;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public interface PaymentStrategy {

	public void pay(int total);

}
