package com.sitdh.thesis.weaving.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="credentail")
public class Credential {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="credential_id")
	private Long credentialId;
	
	@Column(name="provider_id")
	private String providerId;
	
	@Column(name="access_token")
	private String accessToken;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL) @JoinColumn(name="user_id")
	private UserInformation userInfo;

	public Long getCredentialId() {
		return credentialId;
	}

	public void setCredentialId(Long credentialId) {
		this.credentialId = credentialId;
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public UserInformation getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInformation userInfo) {
		this.userInfo = userInfo;
	}
	
}
