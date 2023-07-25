/*
 * 
 */
package com.channel4.mint.automated.spot.interfaces.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

// TODO: Auto-generated Javadoc
/**
 * Spot.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-12-19T04:58:28.844Z")

public class Spot   {
  
  /** The iteration number. */
  @JsonProperty("iterationNumber")
  private Integer iterationNumber = null;

  /** The run id. */
  @JsonProperty("runId")
  private Integer runId = null;

  /** The file name. */
  @JsonProperty("fileName")
  private String fileName = null;

  /**
   * Iteration number.
   *
   * @param iterationNumber the iteration number
   * @return the spot
   */
  public Spot iterationNumber(Integer iterationNumber) {
    this.iterationNumber = iterationNumber;
    return this;
  }

   /**
    * Get iterationNumber.
    *
    * @return iterationNumber
    */
  @ApiModelProperty(value = "")


  public Integer getIterationNumber() {
    return iterationNumber;
  }

  /**
   * Sets the iteration number.
   *
   * @param iterationNumber the new iteration number
   */
  public void setIterationNumber(Integer iterationNumber) {
    this.iterationNumber = iterationNumber;
  }

  /**
   * Run id.
   *
   * @param runId the run id
   * @return the spot
   */
  public Spot runId(Integer runId) {
    this.runId = runId;
    return this;
  }

   /**
    * Get runId.
    *
    * @return runId
    */
  @ApiModelProperty(value = "")


  public Integer getRunId() {
    return runId;
  }

  /**
   * Sets the run id.
   *
   * @param runId the new run id
   */
  public void setRunId(Integer runId) {
    this.runId = runId;
  }

  /**
   * File name.
   *
   * @param fileName the file name
   * @return the spot
   */
  public Spot fileName(String fileName) {
    this.fileName = fileName;
    return this;
  }

   /**
    * Get fileName.
    *
    * @return fileName
    */
  @ApiModelProperty(value = "")


  public String getFileName() {
    return fileName;
  }

  /**
   * Sets the file name.
   *
   * @param fileName the new file name
   */
  public void setFileName(String fileName) {
    this.fileName = fileName;
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
    Spot spot = (Spot) o;
    return Objects.equals(this.iterationNumber, spot.iterationNumber) &&
        Objects.equals(this.runId, spot.runId) &&
        Objects.equals(this.fileName, spot.fileName);
  }

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    return Objects.hash(iterationNumber, runId, fileName);
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Spot {\n");
    
    sb.append("    iterationNumber: ").append(toIndentedString(iterationNumber)).append("\n");
    sb.append("    runId: ").append(toIndentedString(runId)).append("\n");
    sb.append("    fileName: ").append(toIndentedString(fileName)).append("\n");
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

