package com.channel4.mint.automated.spot.interfaces.dto;

import java.math.BigDecimal;
import java.util.Objects;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * ChannelSetTimebandsBulkRequestTimebands
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-12-28T04:55:33.590Z")

public class ChannelSetTimebandsBulkRequestTimebands   {
  @JsonProperty("timebandId")
  private Integer timebandId = null;

  @JsonProperty("day")
  private String day = null;

  @JsonProperty("startTime")
  private String startTime = null;

  @JsonProperty("endTime")
  private String endTime = null;

  @JsonProperty("timeBand")
  private String timeBand = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("availability")
  private BigDecimal availability = null;

  public ChannelSetTimebandsBulkRequestTimebands timebandId(Integer timebandId) {
    this.timebandId = timebandId;
    return this;
  }

   /**
   * Get timebandId
   * @return timebandId
  **/
  @ApiModelProperty(value = "")


  public Integer getTimebandId() {
    return timebandId;
  }

  public void setTimebandId(Integer timebandId) {
    this.timebandId = timebandId;
  }

  public ChannelSetTimebandsBulkRequestTimebands day(String day) {
    this.day = day;
    return this;
  }

   /**
   * Get day
   * @return day
  **/
  @ApiModelProperty(value = "")


  public String getDay() {
    return day;
  }

  public void setDay(String day) {
    this.day = day;
  }

  public ChannelSetTimebandsBulkRequestTimebands startTime(String startTime) {
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

  public ChannelSetTimebandsBulkRequestTimebands endTime(String endTime) {
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

  public ChannelSetTimebandsBulkRequestTimebands timeBand(String timeBand) {
    this.timeBand = timeBand;
    return this;
  }

   /**
   * Get timeBand
   * @return timeBand
  **/
  @ApiModelProperty(value = "")


  public String getTimeBand() {
    return timeBand;
  }

  public void setTimeBand(String timeBand) {
    this.timeBand = timeBand;
  }

  public ChannelSetTimebandsBulkRequestTimebands name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ChannelSetTimebandsBulkRequestTimebands availability(BigDecimal availability) {
    this.availability = availability;
    return this;
  }

   /**
   * Get availability
   * @return availability
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getAvailability() {
    return availability;
  }

  public void setAvailability(BigDecimal availability) {
    this.availability = availability;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChannelSetTimebandsBulkRequestTimebands channelSetTimebandsBulkRequestTimebands = (ChannelSetTimebandsBulkRequestTimebands) o;
    return Objects.equals(this.timebandId, channelSetTimebandsBulkRequestTimebands.timebandId) &&
        Objects.equals(this.day, channelSetTimebandsBulkRequestTimebands.day) &&
        Objects.equals(this.startTime, channelSetTimebandsBulkRequestTimebands.startTime) &&
        Objects.equals(this.endTime, channelSetTimebandsBulkRequestTimebands.endTime) &&
        Objects.equals(this.timeBand, channelSetTimebandsBulkRequestTimebands.timeBand) &&
        Objects.equals(this.name, channelSetTimebandsBulkRequestTimebands.name) &&
        Objects.equals(this.availability, channelSetTimebandsBulkRequestTimebands.availability);
  }

  @Override
  public int hashCode() {
    return Objects.hash(timebandId, day, startTime, endTime, timeBand, name, availability);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChannelSetTimebandsBulkRequestTimebands {\n");
    
    sb.append("    timebandId: ").append(toIndentedString(timebandId)).append("\n");
    sb.append("    day: ").append(toIndentedString(day)).append("\n");
    sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
    sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
    sb.append("    timeBand: ").append(toIndentedString(timeBand)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    availability: ").append(toIndentedString(availability)).append("\n");
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

