package com.majorperk.marketservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MarketplaceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarketplaceServiceApplication.class, args);
	}

}
