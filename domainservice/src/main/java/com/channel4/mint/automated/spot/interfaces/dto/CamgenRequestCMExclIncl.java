package com.channel4.mint.automated.spot.interfaces.dto;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * CamgenRequestCMExclIncl
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-14T09:04:29.792Z")

public class CamgenRequestCMExclIncl {
	@JsonProperty("id")
	private Long id = null;

	@JsonProperty("cmId")
	private Long cmId = null;

	@JsonProperty("isExcluded")
	private Boolean isExcluded = null;

	public CamgenRequestCMExclIncl id(Long id) {
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

	public CamgenRequestCMExclIncl cmId(Long cmId) {
		this.cmId = cmId;
		return this;
	}

	/**
	 * Get cmId
	 * 
	 * @return cmId
	 **/
	@ApiModelProperty(value = "")

	public Long getCmId() {
		return cmId;
	}

	public void setCmId(Long cmId) {
		this.cmId = cmId;
	}

	public CamgenRequestCMExclIncl isExcluded(Boolean isExcluded) {
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
		CamgenRequestCMExclIncl camgenRequestCMExclIncl = (CamgenRequestCMExclIncl) o;
		return Objects.equals(this.id, camgenRequestCMExclIncl.id)
				&& Objects.equals(this.cmId, camgenRequestCMExclIncl.cmId)
				&& Objects.equals(this.isExcluded, camgenRequestCMExclIncl.isExcluded);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, cmId, isExcluded);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class CamgenRequestCMExclIncl {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    cmId: ").append(toIndentedString(cmId)).append("\n");
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
