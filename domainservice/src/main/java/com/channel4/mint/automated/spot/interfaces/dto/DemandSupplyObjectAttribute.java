package com.channel4.mint.automated.spot.interfaces.dto;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * DemandSupplyObjectAttribute
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-03-20T06:10:00.689Z")

public class DemandSupplyObjectAttribute   {
  @JsonProperty("demandSupplyObjectAttributeId")
  private Integer demandSupplyObjectAttributeId = null;

  @JsonProperty("demandSupplyObjectId")
  private Integer demandSupplyObjectId = null;

  @JsonProperty("demandSupplyObjectAttributeName")
  private String demandSupplyObjectAttributeName = null;

  @JsonProperty("demandSupplyObjectAttributeDesc")
  private String demandSupplyObjectAttributeDesc = null;

  public DemandSupplyObjectAttribute demandSupplyObjectAttributeId(Integer demandSupplyObjectAttributeId) {
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

  public DemandSupplyObjectAttribute demandSupplyObjectId(Integer demandSupplyObjectId) {
    this.demandSupplyObjectId = demandSupplyObjectId;
    return this;
  }

  /**
   * Get demandSupplyObjectId
   * @return demandSupplyObjectId
  **/
  @ApiModelProperty(value = "")


  public Integer getDemandSupplyObjectId() {
    return demandSupplyObjectId;
  }

  public void setDemandSupplyObjectId(Integer demandSupplyObjectId) {
    this.demandSupplyObjectId = demandSupplyObjectId;
  }

  public DemandSupplyObjectAttribute demandSupplyObjectAttributeName(String demandSupplyObjectAttributeName) {
    this.demandSupplyObjectAttributeName = demandSupplyObjectAttributeName;
    return this;
  }

  /**
   * Get demandSupplyObjectAttributeName
   * @return demandSupplyObjectAttributeName
  **/
  @ApiModelProperty(value = "")


  public String getDemandSupplyObjectAttributeName() {
    return demandSupplyObjectAttributeName;
  }

  public void setDemandSupplyObjectAttributeName(String demandSupplyObjectAttributeName) {
    this.demandSupplyObjectAttributeName = demandSupplyObjectAttributeName;
  }

  public DemandSupplyObjectAttribute demandSupplyObjectAttributeDesc(String demandSupplyObjectAttributeDesc) {
    this.demandSupplyObjectAttributeDesc = demandSupplyObjectAttributeDesc;
    return this;
  }

  /**
   * Get demandSupplyObjectAttributeDesc
   * @return demandSupplyObjectAttributeDesc
  **/
  @ApiModelProperty(value = "")


  public String getDemandSupplyObjectAttributeDesc() {
    return demandSupplyObjectAttributeDesc;
  }

  public void setDemandSupplyObjectAttributeDesc(String demandSupplyObjectAttributeDesc) {
    this.demandSupplyObjectAttributeDesc = demandSupplyObjectAttributeDesc;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DemandSupplyObjectAttribute demandSupplyObjectAttribute = (DemandSupplyObjectAttribute) o;
    return Objects.equals(this.demandSupplyObjectAttributeId, demandSupplyObjectAttribute.demandSupplyObjectAttributeId) &&
        Objects.equals(this.demandSupplyObjectId, demandSupplyObjectAttribute.demandSupplyObjectId) &&
        Objects.equals(this.demandSupplyObjectAttributeName, demandSupplyObjectAttribute.demandSupplyObjectAttributeName) &&
        Objects.equals(this.demandSupplyObjectAttributeDesc, demandSupplyObjectAttribute.demandSupplyObjectAttributeDesc);
  }

  @Override
  public int hashCode() {
    return Objects.hash(demandSupplyObjectAttributeId, demandSupplyObjectId, demandSupplyObjectAttributeName, demandSupplyObjectAttributeDesc);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DemandSupplyObjectAttribute {\n");
    
    sb.append("    demandSupplyObjectAttributeId: ").append(toIndentedString(demandSupplyObjectAttributeId)).append("\n");
    sb.append("    demandSupplyObjectId: ").append(toIndentedString(demandSupplyObjectId)).append("\n");
    sb.append("    demandSupplyObjectAttributeName: ").append(toIndentedString(demandSupplyObjectAttributeName)).append("\n");
    sb.append("    demandSupplyObjectAttributeDesc: ").append(toIndentedString(demandSupplyObjectAttributeDesc)).append("\n");
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

