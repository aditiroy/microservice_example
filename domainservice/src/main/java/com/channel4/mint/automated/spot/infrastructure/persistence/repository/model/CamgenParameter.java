/*
 * 
 */
package com.channel4.mint.automated.spot.infrastructure.persistence.repository.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The persistent class for the CAMGEN_PARAMETER database table.
 * 
 */
@Entity
@Table(name = "CAMGEN_PARAMETER")
@NamedQuery(name = "CamgenParameter.findAll", query = "SELECT c FROM CamgenParameter c")
public class CamgenParameter implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The parameter id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PARAMETER_ID")
	private long parameterId;

	/** The created by. */
	@Column(name = "CREATED_BY")
	private String createdBy;

	/** The created on. */
	@Column(name = "CREATED_ON")
	private Timestamp createdOn;

	/** The description. */
	private String description;

	/** The display sequence number. */
	@Column(name = "DISPLAY_SEQUENCE_NUMBER")
	private BigDecimal displaySequenceNumber;

	/** The modified by. */
	@Column(name = "MODIFIED_BY")
	private String modifiedBy;

	/** The modified on. */
	@Column(name = "MODIFIED_ON")
	private Timestamp modifiedOn;

	/** The parameter name. */
	@Column(name = "PARAMETER_NAME")
	private String parameterName;

	/** The value. */
	@Column(name = "VALUE")
	private String value;

	/**
	 * Instantiates a new camgen parameter.
	 */
	public CamgenParameter() {
	}

	/**
	 * Gets the parameter id.
	 *
	 * @return the parameter id
	 */
	public long getParameterId() {
		return this.parameterId;
	}

	/**
	 * Sets the parameter id.
	 *
	 * @param parameterId
	 *            the new parameter id
	 */
	public void setParameterId(long parameterId) {
		this.parameterId = parameterId;
	}

	/**
	 * Gets the created by.
	 *
	 * @return the created by
	 */
	public String getCreatedBy() {
		return this.createdBy;
	}

	/**
	 * Sets the created by.
	 *
	 * @param createdBy
	 *            the new created by
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * Gets the created on.
	 *
	 * @return the created on
	 */
	public Timestamp getCreatedOn() {
		return this.createdOn;
	}

	/**
	 * Sets the created on.
	 *
	 * @param createdOn
	 *            the new created on
	 */
	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description
	 *            the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the display sequence number.
	 *
	 * @return the display sequence number
	 */
	public BigDecimal getDisplaySequenceNumber() {
		return this.displaySequenceNumber;
	}

	/**
	 * Sets the display sequence number.
	 *
	 * @param displaySequenceNumber
	 *            the new display sequence number
	 */
	public void setDisplaySequenceNumber(BigDecimal displaySequenceNumber) {
		this.displaySequenceNumber = displaySequenceNumber;
	}

	/**
	 * Gets the modified by.
	 *
	 * @return the modified by
	 */
	public String getModifiedBy() {
		return this.modifiedBy;
	}

	/**
	 * Sets the modified by.
	 *
	 * @param modifiedBy
	 *            the new modified by
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	/**
	 * Gets the modified on.
	 *
	 * @return the modified on
	 */
	public Timestamp getModifiedOn() {
		return this.modifiedOn;
	}

	/**
	 * Sets the modified on.
	 *
	 * @param modifiedOn
	 *            the new modified on
	 */
	public void setModifiedOn(Timestamp modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	/**
	 * Gets the parameter name.
	 *
	 * @return the parameter name
	 */
	public String getParameterName() {
		return this.parameterName;
	}

	/**
	 * Sets the parameter name.
	 *
	 * @param parameterName
	 *            the new parameter name
	 */
	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public String getValue() {
		return this.value;
	}

	/**
	 * Sets the value.
	 *
	 * @param value
	 *            the new value
	 */
	public void setValue(String value) {
		this.value = value;
	}

}