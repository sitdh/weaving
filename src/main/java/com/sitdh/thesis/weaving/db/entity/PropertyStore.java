package com.sitdh.thesis.weaving.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="property_store")
public class PropertyStore {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO) 
	@Column(name="property_id", nullable=false)
	@NotNull(message="User Id could not be null")
	@Getter @Setter private Integer propertyId;
	
	private String type;
	
	private String value;

	/**
	 * @return the propertyId
	 */
//	public Integer getPropertyId() {
//		return propertyId;
//	}

	/**
	 * @param propertyId the propertyId to set
	 */
//	public void setPropertyId(Integer propertyId) {
//		this.propertyId = propertyId;
//	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

}
