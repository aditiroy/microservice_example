/*
 * 
 */
package com.channel4.mint.automated.spot.interfaces.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * SnapshotSummaryWithPagination
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-14T09:04:29.792Z")

public class SnapshotSummaryWithPagination   {
  @JsonProperty("snapshotSummary")
  @Valid
  private List<SnapshotSummary> snapshotSummary = null;

  @JsonProperty("totalCount")
  private Integer totalCount = null;

  public SnapshotSummaryWithPagination snapshotSummary(List<SnapshotSummary> snapshotSummary) {
    this.snapshotSummary = snapshotSummary;
    return this;
  }

  public SnapshotSummaryWithPagination addSnapshotSummaryItem(SnapshotSummary snapshotSummaryItem) {
    if (this.snapshotSummary == null) {
      this.snapshotSummary = new ArrayList<SnapshotSummary>();
    }
    this.snapshotSummary.add(snapshotSummaryItem);
    return this;
  }

  /**
   * Get snapshotSummary
   * @return snapshotSummary
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<SnapshotSummary> getSnapshotSummary() {
    return snapshotSummary;
  }

  public void setSnapshotSummary(List<SnapshotSummary> snapshotSummary) {
    this.snapshotSummary = snapshotSummary;
  }

  public SnapshotSummaryWithPagination totalCount(Integer totalCount) {
    this.totalCount = totalCount;
    return this;
  }

  /**
   * Get totalCount
   * @return totalCount
  **/
  @ApiModelProperty(value = "")


  public Integer getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(Integer totalCount) {
    this.totalCount = totalCount;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SnapshotSummaryWithPagination snapshotSummaryWithPagination = (SnapshotSummaryWithPagination) o;
    return Objects.equals(this.snapshotSummary, snapshotSummaryWithPagination.snapshotSummary) &&
        Objects.equals(this.totalCount, snapshotSummaryWithPagination.totalCount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(snapshotSummary, totalCount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SnapshotSummaryWithPagination {\n");
    
    sb.append("    snapshotSummary: ").append(toIndentedString(snapshotSummary)).append("\n");
    sb.append("    totalCount: ").append(toIndentedString(totalCount)).append("\n");
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

