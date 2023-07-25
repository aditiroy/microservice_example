package com.channel4.mint.automated.spot.interfaces.dto;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * SnapshotSummaryTxLevels
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-04-09T06:37:08.627Z")

public class SnapshotSummaryTxLevels   {
  @JsonProperty("txLevelId")
  private Long txLevelId = null;

  public SnapshotSummaryTxLevels txLevelId(Long txLevelId) {
    this.txLevelId = txLevelId;
    return this;
  }

  /**
   * Get txLevelId
   * @return txLevelId
  **/
  @ApiModelProperty(value = "")


  public Long getTxLevelId() {
    return txLevelId;
  }

  public void setTxLevelId(Long txLevelId) {
    this.txLevelId = txLevelId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SnapshotSummaryTxLevels snapshotSummaryTxLevels = (SnapshotSummaryTxLevels) o;
    return Objects.equals(this.txLevelId, snapshotSummaryTxLevels.txLevelId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(txLevelId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SnapshotSummaryTxLevels {\n");
    
    sb.append("    txLevelId: ").append(toIndentedString(txLevelId)).append("\n");
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

