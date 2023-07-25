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
 * The persistent class for the CAMGEN_RQST_BATCH_TX_LEVEL database table.
 * 
 */
@Entity
@Table(name="CAMGEN_RQST_BATCH_TX_LEVEL")
@NamedQuery(name="CamgenRqstBatchTxLevel.findAll", query="SELECT c FROM CamgenRqstBatchTxLevel c")
public class CamgenRqstBatchTxLevel implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The batch tx level id. */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BATCH_TX_LEVEL_ID")
	private long batchTxLevelId;

	/** The batch value. */
	@Column(name="BATCH_VALUE")
	private BigDecimal batchValue;

	/** The created by. */
	@Column(name="CREATED_BY")
	private String createdBy;

	/** The created on. */
	@Column(name="CREATED_ON")
	private Timestamp createdOn;

	/** The modified by. */
	@Column(name="MODIFIED_BY")
	private String modifiedBy;

	/** The modified on. */
	@Column(name="MODIFIED_ON")
	private Timestamp modifiedOn;

	/** The transmission level id. */
	@Column(name="TRANSMISSION_LEVEL_ID")
	private BigDecimal transmissionLevelId;

	/** The camgen request. */
	//bi-directional many-to-one association to CamgenRequest
	@ManyToOne
	@JoinColumn(name="REQUEST_ID")
	private CamgenRequest camgenRequest;

	/**
	 * Instantiates a new camgen rqst batch tx level.
	 */
	public CamgenRqstBatchTxLevel() {
	}

	/**
	 * Gets the batch tx level id.
	 *
	 * @return the batch tx level id
	 */
	public long getBatchTxLevelId() {
		return this.batchTxLevelId;
	}

	/**
	 * Sets the batch tx level id.
	 *
	 * @param batchTxLevelId the new batch tx level id
	 */
	public void setBatchTxLevelId(long batchTxLevelId) {
		this.batchTxLevelId = batchTxLevelId;
	}

	/**
	 * Gets the batch value.
	 *
	 * @return the batch value
	 */
	public BigDecimal getBatchValue() {
		return this.batchValue;
	}

	/**
	 * Sets the batch value.
	 *
	 * @param batchValue the new batch value
	 */
	public void setBatchValue(BigDecimal batchValue) {
		this.batchValue = batchValue;
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
	 * Gets the transmission level id.
	 *
	 * @return the transmission level id
	 */
	public BigDecimal getTransmissionLevelId() {
		return this.transmissionLevelId;
	}

	/**
	 * Sets the transmission level id.
	 *
	 * @param transmissionLevelId the new transmission level id
	 */
	public void setTransmissionLevelId(BigDecimal transmissionLevelId) {
		this.transmissionLevelId = transmissionLevelId;
	}

	/**
	 * Gets the camgen request.
	 *
	 * @return the camgen request
	 */
	public CamgenRequest getCamgenRequest() {
		return this.camgenRequest;
	}

	/**
	 * Sets the camgen request.
	 *
	 * @param camgenRequest the new camgen request
	 */
	public void setCamgenRequest(CamgenRequest camgenRequest) {
		this.camgenRequest = camgenRequest;
	}

}