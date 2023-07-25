/*
 * 
 */
package com.channel4.mint.automated.spot.interfaces.dto;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * CriteriaLine
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-11T05:47:42.947Z")

public class CriteriaLine   {
  @JsonProperty("criteriaLineId")
  private Long criteriaLineId = null;

  /**
   * Gets or Sets operator
   */
  public enum OperatorEnum {
    AND("AND"),
    
    OR("OR");

    private String value;

    OperatorEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static OperatorEnum fromValue(String text) {
      for (OperatorEnum b : OperatorEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("operator")
  private OperatorEnum operator = null;

  @JsonProperty("objectId")
  private Long objectId = null;

  @JsonProperty("objectCode")
  private String objectCode = null;

  @JsonProperty("attributeId")
  private Long attributeId = null;

  @JsonProperty("attributeCode")
  private String attributeCode = null;

  @JsonProperty("conditionId")
  private Long conditionId = null;

  @JsonProperty("conditionCode")
  private String conditionCode = null;

  @JsonProperty("value")
  private String value = null;

  public CriteriaLine criteriaLineId(Long criteriaLineId) {
    this.criteriaLineId = criteriaLineId;
    return this;
  }

  /**
   * Get criteriaLineId
   * @return criteriaLineId
  **/
  @ApiModelProperty(value = "")


  public Long getCriteriaLineId() {
    return criteriaLineId;
  }

  public void setCriteriaLineId(Long criteriaLineId) {
    this.criteriaLineId = criteriaLineId;
  }

  public CriteriaLine operator(OperatorEnum operator) {
    this.operator = operator;
    return this;
  }

  /**
   * Get operator
   * @return operator
  **/
  @ApiModelProperty(value = "")


  public OperatorEnum getOperator() {
    return operator;
  }

  public void setOperator(OperatorEnum operator) {
    this.operator = operator;
  }

  public CriteriaLine objectId(Long objectId) {
    this.objectId = objectId;
    return this;
  }

  /**
   * Get objectId
   * @return objectId
  **/
  @ApiModelProperty(value = "")


  public Long getObjectId() {
    return objectId;
  }

  public void setObjectId(Long objectId) {
    this.objectId = objectId;
  }

  public CriteriaLine objectCode(String objectCode) {
    this.objectCode = objectCode;
    return this;
  }

  /**
   * Get objectCode
   * @return objectCode
  **/
  @ApiModelProperty(value = "")


  public String getObjectCode() {
    return objectCode;
  }

  public void setObjectCode(String objectCode) {
    this.objectCode = objectCode;
  }

  public CriteriaLine attributeId(Long attributeId) {
    this.attributeId = attributeId;
    return this;
  }

  /**
   * Get attributeId
   * @return attributeId
  **/
  @ApiModelProperty(value = "")


  public Long getAttributeId() {
    return attributeId;
  }

  public void setAttributeId(Long attributeId) {
    this.attributeId = attributeId;
  }

  public CriteriaLine attributeCode(String attributeCode) {
    this.attributeCode = attributeCode;
    return this;
  }

  /**
   * Get attributeCode
   * @return attributeCode
  **/
  @ApiModelProperty(value = "")


  public String getAttributeCode() {
    return attributeCode;
  }

  public void setAttributeCode(String attributeCode) {
    this.attributeCode = attributeCode;
  }

  public CriteriaLine conditionId(Long conditionId) {
    this.conditionId = conditionId;
    return this;
  }

  /**
   * Get conditionId
   * @return conditionId
  **/
  @ApiModelProperty(value = "")


  public Long getConditionId() {
    return conditionId;
  }

  public void setConditionId(Long conditionId) {
    this.conditionId = conditionId;
  }

  public CriteriaLine conditionCode(String conditionCode) {
    this.conditionCode = conditionCode;
    return this;
  }

  /**
   * Get conditionCode
   * @return conditionCode
  **/
  @ApiModelProperty(value = "")


  public String getConditionCode() {
    return conditionCode;
  }

  public void setConditionCode(String conditionCode) {
    this.conditionCode = conditionCode;
  }

  public CriteriaLine value(String value) {
    this.value = value;
    return this;
  }

  /**
   * Get value
   * @return value
  **/
  @ApiModelProperty(value = "")


  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CriteriaLine criteriaLine = (CriteriaLine) o;
    return Objects.equals(this.criteriaLineId, criteriaLine.criteriaLineId) &&
        Objects.equals(this.operator, criteriaLine.operator) &&
        Objects.equals(this.objectId, criteriaLine.objectId) &&
        Objects.equals(this.objectCode, criteriaLine.objectCode) &&
        Objects.equals(this.attributeId, criteriaLine.attributeId) &&
        Objects.equals(this.attributeCode, criteriaLine.attributeCode) &&
        Objects.equals(this.conditionId, criteriaLine.conditionId) &&
        Objects.equals(this.conditionCode, criteriaLine.conditionCode) &&
        Objects.equals(this.value, criteriaLine.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(criteriaLineId, operator, objectId, objectCode, attributeId, attributeCode, conditionId, conditionCode, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CriteriaLine {\n");
    
    sb.append("    criteriaLineId: ").append(toIndentedString(criteriaLineId)).append("\n");
    sb.append("    operator: ").append(toIndentedString(operator)).append("\n");
    sb.append("    objectId: ").append(toIndentedString(objectId)).append("\n");
    sb.append("    objectCode: ").append(toIndentedString(objectCode)).append("\n");
    sb.append("    attributeId: ").append(toIndentedString(attributeId)).append("\n");
    sb.append("    attributeCode: ").append(toIndentedString(attributeCode)).append("\n");
    sb.append("    conditionId: ").append(toIndentedString(conditionId)).append("\n");
    sb.append("    conditionCode: ").append(toIndentedString(conditionCode)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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

