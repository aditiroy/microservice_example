package com.channel4.mint.automated.spot.interfaces.dto;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * DemandSupplyLevelObject
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-03-20T06:10:00.689Z")

public class DemandSupplyLevelObject   {
  @JsonProperty("demandSupplyLevelObjectId")
  private Integer demandSupplyLevelObjectId = null;

  @JsonProperty("demandSupplyLevelId")
  private Integer demandSupplyLevelId = null;

  @JsonProperty("demandSupplyLevelObjectName")
  private String demandSupplyLevelObjectName = null;

  @JsonProperty("demandSupplyLevelObjectDesc")
  private String demandSupplyLevelObjectDesc = null;

  public DemandSupplyLevelObject demandSupplyLevelObjectId(Integer demandSupplyLevelObjectId) {
    this.demandSupplyLevelObjectId = demandSupplyLevelObjectId;
    return this;
  }

  /**
   * Get demandSupplyLevelObjectId
   * @return demandSupplyLevelObjectId
  **/
  @ApiModelProperty(value = "")


  public Integer getDemandSupplyLevelObjectId() {
    return demandSupplyLevelObjectId;
  }

  public void setDemandSupplyLevelObjectId(Integer demandSupplyLevelObjectId) {
    this.demandSupplyLevelObjectId = demandSupplyLevelObjectId;
  }

  public DemandSupplyLevelObject demandSupplyLevelId(Integer demandSupplyLevelId) {
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

  public DemandSupplyLevelObject demandSupplyLevelObjectName(String demandSupplyLevelObjectName) {
    this.demandSupplyLevelObjectName = demandSupplyLevelObjectName;
    return this;
  }

  /**
   * Get demandSupplyLevelObjectName
   * @return demandSupplyLevelObjectName
  **/
  @ApiModelProperty(value = "")


  public String getDemandSupplyLevelObjectName() {
    return demandSupplyLevelObjectName;
  }

  public void setDemandSupplyLevelObjectName(String demandSupplyLevelObjectName) {
    this.demandSupplyLevelObjectName = demandSupplyLevelObjectName;
  }

  public DemandSupplyLevelObject demandSupplyLevelObjectDesc(String demandSupplyLevelObjectDesc) {
    this.demandSupplyLevelObjectDesc = demandSupplyLevelObjectDesc;
    return this;
  }

  /**
   * Get demandSupplyLevelObjectDesc
   * @return demandSupplyLevelObjectDesc
  **/
  @ApiModelProperty(value = "")


  public String getDemandSupplyLevelObjectDesc() {
    return demandSupplyLevelObjectDesc;
  }

  public void setDemandSupplyLevelObjectDesc(String demandSupplyLevelObjectDesc) {
    this.demandSupplyLevelObjectDesc = demandSupplyLevelObjectDesc;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DemandSupplyLevelObject demandSupplyLevelObject = (DemandSupplyLevelObject) o;
    return Objects.equals(this.demandSupplyLevelObjectId, demandSupplyLevelObject.demandSupplyLevelObjectId) &&
        Objects.equals(this.demandSupplyLevelId, demandSupplyLevelObject.demandSupplyLevelId) &&
        Objects.equals(this.demandSupplyLevelObjectName, demandSupplyLevelObject.demandSupplyLevelObjectName) &&
        Objects.equals(this.demandSupplyLevelObjectDesc, demandSupplyLevelObject.demandSupplyLevelObjectDesc);
  }

  @Override
  public int hashCode() {
    return Objects.hash(demandSupplyLevelObjectId, demandSupplyLevelId, demandSupplyLevelObjectName, demandSupplyLevelObjectDesc);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DemandSupplyLevelObject {\n");
    
    sb.append("    demandSupplyLevelObjectId: ").append(toIndentedString(demandSupplyLevelObjectId)).append("\n");
    sb.append("    demandSupplyLevelId: ").append(toIndentedString(demandSupplyLevelId)).append("\n");
    sb.append("    demandSupplyLevelObjectName: ").append(toIndentedString(demandSupplyLevelObjectName)).append("\n");
    sb.append("    demandSupplyLevelObjectDesc: ").append(toIndentedString(demandSupplyLevelObjectDesc)).append("\n");
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

