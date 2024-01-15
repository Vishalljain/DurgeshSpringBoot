package com.in28minutes.microservices;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrentExchangeRepository extends JpaRepository<CurrencyExchange, Long> {

	 CurrencyExchange findByFromAndTo(String from,String to);
}
