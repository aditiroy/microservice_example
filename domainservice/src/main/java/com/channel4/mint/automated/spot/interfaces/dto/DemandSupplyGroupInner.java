package com.channel4.mint.automated.spot.interfaces.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * DemandSupplyGroupInner
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-12-28T04:55:33.590Z")

public class DemandSupplyGroupInner {
	@JsonProperty("demandSupplyId")
	private Integer demandSupplyId = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("levelId")
	private Long levelId = null;
	
	@JsonProperty("levelCode")
	private String levelCode = null;

	@JsonProperty("amendmentPercent")
	private Double amendmentPercent = null;

	@JsonProperty("status")
	private String status = null;

	@JsonProperty("criterias")
	private List<CriteriaLine> criterias = null;
	
	

	public String getLevelCode() {
		return levelCode;
	}

	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
	}

	public Integer getDemandSupplyId() {
		return demandSupplyId;
	}

	public void setDemandSupplyId(Integer demandSupplyId) {
		this.demandSupplyId = demandSupplyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getLevelId() {
		return levelId;
	}

	public void setLevelId(Long levelId) {
		this.levelId = levelId;
	}

	public Double getAmendmentPercent() {
		return amendmentPercent;
	}

	public void setAmendmentPercent(Double amendmentPercent) {
		this.amendmentPercent = amendmentPercent;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<CriteriaLine> getCriterias() {
		return criterias;
	}

	public void setCriterias(List<CriteriaLine> criterias) {
		this.criterias = criterias;
	}

}
