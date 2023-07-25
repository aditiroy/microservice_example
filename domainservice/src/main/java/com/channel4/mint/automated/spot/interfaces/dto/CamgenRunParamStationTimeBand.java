/*
 * 
 */
package com.channel4.mint.automated.spot.interfaces.dto;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * CamgenRunParamStationTimeBand
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-14T09:04:29.792Z")

public class CamgenRunParamStationTimeBand {
	@JsonProperty("runParameterStationTimeBandId")
	private Integer runParameterStationTimeBandId = null;

	@JsonProperty("channelId")
	private Integer channelId = null;

	@JsonProperty("stationTimeBandId")
	private Integer stationTimeBandId = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("excludeFlag")
	private String excludeFlag = null;

	@JsonProperty("dayCode")
	private String dayCode = null;

	@JsonProperty("startTime")
	private String startTime = null;

	@JsonProperty("endTime")
	private String endTime = null;

	@JsonProperty("eiCutOff")
	private Integer eiCutOff = null;

	@JsonProperty("tbProgRepetitionLimit")
	private Integer tbProgRepetitionLimit = null;

	@JsonProperty("amendDemand")
	private Integer amendDemand = null;

	@JsonProperty("createdBy")
	private String createdBy = null;

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public CamgenRunParamStationTimeBand runParameterStationTimeBandId(Integer runParameterStationTimeBandId) {
		this.runParameterStationTimeBandId = runParameterStationTimeBandId;
		return this;
	}

	/**
	 * Get runParameterStationTimeBandId
	 * 
	 * @return runParameterStationTimeBandId
	 **/
	@ApiModelProperty(value = "")

	public Integer getRunParameterStationTimeBandId() {
		return runParameterStationTimeBandId;
	}

	public void setRunParameterStationTimeBandId(Integer runParameterStationTimeBandId) {
		this.runParameterStationTimeBandId = runParameterStationTimeBandId;
	}

	public CamgenRunParamStationTimeBand channelId(Integer channelId) {
		this.channelId = channelId;
		return this;
	}

	/**
	 * Get channelId
	 * 
	 * @return channelId
	 **/
	@ApiModelProperty(value = "")

