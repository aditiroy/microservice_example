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
 * The persistent class for the CAMGEN_PLAN_AUTOFILLING_DAY database table.
 * 
 */
@Entity
@Table(name="CAMGEN_PLAN_AUTOFILLING_DAY")
@NamedQuery(name="CamgenPlanAutofillingDay.findAll", query="SELECT c FROM CamgenPlanAutofillingDay c")
public class CamgenPlanAutofillingDay implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The autofilling day id. */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="AUTOFILLING_DAY_ID")
	private long autofillingDayId;

	/** The duration. */
	private BigDecimal duration;

	/** The offset. */
	private BigDecimal offset;

	/** The run day. */
	@Column(name="RUN_DAY")
	private String runDay;

	/** The start time. */
	@Column(name="START_TIME")
	private String startTime;

	/** The camgen plan. */
	//bi-directional many-to-one association to CamgenPlan
	@ManyToOne
	@JoinColumn(name="PLAN_ID")
	private CamgenPlan camgenPlan;

	/**
	 * Instantiates a new camgen plan autofilling day.
	 */
	public CamgenPlanAutofillingDay() {
	}

	/**
	 * Gets the autofilling day id.
	 *
	 * @return the autofilling day id
	 */
	public long getAutofillingDayId() {
		return this.autofillingDayId;
	}

	/**
	 * Sets the autofilling day id.
	 *
	 * @param autofillingDayId the new autofilling day id
	 */
	public void setAutofillingDayId(long autofillingDayId) {
		this.autofillingDayId = autofillingDayId;
	}

	/**
	 * Gets the duration.
	 *
	 * @return the duration
	 */
	public BigDecimal getDuration() {
		return this.duration;
	}

	/**
	 * Sets the duration.
	 *
	 * @param duration the new duration
	 */
	public void setDuration(BigDecimal duration) {
		this.duration = duration;
	}

	/**
	 * Gets the offset.
	 *
	 * @return the offset
	 */
	public BigDecimal getOffset() {
		return this.offset;
	}

	/**
	 * Sets the offset.
	 *
	 * @param offset the new offset
	 */
	public void setOffset(BigDecimal offset) {
		this.offset = offset;
	}

	/**
	 * Gets the run day.
	 *
	 * @return the run day
	 */
	public String getRunDay() {
		return this.runDay;
	}

	/**
	 * Sets the run day.
	 *
	 * @param runDay the new run day
	 */
	public void setRunDay(String runDay) {
		this.runDay = runDay;
	}

	/**
	 * Gets the start time.
	 *
	 * @return the start time
	 */
	public String getStartTime() {
		return this.startTime;
	}

	/**
	 * Sets the start time.
	 *
	 * @param startTime the new start time
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
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