/*****************************************************************
 * Copy right (c) Channel4 , All rights reserved.
 * 
 * 
 * Application Name: automated-spot-domain-service
 * 
 * This application is used for managing add sales of C4.
 * Which is a public media company of UK.
 * 
 * 
 * File Name:  CamgenExclusionCategory.java
 * File created Date : 15-May-2018
 * 
 *
 * 
 *****************************************************************/
package com.channel4.mint.automated.spot.infrastructure.persistence.repository.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The Class CamgenExclusionCategory is a class in automated-spot-domain-service.
 */
@Entity
@Table(name="CAMGEN_EXCLUSION_CATEGORY")
@NamedQuery(name="CamgenExclusionCategory.findAll", query="SELECT c FROM CamgenExclusionCategory c")
public class CamgenExclusionCategory implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The category id. */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CATEGORY_ID")
	private BigDecimal categoryId;

	/** The category name. */
	@Column(name="CATEGORY_NAME")
	private String categoryName;

	/**
	 * Instantiates a new camgen exclusion category.
	 */
	public CamgenExclusionCategory() {
	}

	/**
	 * Gets the category id.
	 *
	 * @return BigDecimal
	 */
	public BigDecimal getCategoryId() {
		return categoryId;
	}

	/**
	 * Sets the category id.
	 *
	 * @param categoryId the category id
	 */
	public void setCategoryId(BigDecimal categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * Gets the category name.
	 *
	 * @return String
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * Sets the category name.
	 *
	 * @param categoryName the category name
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}