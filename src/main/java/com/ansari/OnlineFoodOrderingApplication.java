package com.ansari;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.ansari.model")
public class OnlineFoodOrderingApplication {

	public static void main(String[] args) {

		SpringApplication.run(OnlineFoodOrderingApplication.class, args);

	}

}
