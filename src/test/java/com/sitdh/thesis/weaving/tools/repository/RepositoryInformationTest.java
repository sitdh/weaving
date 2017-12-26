package com.sitdh.thesis.weaving.tools.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryInformationTest {
	
	private final String PRIMARY_URI = "http://github.com/sitdh/lorem";
	
	private final String SECONDARY_URI = "http://github.com/sitdh/ipsum";
	
	@Autowired
	private RepositoryInformation primaryRepoInfo;
	
	@Autowired
	private RepositoryInformation uriRepository;

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void respositoryShouldBeParse() throws MalformedURLException {
		
		primaryRepoInfo.setupRepository(new URL(PRIMARY_URI));
		
		assertThat(primaryRepoInfo.repositorySlug(), is("sitdh/lorem"));
		assertThat(primaryRepoInfo.repositoryName(), is("lorem"));
		
		uriRepository.setupRepository(PRIMARY_URI);
		assertThat(primaryRepoInfo.repositorySlug(), is(uriRepository.repositorySlug()));
		assertThat(primaryRepoInfo.repositoryName(), is(uriRepository.repositoryName()));
		
		// Cross-check
		primaryRepoInfo.setupRepository(SECONDARY_URI);
		assertThat(primaryRepoInfo.repositorySlug(), is("sitdh/ipsum"));
		assertThat(primaryRepoInfo.repositoryName(), is("ipsum"));
		
	}
	
	@Test
	public void basicURL() throws Exception {
		URL url = new URL("http://github.com/a/b");
		assertThat(url.getPath(), is("/a/b"));
	}

	@Test
	public void urlValidation() throws MalformedURLException {
		URL url = new URL(PRIMARY_URI);
		primaryRepoInfo.setupRepository(url);
		
		assertTrue(primaryRepoInfo.isUrlValid());
	}
}
