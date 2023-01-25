package com.volunteer.ordercreator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class OrderCreatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderCreatorApplication.class, args);
	}

}
