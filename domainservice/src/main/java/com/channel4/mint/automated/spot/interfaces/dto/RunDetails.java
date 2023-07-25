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
 * RunDetails.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-12-19T04:58:28.844Z")

public class RunDetails   {
  
  /** The snapshot ID. */
  @JsonProperty("snapshotID")
  private Long snapshotID = null;

  /** The run ID. */
  @JsonProperty("runID")
  private Long runID = null;

  /** The run date time. */
  @JsonProperty("runDateTime")
  private DateTime runDateTime = null;

  /** The notes. */
  @JsonProperty("notes")
  private String notes = null;

  /** The status. */
  @JsonProperty("status")
  private String status = null;

  /** The run type. */
  @JsonProperty("runType")
  private String runType = null;

  /** The schedule. */
  @JsonProperty("schedule")
  private DateTime schedule = null;

  /** The slot. */
  @JsonProperty("slot")
  private Boolean slot = null;

  /**
   * Snapshot ID.
   *
   * @param snapshotID the snapshot ID
   * @return the run details
   */
  public RunDetails snapshotID(Long snapshotID) {
    this.snapshotID = snapshotID;
    return this;
  }

   /**
    * Get snapshotID.
    *
    * @return snapshotID
    */
  @ApiModelProperty(value = "")


  public Long getSnapshotID() {
    return snapshotID;
  }

  /**
   * Sets the snapshot ID.
   *
   * @param snapshotID the new snapshot ID
   */
  public void setSnapshotID(Long snapshotID) {
    this.snapshotID = snapshotID;
  }

  /**
   * Run ID.
   *
   * @param runID the run ID
   * @return the run details
   */
  public RunDetails runID(Long runID) {
    this.runID = runID;
    return this;
  }

   /**
    * Get runID.
    *
    * @return runID
    */
  @ApiModelProperty(value = "")


  public Long getRunID() {
    return runID;
  }

  /**
   * Sets the run ID.
   *
   * @param runID the new run ID
   */
  public void setRunID(Long runID) {
    this.runID = runID;
  }

  /**
   * Run date time.
   *
   * @param runDateTime the run date time
   * @return the run details
   */
  public RunDetails runDateTime(DateTime runDateTime) {
    this.runDateTime = runDateTime;
    return this;
  }

   /**
    * Get runDateTime.
    *
    * @return runDateTime
    */
  @ApiModelProperty(value = "")

  @Valid

  public DateTime getRunDateTime() {
    return runDateTime;
  }

  /**
   * Sets the run date time.
   *
   * @param runDateTime the new run date time
   */
  public void setRunDateTime(DateTime runDateTime) {
    this.runDateTime = runDateTime;
  }

  /**
   * Notes.
   *
   * @param notes the notes
   * @return the run details
   */
  public RunDetails notes(String notes) {
    this.notes = notes;
    return this;
  }

   /**
    * Get notes.
    *
    * @return notes
    */
  @ApiModelProperty(value = "")


  public String getNotes() {
    return notes;
  }

  /**
   * Sets the notes.
   *
   * @param notes the new notes
   */
  public void setNotes(String notes) {
    this.notes = notes;
  }

  /**
   * Status.
   *
   * @param status the status
   * @return the run details
   */
  public RunDetails status(String status) {
    this.status = status;
    return this;
  }

   /**
    * Get status.
    *
    * @return status
    */
  @ApiModelProperty(value = "")


  public String getStatus() {
    return status;
  }

  /**
   * Sets the status.
   *
   * @param status the new status
   */
  public void setStatus(String status) {
    this.status = status;
  }

  /**
   * Run type.
   *
   * @param runType the run type
   * @return the run details
   */
  public RunDetails runType(String runType) {
    this.runType = runType;
    return this;
  }

   /**
    * Get runType.
    *
    * @return runType
    */
  @ApiModelProperty(value = "")


  public String getRunType() {
    return runType;
  }

  /**
   * Sets the run type.
   *
   * @param runType the new run type
   */
  public void setRunType(String runType) {
    this.runType = runType;
  }

  /**
   * Schedule.
   *
   * @param schedule the schedule
   * @return the run details
   */
  public RunDetails schedule(DateTime schedule) {
    this.schedule = schedule;
    return this;
  }

   /**
    * Get schedule.
    *
    * @return schedule
    */
  @ApiModelProperty(value = "")

  @Valid

  public DateTime getSchedule() {
    return schedule;
  }

  /**
   * Sets the schedule.
   *
   * @param schedule the new schedule
   */
  public void setSchedule(DateTime schedule) {
    this.schedule = schedule;
  }

  /**
   * Slot.
   *
   * @param slot the slot
   * @return the run details
   */
  public RunDetails slot(Boolean slot) {
    this.slot = slot;
    return this;
  }

   /**
    * Get slot.
    *
    * @return slot
    */
  @ApiModelProperty(value = "")


  public Boolean getSlot() {
    return slot;
  }

  /**
   * Sets the slot.
   *
   * @param slot the new slot
   */
  public void setSlot(Boolean slot) {
    this.slot = slot;
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
    RunDetails runDetails = (RunDetails) o;
    return Objects.equals(this.snapshotID, runDetails.snapshotID) &&
        Objects.equals(this.runID, runDetails.runID) &&
        Objects.equals(this.runDateTime, runDetails.runDateTime) &&
        Objects.equals(this.notes, runDetails.notes) &&
        Objects.equals(this.status, runDetails.status) &&
        Objects.equals(this.runType, runDetails.runType) &&
        Objects.equals(this.schedule, runDetails.schedule) &&
        Objects.equals(this.slot, runDetails.slot);
  }

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    return Objects.hash(snapshotID, runID, runDateTime, notes, status, runType, schedule, slot);
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RunDetails {\n");
    
    sb.append("    snapshotID: ").append(toIndentedString(snapshotID)).append("\n");
    sb.append("    runID: ").append(toIndentedString(runID)).append("\n");
    sb.append("    runDateTime: ").append(toIndentedString(runDateTime)).append("\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    runType: ").append(toIndentedString(runType)).append("\n");
    sb.append("    schedule: ").append(toIndentedString(schedule)).append("\n");
    sb.append("    slot: ").append(toIndentedString(slot)).append("\n");
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

