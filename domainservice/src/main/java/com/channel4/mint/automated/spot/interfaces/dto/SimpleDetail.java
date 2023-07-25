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
 * SimpleDetail.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-12-19T04:58:28.844Z")

public class SimpleDetail   {
  
  /** The snapshot ID. */
  @JsonProperty("snapshotID")
  private Long snapshotID = null;

  /** The create on. */
  @JsonProperty("createOn")
  private DateTime createOn = null;

  /** The plan ID. */
  @JsonProperty("planID")
  private Long planID = null;

  /** The break count. */
  @JsonProperty("breakCount")
  private Long breakCount = null;

  /** The campaign count. */
  @JsonProperty("campaignCount")
  private Long campaignCount = null;

  /**
   * Snapshot ID.
   *
   * @param snapshotID the snapshot ID
   * @return the simple detail
   */
  public SimpleDetail snapshotID(Long snapshotID) {
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
   * Creates the on.
   *
   * @param createOn the create on
   * @return the simple detail
   */
  public SimpleDetail createOn(DateTime createOn) {
    this.createOn = createOn;
    return this;
  }

   /**
    * Get createOn.
    *
    * @return createOn
    */
  @ApiModelProperty(value = "")

  @Valid

  public DateTime getCreateOn() {
    return createOn;
  }

  /**
   * Sets the creates the on.
   *
   * @param createOn the new creates the on
   */
  public void setCreateOn(DateTime createOn) {
    this.createOn = createOn;
  }

  /**
   * Plan ID.
   *
   * @param planID the plan ID
   * @return the simple detail
   */
  public SimpleDetail planID(Long planID) {
    this.planID = planID;
    return this;
  }

   /**
    * Get planID.
    *
    * @return planID
    */
  @ApiModelProperty(value = "")


  public Long getPlanID() {
    return planID;
  }

  /**
   * Sets the plan ID.
   *
   * @param planID the new plan ID
   */
  public void setPlanID(Long planID) {
    this.planID = planID;
  }

  /**
   * Break count.
   *
   * @param breakCount the break count
   * @return the simple detail
   */
  public SimpleDetail breakCount(Long breakCount) {
    this.breakCount = breakCount;
    return this;
  }

   /**
    * Get breakCount.
    *
    * @return breakCount
    */
  @ApiModelProperty(value = "")


  public Long getBreakCount() {
    return breakCount;
  }

  /**
   * Sets the break count.
   *
   * @param breakCount the new break count
   */
  public void setBreakCount(Long breakCount) {
    this.breakCount = breakCount;
  }

  /**
   * Campaign count.
   *
   * @param campaignCount the campaign count
   * @return the simple detail
   */
  public SimpleDetail campaignCount(Long campaignCount) {
    this.campaignCount = campaignCount;
    return this;
  }

   /**
    * Get campaignCount.
    *
    * @return campaignCount
    */
  @ApiModelProperty(value = "")


  public Long getCampaignCount() {
    return campaignCount;
  }

  /**
   * Sets the campaign count.
   *
   * @param campaignCount the new campaign count
   */
  public void setCampaignCount(Long campaignCount) {
    this.campaignCount = campaignCount;
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
    SimpleDetail simpleDetail = (SimpleDetail) o;
    return Objects.equals(this.snapshotID, simpleDetail.snapshotID) &&
        Objects.equals(this.createOn, simpleDetail.createOn) &&
        Objects.equals(this.planID, simpleDetail.planID) &&
        Objects.equals(this.breakCount, simpleDetail.breakCount) &&
        Objects.equals(this.campaignCount, simpleDetail.campaignCount);
  }

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    return Objects.hash(snapshotID, createOn, planID, breakCount, campaignCount);
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SimpleDetail {\n");
    
    sb.append("    snapshotID: ").append(toIndentedString(snapshotID)).append("\n");
    sb.append("    createOn: ").append(toIndentedString(createOn)).append("\n");
    sb.append("    planID: ").append(toIndentedString(planID)).append("\n");
    sb.append("    breakCount: ").append(toIndentedString(breakCount)).append("\n");
    sb.append("    campaignCount: ").append(toIndentedString(campaignCount)).append("\n");
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

