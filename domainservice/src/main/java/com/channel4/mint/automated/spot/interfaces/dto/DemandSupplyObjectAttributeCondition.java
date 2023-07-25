package com.channel4.mint.automated.spot.interfaces.dto;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * DemandSupplyObjectAttributeCondition
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-03-20T06:10:00.689Z")

public class DemandSupplyObjectAttributeCondition   {
  @JsonProperty("demandSupplyObjectAttributeConditionId")
  private Integer demandSupplyObjectAttributeConditionId = null;

  @JsonProperty("demandSupplyObjectAttributeId")
  private Integer demandSupplyObjectAttributeId = null;

  @JsonProperty("demandSupplyObjectAttributeConditionName")
  private String demandSupplyObjectAttributeConditionName = null;

  @JsonProperty("demandSupplyObjectAttributeConditionDesc")
  private String demandSupplyObjectAttributeConditionDesc = null;

  public DemandSupplyObjectAttributeCondition demandSupplyObjectAttributeConditionId(Integer demandSupplyObjectAttributeConditionId) {
    this.demandSupplyObjectAttributeConditionId = demandSupplyObjectAttributeConditionId;
    return this;
  }

  /**
   * Get demandSupplyObjectAttributeConditionId
   * @return demandSupplyObjectAttributeConditionId
  **/
  @ApiModelProperty(value = "")


  public Integer getDemandSupplyObjectAttributeConditionId() {
    return demandSupplyObjectAttributeConditionId;
  }

  public void setDemandSupplyObjectAttributeConditionId(Integer demandSupplyObjectAttributeConditionId) {
    this.demandSupplyObjectAttributeConditionId = demandSupplyObjectAttributeConditionId;
  }

  public DemandSupplyObjectAttributeCondition demandSupplyObjectAttributeId(Integer demandSupplyObjectAttributeId) {
    this.demandSupplyObjectAttributeId = demandSupplyObjectAttributeId;
    return this;
  }

  /**
   * Get demandSupplyObjectAttributeId
   * @return demandSupplyObjectAttributeId
  **/
  @ApiModelProperty(value = "")


  public Integer getDemandSupplyObjectAttributeId() {
    return demandSupplyObjectAttributeId;
  }

  public void setDemandSupplyObjectAttributeId(Integer demandSupplyObjectAttributeId) {
    this.demandSupplyObjectAttributeId = demandSupplyObjectAttributeId;
  }

  public DemandSupplyObjectAttributeCondition demandSupplyObjectAttributeConditionName(String demandSupplyObjectAttributeConditionName) {
    this.demandSupplyObjectAttributeConditionName = demandSupplyObjectAttributeConditionName;
    return this;
  }

  /**
   * Get demandSupplyObjectAttributeConditionName
   * @return demandSupplyObjectAttributeConditionName
  **/
  @ApiModelProperty(value = "")


  public String getDemandSupplyObjectAttributeConditionName() {
    return demandSupplyObjectAttributeConditionName;
  }

  public void setDemandSupplyObjectAttributeConditionName(String demandSupplyObjectAttributeConditionName) {
    this.demandSupplyObjectAttributeConditionName = demandSupplyObjectAttributeConditionName;
  }

  public DemandSupplyObjectAttributeCondition demandSupplyObjectAttributeConditionDesc(String demandSupplyObjectAttributeConditionDesc) {
    this.demandSupplyObjectAttributeConditionDesc = demandSupplyObjectAttributeConditionDesc;
    return this;
  }

  /**
   * Get demandSupplyObjectAttributeConditionDesc
   * @return demandSupplyObjectAttributeConditionDesc
  **/
  @ApiModelProperty(value = "")


  public String getDemandSupplyObjectAttributeConditionDesc() {
    return demandSupplyObjectAttributeConditionDesc;
  }

  public void setDemandSupplyObjectAttributeConditionDesc(String demandSupplyObjectAttributeConditionDesc) {
    this.demandSupplyObjectAttributeConditionDesc = demandSupplyObjectAttributeConditionDesc;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DemandSupplyObjectAttributeCondition demandSupplyObjectAttributeCondition = (DemandSupplyObjectAttributeCondition) o;
    return Objects.equals(this.demandSupplyObjectAttributeConditionId, demandSupplyObjectAttributeCondition.demandSupplyObjectAttributeConditionId) &&
        Objects.equals(this.demandSupplyObjectAttributeId, demandSupplyObjectAttributeCondition.demandSupplyObjectAttributeId) &&
        Objects.equals(this.demandSupplyObjectAttributeConditionName, demandSupplyObjectAttributeCondition.demandSupplyObjectAttributeConditionName) &&
        Objects.equals(this.demandSupplyObjectAttributeConditionDesc, demandSupplyObjectAttributeCondition.demandSupplyObjectAttributeConditionDesc);
  }

  @Override
  public int hashCode() {
    return Objects.hash(demandSupplyObjectAttributeConditionId, demandSupplyObjectAttributeId, demandSupplyObjectAttributeConditionName, demandSupplyObjectAttributeConditionDesc);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DemandSupplyObjectAttributeCondition {\n");
    
    sb.append("    demandSupplyObjectAttributeConditionId: ").append(toIndentedString(demandSupplyObjectAttributeConditionId)).append("\n");
    sb.append("    demandSupplyObjectAttributeId: ").append(toIndentedString(demandSupplyObjectAttributeId)).append("\n");
    sb.append("    demandSupplyObjectAttributeConditionName: ").append(toIndentedString(demandSupplyObjectAttributeConditionName)).append("\n");
    sb.append("    demandSupplyObjectAttributeConditionDesc: ").append(toIndentedString(demandSupplyObjectAttributeConditionDesc)).append("\n");
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

