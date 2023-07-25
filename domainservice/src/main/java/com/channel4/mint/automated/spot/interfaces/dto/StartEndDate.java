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
 * StartEndDate.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-12-19T04:58:28.844Z")

public class StartEndDate   {
  
  /** The start. */
  @JsonProperty("start")
  private DateTime start = null;

  /** The end. */
  @JsonProperty("end")
  private DateTime end = null;

  /**
   * Start.
   *
   * @param start the start
   * @return the start end date
   */
  public StartEndDate start(DateTime start) {
    this.start = start;
    return this;
  }

   /**
    * Get start.
    *
    * @return start
    */
  @ApiModelProperty(value = "")

  @Valid

  public DateTime getStart() {
    return start;
  }

  /**
   * Sets the start.
   *
   * @param start the new start
   */
  public void setStart(DateTime start) {
    this.start = start;
  }

  /**
   * End.
   *
   * @param end the end
   * @return the start end date
   */
  public StartEndDate end(DateTime end) {
    this.end = end;
    return this;
  }

   /**
    * Get end.
    *
    * @return end
    */
  @ApiModelProperty(value = "")

  @Valid

  public DateTime getEnd() {
    return end;
  }

  /**
   * Sets the end.
   *
   * @param end the new end
   */
  public void setEnd(DateTime end) {
    this.end = end;
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
    StartEndDate startEndDate = (StartEndDate) o;
    return Objects.equals(this.start, startEndDate.start) &&
        Objects.equals(this.end, startEndDate.end);
  }

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    return Objects.hash(start, end);
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StartEndDate {\n");
    
    sb.append("    start: ").append(toIndentedString(start)).append("\n");
    sb.append("    end: ").append(toIndentedString(end)).append("\n");
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

