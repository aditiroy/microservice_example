package com.channel4.mint.automated.spot.interfaces.dto;

import java.util.List;

import javax.validation.Valid;

import org.joda.time.DateTime;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * PlansObject
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-14T09:04:29.792Z")

public class PlansObject {
	@JsonProperty("planId")
	private Integer planId = null;

	@JsonProperty("createdBy")
	private String createdBy = null;

	@JsonProperty("createdDateTime")
	private DateTime createdDateTime = null;

	@JsonProperty("modifiedBy")
	private String modifiedBy = null;

	@JsonProperty("modifiedDateTime")
	private DateTime modifiedDateTime = null;

	@JsonProperty("iterationCount")
	private Integer iterationCount = null;

	@JsonProperty("channelSetId")
	private Integer channelSetId = null;

	@JsonProperty("dateRange")
	private StartEndDate dateRange = null;

	@JsonProperty("run")
	private Boolean run = null;

	@JsonProperty("slot")
	private Boolean slot = null;

	@JsonProperty("autoFilling")
	@Valid
	private List<AutoFillingDaySetup> autoFilling = null;

	@JsonProperty("demandSupply")
	@Valid
	private List<DemandSupplyGroup> demandSupply = null;

	@JsonProperty("exclusions")
	private Exclusions exclusions = null;

	public Integer getPlanId() {
		return planId;
	}

	public void setPlanId(Integer planId) {
		this.planId = planId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public DateTime getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(DateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public DateTime getModifiedDateTime() {
		return modifiedDateTime;
	}

	public void setModifiedDateTime(DateTime modifiedDateTime) {
		this.modifiedDateTime = modifiedDateTime;
	}

	public Integer getIterationCount() {
		return iterationCount;
	}

	public void setIterationCount(Integer iterationCount) {
		this.iterationCount = iterationCount;
	}

	public Integer getChannelSetId() {
		return channelSetId;
	}

	public void setChannelSetId(Integer channelSetId) {
		this.channelSetId = channelSetId;
	}

	public StartEndDate getDateRange() {
		return dateRange;
	}

	public void setDateRange(StartEndDate dateRange) {
		this.dateRange = dateRange;
	}

	public Boolean getRun() {
		return run;
	}

	public void setRun(Boolean run) {
		this.run = run;
	}

	public Boolean getSlot() {
		return slot;
	}

	public void setSlot(Boolean slot) {
		this.slot = slot;
	}

	public List<AutoFillingDaySetup> getAutoFilling() {
		return autoFilling;
	}

	public void setAutoFilling(List<AutoFillingDaySetup> autoFilling) {
		this.autoFilling = autoFilling;
	}

	public List<DemandSupplyGroup> getDemandSupply() {
		return demandSupply;
	}

	public void setDemandSupply(List<DemandSupplyGroup> demandSupply) {
		this.demandSupply = demandSupply;
	}

	public Exclusions getExclusions() {
		return exclusions;
	}

	public void setExclusions(Exclusions exclusions) {
		this.exclusions = exclusions;
	}

}
