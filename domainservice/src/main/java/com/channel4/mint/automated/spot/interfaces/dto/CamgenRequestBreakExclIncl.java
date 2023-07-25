package com.channel4.mint.automated.spot.interfaces.dto;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * CamgenRequestBreakExclIncl
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-14T09:04:29.792Z")

public class CamgenRequestBreakExclIncl {
	@JsonProperty("id")
	private Long id = null;

	@JsonProperty("commercialBreakId")
	private Long commercialBreakId = null;

	@JsonProperty("isExcluded")
	private Boolean isExcluded = null;

	public CamgenRequestBreakExclIncl id(Long id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "")

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CamgenRequestBreakExclIncl commercialBreakId(Long commercialBreakId) {
		this.commercialBreakId = commercialBreakId;
		return this;
	}

	/**
	 * Get commercialBreakId
	 * 
	 * @return commercialBreakId
	 **/
	@ApiModelProperty(value = "")

	public Long getCommercialBreakId() {
		return commercialBreakId;
	}

	public void setCommercialBreakId(Long commercialBreakId) {
		this.commercialBreakId = commercialBreakId;
	}

	public CamgenRequestBreakExclIncl isExcluded(Boolean isExcluded) {
		this.isExcluded = isExcluded;
		return this;
	}

	/**
	 * Get isExcluded
	 * 
	 * @return isExcluded
	 **/
	@ApiModelProperty(value = "")

	public Boolean isIsExcluded() {
		return isExcluded;
	}

	public void setIsExcluded(Boolean isExcluded) {
		this.isExcluded = isExcluded;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CamgenRequestBreakExclIncl camgenRequestBreakExclIncl = (CamgenRequestBreakExclIncl) o;
		return Objects.equals(this.id, camgenRequestBreakExclIncl.id)
				&& Objects.equals(this.commercialBreakId, camgenRequestBreakExclIncl.commercialBreakId)
				&& Objects.equals(this.isExcluded, camgenRequestBreakExclIncl.isExcluded);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, commercialBreakId, isExcluded);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class CamgenRequestBreakExclIncl {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    commercialBreakId: ").append(toIndentedString(commercialBreakId)).append("\n");
		sb.append("    isExcluded: ").append(toIndentedString(isExcluded)).append("\n");
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
