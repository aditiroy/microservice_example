/*
 * 
 */
package com.channel4.mint.automated.spot.interfaces.dto;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * CamgenRunParam
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-14T09:04:29.792Z")

public class CamgenRunParam {
	@JsonProperty("runParameterId")
	private Integer runParameterId = null;

	@JsonProperty("parameter")
	private String parameter = null;

	@JsonProperty("standardvalue")
	private String standardvalue = null;

	@JsonProperty("value")
	private String value = null;

	@JsonProperty("remarks")
	private String remarks = null;

	@JsonProperty("createdBy")
	private String createdBy = null;

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public CamgenRunParam runParameterId(Integer runParameterId) {
		this.runParameterId = runParameterId;
		return this;
	}

	/**
	 * Get runParameterId
	 * 
	 * @return runParameterId
	 **/
	@ApiModelProperty(value = "")

	public Integer getRunParameterId() {
		return runParameterId;
	}

	public void setRunParameterId(Integer runParameterId) {
		this.runParameterId = runParameterId;
	}

	public CamgenRunParam parameter(String parameter) {
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

	public CamgenRunParam standardvalue(String standardvalue) {
		this.standardvalue = standardvalue;
		return this;
	}

	/**
	 * Get standardvalue
	 * 
	 * @return standardvalue
	 **/
	@ApiModelProperty(value = "")

	public String getStandardvalue() {
		return standardvalue;
	}

	public void setStandardvalue(String standardvalue) {
		this.standardvalue = standardvalue;
	}

	public CamgenRunParam value(String value) {
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

	public CamgenRunParam remarks(String remarks) {
		this.remarks = remarks;
		return this;
	}

	/**
	 * Get remarks
	 * 
	 * @return remarks
	 **/
	@ApiModelProperty(value = "")

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CamgenRunParam camgenRunParam = (CamgenRunParam) o;
		return Objects.equals(this.runParameterId, camgenRunParam.runParameterId)
				&& Objects.equals(this.parameter, camgenRunParam.parameter)
				&& Objects.equals(this.standardvalue, camgenRunParam.standardvalue)
				&& Objects.equals(this.value, camgenRunParam.value)
				&& Objects.equals(this.remarks, camgenRunParam.remarks);
	}

	@Override
	public int hashCode() {
		return Objects.hash(runParameterId, parameter, standardvalue, value, remarks);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class CamgenRunParam {\n");

		sb.append("    runParameterId: ").append(toIndentedString(runParameterId)).append("\n");
		sb.append("    parameter: ").append(toIndentedString(parameter)).append("\n");
		sb.append("    standardvalue: ").append(toIndentedString(standardvalue)).append("\n");
		sb.append("    value: ").append(toIndentedString(value)).append("\n");
		sb.append("    remarks: ").append(toIndentedString(remarks)).append("\n");
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