	public Integer getChannelId() {
		return channelId;
	}

	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}

	public CamgenRunParamStationTimeBand stationTimeBandId(Integer stationTimeBandId) {
		this.stationTimeBandId = stationTimeBandId;
		return this;
	}

	/**
	 * Get stationTimeBandId
	 * 
	 * @return stationTimeBandId
	 **/
	@ApiModelProperty(value = "")

	public Integer getStationTimeBandId() {
		return stationTimeBandId;
	}

	public void setStationTimeBandId(Integer stationTimeBandId) {
		this.stationTimeBandId = stationTimeBandId;
	}

	public CamgenRunParamStationTimeBand name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Get name
	 * 
	 * @return name
	 **/
	@ApiModelProperty(value = "")

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CamgenRunParamStationTimeBand excludeFlag(String excludeFlag) {
		this.excludeFlag = excludeFlag;
		return this;
	}

	/**
	 * Get excludeFlag
	 * 
	 * @return excludeFlag
	 **/
	@ApiModelProperty(value = "")

	public String getExcludeFlag() {
		return excludeFlag;
	}

	public void setExcludeFlag(String excludeFlag) {
		this.excludeFlag = excludeFlag;
	}

	public CamgenRunParamStationTimeBand dayCode(String dayCode) {
		this.dayCode = dayCode;
		return this;
	}

	/**
	 * Get dayCode
	 * 
	 * @return dayCode
	 **/
	@ApiModelProperty(value = "")

	public String getDayCode() {
		return dayCode;
	}

	public void setDayCode(String dayCode) {
		this.dayCode = dayCode;
	}

	public CamgenRunParamStationTimeBand startTime(String startTime) {
		this.startTime = startTime;
		return this;
	}

	/**
	 * Get startTime
	 * 
	 * @return startTime
	 **/
	@ApiModelProperty(value = "")

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public CamgenRunParamStationTimeBand endTime(String endTime) {
		this.endTime = endTime;
		return this;
	}

	/**
	 * Get endTime
	 * 
	 * @return endTime
	 **/
	@ApiModelProperty(value = "")

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public CamgenRunParamStationTimeBand eiCutOff(Integer eiCutOff) {
		this.eiCutOff = eiCutOff;
		return this;
	}

	/**
	 * Get eiCutOff
	 * 
	 * @return eiCutOff
	 **/
	@ApiModelProperty(value = "")

	public Integer getEiCutOff() {
		return eiCutOff;
	}

	public void setEiCutOff(Integer eiCutOff) {
		this.eiCutOff = eiCutOff;
	}

	public CamgenRunParamStationTimeBand tbProgRepetitionLimit(Integer tbProgRepetitionLimit) {
		this.tbProgRepetitionLimit = tbProgRepetitionLimit;
		return this;
	}

	/**
	 * Get tbProgRepetitionLimit
	 * 
	 * @return tbProgRepetitionLimit
	 **/
	@ApiModelProperty(value = "")

	public Integer getTbProgRepetitionLimit() {
		return tbProgRepetitionLimit;
	}

	public void setTbProgRepetitionLimit(Integer tbProgRepetitionLimit) {
		this.tbProgRepetitionLimit = tbProgRepetitionLimit;
	}

	public CamgenRunParamStationTimeBand amendDemand(Integer amendDemand) {
		this.amendDemand = amendDemand;
		return this;
	}

	/**
	 * Get amendDemand
	 * 
	 * @return amendDemand
	 **/
	@ApiModelProperty(value = "")

	public Integer getAmendDemand() {
		return amendDemand;
	}

	public void setAmendDemand(Integer amendDemand) {
		this.amendDemand = amendDemand;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CamgenRunParamStationTimeBand camgenRunParamStationTimeBand = (CamgenRunParamStationTimeBand) o;
		return Objects.equals(this.runParameterStationTimeBandId,
				camgenRunParamStationTimeBand.runParameterStationTimeBandId)
				&& Objects.equals(this.channelId, camgenRunParamStationTimeBand.channelId)
				&& Objects.equals(this.stationTimeBandId, camgenRunParamStationTimeBand.stationTimeBandId)
				&& Objects.equals(this.name, camgenRunParamStationTimeBand.name)
				&& Objects.equals(this.excludeFlag, camgenRunParamStationTimeBand.excludeFlag)
				&& Objects.equals(this.dayCode, camgenRunParamStationTimeBand.dayCode)
				&& Objects.equals(this.startTime, camgenRunParamStationTimeBand.startTime)
				&& Objects.equals(this.endTime, camgenRunParamStationTimeBand.endTime)
				&& Objects.equals(this.eiCutOff, camgenRunParamStationTimeBand.eiCutOff)
				&& Objects.equals(this.tbProgRepetitionLimit, camgenRunParamStationTimeBand.tbProgRepetitionLimit)
				&& Objects.equals(this.amendDemand, camgenRunParamStationTimeBand.amendDemand);
	}

	@Override
	public int hashCode() {
		return Objects.hash(runParameterStationTimeBandId, channelId, stationTimeBandId, name, excludeFlag, dayCode,
				startTime, endTime, eiCutOff, tbProgRepetitionLimit, amendDemand);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class CamgenRunParamStationTimeBand {\n");

		sb.append("    runParameterStationTimeBandId: ").append(toIndentedString(runParameterStationTimeBandId))
				.append("\n");
		sb.append("    channelId: ").append(toIndentedString(channelId)).append("\n");
		sb.append("    stationTimeBandId: ").append(toIndentedString(stationTimeBandId)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    excludeFlag: ").append(toIndentedString(excludeFlag)).append("\n");
		sb.append("    dayCode: ").append(toIndentedString(dayCode)).append("\n");
		sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
		sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
		sb.append("    eiCutOff: ").append(toIndentedString(eiCutOff)).append("\n");
		sb.append("    tbProgRepetitionLimit: ").append(toIndentedString(tbProgRepetitionLimit)).append("\n");
		sb.append("    amendDemand: ").append(toIndentedString(amendDemand)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
