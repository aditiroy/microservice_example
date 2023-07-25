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
 * The persistent class for the RUN_AUDIENCE_GROUP_CHANNEL database table.
 * 
 */
@Entity
@Table(name="RUN_AUDIENCE_GROUP_CHANNEL")
@NamedQuery(name="RunAudienceGroupChannel.findAll", query="SELECT r FROM RunAudienceGroupChannel r")
public class RunAudienceGroupChannel implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The audience group channel id. */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="AUDIENCE_GROUP_CHANNEL_ID")
	private long audienceGroupChannelId;

	/** The audience id. */
	@Column(name="AUDIENCE_ID")
	private BigDecimal audienceId;

	/** The channel id. */
	@Column(name="CHANNEL_ID")
	private BigDecimal channelId;

	/** The created by. */
	@Column(name="CREATED_BY")
	private String createdBy;

	/** The created on. */
	@Column(name="CREATED_ON")
	private Timestamp createdOn;

	/** The modified by. */
	@Column(name="MODIFIED_BY")
	private String modifiedBy;

	/** The modified on. */
	@Column(name="MODIFIED_ON")
	private Timestamp modifiedOn;

	/** The target percentage. */
	@Column(name="TARGET_PERCENTAGE")
	private BigDecimal targetPercentage;

	/** The camgen run. */
	//bi-directional many-to-one association to CamgenRun
	@ManyToOne
	@JoinColumn(name="RUN_ID")
	private CamgenRun camgenRun;

	/**
	 * Instantiates a new run audience group channel.
	 */
	public RunAudienceGroupChannel() {
	}

	/**
	 * Gets the audience group channel id.
	 *
	 * @return the audience group channel id
	 */
	public long getAudienceGroupChannelId() {
		return this.audienceGroupChannelId;
	}

	/**
	 * Sets the audience group channel id.
	 *
	 * @param audienceGroupChannelId the new audience group channel id
	 */
	public void setAudienceGroupChannelId(long audienceGroupChannelId) {
		this.audienceGroupChannelId = audienceGroupChannelId;
	}

	/**
	 * Gets the audience id.
	 *
	 * @return the audience id
	 */
	public BigDecimal getAudienceId() {
		return this.audienceId;
	}

	/**
	 * Sets the audience id.
	 *
	 * @param audienceId the new audience id
	 */
	public void setAudienceId(BigDecimal audienceId) {
		this.audienceId = audienceId;
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
	 * Gets the target percentage.
	 *
	 * @return the target percentage
	 */
	public BigDecimal getTargetPercentage() {
		return this.targetPercentage;
	}

	/**
	 * Sets the target percentage.
	 *
	 * @param targetPercentage the new target percentage
	 */
	public void setTargetPercentage(BigDecimal targetPercentage) {
		this.targetPercentage = targetPercentage;
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