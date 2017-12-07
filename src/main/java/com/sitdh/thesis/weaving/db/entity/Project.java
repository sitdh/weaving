package com.sitdh.thesis.weaving.db.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Project {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="project_id")
	private Long projectId;
	
	@NotNull @Size(min=4, max=200)
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@NotNull
	@Column(name="project_repository", nullable=false)
	private String projectRepository;
	
	@NotNull
	@Column(name="local_repository", nullable=false)
	private String localRepository;
	
	@Column(name="website")
	private String website;
	
	@NotNull @Size(max=250)
	@Column(name="graph_url", length=250)
	private String graphUrl;
	
	@Column(name="project_action")
	private String projectAction;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="creater")
	private UserInformation creater;
	
	@Column(name="create_date", insertable=false, updatable=false)
	private Date createdate;
	
	@Column(name="last_update", insertable=false, updatable=false)
	private Date lastupdate;
	
	@PrePersist
	public void prePersisted() {
		createdate = new Date();
		preUpdated();
	}
	
	@PreUpdate
	public void preUpdated() {
		lastupdate = new Date();
	}

}
