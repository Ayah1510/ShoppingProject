package com.shopping.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "item")
public class Item {

	@Id
	@Column(name = "upocode", unique = true, nullable = false)
	private String upoCode;

	@Column(name = "name")
	private String name;

	@Column(name = "price")
	private int price;

}
