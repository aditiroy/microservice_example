/*
 * 
 */
package com.channel4.mint.automated.spot.interfaces.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

// TODO: Auto-generated Javadoc
/**
 * CriteriaLineNormalised.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-12-19T04:58:28.844Z")

public class CriteriaLineNormalised {

	/** The id. */
	@JsonProperty("criteriaLineId")
	private Long criteriaLineId = null;

	/** The operator. */
	@JsonProperty("operator")
	private String operator = null;

	/** The object. */
	@JsonProperty("objectId")
	private Long objectId = null;

	/** The attribute. */
	@JsonProperty("attributeId")
	private Long attributeId = null;

	/** The condition. */
	@JsonProperty("conditionId")
	private Long conditionId = null;

	/** The value. */
	@JsonProperty("value")
	private String value = null;

	

	public Long getCriteriaLineId() {
		return criteriaLineId;
	}

	public void setCriteriaLineId(Long criteriaLineId) {
		this.criteriaLineId = criteriaLineId;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Long getObjectId() {
		return objectId;
	}

	public void setObjectId(Long objectId) {
		this.objectId = objectId;
	}

	public Long getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(Long attributeId) {
		this.attributeId = attributeId;
	}

	public Long getConditionId() {
		return conditionId;
	}

	public void setConditionId(Long conditionId) {
		this.conditionId = conditionId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
