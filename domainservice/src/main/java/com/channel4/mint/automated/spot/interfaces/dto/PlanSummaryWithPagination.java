package com.channel4.mint.automated.spot.interfaces.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * PlanSummaryWithPagination
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-14T09:04:29.792Z")

public class PlanSummaryWithPagination {
	@JsonProperty("planSummary")
	@Valid
	private List<PlanSummary> planSummary = null;

	@JsonProperty("totalCount")
	private Integer totalCount = null;

	public PlanSummaryWithPagination planSummary(List<PlanSummary> planSummary) {
		this.planSummary = planSummary;
		return this;
	}

	public PlanSummaryWithPagination addPlanSummaryItem(PlanSummary planSummaryItem) {
		if (this.planSummary == null) {
			this.planSummary = new ArrayList<PlanSummary>();
		}
		this.planSummary.add(planSummaryItem);
		return this;
	}

	/**
	 * Get planSummary
	 * 
	 * @return planSummary
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public List<PlanSummary> getPlanSummary() {
		return planSummary;
	}

	public void setPlanSummary(List<PlanSummary> planSummary) {
		this.planSummary = planSummary;
	}

	public PlanSummaryWithPagination totalCount(Integer totalCount) {
		this.totalCount = totalCount;
		return this;
	}

	/**
	 * Get totalCount
	 * 
	 * @return totalCount
	 **/
	@ApiModelProperty(value = "")

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PlanSummaryWithPagination planSummaryWithPagination = (PlanSummaryWithPagination) o;
		return Objects.equals(this.planSummary, planSummaryWithPagination.planSummary)
				&& Objects.equals(this.totalCount, planSummaryWithPagination.totalCount);
	}

	@Override
	public int hashCode() {
		return Objects.hash(planSummary, totalCount);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PlanSummaryWithPagination {\n");

		sb.append("    planSummary: ").append(toIndentedString(planSummary)).append("\n");
		sb.append("    totalCount: ").append(toIndentedString(totalCount)).append("\n");
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
