/*
 * 
 */
package com.channel4.mint.automated.spot.infrastructure.persistence.repository.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


// TODO: Auto-generated Javadoc
/**
 * The persistent class for the RUN_EXTRACT_PARAMETER database table.
 * 
 */
@Entity
@Table(name="RUN_EXTRACT_PARAMETER")
@NamedQuery(name="RunExtractParameter.findAll", query="SELECT r FROM RunExtractParameter r")
public class RunExtractParameter implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The extract parameter id. */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EXTRACT_PARAMETER_ID")
	private long extractParameterId;

	/** The created by. */
	@Column(name="CREATED_BY")
	private String createdBy;

	/** The created on. */
	@Column(name="CREATED_ON")
	private Timestamp createdOn;

	/** The extract parameter name. */
	@Column(name="EXTRACT_PARAMETER_NAME")
	private String extractParameterName;

	/** The modified by. */
	@Column(name="MODIFIED_BY")
	private String modifiedBy;

	/** The modified on. */
	@Column(name="MODIFIED_ON")
	private Timestamp modifiedOn;

	/** The value. */
	@Column(name="VALUE")
	private String value;

	/** The camgen run. */
	//bi-directional many-to-one association to CamgenRun
	@ManyToOne
	@JoinColumn(name="RUN_ID")
	private CamgenRun camgenRun;

	/**
	 * Instantiates a new run extract parameter.
	 */
	public RunExtractParameter() {
	}

	/**
	 * Gets the extract parameter id.
	 *
	 * @return the extract parameter id
	 */
	public long getExtractParameterId() {
		return this.extractParameterId;
	}

	/**
	 * Sets the extract parameter id.
	 *
	 * @param extractParameterId the new extract parameter id
	 */
	public void setExtractParameterId(long extractParameterId) {
		this.extractParameterId = extractParameterId;
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
	 * @param createdBy the new created by
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
	 * @param createdOn the new created on
	 */
	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * Gets the extract parameter name.
	 *
	 * @return the extract parameter name
	 */
	public String getExtractParameterName() {
		return this.extractParameterName;
	}

	/**
	 * Sets the extract parameter name.
	 *
	 * @param extractParameterName the new extract parameter name
	 */
	public void setExtractParameterName(String extractParameterName) {
		this.extractParameterName = extractParameterName;
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
	 * @param modifiedBy the new modified by
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
	 * @param modifiedOn the new modified on
	 */
	public void setModifiedOn(Timestamp modifiedOn) {
		this.modifiedOn = modifiedOn;
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
	 * @param value the new value
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * Gets the camgen run.
	 *
	 * @return the camgen run
	 */
	public CamgenRun getCamgenRun() {
		return this.camgenRun;
	}

	/**
	 * Sets the camgen run.
	 *
	 * @param camgenRun the new camgen run
	 */
	public void setCamgenRun(CamgenRun camgenRun) {
		this.camgenRun = camgenRun;
	}

}