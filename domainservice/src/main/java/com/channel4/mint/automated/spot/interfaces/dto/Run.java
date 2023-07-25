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
 * Run.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-12-19T04:58:28.844Z")

public class Run   {
  
  /** The snapshot ID. */
  @JsonProperty("snapshotID")
  private Long snapshotID = null;

  /** The run ID. */
  @JsonProperty("runID")
  private Long runID = null;

  /** The run date. */
  @JsonProperty("runDate")
  private DateTime runDate = null;

  /** The notes. */
  @JsonProperty("notes")
  private String notes = null;

  /** The run type. */
  @JsonProperty("runType")
  private String runType = null;

  /**
   * Snapshot ID.
   *
   * @param snapshotID the snapshot ID
   * @return the run
   */
  public Run snapshotID(Long snapshotID) {
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
   * @return the run
   */
  public Run runID(Long runID) {
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
   * Run date.
   *
   * @param runDate the run date
   * @return the run
   */
  public Run runDate(DateTime runDate) {
    this.runDate = runDate;
    return this;
  }

   /**
    * Get runDate.
    *
    * @return runDate
    */
  @ApiModelProperty(value = "")

  @Valid

  public DateTime getRunDate() {
    return runDate;
  }

  /**
   * Sets the run date.
   *
   * @param runDate the new run date
   */
  public void setRunDate(DateTime runDate) {
    this.runDate = runDate;
  }

  /**
   * Notes.
   *
   * @param notes the notes
   * @return the run
   */
  public Run notes(String notes) {
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
   * Run type.
   *
   * @param runType the run type
   * @return the run
   */
  public Run runType(String runType) {
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
    Run run = (Run) o;
    return Objects.equals(this.snapshotID, run.snapshotID) &&
        Objects.equals(this.runID, run.runID) &&
        Objects.equals(this.runDate, run.runDate) &&
        Objects.equals(this.notes, run.notes) &&
        Objects.equals(this.runType, run.runType);
  }

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    return Objects.hash(snapshotID, runID, runDate, notes, runType);
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Run {\n");
    
    sb.append("    snapshotID: ").append(toIndentedString(snapshotID)).append("\n");
    sb.append("    runID: ").append(toIndentedString(runID)).append("\n");
    sb.append("    runDate: ").append(toIndentedString(runDate)).append("\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
    sb.append("    runType: ").append(toIndentedString(runType)).append("\n");
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

