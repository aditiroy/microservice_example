package com.channel4.mint.automated.spot.interfaces.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * ExclusionDemandSupplyGroup
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-12-28T04:55:33.590Z")

public class ExclusionDemandSupplyGroup {
	@JsonProperty("categoryId")
	private Integer categoryId = null;

	@JsonProperty("categoryName")
	private String categoryName = null;

	@JsonProperty("categoryValue")
	private String categoryValue = null;

	@JsonProperty("startTime")
	private String startTime = null;

	@JsonProperty("endTime")
	private String endTime = null;

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public ExclusionDemandSupplyGroup categoryId(Integer categoryId) {
		this.categoryId = categoryId;
		return this;
	}

	/**
	 * Get categoryId
	 * 
	 * @return categoryId
	 **/
	@ApiModelProperty(value = "")

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public ExclusionDemandSupplyGroup categoryName(String categoryName) {
		this.categoryName = categoryName;
		return this;
	}

	/**
	 * Get categoryName
	 * 
	 * @return categoryName
	 **/
	@ApiModelProperty(value = "")

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public ExclusionDemandSupplyGroup categoryValue(String categoryValue) {
		this.categoryValue = categoryValue;
		return this;
	}

	/**
	 * Get categoryValue
	 * 
	 * @return categoryValue
	 **/
	@ApiModelProperty(value = "")

	public String getCategoryValue() {
		return categoryValue;
	}

	public void setCategoryValue(String categoryValue) {
		this.categoryValue = categoryValue;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ExclusionDemandSupplyGroup exclusionDemandSupplyGroup = (ExclusionDemandSupplyGroup) o;
		return Objects.equals(this.categoryId, exclusionDemandSupplyGroup.categoryId)
				&& Objects.equals(this.categoryName, exclusionDemandSupplyGroup.categoryName)
				&& Objects.equals(this.categoryValue, exclusionDemandSupplyGroup.categoryValue);
	}

	@Override
	public int hashCode() {
		return Objects.hash(categoryId, categoryName, categoryValue);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ExclusionDemandSupplyGroup {\n");

		sb.append("    categoryId: ").append(toIndentedString(categoryId)).append("\n");
		sb.append("    categoryName: ").append(toIndentedString(categoryName)).append("\n");
		sb.append("    categoryValue: ").append(toIndentedString(categoryValue)).append("\n");
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
