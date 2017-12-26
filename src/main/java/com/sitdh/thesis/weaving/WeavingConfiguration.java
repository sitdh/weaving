package com.sitdh.thesis.weaving;

import org.apache.commons.validator.routines.UrlValidator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EnableAutoConfiguration
@Configuration
@PropertySource("classpath:/weaving-config.properties")
public class WeavingConfiguration {
	
	private Logger log;
	
	@Value("#{'${weaving.repository.schems}'.split(',')}")
	private String[] schemes;
	
	public WeavingConfiguration() {
		log = Logger.getLogger(this.getClass());
	}
	
	@Bean
	public UrlValidator urlValidator() {
		log.log(Level.INFO, schemes);
		return new UrlValidator(schemes);
	}

}
