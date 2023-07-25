/*
 * 
 */
package com.channel4.mint.automated.spot.interfaces.dto;

import java.util.List;

import javax.validation.Valid;

import org.joda.time.LocalDate;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * CamgenSnapshotRunDetail
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-14T09:04:29.792Z")

public class CamgenSnapshotRunDetail {
	@JsonProperty("runId")
	private Integer runId = null;

	@JsonProperty("snapshotId")
	private Long snapshotId = null;

	@JsonProperty("iterationCount")
	private Integer iterationCount = null;

	@JsonProperty("runDateTime")
	private String runDateTime = null;
	
	// format will be yyyy-MM-dd'T'HHMMSS
	@JsonProperty("scheduledRunDateTime")
	private String scheduledRunDateTime = null;

	@JsonProperty("runStatus")
	private String runStatus = null;

	@JsonProperty("slotFlag")
	private Boolean slotFlag = null;

	@JsonProperty("notes")
	private String notes = null;

	@JsonProperty("slotFileImportStatus")
	private String slotFileImportStatus = null;

	@JsonProperty("slotFileLastImportDate")
	private LocalDate slotFileLastImportDate = null;

	@JsonProperty("camgenRunParameters")
	@Valid
	private List<CamgenRunParam> camgenRunParameters = null;

	@JsonProperty("camgenRunParamExtracts")
	@Valid
	private List<CamgenRunParamExtract> camgenRunParamExtracts = null;

	@JsonProperty("camgenRunParamStationEITimeBands")
	@Valid
	private List<CamgenRunParamStationEITimeBand> camgenRunParamStationEITimeBands = null;

	@JsonProperty("camgenRunParamStationTimeBands")
	@Valid
	private List<CamgenRunParamStationTimeBand> camgenRunParamStationTimeBands = null;

	@JsonProperty("camgenRunParamEIBands")
	@Valid
	private List<CamgenRunParamEIBand> camgenRunParamEIBands = null;

	@JsonProperty("camgenRunParamAudGroupChannels")
	@Valid
	private List<CamgenRunParamAudGroupChannel> camgenRunParamAudGroupChannels = null;

	@JsonProperty("createdBy")
	private String createdBy = null;

	public Integer getRunId() {
		return runId;
	}

	public void setRunId(Integer runId) {
		this.runId = runId;
	}

	public Long getSnapshotId() {
		return snapshotId;
	}

	public void setSnapshotId(Long snapshotId) {
		this.snapshotId = snapshotId;
	}

	public Integer getIterationCount() {
		return iterationCount;
	}

	public void setIterationCount(Integer iterationCount) {
		this.iterationCount = iterationCount;
	}

	public String getRunDateTime() {
		return runDateTime;
	}

	public void setRunDateTime(String runDateTime) {
		this.runDateTime = runDateTime;
	}

	public String getScheduledRunDateTime() {
		return scheduledRunDateTime;
	}

	public void setScheduledRunDateTime(String scheduledRunDateTime) {
		this.scheduledRunDateTime = scheduledRunDateTime;
	}

	public String getRunStatus() {
		return runStatus;
	}

	public void setRunStatus(String runStatus) {
		this.runStatus = runStatus;
	}

	public Boolean getSlotFlag() {
		return slotFlag;
	}

	public void setSlotFlag(Boolean slotFlag) {
		this.slotFlag = slotFlag;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getSlotFileImportStatus() {
		return slotFileImportStatus;
	}

	public void setSlotFileImportStatus(String slotFileImportStatus) {
		this.slotFileImportStatus = slotFileImportStatus;
	}

	public LocalDate getSlotFileLastImportDate() {
		return slotFileLastImportDate;
	}

	public void setSlotFileLastImportDate(LocalDate slotFileLastImportDate) {
		this.slotFileLastImportDate = slotFileLastImportDate;
	}

	public List<CamgenRunParam> getCamgenRunParameters() {
		return camgenRunParameters;
	}

	public void setCamgenRunParameters(List<CamgenRunParam> camgenRunParameters) {
		this.camgenRunParameters = camgenRunParameters;
	}

	public List<CamgenRunParamExtract> getCamgenRunParamExtracts() {
		return camgenRunParamExtracts;
	}

	public void setCamgenRunParamExtracts(List<CamgenRunParamExtract> camgenRunParamExtracts) {
		this.camgenRunParamExtracts = camgenRunParamExtracts;
	}

	public List<CamgenRunParamStationEITimeBand> getCamgenRunParamStationEITimeBands() {
		return camgenRunParamStationEITimeBands;
	}

	public void setCamgenRunParamStationEITimeBands(
			List<CamgenRunParamStationEITimeBand> camgenRunParamStationEITimeBands) {
		this.camgenRunParamStationEITimeBands = camgenRunParamStationEITimeBands;
	}

	public List<CamgenRunParamStationTimeBand> getCamgenRunParamStationTimeBands() {
		return camgenRunParamStationTimeBands;
	}

	public void setCamgenRunParamStationTimeBands(List<CamgenRunParamStationTimeBand> camgenRunParamStationTimeBands) {
		this.camgenRunParamStationTimeBands = camgenRunParamStationTimeBands;
	}

	public List<CamgenRunParamEIBand> getCamgenRunParamEIBands() {
		return camgenRunParamEIBands;
	}

	public void setCamgenRunParamEIBands(List<CamgenRunParamEIBand> camgenRunParamEIBands) {
		this.camgenRunParamEIBands = camgenRunParamEIBands;
	}

	public List<CamgenRunParamAudGroupChannel> getCamgenRunParamAudGroupChannels() {
		return camgenRunParamAudGroupChannels;
	}

	public void setCamgenRunParamAudGroupChannels(List<CamgenRunParamAudGroupChannel> camgenRunParamAudGroupChannels) {
		this.camgenRunParamAudGroupChannels = camgenRunParamAudGroupChannels;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

}
