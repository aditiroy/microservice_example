/*
 * 
 */
package com.channel4.mint.automated.spot.interfaces.dto;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * CamgenRunIteration
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-14T09:04:29.792Z")

public class CamgenRunIteration {
	@JsonProperty("CamgenRunIterationId")
	private Long camgenRunIterationId = null;

	@JsonProperty("iterationNumber")
	private Integer iterationNumber = null;

	@JsonProperty("startTime")
	private String startTime = null;

	@JsonProperty("endTime")
	private String endTime = null;

	@JsonProperty("snapShotId")
	private Integer snapShotId = null;

	@JsonProperty("runId")
	private Integer runId = null;

	@JsonProperty("solutionFileName")
	private String solutionFileName = null;

	@JsonProperty("createdBy")
	private String createdBy = null;

	public Long getCamgenRunIterationId() {
		return camgenRunIterationId;
	}

	public void setCamgenRunIterationId(Long camgenRunIterationId) {
		this.camgenRunIterationId = camgenRunIterationId;
	}

	public Integer getIterationNumber() {
		return iterationNumber;
	}

	public void setIterationNumber(Integer iterationNumber) {
		this.iterationNumber = iterationNumber;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Integer getSnapShotId() {
		return snapShotId;
	}

	public void setSnapShotId(Integer snapShotId) {
		this.snapShotId = snapShotId;
	}

	public Integer getRunId() {
		return runId;
	}

	public void setRunId(Integer runId) {
		this.runId = runId;
	}

	public String getSolutionFileName() {
		return solutionFileName;
	}

	public void setSolutionFileName(String solutionFileName) {
		this.solutionFileName = solutionFileName;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

}
