package com.channel4.mint.automated.spot.infrastructure.persistence.repository.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the CAMGEN_STATION_TIMEBAND database table.
 * 
 */
@Entity
@Table(name="CAMGEN_STATION_TIMEBAND")
@NamedQuery(name="CamgenStationTimeband.findAll", query="SELECT c FROM CamgenStationTimeband c")
public class CamgenStationTimeband implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="STATION_TIMEBAND_ID")
	private long stationTimebandId;

	@Column(name="AMEND_DEMAND")
	private BigDecimal amendDemand;

	@Column(name="APPLICABLE_DAY")
	private String applicableDay;

	@Column(name="CHANNEL_ID")
	private BigDecimal channelId;

	@Column(name="CREATED_BY")
	private String createdBy;

	@Column(name="CREATED_ON")
	private Timestamp createdOn;

	@Column(name="EI_CUT_OFF")
	private BigDecimal eiCutOff;

	@Column(name="END_TIME")
	private String endTime;

	@Column(name="IS_EXCLUDE")
	private BigDecimal isExclude;

	@Column(name="MODIFIED_BY")
	private String modifiedBy;

	@Column(name="MODIFIED_ON")
	private Timestamp modifiedOn;

	@Column(name="START_TIME")
	private String startTime;

	@Column(name="TB_PROG_REPITITION_LIMIT")
	private BigDecimal tbProgRepititionLimit;

	private String timeband;

	public CamgenStationTimeband() {
	}

	public long getStationTimebandId() {
		return this.stationTimebandId;
	}

	public void setStationTimebandId(long stationTimebandId) {
		this.stationTimebandId = stationTimebandId;
	}

	public BigDecimal getAmendDemand() {
		return this.amendDemand;
	}

	public void setAmendDemand(BigDecimal amendDemand) {
		this.amendDemand = amendDemand;
	}

	public String getApplicableDay() {
		return this.applicableDay;
	}

	public void setApplicableDay(String applicableDay) {
		this.applicableDay = applicableDay;
	}

	public BigDecimal getChannelId() {
		return this.channelId;
	}

	public void setChannelId(BigDecimal channelId) {
		this.channelId = channelId;
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

	public BigDecimal getEiCutOff() {
		return this.eiCutOff;
	}

	public void setEiCutOff(BigDecimal eiCutOff) {
		this.eiCutOff = eiCutOff;
	}

	public String getEndTime() {
		return this.endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public BigDecimal getIsExclude() {
		return this.isExclude;
	}

	public void setIsExclude(BigDecimal isExclude) {
		this.isExclude = isExclude;
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

	public String getStartTime() {
		return this.startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public BigDecimal getTbProgRepititionLimit() {
		return this.tbProgRepititionLimit;
	}

	public void setTbProgRepititionLimit(BigDecimal tbProgRepititionLimit) {
		this.tbProgRepititionLimit = tbProgRepititionLimit;
	}

	public String getTimeband() {
		return this.timeband;
	}

	public void setTimeband(String timeband) {
		this.timeband = timeband;
	}

}