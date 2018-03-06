package com.sitdh.thesis.weaving.tools.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.sitdh.thesis.weaving.db.entity.UserInformation;

@RunWith(SpringRunner.class)
@SpringBootTest
@PropertySource("classpath:/weaving-config.properties")
public class SimpleRepositoryManagerTest {
	
	@Autowired
	private RepositoryManager repoManager;
	
	@Value("${weaving.repository.local-repository}")
	private String tempLocalRepositoryLocation;
	
	private UserInformation createUserInformation() throws URISyntaxException {
		UserInformation userInfo = mock(UserInformation.class);
		when(userInfo.getUserId()).thenReturn("ABCD");
		
		return userInfo;
	}

	@Test
	public void repositoryManagerExists() {
		assertNotNull(repoManager);
	}
	
	@Test
	public void repositoryShouldBeCloned() throws URISyntaxException {
		UserInformation userInfo = this.createUserInformation();
		
		String localRepository = repoManager.cloneRepository(userInfo, "sitdh/message");
		List<String> messages = Arrays.asList(tempLocalRepositoryLocation, userInfo.getUserId(), "sitdh/message");
		
		assertThat(localRepository, is(StringUtils.join(messages, "/")));
	}

}
