/*
 * 
 */
package com.channel4.mint.automated.spot.interfaces.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

// TODO: Auto-generated Javadoc
/**
 * CamgenParamStationEITimeBand.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-12-19T04:58:28.844Z")

public class CamgenParamStationEITimeBand {
	
	/** The id. */
	@JsonProperty("id")
	private Long id = null;

	/** The day code. */
	@JsonProperty("dayCode")
	private String dayCode = null;

	/** The start time. */
	@JsonProperty("startTime")
	private String startTime = null;

	/** The end time. */
	@JsonProperty("endTime")
	private String endTime = null;

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
