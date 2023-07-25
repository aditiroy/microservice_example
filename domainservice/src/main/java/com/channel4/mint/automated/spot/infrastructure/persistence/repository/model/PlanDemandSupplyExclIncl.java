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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


// TODO: Auto-generated Javadoc
/**
 * The persistent class for the PLAN_DEMAND_SUPPLY_EXCL_INCL database table.
 * 
 */
@Entity
@Table(name="PLAN_DEMAND_SUPPLY_EXCL_INCL")
@NamedQuery(name="PlanDemandSupplyExclIncl.findAll", query="SELECT p FROM PlanDemandSupplyExclIncl p")
public class PlanDemandSupplyExclIncl implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The demand supply excl incl id. */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DEMAND_SUPPLY_EXCL_INCL_ID")
	private long demandSupplyExclInclId;

	/** The category. */
	private String category;

	/** The end time. */
	@Column(name="END_TIME")
	private String endTime;

	/** The is excluded. */
	@Column(name="IS_EXCLUDED")
	private BigDecimal isExcluded;

	/** The reference code. */
	@Column(name="REFERENCE_CODE")
	private String referenceCode;

	/** The star time. */
	@Column(name="STAR_TIME")
	private String starTime;

	/** The camgen plan. */
	//bi-directional many-to-one association to CamgenPlan
	@ManyToOne
	@JoinColumn(name="PLAN_ID")
	private CamgenPlan camgenPlan;

	/**
	 * Instantiates a new plan demand supply excl incl.
	 */
	public PlanDemandSupplyExclIncl() {
	}

	/**
	 * Gets the demand supply excl incl id.
	 *
	 * @return the demand supply excl incl id
	 */
	public long getDemandSupplyExclInclId() {
		return this.demandSupplyExclInclId;
	}

	/**
	 * Sets the demand supply excl incl id.
	 *
	 * @param demandSupplyExclInclId the new demand supply excl incl id
	 */
	public void setDemandSupplyExclInclId(long demandSupplyExclInclId) {
		this.demandSupplyExclInclId = demandSupplyExclInclId;
	}

	/**
	 * Gets the category.
	 *
	 * @return the category
	 */
	public String getCategory() {
		return this.category;
	}

	/**
	 * Sets the category.
	 *
	 * @param category the new category
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * Gets the end time.
	 *
	 * @return the end time
	 */
	public String getEndTime() {
		return this.endTime;
	}

	/**
	 * Sets the end time.
	 *
	 * @param endTime the new end time
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
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
	 * Gets the reference code.
	 *
	 * @return the reference code
	 */
	public String getReferenceCode() {
		return this.referenceCode;
	}

	/**
	 * Sets the reference code.
	 *
	 * @param referenceCode the new reference code
	 */
	public void setReferenceCode(String referenceCode) {
		this.referenceCode = referenceCode;
	}

	/**
	 * Gets the star time.
	 *
	 * @return the star time
	 */
	public String getStarTime() {
		return this.starTime;
	}

	/**
	 * Sets the star time.
	 *
	 * @param starTime the new star time
	 */
	public void setStarTime(String starTime) {
		this.starTime = starTime;
	}

	/**
	 * Gets the camgen plan.
	 *
	 * @return the camgen plan
	 */
	public CamgenPlan getCamgenPlan() {
		return this.camgenPlan;
	}

	/**
	 * Sets the camgen plan.
	 *
	 * @param camgenPlan the new camgen plan
	 */
	public void setCamgenPlan(CamgenPlan camgenPlan) {
		this.camgenPlan = camgenPlan;
	}

}