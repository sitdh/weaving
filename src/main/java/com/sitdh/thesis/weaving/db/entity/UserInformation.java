package com.sitdh.thesis.weaving.db.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="user_information")
public class UserInformation {

	@Id @NotNull(message="User Id could not be null")
	@Column(name="uid", nullable=false)
	private String userId;
	
	@NotNull(message="Email could not be null")
	@Column(name="email", unique=true, nullable=false)
	private String email;
	
	@Column(name="display_name", length=60)
	private String displayName;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="photo_url")
	private String photoURL;
	
	@Column(name="provider_id")
	private String defaultProviderId;
	
	@OneToMany(mappedBy="userInfo", cascade=CascadeType.ALL)
	private Set<Credential> credentials;
	
	@Column(name="create_date", insertable=false, updatable=false, nullable=false)
	private Date createDate;
	
	@Column(name="lastupdate", insertable=false, updatable=false, nullable=false)
	private Date lastupdate;
	
	@PrePersist
	public void prepersist() {
		createDate = new Date();
		this.preupdate();
	}
	
	@PreUpdate
	public void preupdate() {
		lastupdate = new Date();
	}
	
	public UserInformation(String uid, String email, String displayName, String phoneNumber, String photoURL, String defaultProviderId, List<Credential> credentials) {
		this.setUserId(uid);
		this.setEmail(email);
		this.setDisplayName(displayName);
		this.setPhoneNumber(phoneNumber);
		this.setPhotoURL(photoURL);
		this.setDefaultProviderId(defaultProviderId);
	}
	
	public UserInformation(String uid, String email, String displayName, String phoneNumber, String photoURL, String defaultProviderId, List<Credential> credentials, Date createDate, Date lastupdate) {
		this(uid, email, displayName, phoneNumber, photoURL, defaultProviderId, credentials);
		this.setCreateDate(createDate);
		this.setLastupdate(lastupdate);
		
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPhotoURL() {
		return photoURL;
	}

	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}

	public String getDefaultProviderId() {
		return defaultProviderId;
	}

	public void setDefaultProviderId(String defaultProviderId) {
		this.defaultProviderId = defaultProviderId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastupdate() {
		return lastupdate;
	}

	public void setLastupdate(Date lastupdate) {
		this.lastupdate = lastupdate;
	}

	public Set<Credential> getCredentials() {
		return credentials;
	}

	public void setCredentials(Set<Credential> credentials) {
		this.credentials = credentials;
	}
	
}
