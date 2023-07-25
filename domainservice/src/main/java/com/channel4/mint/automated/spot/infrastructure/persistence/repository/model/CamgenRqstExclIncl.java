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
 * The persistent class for the CAMGEN_RQST_EXCL_INCL database table.
 * 
 */
@Entity
@Table(name="CAMGEN_RQST_EXCL_INCL")
@NamedQuery(name="CamgenRqstExclIncl.findAll", query="SELECT c FROM CamgenRqstExclIncl c")
public class CamgenRqstExclIncl implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The camgen rqst excl incl id. */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CAMGEN_RQST_EXCL_INCL_ID")
	private long camgenRqstExclInclId;

	/** The created by. */
	@Column(name="CREATED_BY")
	private String createdBy;

	/** The created on. */
	@Column(name="CREATED_ON")
	private Timestamp createdOn;

	/** The is excluded. */
	@Column(name="IS_EXCLUDED")
	private BigDecimal isExcluded;

	/** The modified by. */
	@Column(name="MODIFIED_BY")
	private String modifiedBy;

	/** The modified on. */
	@Column(name="MODIFIED_ON")
	private Timestamp modifiedOn;

	/** The reference id. */
	@Column(name="REFERENCE_ID")
	private BigDecimal referenceId;

	/** The reference type. */
	@Column(name="REFERENCE_TYPE")
	private String referenceType;

	/** The camgen request. */
	//bi-directional many-to-one association to CamgenRequest
	@ManyToOne
	@JoinColumn(name="REQUEST_ID")
	private CamgenRequest camgenRequest;

	/**
	 * Instantiates a new camgen rqst excl incl.
	 */
	public CamgenRqstExclIncl() {
	}

	/**
	 * Gets the camgen rqst excl incl id.
	 *
	 * @return the camgen rqst excl incl id
	 */
	public long getCamgenRqstExclInclId() {
		return this.camgenRqstExclInclId;
	}

	/**
	 * Sets the camgen rqst excl incl id.
	 *
	 * @param camgenRqstExclInclId the new camgen rqst excl incl id
	 */
	public void setCamgenRqstExclInclId(long camgenRqstExclInclId) {
		this.camgenRqstExclInclId = camgenRqstExclInclId;
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
	 * Gets the checks if is excluded.
	 *
	 * @return the checks if is excluded
	 */
	public BigDecimal getIsExcluded() {
		return this.isExcluded;
	}

	/**
	 * Sets the checks if is excluded.
	 *
	 * @param isExcluded the new checks if is excluded
	 */
	public void setIsExcluded(BigDecimal isExcluded) {
		this.isExcluded = isExcluded;
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
	 * Gets the reference id.
	 *
	 * @return the reference id
	 */
	public BigDecimal getReferenceId() {
		return this.referenceId;
	}

	/**
	 * Sets the reference id.
	 *
	 * @param referenceId the new reference id
	 */
	public void setReferenceId(BigDecimal referenceId) {
		this.referenceId = referenceId;
	}

	/**
	 * Gets the reference type.
	 *
	 * @return the reference type
	 */
	public String getReferenceType() {
		return this.referenceType;
	}

	/**
	 * Sets the reference type.
	 *
	 * @param referenceType the new reference type
	 */
	public void setReferenceType(String referenceType) {
		this.referenceType = referenceType;
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