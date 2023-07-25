/*
 * 
 */
package com.channel4.mint.automated.spot.interfaces.dto;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * CamgenRunParamStationEITimeBand
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-14T09:04:29.792Z")

public class CamgenRunParamStationEITimeBand   {
  @JsonProperty("runParameterStationEITimeBandId")
  private Integer runParameterStationEITimeBandId = null;

  @JsonProperty("dayCode")
  private String dayCode = null;

  @JsonProperty("startTime")
  private String startTime = null;

  @JsonProperty("endTime")
  private String endTime = null;

  public CamgenRunParamStationEITimeBand runParameterStationEITimeBandId(Integer runParameterStationEITimeBandId) {
    this.runParameterStationEITimeBandId = runParameterStationEITimeBandId;
    return this;
  }

  /**
   * Get runParameterStationEITimeBandId
   * @return runParameterStationEITimeBandId
  **/
  @ApiModelProperty(value = "")


  public Integer getRunParameterStationEITimeBandId() {
    return runParameterStationEITimeBandId;
  }

  public void setRunParameterStationEITimeBandId(Integer runParameterStationEITimeBandId) {
    this.runParameterStationEITimeBandId = runParameterStationEITimeBandId;
  }

  public CamgenRunParamStationEITimeBand dayCode(String dayCode) {
    this.dayCode = dayCode;
    return this;
  }

  /**
   * Get dayCode
   * @return dayCode
  **/
  @ApiModelProperty(value = "")


  public String getDayCode() {
    return dayCode;
  }

  public void setDayCode(String dayCode) {
    this.dayCode = dayCode;
  }

  public CamgenRunParamStationEITimeBand startTime(String startTime) {
    this.startTime = startTime;
    return this;
  }

  /**
   * Get startTime
   * @return startTime
  **/
  @ApiModelProperty(value = "")


  public String getStartTime() {
    return startTime;
  }

  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  public CamgenRunParamStationEITimeBand endTime(String endTime) {
    this.endTime = endTime;
    return this;
  }

  /**
   * Get endTime
   * @return endTime
  **/
  @ApiModelProperty(value = "")


  public String getEndTime() {
    return endTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CamgenRunParamStationEITimeBand camgenRunParamStationEITimeBand = (CamgenRunParamStationEITimeBand) o;
    return Objects.equals(this.runParameterStationEITimeBandId, camgenRunParamStationEITimeBand.runParameterStationEITimeBandId) &&
        Objects.equals(this.dayCode, camgenRunParamStationEITimeBand.dayCode) &&
        Objects.equals(this.startTime, camgenRunParamStationEITimeBand.startTime) &&
        Objects.equals(this.endTime, camgenRunParamStationEITimeBand.endTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(runParameterStationEITimeBandId, dayCode, startTime, endTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CamgenRunParamStationEITimeBand {\n");
    
    sb.append("    runParameterStationEITimeBandId: ").append(toIndentedString(runParameterStationEITimeBandId)).append("\n");
    sb.append("    dayCode: ").append(toIndentedString(dayCode)).append("\n");
    sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
    sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
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

