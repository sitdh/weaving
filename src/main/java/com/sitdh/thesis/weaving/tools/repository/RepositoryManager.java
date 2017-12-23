package com.sitdh.thesis.weaving.tools.repository;

import com.sitdh.thesis.weaving.db.entity.UserInformation;

public interface RepositoryManager {
	
	public String cloneRepository(UserInformation user, String repository);
	
	public String cloneRepository(UserInformation user, String repository, String branch);

}
