package com.channel4.mint.automated.spot.interfaces.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * DemandSupplyGroup
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-14T09:04:29.792Z")

public class DemandSupplyGroup   {
  @JsonProperty("demandSupplyId")
  private Integer demandSupplyId = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("levelId")
  private Long levelId = null;

  /**
   * Gets or Sets levelCode
   */
  public enum LevelCodeEnum {
    BREAK("BREAK"),
    
    CAMPAIGNLINEMONTH("CLIM"),
	  
	CAMPAIGNLINEMONTHTIMEBAND("CLIMTB");
    private String value;

    LevelCodeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static LevelCodeEnum fromValue(String text) {
      for (LevelCodeEnum b : LevelCodeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
    
    @JsonCreator
    public static String fromValueCons(String text) {
      for (LevelCodeEnum b : LevelCodeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b.name();
        }
      }
      return null;
    }
  }

  @JsonProperty("levelCode")
  private LevelCodeEnum levelCode = null;

  @JsonProperty("amendmentPercent")
  private Double amendmentPercent = null;

  @JsonProperty("status")
  private String status = null;

  @JsonProperty("criterias")
  @Valid
  private List<CriteriaLine> criterias = null;

  public DemandSupplyGroup demandSupplyId(Integer demandSupplyId) {
    this.demandSupplyId = demandSupplyId;
    return this;
  }

  /**
   * Get demandSupplyId
   * @return demandSupplyId
  **/
  @ApiModelProperty(value = "")


  public Integer getDemandSupplyId() {
    return demandSupplyId;
  }

  public void setDemandSupplyId(Integer demandSupplyId) {
    this.demandSupplyId = demandSupplyId;
  }

  public DemandSupplyGroup name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public DemandSupplyGroup levelId(Long levelId) {
    this.levelId = levelId;
    return this;
  }

  /**
   * Get levelId
   * @return levelId
  **/
  @ApiModelProperty(value = "")


  public Long getLevelId() {
    return levelId;
  }

  public void setLevelId(Long levelId) {
    this.levelId = levelId;
  }

  public DemandSupplyGroup levelCode(LevelCodeEnum levelCode) {
    this.levelCode = levelCode;
    return this;
  }

  /**
   * Get levelCode
   * @return levelCode
  **/
  @ApiModelProperty(value = "")


  public LevelCodeEnum getLevelCode() {
    return levelCode;
  }

  public void setLevelCode(LevelCodeEnum levelCode) {
    this.levelCode = levelCode;
  }

  public DemandSupplyGroup amendmentPercent(Double amendmentPercent) {
    this.amendmentPercent = amendmentPercent;
    return this;
  }

  /**
   * Get amendmentPercent
   * @return amendmentPercent
  **/
  @ApiModelProperty(value = "")


  public Double getAmendmentPercent() {
    return amendmentPercent;
  }

  public void setAmendmentPercent(Double amendmentPercent) {
    this.amendmentPercent = amendmentPercent;
  }

  public DemandSupplyGroup status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public DemandSupplyGroup criterias(List<CriteriaLine> criterias) {
    this.criterias = criterias;
    return this;
  }

  public DemandSupplyGroup addCriteriasItem(CriteriaLine criteriasItem) {
    if (this.criterias == null) {
      this.criterias = new ArrayList<CriteriaLine>();
    }
    this.criterias.add(criteriasItem);
    return this;
  }

  /**
   * Get criterias
   * @return criterias
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<CriteriaLine> getCriterias() {
    return criterias;
  }

  public void setCriterias(List<CriteriaLine> criterias) {
    this.criterias = criterias;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DemandSupplyGroup demandSupplyGroup = (DemandSupplyGroup) o;
    return Objects.equals(this.demandSupplyId, demandSupplyGroup.demandSupplyId) &&
        Objects.equals(this.name, demandSupplyGroup.name) &&
        Objects.equals(this.levelId, demandSupplyGroup.levelId) &&
        Objects.equals(this.levelCode, demandSupplyGroup.levelCode) &&
        Objects.equals(this.amendmentPercent, demandSupplyGroup.amendmentPercent) &&
        Objects.equals(this.status, demandSupplyGroup.status) &&
        Objects.equals(this.criterias, demandSupplyGroup.criterias);
  }

  @Override
  public int hashCode() {
    return Objects.hash(demandSupplyId, name, levelId, levelCode, amendmentPercent, status, criterias);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DemandSupplyGroup {\n");
    
    sb.append("    demandSupplyId: ").append(toIndentedString(demandSupplyId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    levelId: ").append(toIndentedString(levelId)).append("\n");
    sb.append("    levelCode: ").append(toIndentedString(levelCode)).append("\n");
    sb.append("    amendmentPercent: ").append(toIndentedString(amendmentPercent)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    criterias: ").append(toIndentedString(criterias)).append("\n");
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

