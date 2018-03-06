package com.sitdh.thesis.weaving.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="file")
public class File {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="file_id")
	@Getter @Setter private Integer fid;

}
