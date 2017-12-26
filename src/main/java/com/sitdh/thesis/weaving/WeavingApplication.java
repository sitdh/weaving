package com.sitdh.thesis.weaving;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@EnableJpaRepositories
@Import(WeavingConfiguration.class)
public class WeavingApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeavingApplication.class, args);
	}
}
