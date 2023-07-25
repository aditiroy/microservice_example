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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The persistent class for the RUN_PARAMETER database table.
 * 
 */
@Entity
@Table(name = "RUN_PARAMETER")
@NamedQuery(name = "RunParameter.findAll", query = "SELECT r FROM RunParameter r")
public class RunParameter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PARAMETER_ID")
	private long parameterId;

	@Column(name="CREATED_BY")
	private String createdBy;

	@Column(name="CREATED_ON")
	private Timestamp createdOn;

	private String description;

	@Column(name="DISPLAY_SEQUENCE_NUMBER")
	private BigDecimal displaySequenceNumber;

	@Column(name="MODIFIED_BY")
	private String modifiedBy;

	@Column(name="MODIFIED_ON")
	private Timestamp modifiedOn;

	@Column(name="PARAMETER_NAME")
	private String parameterName;

	@Column(name="VALUE")
	private String value;

	//bi-directional many-to-one association to CamgenRun
	@ManyToOne
	@JoinColumn(name="RUN_ID")
	private CamgenRun camgenRun;

	public RunParameter() {
	}

	public long getParameterId() {
		return this.parameterId;
	}

	public void setParameterId(long parameterId) {
		this.parameterId = parameterId;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getDisplaySequenceNumber() {
		return this.displaySequenceNumber;
	}

	public void setDisplaySequenceNumber(BigDecimal displaySequenceNumber) {
		this.displaySequenceNumber = displaySequenceNumber;
	}

	public String getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getModifiedOn() {
		return this.modifiedOn;
	}

	public void setModifiedOn(Timestamp modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public String getParameterName() {
		return this.parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public CamgenRun getCamgenRun() {
		return this.camgenRun;
	}

	public void setCamgenRun(CamgenRun camgenRun) {
		this.camgenRun = camgenRun;
	}

}