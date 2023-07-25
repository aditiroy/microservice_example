package com.channel4.mint.automated.spot.interfaces.dto;

import java.util.List;

import javax.validation.Valid;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * SnapshotDetail
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-14T09:04:29.792Z")

public class SnapshotDetail {
	@JsonProperty("snapshotId")
	private Integer snapshotId = null;

	@JsonProperty("type")
	private String type = null;

	@JsonProperty("iterationCount")
	private Integer iterationCount = null;

	@JsonProperty("channelSet")
	private Long channelSet = null;

	@JsonProperty("planId")
	private Long planId = null;

	@JsonProperty("camgenRequestStartDate")
	private LocalDate camgenRequestStartDate = null;

	@JsonProperty("camgenRequestEndDate")
	private LocalDate camgenRequestEndDate = null;

	@JsonProperty("run")
	private Boolean run = null;

	@JsonProperty("slot")
	private Boolean slot = null;

	@JsonProperty("status")
	private String status = null;

	@JsonProperty("scheduledDateTime")
	private LocalDate scheduledDateTime = null;

	@JsonProperty("createdOn")
	private DateTime createdOn = null;

	@JsonProperty("createdBy")
	private String createdBy = null;

	@JsonProperty("fillingStartDate")
	private LocalDate fillingStartDate = null;

	@JsonProperty("fillingEndDate")
	private LocalDate fillingEndDate = null;

	@JsonProperty("demandSupply")
	@Valid
	private List<DemandSupplyGroup> demandSupply = null;

	@JsonProperty("channelSetTimebands")
	@Valid
	private List<ChannelSetTimeBand> channelSetTimebands = null;

	@JsonProperty("batchTxLevels")
	@Valid
	private List<BatchTxLevel> batchTxLevels = null;

	@JsonProperty("commercialBreakInclExcls")
	@Valid
	private List<CamgenRequestBreakExclIncl> commercialBreakInclExcls = null;

	@JsonProperty("campaignMonthInclExcls")
	@Valid
	private List<CamgenRequestCMExclIncl> campaignMonthInclExcls = null;

	public LocalDate getFillingStartDate() {
		return fillingStartDate;
	}

	public void setFillingStartDate(LocalDate fillingStartDate) {
		this.fillingStartDate = fillingStartDate;
	}

	public LocalDate getFillingEndDate() {
		return fillingEndDate;
	}

	public void setFillingEndDate(LocalDate fillingEndDate) {
		this.fillingEndDate = fillingEndDate;
	}

	public Integer getSnapshotId() {
		return snapshotId;
	}

	public void setSnapshotId(Integer snapshotId) {
		this.snapshotId = snapshotId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getIterationCount() {
		return iterationCount;
	}

	public void setIterationCount(Integer iterationCount) {
		this.iterationCount = iterationCount;
	}

	public Long getChannelSet() {
		return channelSet;
	}

	public void setChannelSet(Long channelSet) {
		this.channelSet = channelSet;
	}

	public Long getPlanId() {
		return planId;
	}

	public void setPlanId(Long planId) {
		this.planId = planId;
	}

	public LocalDate getCamgenRequestStartDate() {
		return camgenRequestStartDate;
	}

	public void setCamgenRequestStartDate(LocalDate camgenRequestStartDate) {
		this.camgenRequestStartDate = camgenRequestStartDate;
	}

	public LocalDate getCamgenRequestEndDate() {
		return camgenRequestEndDate;
	}

	public void setCamgenRequestEndDate(LocalDate camgenRequestEndDate) {
		this.camgenRequestEndDate = camgenRequestEndDate;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getScheduledDateTime() {
		return scheduledDateTime;
	}

	public void setScheduledDateTime(LocalDate scheduledDateTime) {
		this.scheduledDateTime = scheduledDateTime;
	}

	public DateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(DateTime createdOn) {
		this.createdOn = createdOn;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public List<DemandSupplyGroup> getDemandSupply() {
		return demandSupply;
	}

	public void setDemandSupply(List<DemandSupplyGroup> demandSupply) {
		this.demandSupply = demandSupply;
	}

	public List<ChannelSetTimeBand> getChannelSetTimebands() {
		return channelSetTimebands;
	}

	public void setChannelSetTimebands(List<ChannelSetTimeBand> channelSetTimebands) {
		this.channelSetTimebands = channelSetTimebands;
	}

	public List<BatchTxLevel> getBatchTxLevels() {
		return batchTxLevels;
	}

	public void setBatchTxLevels(List<BatchTxLevel> batchTxLevels) {
		this.batchTxLevels = batchTxLevels;
	}

	public List<CamgenRequestBreakExclIncl> getCommercialBreakInclExcls() {
		return commercialBreakInclExcls;
	}

	public void setCommercialBreakInclExcls(List<CamgenRequestBreakExclIncl> commercialBreakInclExcls) {
		this.commercialBreakInclExcls = commercialBreakInclExcls;
	}

	public List<CamgenRequestCMExclIncl> getCampaignMonthInclExcls() {
		return campaignMonthInclExcls;
	}

	public void setCampaignMonthInclExcls(List<CamgenRequestCMExclIncl> campaignMonthInclExcls) {
		this.campaignMonthInclExcls = campaignMonthInclExcls;
	}

}
