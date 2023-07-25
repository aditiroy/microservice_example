/*
 * 
 */
package com.channel4.mint.automated.spot.interfaces.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

// TODO: Auto-generated Javadoc
/**
 * CamgenParamStationTimeBand.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-12-19T04:58:28.844Z")

public class CamgenParamStationTimeBand {
	
	/** The id. */
	@JsonProperty("id")
	private Long id = null;

	/** The channel id. */
	@JsonProperty("channelId")
	private Integer channelId = null;

	/** The station time band id. */
	@JsonProperty("stationTimeBandId")
	private Integer stationTimeBandId = null;

	/** The name. */
	@JsonProperty("name")
	private String name = null;

	/** The exclude flag. */
	@JsonProperty("excludeFlag")
	private Boolean excludeFlag = null;

	/** The day code. */
	@JsonProperty("dayCode")
	private String dayCode = null;

	/** The start time. */
	@JsonProperty("startTime")
	private String startTime = null;

	/** The end time. */
	@JsonProperty("endTime")
	private String endTime = null;

	/** The ei cut off. */
	@JsonProperty("eiCutOff")
	private Integer eiCutOff = null;

	/** The tb prog repetition limit. */
	@JsonProperty("tbProgRepetitionLimit")
	private Integer tbProgRepetitionLimit = null;

	/** The amend demand. */
	@JsonProperty("amendDemand")
	private Integer amendDemand = null;

	/** The created by. */
	@JsonProperty("createdBy")
	private String createdBy = null;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the channel id.
	 *
	 * @return the channel id
	 */
	public Integer getChannelId() {
		return channelId;
	}

	/**
	 * Sets the channel id.
	 *
	 * @param channelId the new channel id
	 */
	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}

	/**
	 * Gets the station time band id.
	 *
	 * @return the station time band id
	 */
	public Integer getStationTimeBandId() {
		return stationTimeBandId;
	}

	/**
	 * Sets the station time band id.
	 *
	 * @param stationTimeBandId the new station time band id
	 */
	public void setStationTimeBandId(Integer stationTimeBandId) {
		this.stationTimeBandId = stationTimeBandId;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the exclude flag.
	 *
	 * @return the exclude flag
	 */
	public Boolean getExcludeFlag() {
		return excludeFlag;
	}

	/**
	 * Sets the exclude flag.
	 *
	 * @param excludeFlag the new exclude flag
	 */
	public void setExcludeFlag(Boolean excludeFlag) {
		this.excludeFlag = excludeFlag;
	}

	/**
	 * Gets the day code.
	 *
	 * @return the day code
	 */
	public String getDayCode() {
		return dayCode;
	}

	/**
	 * Sets the day code.
	 *
	 * @param dayCode the new day code
	 */
	public void setDayCode(String dayCode) {
		this.dayCode = dayCode;
	}

	/**
	 * Gets the start time.
	 *
	 * @return the start time
	 */
	public String getStartTime() {
		return startTime;
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
	 * Gets the end time.
	 *
	 * @return the end time
	 */
	public String getEndTime() {
		return endTime;
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
	 * Gets the ei cut off.
	 *
	 * @return the ei cut off
	 */
	public Integer getEiCutOff() {
		return eiCutOff;
	}

	/**
	 * Sets the ei cut off.
	 *
	 * @param eiCutOff the new ei cut off
	 */
	public void setEiCutOff(Integer eiCutOff) {
		this.eiCutOff = eiCutOff;
	}

	/**
	 * Gets the tb prog repetition limit.
	 *
	 * @return the tb prog repetition limit
	 */
	public Integer getTbProgRepetitionLimit() {
		return tbProgRepetitionLimit;
	}

	/**
	 * Sets the tb prog repetition limit.
	 *
	 * @param tbProgRepetitionLimit the new tb prog repetition limit
	 */
	public void setTbProgRepetitionLimit(Integer tbProgRepetitionLimit) {
		this.tbProgRepetitionLimit = tbProgRepetitionLimit;
	}

	/**
	 * Gets the amend demand.
	 *
	 * @return the amend demand
	 */
	public Integer getAmendDemand() {
		return amendDemand;
	}

	/**
	 * Sets the amend demand.
	 *
	 * @param amendDemand the new amend demand
	 */
	public void setAmendDemand(Integer amendDemand) {
		this.amendDemand = amendDemand;
	}

	/**
	 * Gets the created by.
	 *
	 * @return the created by
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * Sets the created by.
	 *
	 * @param createdBy the new created by
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

}
