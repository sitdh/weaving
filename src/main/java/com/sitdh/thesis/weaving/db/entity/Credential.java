package com.sitdh.thesis.weaving.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Credential {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="credential_id")
	private Long credentialId;
	
	@Column(name="provider_id")
	private String providerId;
	
	@Column(name="access_token")
	private String accessToken;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="userinformation_id")
	private UserInformation userInformation;

}
