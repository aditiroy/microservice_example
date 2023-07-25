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
 * The persistent class for the CAMGEN_RQST_CH_SET_TIMEBAND database table.
 * 
 */
@Entity
@Table(name="CAMGEN_RQST_CH_SET_TIMEBAND")
@NamedQuery(name="CamgenRqstChSetTimeband.findAll", query="SELECT c FROM CamgenRqstChSetTimeband c")
public class CamgenRqstChSetTimeband implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The camgen rqst ch set timeband id. */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CAMGEN_RQST_CH_SET_TIMEBAND_ID")
	private long camgenRqstChSetTimebandId;

	/** The applicable day. */
	@Column(name="APPLICABLE_DAY")
	private String applicableDay;

	/** The availability percentage. */
	@Column(name="AVAILABILITY_PERCENTAGE")
	private BigDecimal availabilityPercentage;

	/** The created by. */
	@Column(name="CREATED_BY")
	private String createdBy;

	/** The created on. */
	@Column(name="CREATED_ON")
	private Timestamp createdOn;

	/** The end time. */
	@Column(name="END_TIME")
	private String endTime;

	/** The modified by. */
	@Column(name="MODIFIED_BY")
	private String modifiedBy;

	/** The modified on. */
	@Column(name="MODIFIED_ON")
	private Timestamp modifiedOn;

	/** The start time. */
	@Column(name="START_TIME")
	private String startTime;

	/** The timeband. */
	private String timeband;

	/** The camgen request. */
	//bi-directional many-to-one association to CamgenRequest
	@ManyToOne
	@JoinColumn(name="REQUEST_ID")
	private CamgenRequest camgenRequest;

	/**
	 * Instantiates a new camgen rqst ch set timeband.
	 */
	public CamgenRqstChSetTimeband() {
	}

	/**
	 * Gets the camgen rqst ch set timeband id.
	 *
	 * @return the camgen rqst ch set timeband id
	 */
	public long getCamgenRqstChSetTimebandId() {
		return this.camgenRqstChSetTimebandId;
	}

	/**
	 * Sets the camgen rqst ch set timeband id.
	 *
	 * @param camgenRqstChSetTimebandId the new camgen rqst ch set timeband id
	 */
	public void setCamgenRqstChSetTimebandId(long camgenRqstChSetTimebandId) {
		this.camgenRqstChSetTimebandId = camgenRqstChSetTimebandId;
	}

	/**
	 * Gets the applicable day.
	 *
	 * @return the applicable day
	 */
	public String getApplicableDay() {
		return this.applicableDay;
	}

	/**
	 * Sets the applicable day.
	 *
	 * @param applicableDay the new applicable day
	 */
	public void setApplicableDay(String applicableDay) {
		this.applicableDay = applicableDay;
	}

	/**
	 * Gets the availability percentage.
	 *
	 * @return the availability percentage
	 */
	public BigDecimal getAvailabilityPercentage() {
		return this.availabilityPercentage;
	}

	/**
	 * Sets the availability percentage.
	 *
	 * @param availabilityPercentage the new availability percentage
	 */
	public void setAvailabilityPercentage(BigDecimal availabilityPercentage) {
		this.availabilityPercentage = availabilityPercentage;
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
	 * Gets the timeband.
	 *
	 * @return the timeband
	 */
	public String getTimeband() {
		return this.timeband;
	}

	/**
	 * Sets the timeband.
	 *
	 * @param timeband the new timeband
	 */
	public void setTimeband(String timeband) {
		this.timeband = timeband;
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