/*
 * 
 */
package com.channel4.mint.automated.spot.interfaces.dto;

import org.joda.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

// TODO: Auto-generated Javadoc
/**
 * ManualSnapshot.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-12-19T04:58:28.844Z")

public class ManualSnapshot {

	/** The start date. */
	@JsonProperty("startDate")
	private LocalDate startDate = null;

	/** The end date. */
	@JsonProperty("endDate")
	private LocalDate endDate = null;

	/** The channel set id. */
	@JsonProperty("channelSetId")
	private Long channelSetId = null;

	/** The created by. */
	@JsonProperty("createdBy")
	private String createdBy = null;

	@JsonProperty("requestType")
	private String requestType = null;

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	/**
	 * Gets the start date.
	 *
	 * @return the start date
	 */
	public LocalDate getStartDate() {
		return startDate;
	}

	/**
	 * Sets the start date.
	 *
	 * @param startDate
	 *            the new start date
	 */
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	/**
	 * Gets the end date.
	 *
	 * @return the end date
	 */
	public LocalDate getEndDate() {
		return endDate;
	}

	/**
	 * Sets the end date.
	 *
	 * @param endDate
	 *            the new end date
	 */
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	/**
	 * Gets the channel set id.
	 *
	 * @return the channel set id
	 */
	public Long getChannelSetId() {
		return channelSetId;
	}

	/**
	 * Sets the channel set id.
	 *
	 * @param channelSetId
	 *            the new channel set id
	 */
	public void setChannelSetId(Long channelSetId) {
		this.channelSetId = channelSetId;
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
	 * @param createdBy
	 *            the new created by
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

}
