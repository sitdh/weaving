package com.sitdh.thesis.weaving.tools.repository;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.net.URISyntaxException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sitdh.thesis.weaving.db.entity.UserInformation;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleRepositoryManagerTest {
	
	@Autowired
	private RepositoryManager repoManager;
	
	private UserInformation createUserInformation() throws URISyntaxException {
		UserInformation userInfo = mock(UserInformation.class);
		when(userInfo.getUserId()).thenReturn("ABCD");
		
		return userInfo;
	}

	@Test
	public void repositoryManagerExists() {
		assertNotNull(repoManager);
	}
	
	public void repositoryShouldBeCloned() throws URISyntaxException {
		UserInformation userInfo = this.createUserInformation();
		
		String localRepository = repoManager.cloneRepository(userInfo, "sitdh/message");
		
	}

}
