/*
 * 
 */
package com.channel4.mint.automated.spot.interfaces.dto;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * CamgenRunParamEIBand
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-14T09:04:29.792Z")

public class CamgenRunParamEIBand {
	@JsonProperty("runParameterEIBandId")
	private Integer runParameterEIBandId = null;

	@JsonProperty("eiBand")
	private Integer eiBand = null;

	@JsonProperty("createdBy")
	private String createdBy = null;

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public CamgenRunParamEIBand runParameterEIBandId(Integer runParameterEIBandId) {
		this.runParameterEIBandId = runParameterEIBandId;
		return this;
	}

	/**
	 * Get runParameterEIBandId
	 * 
	 * @return runParameterEIBandId
	 **/
	@ApiModelProperty(value = "")

	public Integer getRunParameterEIBandId() {
		return runParameterEIBandId;
	}

	public void setRunParameterEIBandId(Integer runParameterEIBandId) {
		this.runParameterEIBandId = runParameterEIBandId;
	}

	public CamgenRunParamEIBand eiBand(Integer eiBand) {
		this.eiBand = eiBand;
		return this;
	}

	/**
	 * Get eiBand
	 * 
	 * @return eiBand
	 **/
	@ApiModelProperty(value = "")

	public Integer getEiBand() {
		return eiBand;
	}

	public void setEiBand(Integer eiBand) {
		this.eiBand = eiBand;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CamgenRunParamEIBand camgenRunParamEIBand = (CamgenRunParamEIBand) o;
		return Objects.equals(this.runParameterEIBandId, camgenRunParamEIBand.runParameterEIBandId)
				&& Objects.equals(this.eiBand, camgenRunParamEIBand.eiBand);
	}

	@Override
	public int hashCode() {
		return Objects.hash(runParameterEIBandId, eiBand);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class CamgenRunParamEIBand {\n");

		sb.append("    runParameterEIBandId: ").append(toIndentedString(runParameterEIBandId)).append("\n");
		sb.append("    eiBand: ").append(toIndentedString(eiBand)).append("\n");
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
