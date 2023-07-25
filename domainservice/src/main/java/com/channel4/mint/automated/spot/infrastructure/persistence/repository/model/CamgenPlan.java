/*
 * 
 */
package com.channel4.mint.automated.spot.infrastructure.persistence.repository.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

// TODO: Auto-generated Javadoc
/**
 * The persistent class for the CAMGEN_PLAN database table.
 * 
 */
@Entity
@Table(name = "CAMGEN_PLAN")
@NamedQuery(name = "CamgenPlan.findAll", query = "SELECT c FROM CamgenPlan c")
public class CamgenPlan implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "PLAN_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long planId;

	@Column(name = "CHANNEL_SET_ID")
	private BigDecimal channelSetId;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "CREATED_ON")
	private Timestamp createdOn;

	@Temporal(TemporalType.DATE)
	@Column(name = "END_DATE")
	private Date endDate;

	@Column(name = "IS_RUN")
	private BigDecimal isRun;

	@Column(name = "IS_SLOT")
	private BigDecimal isSlot;

	@Column(name = "MODIFIED_BY")
	private String modifiedBy;

	@Column(name = "MODIFIED_ON")
	private Timestamp modifiedOn;

	@Temporal(TemporalType.DATE)
	@Column(name = "START_DATE")
	private Date startDate;

	private String status;

	@Column(name = "TOTAL_ITERATION")
	private BigDecimal totalIteration;

	// bi-directional many-to-one association to CamgenPlanAutofillingDay
	@OneToMany(mappedBy = "camgenPlan", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CamgenPlanAutofillingDay> camgenPlanAutofillingDays;

	// bi-directional many-to-one association to CamgenPlanDemandSupply
	@OneToMany(mappedBy = "camgenPlan", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CamgenPlanDemandSupply> camgenPlanDemandSupplies;

	// bi-directional many-to-one association to CamgenPlanExclusion
	@OneToMany(mappedBy = "camgenPlan", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CamgenPlanExclusion> camgenPlanExclusions;

	// bi-directional many-to-one association to CamgenRequest
	@OneToMany(mappedBy = "camgenPlan", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CamgenRequest> camgenRequests;

	public CamgenPlan() {
	}

	public long getPlanId() {
		return this.planId;
	}

	public void setPlanId(long planId) {
		this.planId = planId;
	}

	public BigDecimal getChannelSetId() {
		return this.channelSetId;
	}

	public void setChannelSetId(BigDecimal channelSetId) {
		this.channelSetId = channelSetId;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public BigDecimal getIsRun() {
		return this.isRun;
	}

	public void setIsRun(BigDecimal isRun) {
		this.isRun = isRun;
	}

	public BigDecimal getIsSlot() {
		return this.isSlot;
	}

	public void setIsSlot(BigDecimal isSlot) {
		this.isSlot = isSlot;
	}

	public String getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getModifiedOn() {
		return this.modifiedOn;
	}

	public void setModifiedOn(Timestamp modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getTotalIteration() {
		return this.totalIteration;
	}

	public void setTotalIteration(BigDecimal totalIteration) {
		this.totalIteration = totalIteration;
	}

	public List<CamgenPlanAutofillingDay> getCamgenPlanAutofillingDays() {
		return this.camgenPlanAutofillingDays;
	}

	public void setCamgenPlanAutofillingDays(List<CamgenPlanAutofillingDay> camgenPlanAutofillingDays) {
		this.camgenPlanAutofillingDays = camgenPlanAutofillingDays;
	}

	public CamgenPlanAutofillingDay addCamgenPlanAutofillingDay(CamgenPlanAutofillingDay camgenPlanAutofillingDay) {
		getCamgenPlanAutofillingDays().add(camgenPlanAutofillingDay);
		camgenPlanAutofillingDay.setCamgenPlan(this);

		return camgenPlanAutofillingDay;
	}

	public CamgenPlanAutofillingDay removeCamgenPlanAutofillingDay(CamgenPlanAutofillingDay camgenPlanAutofillingDay) {
		getCamgenPlanAutofillingDays().remove(camgenPlanAutofillingDay);
		camgenPlanAutofillingDay.setCamgenPlan(null);

		return camgenPlanAutofillingDay;
	}

	public List<CamgenPlanDemandSupply> getCamgenPlanDemandSupplies() {
		return this.camgenPlanDemandSupplies;
	}

	public void setCamgenPlanDemandSupplies(List<CamgenPlanDemandSupply> camgenPlanDemandSupplies) {
		this.camgenPlanDemandSupplies = camgenPlanDemandSupplies;
	}

	public CamgenPlanDemandSupply addCamgenPlanDemandSupply(CamgenPlanDemandSupply camgenPlanDemandSupply) {
		getCamgenPlanDemandSupplies().add(camgenPlanDemandSupply);
		camgenPlanDemandSupply.setCamgenPlan(this);

		return camgenPlanDemandSupply;
	}

	public CamgenPlanDemandSupply removeCamgenPlanDemandSupply(CamgenPlanDemandSupply camgenPlanDemandSupply) {
		getCamgenPlanDemandSupplies().remove(camgenPlanDemandSupply);
		camgenPlanDemandSupply.setCamgenPlan(null);

		return camgenPlanDemandSupply;
	}

	public List<CamgenPlanExclusion> getCamgenPlanExclusions() {
		return this.camgenPlanExclusions;
	}

	public void setCamgenPlanExclusions(List<CamgenPlanExclusion> camgenPlanExclusions) {
		this.camgenPlanExclusions = camgenPlanExclusions;
	}

	public CamgenPlanExclusion addCamgenPlanExclusion(CamgenPlanExclusion camgenPlanExclusion) {
		getCamgenPlanExclusions().add(camgenPlanExclusion);
		camgenPlanExclusion.setCamgenPlan(this);

		return camgenPlanExclusion;
	}

	public CamgenPlanExclusion removeCamgenPlanExclusion(CamgenPlanExclusion camgenPlanExclusion) {
		getCamgenPlanExclusions().remove(camgenPlanExclusion);
		camgenPlanExclusion.setCamgenPlan(null);

		return camgenPlanExclusion;
	}

	public List<CamgenRequest> getCamgenRequests() {
		return this.camgenRequests;
	}

	public void setCamgenRequests(List<CamgenRequest> camgenRequests) {
		this.camgenRequests = camgenRequests;
	}

	public CamgenRequest addCamgenRequest(CamgenRequest camgenRequest) {
		getCamgenRequests().add(camgenRequest);
		camgenRequest.setCamgenPlan(this);

		return camgenRequest;
	}

	public CamgenRequest removeCamgenRequest(CamgenRequest camgenRequest) {
		getCamgenRequests().remove(camgenRequest);
		camgenRequest.setCamgenPlan(null);

		return camgenRequest;
	}

}