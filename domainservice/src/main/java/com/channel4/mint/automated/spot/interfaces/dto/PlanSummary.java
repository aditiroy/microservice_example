package com.channel4.mint.automated.spot.interfaces.dto;


import java.util.Objects;

import javax.validation.Valid;

import org.joda.time.LocalDate;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * PlanSummary
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-14T09:04:29.792Z")

public class PlanSummary   {
  @JsonProperty("planId")
  private Integer planId = null;

  @JsonProperty("runStartDate")
  private LocalDate runStartDate = null;

  @JsonProperty("runEndDate")
  private LocalDate runEndDate = null;

  @JsonProperty("channelSetId")
  private Long channelSetId = null;

  @JsonProperty("iteration")
  private Integer iteration = null;

  @JsonProperty("run")
  private Boolean run = null;

  @JsonProperty("slot")
  private Boolean slot = null;

  @JsonProperty("createdBy")
  private String createdBy = null;

  @JsonProperty("status")
  private String status = null;

  public PlanSummary planId(Integer planId) {
    this.planId = planId;
    return this;
  }

  /**
   * Get planId
   * @return planId
  **/
  @ApiModelProperty(value = "")


  public Integer getPlanId() {
    return planId;
  }

  public void setPlanId(Integer planId) {
    this.planId = planId;
  }

  public PlanSummary runStartDate(LocalDate runStartDate) {
    this.runStartDate = runStartDate;
    return this;
  }

  /**
   * Get runStartDate
   * @return runStartDate
  **/
  @ApiModelProperty(value = "")

  @Valid

  public LocalDate getRunStartDate() {
    return runStartDate;
  }

  public void setRunStartDate(LocalDate runStartDate) {
    this.runStartDate = runStartDate;
  }

  public PlanSummary runEndDate(LocalDate runEndDate) {
    this.runEndDate = runEndDate;
    return this;
  }

  /**
   * Get runEndDate
   * @return runEndDate
  **/
  @ApiModelProperty(value = "")

  @Valid

  public LocalDate getRunEndDate() {
    return runEndDate;
  }

  public void setRunEndDate(LocalDate runEndDate) {
    this.runEndDate = runEndDate;
  }

  public PlanSummary channelSetId(Long channelSetId) {
    this.channelSetId = channelSetId;
    return this;
  }

  /**
   * Get channelSetId
   * @return channelSetId
  **/
  @ApiModelProperty(value = "")


  public Long getChannelSetId() {
    return channelSetId;
  }

  public void setChannelSetId(Long channelSetId) {
    this.channelSetId = channelSetId;
  }

  public PlanSummary iteration(Integer iteration) {
    this.iteration = iteration;
    return this;
  }

  /**
   * Get iteration
   * @return iteration
  **/
  @ApiModelProperty(value = "")


  public Integer getIteration() {
    return iteration;
  }

  public void setIteration(Integer iteration) {
    this.iteration = iteration;
  }

  public PlanSummary run(Boolean run) {
    this.run = run;
    return this;
  }

  /**
   * Get run
   * @return run
  **/
  @ApiModelProperty(value = "")


  public Boolean isRun() {
    return run;
  }

  public void setRun(Boolean run) {
    this.run = run;
  }

  public PlanSummary slot(Boolean slot) {
    this.slot = slot;
    return this;
  }

  /**
   * Get slot
   * @return slot
  **/
  @ApiModelProperty(value = "")


  public Boolean isSlot() {
    return slot;
  }

  public void setSlot(Boolean slot) {
    this.slot = slot;
  }

  public PlanSummary createdBy(String createdBy) {
    this.createdBy = createdBy;
    return this;
  }

  /**
   * Get createdBy
   * @return createdBy
  **/
  @ApiModelProperty(value = "")


  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public PlanSummary status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PlanSummary planSummary = (PlanSummary) o;
    return Objects.equals(this.planId, planSummary.planId) &&
        Objects.equals(this.runStartDate, planSummary.runStartDate) &&
        Objects.equals(this.runEndDate, planSummary.runEndDate) &&
        Objects.equals(this.channelSetId, planSummary.channelSetId) &&
        Objects.equals(this.iteration, planSummary.iteration) &&
        Objects.equals(this.run, planSummary.run) &&
        Objects.equals(this.slot, planSummary.slot) &&
        Objects.equals(this.createdBy, planSummary.createdBy) &&
        Objects.equals(this.status, planSummary.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(planId, runStartDate, runEndDate, channelSetId, iteration, run, slot, createdBy, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PlanSummary {\n");
    
    sb.append("    planId: ").append(toIndentedString(planId)).append("\n");
    sb.append("    runStartDate: ").append(toIndentedString(runStartDate)).append("\n");
    sb.append("    runEndDate: ").append(toIndentedString(runEndDate)).append("\n");
    sb.append("    channelSetId: ").append(toIndentedString(channelSetId)).append("\n");
    sb.append("    iteration: ").append(toIndentedString(iteration)).append("\n");
    sb.append("    run: ").append(toIndentedString(run)).append("\n");
    sb.append("    slot: ").append(toIndentedString(slot)).append("\n");
    sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

