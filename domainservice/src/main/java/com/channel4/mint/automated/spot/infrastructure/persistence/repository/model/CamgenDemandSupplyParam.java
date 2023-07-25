/*
 * 
 */
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


// TODO: Auto-generated Javadoc
/**
 * The persistent class for the CAMGEN_DEMAND_SUPPLY_PARAM database table.
 * 
 */
@Entity
@Table(name="CAMGEN_DEMAND_SUPPLY_PARAM")
@NamedQuery(name="CamgenDemandSupplyParam.findAll", query="SELECT c FROM CamgenDemandSupplyParam c")
public class CamgenDemandSupplyParam implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The demand supply id. */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DEMAND_SUPPLY_ID")
	private long demandSupplyId;

	/** The attribute. */
	private String attribute;

	/** The condition. */
	private String condition;

	/** The demand supply level. */
	@Column(name="DEMAND_SUPPLY_LEVEL")
	private String demandSupplyLevel;

	/** The is active. */
	@Column(name="IS_ACTIVE")
	private BigDecimal isActive;

	/** The object. */
	@Column(name="\"OBJECT\"")
	private String object;

	/**
	 * Instantiates a new camgen demand supply param.
	 */
	public CamgenDemandSupplyParam() {
	}

	/**
	 * Gets the demand supply id.
	 *
	 * @return the demand supply id
	 */
	public long getDemandSupplyId() {
		return this.demandSupplyId;
	}

	/**
	 * Sets the demand supply id.
	 *
	 * @param demandSupplyId the new demand supply id
	 */
	public void setDemandSupplyId(long demandSupplyId) {
		this.demandSupplyId = demandSupplyId;
	}

	/**
	 * Gets the attribute.
	 *
	 * @return the attribute
	 */
	public String getAttribute() {
		return this.attribute;
	}

	/**
	 * Sets the attribute.
	 *
	 * @param attribute the new attribute
	 */
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	/**
	 * Gets the condition.
	 *
	 * @return the condition
	 */
	public String getCondition() {
		return this.condition;
	}

	/**
	 * Sets the condition.
	 *
	 * @param condition the new condition
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}

	/**
	 * Gets the demand supply level.
	 *
	 * @return the demand supply level
	 */
	public String getDemandSupplyLevel() {
		return this.demandSupplyLevel;
	}

	/**
	 * Sets the demand supply level.
	 *
	 * @param demandSupplyLevel the new demand supply level
	 */
	public void setDemandSupplyLevel(String demandSupplyLevel) {
		this.demandSupplyLevel = demandSupplyLevel;
	}

	/**
	 * Gets the checks if is active.
	 *
	 * @return the checks if is active
	 */
	public BigDecimal getIsActive() {
		return this.isActive;
	}

	/**
	 * Sets the checks if is active.
	 *
	 * @param isActive the new checks if is active
	 */
	public void setIsActive(BigDecimal isActive) {
		this.isActive = isActive;
	}

	/**
	 * Gets the object.
	 *
	 * @return the object
	 */
	public String getObject() {
		return this.object;
	}

	/**
	 * Sets the object.
	 *
	 * @param object the new object
	 */
	public void setObject(String object) {
		this.object = object;
	}

}