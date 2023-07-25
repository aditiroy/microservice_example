/*
 * 
 */
package com.channel4.mint.automated.spot.interfaces.dto;

import java.util.Objects;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

// TODO: Auto-generated Javadoc
/**
 * StationTimeband.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-12-19T04:58:28.844Z")

public class StationTimeband   {
  
  /** The channel. */
  @JsonProperty("channel")
  private String channel = null;

  /** The station timeband ID. */
  @JsonProperty("stationTimebandID")
  private Long stationTimebandID = null;

  /** The timeband. */
  @JsonProperty("timeband")
  private String timeband = null;

  /** The exclude. */
  @JsonProperty("exclude")
  private Boolean exclude = null;

  /** The day code. */
  @JsonProperty("dayCode")
  private String dayCode = null;

  /** The start end time. */
  @JsonProperty("startEndTime")
  private StartEndDate startEndTime = null;

  /** The ei cut off. */
  @JsonProperty("eiCutOff")
  private String eiCutOff = null;

  /** The tb programme rep. */
  @JsonProperty("tbProgrammeRep")
  private String tbProgrammeRep = null;

  /** The amend demand. */
  @JsonProperty("amendDemand")
  private String amendDemand = null;

  /**
   * Channel.
   *
   * @param channel the channel
   * @return the station timeband
   */
  public StationTimeband channel(String channel) {
    this.channel = channel;
    return this;
  }

   /**
    * Get channel.
    *
    * @return channel
    */
  @ApiModelProperty(value = "")


  public String getChannel() {
    return channel;
  }

  /**
   * Sets the channel.
   *
   * @param channel the new channel
   */
  public void setChannel(String channel) {
    this.channel = channel;
  }

  /**
   * Station timeband ID.
   *
   * @param stationTimebandID the station timeband ID
   * @return the station timeband
   */
  public StationTimeband stationTimebandID(Long stationTimebandID) {
    this.stationTimebandID = stationTimebandID;
    return this;
  }

   /**
    * Get stationTimebandID.
    *
    * @return stationTimebandID
    */
  @ApiModelProperty(value = "")


  public Long getStationTimebandID() {
    return stationTimebandID;
  }

  /**
   * Sets the station timeband ID.
   *
   * @param stationTimebandID the new station timeband ID
   */
  public void setStationTimebandID(Long stationTimebandID) {
    this.stationTimebandID = stationTimebandID;
  }

  /**
   * Timeband.
   *
   * @param timeband the timeband
   * @return the station timeband
   */
  public StationTimeband timeband(String timeband) {
    this.timeband = timeband;
    return this;
  }

   /**
    * Get timeband.
    *
    * @return timeband
    */
  @ApiModelProperty(value = "")


  public String getTimeband() {
    return timeband;
  }

  /**
   * Sets the timeband.
   *
   * @param timeband the new timeband
   */
  public void setTimeband(String timeband) {
    this.timeband = timeband;
  }

  /**
   * Exclude.
   *
   * @param exclude the exclude
   * @return the station timeband
   */
  public StationTimeband exclude(Boolean exclude) {
    this.exclude = exclude;
    return this;
  }

   /**
    * Get exclude.
    *
    * @return exclude
    */
  @ApiModelProperty(value = "")


  public Boolean getExclude() {
    return exclude;
  }

  /**
   * Sets the exclude.
   *
   * @param exclude the new exclude
   */
  public void setExclude(Boolean exclude) {
    this.exclude = exclude;
  }

  /**
   * Day code.
   *
   * @param dayCode the day code
   * @return the station timeband
   */
  public StationTimeband dayCode(String dayCode) {
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
   * Start end time.
   *
   * @param startEndTime the start end time
   * @return the station timeband
   */
  public StationTimeband startEndTime(StartEndDate startEndTime) {
    this.startEndTime = startEndTime;
    return this;
  }

   /**
    * Get startEndTime.
    *
    * @return startEndTime
    */
  @ApiModelProperty(value = "")

  @Valid

  public StartEndDate getStartEndTime() {
    return startEndTime;
  }

  /**
   * Sets the start end time.
   *
   * @param startEndTime the new start end time
   */
  public void setStartEndTime(StartEndDate startEndTime) {
    this.startEndTime = startEndTime;
  }

  /**
   * Ei cut off.
   *
   * @param eiCutOff the ei cut off
   * @return the station timeband
   */
  public StationTimeband eiCutOff(String eiCutOff) {
    this.eiCutOff = eiCutOff;
    return this;
  }

   /**
    * Get eiCutOff.
    *
    * @return eiCutOff
    */
  @ApiModelProperty(value = "")


  public String getEiCutOff() {
    return eiCutOff;
  }

  /**
   * Sets the ei cut off.
   *
   * @param eiCutOff the new ei cut off
   */
  public void setEiCutOff(String eiCutOff) {
    this.eiCutOff = eiCutOff;
  }

  /**
   * Tb programme rep.
   *
   * @param tbProgrammeRep the tb programme rep
   * @return the station timeband
   */
  public StationTimeband tbProgrammeRep(String tbProgrammeRep) {
    this.tbProgrammeRep = tbProgrammeRep;
    return this;
  }

   /**
    * Get tbProgrammeRep.
    *
    * @return tbProgrammeRep
    */
  @ApiModelProperty(value = "")


  public String getTbProgrammeRep() {
    return tbProgrammeRep;
  }

  /**
   * Sets the tb programme rep.
   *
   * @param tbProgrammeRep the new tb programme rep
   */
  public void setTbProgrammeRep(String tbProgrammeRep) {
    this.tbProgrammeRep = tbProgrammeRep;
  }

  /**
   * Amend demand.
   *
   * @param amendDemand the amend demand
   * @return the station timeband
   */
  public StationTimeband amendDemand(String amendDemand) {
    this.amendDemand = amendDemand;
    return this;
  }

   /**
    * Get amendDemand.
    *
    * @return amendDemand
    */
  @ApiModelProperty(value = "")


  public String getAmendDemand() {
    return amendDemand;
  }

  /**
   * Sets the amend demand.
   *
   * @param amendDemand the new amend demand
   */
  public void setAmendDemand(String amendDemand) {
    this.amendDemand = amendDemand;
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
    StationTimeband stationTimeband = (StationTimeband) o;
    return Objects.equals(this.channel, stationTimeband.channel) &&
        Objects.equals(this.stationTimebandID, stationTimeband.stationTimebandID) &&
        Objects.equals(this.timeband, stationTimeband.timeband) &&
        Objects.equals(this.exclude, stationTimeband.exclude) &&
        Objects.equals(this.dayCode, stationTimeband.dayCode) &&
        Objects.equals(this.startEndTime, stationTimeband.startEndTime) &&
        Objects.equals(this.eiCutOff, stationTimeband.eiCutOff) &&
        Objects.equals(this.tbProgrammeRep, stationTimeband.tbProgrammeRep) &&
        Objects.equals(this.amendDemand, stationTimeband.amendDemand);
  }

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    return Objects.hash(channel, stationTimebandID, timeband, exclude, dayCode, startEndTime, eiCutOff, tbProgrammeRep, amendDemand);
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StationTimeband {\n");
    
    sb.append("    channel: ").append(toIndentedString(channel)).append("\n");
    sb.append("    stationTimebandID: ").append(toIndentedString(stationTimebandID)).append("\n");
    sb.append("    timeband: ").append(toIndentedString(timeband)).append("\n");
    sb.append("    exclude: ").append(toIndentedString(exclude)).append("\n");
    sb.append("    dayCode: ").append(toIndentedString(dayCode)).append("\n");
    sb.append("    startEndTime: ").append(toIndentedString(startEndTime)).append("\n");
    sb.append("    eiCutOff: ").append(toIndentedString(eiCutOff)).append("\n");
    sb.append("    tbProgrammeRep: ").append(toIndentedString(tbProgrammeRep)).append("\n");
    sb.append("    amendDemand: ").append(toIndentedString(amendDemand)).append("\n");
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

