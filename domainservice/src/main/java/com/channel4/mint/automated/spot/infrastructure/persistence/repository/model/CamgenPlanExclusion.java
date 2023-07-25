package com.channel4.mint.automated.spot.infrastructure.persistence.repository.model;

import java.io.Serializable;

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
 * The persistent class for the CAMGEN_PLAN_EXCLUSION database table.
 * 
 */
@Entity
@Table(name = "CAMGEN_PLAN_EXCLUSION")
@NamedQuery(name = "CamgenPlanExclusion.findAll", query = "SELECT c FROM CamgenPlanExclusion c")
public class CamgenPlanExclusion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CAMGEN_PLAN_EXCLUSION_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long camgenPlanExclusionId;

	private String category;

	@Column(name = "END_TIME")
	private String endTime;

	@Column(name = "REFERENCE_CODE")
	private String referenceCode;

	@Column(name = "START_TIME")
	private String starTime;

	@ManyToOne
	@JoinColumn(name = "PLAN_ID")
	private CamgenPlan camgenPlan;

	public CamgenPlanExclusion() {
	}

	public long getCamgenPlanExclusionId() {
		return this.camgenPlanExclusionId;
	}

	public void setCamgenPlanExclusionId(long camgenPlanExclusionId) {
		this.camgenPlanExclusionId = camgenPlanExclusionId;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getEndTime() {
		return this.endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}


	public String getReferenceCode() {
		return this.referenceCode;
	}

	public void setReferenceCode(String referenceCode) {
		this.referenceCode = referenceCode;
	}

	public String getStarTime() {
		return this.starTime;
	}

	public void setStarTime(String starTime) {
		this.starTime = starTime;
	}

	public CamgenPlan getCamgenPlan() {
		return this.camgenPlan;
	}

	public void setCamgenPlan(CamgenPlan camgenPlan) {
		this.camgenPlan = camgenPlan;
	}

}