package com.sitdh.thesis.weaving;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(WeavingConfiguration.class)
public class WeavingApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeavingApplication.class, args);
	}
}
