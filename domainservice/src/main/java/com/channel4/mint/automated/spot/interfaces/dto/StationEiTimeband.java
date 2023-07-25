/*
 * 
 */
package com.channel4.mint.automated.spot.interfaces.dto;

import java.util.Objects;

import javax.validation.Valid;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

// TODO: Auto-generated Javadoc
/**
 * StationEiTimeband.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-12-19T04:58:28.844Z")

public class StationEiTimeband   {
  
  /** The day code. */
  @JsonProperty("dayCode")
  private String dayCode = null;

  /** The start time. */
  @JsonProperty("startTime")
  private DateTime startTime = null;

  /**
   * Day code.
   *
   * @param dayCode the day code
   * @return the station ei timeband
   */
  public StationEiTimeband dayCode(String dayCode) {
    this.dayCode = dayCode;
    return this;
  }

   /**
    * Get dayCode.
    *
    * @return dayCode
    */
  @ApiModelProperty(value = "")


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
   * Start time.
   *
   * @param startTime the start time
   * @return the station ei timeband
   */
  public StationEiTimeband startTime(DateTime startTime) {
    this.startTime = startTime;
    return this;
  }

   /**
    * Get startTime.
    *
    * @return startTime
    */
  @ApiModelProperty(value = "")

  @Valid

  public DateTime getStartTime() {
    return startTime;
  }

  /**
   * Sets the start time.
   *
   * @param startTime the new start time
   */
  public void setStartTime(DateTime startTime) {
    this.startTime = startTime;
  }


  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StationEiTimeband stationEiTimeband = (StationEiTimeband) o;
    return Objects.equals(this.dayCode, stationEiTimeband.dayCode) &&
        Objects.equals(this.startTime, stationEiTimeband.startTime);
  }

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    return Objects.hash(dayCode, startTime);
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StationEiTimeband {\n");
    
    sb.append("    dayCode: ").append(toIndentedString(dayCode)).append("\n");
    sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   *
   * @param o the o
   * @return the string
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

