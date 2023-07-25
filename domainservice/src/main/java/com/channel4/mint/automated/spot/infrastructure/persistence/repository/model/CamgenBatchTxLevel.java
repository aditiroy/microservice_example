package com.channel4.mint.automated.spot.infrastructure.persistence.repository.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the CAMGEN_BATCH_TX_LEVEL database table.
 * 
 */
@Entity
@Table(name="CAMGEN_BATCH_TX_LEVEL")
@NamedQuery(name="CamgenBatchTxLevel.findAll", query="SELECT c FROM CamgenBatchTxLevel c")
public class CamgenBatchTxLevel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="BATCH_TX_LEVEL_ID")
	private long batchTxLevelId;

	@Column(name="BATCH_VALUE")
	private BigDecimal batchValue;

	@Column(name="CREATED_BY")
	private String createdBy;

	@Column(name="CREATED_ON")
	private Timestamp createdOn;

	@Column(name="MODIFIED_BY")
	private String modifiedBy;

	@Column(name="MODIFIED_ON")
	private Timestamp modifiedOn;

	@Column(name="TRANSMISSION_LEVEL_ID")
	private BigDecimal transmissionLevelId;

	public CamgenBatchTxLevel() {
	}

	public long getBatchTxLevelId() {
		return this.batchTxLevelId;
	}

	public void setBatchTxLevelId(long batchTxLevelId) {
		this.batchTxLevelId = batchTxLevelId;
	}

	public BigDecimal getBatchValue() {
		return this.batchValue;
	}

	public void setBatchValue(BigDecimal batchValue) {
		this.batchValue = batchValue;
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

	public BigDecimal getTransmissionLevelId() {
		return this.transmissionLevelId;
	}

	public void setTransmissionLevelId(BigDecimal transmissionLevelId) {
		this.transmissionLevelId = transmissionLevelId;
	}

}