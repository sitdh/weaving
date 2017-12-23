package com.sitdh.thesis.weaving.tools.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.sitdh.thesis.weaving.db.entity.UserInformation;

@PropertySource(value="classpath:weaving-config.yml")
@Component
public class SimpleRepositoryManager implements RepositoryManager {
	
	@Value("${weaving.repository.local-repository}")
	private String defaultLocalRepository;

	@Override
	public String cloneRepository(UserInformation user, String repository) {
		// TODO Auto-generated method stub
		
		return "";
	}

	@Override
	public String cloneRepository(UserInformation user, String repository, String branch) {
		// TODO Auto-generated method stub
		
		return "";
	}

}
