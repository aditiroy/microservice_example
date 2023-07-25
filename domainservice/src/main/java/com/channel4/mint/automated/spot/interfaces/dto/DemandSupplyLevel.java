package com.channel4.mint.automated.spot.interfaces.dto;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * DemandSupplyLevel
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-03-20T06:10:00.689Z")

public class DemandSupplyLevel   {
  @JsonProperty("demandSupplyLevelId")
  private Integer demandSupplyLevelId = null;

  @JsonProperty("demandSupplyLevelName")
  private String demandSupplyLevelName = null;

  @JsonProperty("demandSupplyLevelDesc")
  private String demandSupplyLevelDesc = null;

  public DemandSupplyLevel demandSupplyLevelId(Integer demandSupplyLevelId) {
    this.demandSupplyLevelId = demandSupplyLevelId;
    return this;
  }

  /**
   * Get demandSupplyLevelId
   * @return demandSupplyLevelId
  **/
  @ApiModelProperty(value = "")


  public Integer getDemandSupplyLevelId() {
    return demandSupplyLevelId;
  }

  public void setDemandSupplyLevelId(Integer demandSupplyLevelId) {
    this.demandSupplyLevelId = demandSupplyLevelId;
  }

  public DemandSupplyLevel demandSupplyLevelName(String demandSupplyLevelName) {
    this.demandSupplyLevelName = demandSupplyLevelName;
    return this;
  }

  /**
   * Get demandSupplyLevelName
   * @return demandSupplyLevelName
  **/
  @ApiModelProperty(value = "")


  public String getDemandSupplyLevelName() {
    return demandSupplyLevelName;
  }

  public void setDemandSupplyLevelName(String demandSupplyLevelName) {
    this.demandSupplyLevelName = demandSupplyLevelName;
  }

  public DemandSupplyLevel demandSupplyLevelDesc(String demandSupplyLevelDesc) {
    this.demandSupplyLevelDesc = demandSupplyLevelDesc;
    return this;
  }

  /**
   * Get demandSupplyLevelDesc
   * @return demandSupplyLevelDesc
  **/
  @ApiModelProperty(value = "")


  public String getDemandSupplyLevelDesc() {
    return demandSupplyLevelDesc;
  }

  public void setDemandSupplyLevelDesc(String demandSupplyLevelDesc) {
    this.demandSupplyLevelDesc = demandSupplyLevelDesc;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DemandSupplyLevel demandSupplyLevel = (DemandSupplyLevel) o;
    return Objects.equals(this.demandSupplyLevelId, demandSupplyLevel.demandSupplyLevelId) &&
        Objects.equals(this.demandSupplyLevelName, demandSupplyLevel.demandSupplyLevelName) &&
        Objects.equals(this.demandSupplyLevelDesc, demandSupplyLevel.demandSupplyLevelDesc);
  }

  @Override
  public int hashCode() {
    return Objects.hash(demandSupplyLevelId, demandSupplyLevelName, demandSupplyLevelDesc);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DemandSupplyLevel {\n");
    
    sb.append("    demandSupplyLevelId: ").append(toIndentedString(demandSupplyLevelId)).append("\n");
    sb.append("    demandSupplyLevelName: ").append(toIndentedString(demandSupplyLevelName)).append("\n");
    sb.append("    demandSupplyLevelDesc: ").append(toIndentedString(demandSupplyLevelDesc)).append("\n");
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

