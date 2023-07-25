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
 * SearchDateRange.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-12-19T04:58:28.844Z")

public class SearchDateRange   {
  
  /** The range. */
  @JsonProperty("range")
  private StartEndDate range = null;

  /**
   * Range.
   *
   * @param range the range
   * @return the search date range
   */
  public SearchDateRange range(StartEndDate range) {
    this.range = range;
    return this;
  }

   /**
    * Get range.
    *
    * @return range
    */
  @ApiModelProperty(value = "")

  @Valid

  public StartEndDate getRange() {
    return range;
  }

  /**
   * Sets the range.
   *
   * @param range the new range
   */
  public void setRange(StartEndDate range) {
    this.range = range;
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
    SearchDateRange searchDateRange = (SearchDateRange) o;
    return Objects.equals(this.range, searchDateRange.range);
  }

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    return Objects.hash(range);
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SearchDateRange {\n");
    
    sb.append("    range: ").append(toIndentedString(range)).append("\n");
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

