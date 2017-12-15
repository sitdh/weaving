package com.sitdh.thesis.weaving.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="file")
public class File {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="file_id")
	private Integer fid;

}
