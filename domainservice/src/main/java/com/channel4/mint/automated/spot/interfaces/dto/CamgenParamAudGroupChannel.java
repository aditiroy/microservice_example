/*
 * 
 */
package com.channel4.mint.automated.spot.interfaces.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

// TODO: Auto-generated Javadoc
/**
 * CamgenParamAudGroupChannel.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-12-19T04:58:28.844Z")

public class CamgenParamAudGroupChannel {
	
	/** The id. */
	@JsonProperty("id")
	private Long id = null;

	/** The audience group id. */
	@JsonProperty("audienceGroupId")
	private Integer audienceGroupId = null;

	/** The channel id. */
	@JsonProperty("channelId")
	private Integer channelId = null;

	/** The key audience id. */
	@JsonProperty("keyAudienceId")
	private Integer keyAudienceId = null;

	/** The target percentage. */
	@JsonProperty("targetPercentage")
	private String targetPercentage = null;

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
	 * Gets the audience group id.
	 *
	 * @return the audience group id
	 */
	public Integer getAudienceGroupId() {
		return audienceGroupId;
	}

	/**
	 * Sets the audience group id.
	 *
	 * @param audienceGroupId the new audience group id
	 */
	public void setAudienceGroupId(Integer audienceGroupId) {
		this.audienceGroupId = audienceGroupId;
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
	 * Gets the key audience id.
	 *
	 * @return the key audience id
	 */
	public Integer getKeyAudienceId() {
		return keyAudienceId;
	}

	/**
	 * Sets the key audience id.
	 *
	 * @param keyAudienceId the new key audience id
	 */
	public void setKeyAudienceId(Integer keyAudienceId) {
		this.keyAudienceId = keyAudienceId;
	}

	/**
	 * Gets the target percentage.
	 *
	 * @return the target percentage
	 */
	public String getTargetPercentage() {
		return targetPercentage;
	}

	/**
	 * Sets the target percentage.
	 *
	 * @param targetPercentage the new target percentage
	 */
	public void setTargetPercentage(String targetPercentage) {
		this.targetPercentage = targetPercentage;
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
