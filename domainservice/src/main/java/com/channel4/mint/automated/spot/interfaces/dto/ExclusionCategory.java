package com.channel4.mint.automated.spot.interfaces.dto;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * ExclusionCategory
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-14T09:04:29.792Z")

public class ExclusionCategory {
	@JsonProperty("categoryId")
	private String categoryId = null;

	@JsonProperty("categoryName")
	private String categoryName = null;

	public ExclusionCategory categoryId(String categoryId) {
		this.categoryId = categoryId;
		return this;
	}

	/**
	 * Get categoryId
	 * 
	 * @return categoryId
	 **/
	@ApiModelProperty(value = "")

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public ExclusionCategory categoryName(String categoryName) {
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

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ExclusionCategory exclusionCategory = (ExclusionCategory) o;
		return Objects.equals(this.categoryId, exclusionCategory.categoryId)
				&& Objects.equals(this.categoryName, exclusionCategory.categoryName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(categoryId, categoryName);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ExclusionCategory {\n");

		sb.append("    categoryId: ").append(toIndentedString(categoryId)).append("\n");
		sb.append("    categoryName: ").append(toIndentedString(categoryName)).append("\n");
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
