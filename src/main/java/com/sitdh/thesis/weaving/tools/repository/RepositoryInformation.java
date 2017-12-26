package com.sitdh.thesis.weaving.tools.repository;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RepositoryInformation {
	
	@Autowired
	private UrlValidator urlValidator;
	
	private URL repositoryURL;
	
	public void setupRepository(URL repositoryUri) throws MalformedURLException {
		this.repositoryURL = repositoryUri;
	}
	
	public void setupRepository(String url) throws MalformedURLException {
		this.setupRepository(new URL(url));
	}
	
	public String repositorySlug() {
		return repositoryURL.getPath().substring(1);
	}
	
	public boolean isUrlValid() {
		return urlValidator.isValid(this.repositoryURL.toString());
	}

	public String repositoryName() {
		return StringUtils.split(this.repositoryURL.getPath().substring(1), "/")[1];
	}
	
	
}
