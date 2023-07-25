package com.channel4.mint.automated.spot.infrastructure.persistence.repository.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the CAMGEN_STATION_EI_TIMEBAND database table.
 * 
 */
@Entity
@Table(name="CAMGEN_STATION_EI_TIMEBAND")
@NamedQuery(name="CamgenStationEiTimeband.findAll", query="SELECT c FROM CamgenStationEiTimeband c")
public class CamgenStationEiTimeband implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="STATION_EI_TIMEBAND_ID")
	private long stationEiTimebandId;

	@Column(name="APPLICABLE_DAY")
	private String applicableDay;

	@Column(name="CREATED_BY")
	private String createdBy;

	@Column(name="CREATED_ON")
	private Timestamp createdOn;

	@Column(name="END_TIME")
	private String endTime;

	@Column(name="MODIFIED_BY")
	private String modifiedBy;

	@Column(name="MODIFIED_ON")
	private Timestamp modifiedOn;

	@Column(name="START_TIME")
	private String startTime;

	public CamgenStationEiTimeband() {
	}

	public long getStationEiTimebandId() {
		return this.stationEiTimebandId;
	}

	public void setStationEiTimebandId(long stationEiTimebandId) {
		this.stationEiTimebandId = stationEiTimebandId;
	}

	public String getApplicableDay() {
		return this.applicableDay;
	}

	public void setApplicableDay(String applicableDay) {
		this.applicableDay = applicableDay;
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

	public String getEndTime() {
		return this.endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
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

}