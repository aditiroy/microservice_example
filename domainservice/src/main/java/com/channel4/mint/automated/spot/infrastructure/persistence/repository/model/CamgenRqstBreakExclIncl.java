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


/**
 * The persistent class for the CAMGEN_RQST_BREAK_EXCL_INCL database table.
 * 
 */
@Entity
@Table(name="CAMGEN_RQST_BREAK_EXCL_INCL")
@NamedQuery(name="CamgenRqstBreakExclIncl.findAll", query="SELECT c FROM CamgenRqstBreakExclIncl c")
public class CamgenRqstBreakExclIncl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CAMGEN_RQST_BREAK_EXCL_INCL_ID")
	private long camgenRqstBreakExclInclId;

	@Column(name="COMMERCIAL_BREAK_ID")
	private BigDecimal commercialBreakId;

	@Column(name="CREATED_BY")
	private String createdBy;

	@Column(name="CREATED_ON")
	private Timestamp createdOn;

	@Column(name="IS_EXCLUDED")
	private BigDecimal isExcluded;

	@Column(name="MODIFIED_BY")
	private String modifiedBy;

	@Column(name="MODIFIED_ON")
	private Timestamp modifiedOn;

	//bi-directional many-to-one association to CamgenRequest
	@ManyToOne
	@JoinColumn(name="REQUEST_ID")
	private CamgenRequest camgenRequest;

	public CamgenRqstBreakExclIncl() {
	}

	public long getCamgenRqstBreakExclInclId() {
		return this.camgenRqstBreakExclInclId;
	}

	public void setCamgenRqstBreakExclInclId(long camgenRqstBreakExclInclId) {
		this.camgenRqstBreakExclInclId = camgenRqstBreakExclInclId;
	}

	public BigDecimal getCommercialBreakId() {
		return this.commercialBreakId;
	}

	public void setCommercialBreakId(BigDecimal commercialBreakId) {
		this.commercialBreakId = commercialBreakId;
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

	public BigDecimal getIsExcluded() {
		return this.isExcluded;
	}

	public void setIsExcluded(BigDecimal isExcluded) {
		this.isExcluded = isExcluded;
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

	public CamgenRequest getCamgenRequest() {
		return this.camgenRequest;
	}

	public void setCamgenRequest(CamgenRequest camgenRequest) {
		this.camgenRequest = camgenRequest;
	}

}