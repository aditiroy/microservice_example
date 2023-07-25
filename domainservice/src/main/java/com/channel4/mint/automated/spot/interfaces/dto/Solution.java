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
 * Solution.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-12-19T04:58:28.844Z")

public class Solution   {
  
  /** The iteration number. */
  @JsonProperty("iterationNumber")
  private Long iterationNumber = null;

  /** The time. */
  @JsonProperty("time")
  private StartEndDate time = null;

  /** The run type. */
  @JsonProperty("runType")
  private String runType = null;

  /**
   * Iteration number.
   *
   * @param iterationNumber the iteration number
   * @return the solution
   */
  public Solution iterationNumber(Long iterationNumber) {
    this.iterationNumber = iterationNumber;
    return this;
  }

   /**
    * Get iterationNumber.
    *
    * @return iterationNumber
    */
  @ApiModelProperty(value = "")


  public Long getIterationNumber() {
    return iterationNumber;
  }

  /**
   * Sets the iteration number.
   *
   * @param iterationNumber the new iteration number
   */
  public void setIterationNumber(Long iterationNumber) {
    this.iterationNumber = iterationNumber;
  }

  /**
   * Time.
   *
   * @param time the time
   * @return the solution
   */
  public Solution time(StartEndDate time) {
    this.time = time;
    return this;
  }

   /**
    * Get time.
    *
    * @return time
    */
  @ApiModelProperty(value = "")

  @Valid

  public StartEndDate getTime() {
    return time;
  }

  /**
   * Sets the time.
   *
   * @param time the new time
   */
  public void setTime(StartEndDate time) {
    this.time = time;
  }

  /**
   * Run type.
   *
   * @param runType the run type
   * @return the solution
   */
  public Solution runType(String runType) {
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
    Solution solution = (Solution) o;
    return Objects.equals(this.iterationNumber, solution.iterationNumber) &&
        Objects.equals(this.time, solution.time) &&
        Objects.equals(this.runType, solution.runType);
  }

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    return Objects.hash(iterationNumber, time, runType);
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Solution {\n");
    
    sb.append("    iterationNumber: ").append(toIndentedString(iterationNumber)).append("\n");
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
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

