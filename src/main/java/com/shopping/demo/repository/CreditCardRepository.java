package com.shopping.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.shopping.demo.model.CreditCard;

@EnableJpaRepositories(basePackages = { "com.shopping.demo" })
@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, String> {

}
