/*
 * 
 */
package com.channel4.mint.automated.spot.interfaces.dto;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * CamgenRunParamExtract
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-14T09:04:29.792Z")

public class CamgenRunParamExtract {
	@JsonProperty("runParameterExtractId")
	private Integer runParameterExtractId = null;

	@JsonProperty("parameter")
	private String parameter = null;

	@JsonProperty("value")
	private String value = null;

	@JsonProperty("createdBy")
	private String createdBy = null;

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public CamgenRunParamExtract runParameterExtractId(Integer runParameterExtractId) {
		this.runParameterExtractId = runParameterExtractId;
		return this;
	}

	/**
	 * Get runParameterExtractId
	 * 
	 * @return runParameterExtractId
	 **/
	@ApiModelProperty(value = "")

	public Integer getRunParameterExtractId() {
		return runParameterExtractId;
	}

	public void setRunParameterExtractId(Integer runParameterExtractId) {
		this.runParameterExtractId = runParameterExtractId;
	}

	public CamgenRunParamExtract parameter(String parameter) {
		this.parameter = parameter;
		return this;
	}

	/**
	 * Get parameter
	 * 
	 * @return parameter
	 **/
	@ApiModelProperty(value = "")

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public CamgenRunParamExtract value(String value) {
		this.value = value;
		return this;
	}

	/**
	 * Get value
	 * 
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
		CamgenRunParamExtract camgenRunParamExtract = (CamgenRunParamExtract) o;
		return Objects.equals(this.runParameterExtractId, camgenRunParamExtract.runParameterExtractId)
				&& Objects.equals(this.parameter, camgenRunParamExtract.parameter)
				&& Objects.equals(this.value, camgenRunParamExtract.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(runParameterExtractId, parameter, value);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class CamgenRunParamExtract {\n");

		sb.append("    runParameterExtractId: ").append(toIndentedString(runParameterExtractId)).append("\n");
		sb.append("    parameter: ").append(toIndentedString(parameter)).append("\n");
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
