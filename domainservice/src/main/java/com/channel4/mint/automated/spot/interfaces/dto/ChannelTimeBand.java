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
 * ChannelTimeBand.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-12-19T04:58:28.844Z")

public class ChannelTimeBand   {
  
  /** The id. */
  @JsonProperty("id")
  private Integer id = null;

  /** The day. */
  @JsonProperty("day")
  private String day = null;

  /** The start time. */
  @JsonProperty("startTime")
  private DateTime startTime = null;

  /** The end time. */
  @JsonProperty("endTime")
  private DateTime endTime = null;

  /** The time band. */
  @JsonProperty("timeBand")
  private String timeBand = null;

  /** The availability. */
  @JsonProperty("availability")
  private Long availability = null;

  /**
   * Id.
   *
   * @param id the id
   * @return the channel time band
   */
  public ChannelTimeBand id(Integer id) {
    this.id = id;
    return this;
  }

   /**
    * Get id.
    *
    * @return id
    */
  @ApiModelProperty(value = "")


  public Integer getId() {
    return id;
  }

  /**
   * Sets the id.
   *
   * @param id the new id
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Day.
   *
   * @param day the day
   * @return the channel time band
   */
  public ChannelTimeBand day(String day) {
    this.day = day;
    return this;
  }

   /**
    * Get day.
    *
    * @return day
    */
  @ApiModelProperty(value = "")


  public String getDay() {
    return day;
  }

  /**
   * Sets the day.
   *
   * @param day the new day
   */
  public void setDay(String day) {
    this.day = day;
  }

  /**
   * Start time.
   *
   * @param startTime the start time
   * @return the channel time band
   */
  public ChannelTimeBand startTime(DateTime startTime) {
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

  /**
   * End time.
   *
   * @param endTime the end time
   * @return the channel time band
   */
  public ChannelTimeBand endTime(DateTime endTime) {
    this.endTime = endTime;
    return this;
  }

   /**
    * Get endTime.
    *
    * @return endTime
    */
  @ApiModelProperty(value = "")

  @Valid

  public DateTime getEndTime() {
    return endTime;
  }

  /**
   * Sets the end time.
   *
   * @param endTime the new end time
   */
  public void setEndTime(DateTime endTime) {
    this.endTime = endTime;
  }

  /**
   * Time band.
   *
   * @param timeBand the time band
   * @return the channel time band
   */
  public ChannelTimeBand timeBand(String timeBand) {
    this.timeBand = timeBand;
    return this;
  }

   /**
    * Get timeBand.
    *
    * @return timeBand
    */
  @ApiModelProperty(value = "")


  public String getTimeBand() {
    return timeBand;
  }

  /**
   * Sets the time band.
   *
   * @param timeBand the new time band
   */
  public void setTimeBand(String timeBand) {
    this.timeBand = timeBand;
  }

  /**
   * Availability.
   *
   * @param availability the availability
   * @return the channel time band
   */
  public ChannelTimeBand availability(Long availability) {
    this.availability = availability;
    return this;
  }

   /**
    * Get availability.
    *
    * @return availability
    */
  @ApiModelProperty(value = "")


  public Long getAvailability() {
    return availability;
  }

  /**
   * Sets the availability.
   *
   * @param availability the new availability
   */
  public void setAvailability(Long availability) {
    this.availability = availability;
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
    ChannelTimeBand channelTimeBand = (ChannelTimeBand) o;
    return Objects.equals(this.id, channelTimeBand.id) &&
        Objects.equals(this.day, channelTimeBand.day) &&
        Objects.equals(this.startTime, channelTimeBand.startTime) &&
        Objects.equals(this.endTime, channelTimeBand.endTime) &&
        Objects.equals(this.timeBand, channelTimeBand.timeBand) &&
        Objects.equals(this.availability, channelTimeBand.availability);
  }

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    return Objects.hash(id, day, startTime, endTime, timeBand, availability);
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChannelTimeBand {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    day: ").append(toIndentedString(day)).append("\n");
    sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
    sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
    sb.append("    timeBand: ").append(toIndentedString(timeBand)).append("\n");
    sb.append("    availability: ").append(toIndentedString(availability)).append("\n");
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

