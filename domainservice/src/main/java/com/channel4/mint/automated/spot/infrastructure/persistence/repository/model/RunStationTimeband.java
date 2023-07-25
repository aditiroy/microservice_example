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
 * The persistent class for the RUN_STATION_TIMEBAND database table.
 * 
 */
@Entity
@Table(name="RUN_STATION_TIMEBAND")
@NamedQuery(name="RunStationTimeband.findAll", query="SELECT r FROM RunStationTimeband r")
public class RunStationTimeband implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The station timeband id. */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="STATION_TIMEBAND_ID")
	private long stationTimebandId;

	/** The amend demand. */
	@Column(name="AMEND_DEMAND")
	private BigDecimal amendDemand;

	/** The applicable day. */
	@Column(name="APPLICABLE_DAY")
	private String applicableDay;

	/** The channel id. */
	@Column(name="CHANNEL_ID")
	private BigDecimal channelId;

	/** The created by. */
	@Column(name="CREATED_BY")
	private String createdBy;

	/** The created on. */
	@Column(name="CREATED_ON")
	private Timestamp createdOn;

	/** The ei cut off. */
	@Column(name="EI_CUT_OFF")
	private BigDecimal eiCutOff;

	/** The end time. */
	@Column(name="END_TIME")
	private String endTime;

	/** The is exclude. */
	@Column(name="IS_EXCLUDE")
	private BigDecimal isExclude;

	/** The modified by. */
	@Column(name="MODIFIED_BY")
	private String modifiedBy;

	/** The modified on. */
	@Column(name="MODIFIED_ON")
	private Timestamp modifiedOn;

	/** The start time. */
	@Column(name="START_TIME")
	private String startTime;

	/** The tb prog repitition limit. */
	@Column(name="TB_PROG_REPITITION_LIMIT")
	private BigDecimal tbProgRepititionLimit;

	/** The timeband. */
	private String timeband;

	/** The camgen run. */
	//bi-directional many-to-one association to CamgenRun
	@ManyToOne
	@JoinColumn(name="RUN_ID")
	private CamgenRun camgenRun;

	/**
	 * Instantiates a new run station timeband.
	 */
	public RunStationTimeband() {
	}

	/**
	 * Gets the station timeband id.
	 *
	 * @return the station timeband id
	 */
	public long getStationTimebandId() {
		return this.stationTimebandId;
	}

	/**
	 * Sets the station timeband id.
	 *
	 * @param stationTimebandId the new station timeband id
	 */
	public void setStationTimebandId(long stationTimebandId) {
		this.stationTimebandId = stationTimebandId;
	}

	/**
	 * Gets the amend demand.
	 *
	 * @return the amend demand
	 */
	public BigDecimal getAmendDemand() {
		return this.amendDemand;
	}

	/**
	 * Sets the amend demand.
	 *
	 * @param amendDemand the new amend demand
	 */
	public void setAmendDemand(BigDecimal amendDemand) {
		this.amendDemand = amendDemand;
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
	 * Gets the channel id.
	 *
	 * @return the channel id
	 */
	public BigDecimal getChannelId() {
		return this.channelId;
	}

	/**
	 * Sets the channel id.
	 *
	 * @param channelId the new channel id
	 */
	public void setChannelId(BigDecimal channelId) {
		this.channelId = channelId;
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
	 * Gets the ei cut off.
	 *
	 * @return the ei cut off
	 */
	public BigDecimal getEiCutOff() {
		return this.eiCutOff;
	}

	/**
	 * Sets the ei cut off.
	 *
	 * @param eiCutOff the new ei cut off
	 */
	public void setEiCutOff(BigDecimal eiCutOff) {
		this.eiCutOff = eiCutOff;
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
	 * Gets the checks if is exclude.
	 *
	 * @return the checks if is exclude
	 */
	public BigDecimal getIsExclude() {
		return this.isExclude;
	}

	/**
	 * Sets the checks if is exclude.
	 *
	 * @param isExclude the new checks if is exclude
	 */
	public void setIsExclude(BigDecimal isExclude) {
		this.isExclude = isExclude;
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
	 * Gets the tb prog repitition limit.
	 *
	 * @return the tb prog repitition limit
	 */
	public BigDecimal getTbProgRepititionLimit() {
		return this.tbProgRepititionLimit;
	}

	/**
	 * Sets the tb prog repitition limit.
	 *
	 * @param tbProgRepititionLimit the new tb prog repitition limit
	 */
	public void setTbProgRepititionLimit(BigDecimal tbProgRepititionLimit) {
		this.tbProgRepititionLimit = tbProgRepititionLimit;
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