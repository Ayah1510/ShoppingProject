package com.shopping.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.shopping.demo.model.PaypalStrategy;

@EnableJpaRepositories(basePackages = {"com.shopping.demo"})
@Repository
public interface PayPalStrategyRepository extends JpaRepository<PaypalStrategy, String>{

}
