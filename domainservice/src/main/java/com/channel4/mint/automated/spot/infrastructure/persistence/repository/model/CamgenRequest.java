
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the CAMGEN_REQUEST database table.
 * 
 */
@Entity
@Table(name = "CAMGEN_REQUEST")
@NamedQuery(name = "CamgenRequest.findAll", query = "SELECT c FROM CamgenRequest c")
public class CamgenRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "REQUEST_ID")
	private long requestId;

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

	@Column(name = "REQUEST_TYPE")
	private String requestType;

	@Temporal(TemporalType.DATE)
	@Column(name = "SCHEDULE_DATE_TIME")
	private Date scheduleDateTime;

	@Temporal(TemporalType.DATE)
	@Column(name = "FILLING_START_DATE")
	private Date fillingStartDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "FILLING_END_DATE")
	private Date fillingEndDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "START_DATE")
	private Date startDate;

	private String status;

	@Column(name = "TOTAL_ITERATION")
	private BigDecimal totalIteration;

	// bi-directional many-to-one association to CamgenPlan
	@ManyToOne
	@JoinColumn(name = "PLAN_ID")
	private CamgenPlan camgenPlan;

	// bi-directional many-to-one association to CamgenRqstBatchTxLevel
	@OneToMany(mappedBy = "camgenRequest", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CamgenRqstBatchTxLevel> camgenRqstBatchTxLevels;

	// bi-directional many-to-one association to CamgenRqstBreakExclIncl
	@OneToMany(mappedBy = "camgenRequest", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CamgenRqstBreakExclIncl> camgenRqstBreakExclIncls;

	// bi-directional many-to-one association to CamgenRqstChSetTimeband
	@OneToMany(mappedBy = "camgenRequest", cascade = CascadeType.ALL,orphanRemoval = true)
	private List<CamgenRqstChSetTimeband> camgenRqstChSetTimebands;

	// bi-directional many-to-one association to CamgenRqstClimExclIncl
	@OneToMany(mappedBy = "camgenRequest", cascade = CascadeType.ALL,orphanRemoval = true)
	private List<CamgenRqstClimExclIncl> camgenRqstClimExclIncls;

	// bi-directional many-to-one association to CamgenRqstDemandSupply
	@OneToMany(mappedBy = "camgenRequest", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CamgenRqstDemandSupply> camgenRqstDemandSupplies;

	// bi-directional many-to-one association to CamgenRun
	@OneToMany(mappedBy = "camgenRequest", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CamgenRun> camgenRuns;

	public CamgenRequest() {
	}

	public long getRequestId() {
		return this.requestId;
	}

	public void setRequestId(long requestId) {
		this.requestId = requestId;
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

	public String getRequestType() {
		return this.requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public Date getScheduleDateTime() {
		return this.scheduleDateTime;
	}

	public void setScheduleDateTime(Date scheduleDateTime) {
		this.scheduleDateTime = scheduleDateTime;
	}

	public Date getFillingStartDate() {
		return fillingStartDate;
	}

	public void setFillingStartDate(Date fillingStartDate) {
		this.fillingStartDate = fillingStartDate;
	}

	public Date getFillingEndDate() {
		return fillingEndDate;
	}

	public void setFillingEndDate(Date fillingEndDate) {
		this.fillingEndDate = fillingEndDate;
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

	public CamgenPlan getCamgenPlan() {
		return this.camgenPlan;
	}

	public void setCamgenPlan(CamgenPlan camgenPlan) {
		this.camgenPlan = camgenPlan;
	}

	public List<CamgenRqstBatchTxLevel> getCamgenRqstBatchTxLevels() {
		return this.camgenRqstBatchTxLevels;
	}

	public void setCamgenRqstBatchTxLevels(List<CamgenRqstBatchTxLevel> camgenRqstBatchTxLevels) {
		this.camgenRqstBatchTxLevels = camgenRqstBatchTxLevels;
	}

	public CamgenRqstBatchTxLevel addCamgenRqstBatchTxLevel(CamgenRqstBatchTxLevel camgenRqstBatchTxLevel) {
		getCamgenRqstBatchTxLevels().add(camgenRqstBatchTxLevel);
		camgenRqstBatchTxLevel.setCamgenRequest(this);

		return camgenRqstBatchTxLevel;
	}

	public CamgenRqstBatchTxLevel removeCamgenRqstBatchTxLevel(CamgenRqstBatchTxLevel camgenRqstBatchTxLevel) {
		getCamgenRqstBatchTxLevels().remove(camgenRqstBatchTxLevel);
		camgenRqstBatchTxLevel.setCamgenRequest(null);

		return camgenRqstBatchTxLevel;
	}

	public List<CamgenRqstBreakExclIncl> getCamgenRqstBreakExclIncls() {
		return this.camgenRqstBreakExclIncls;
	}

	public void setCamgenRqstBreakExclIncls(List<CamgenRqstBreakExclIncl> camgenRqstBreakExclIncls) {
		this.camgenRqstBreakExclIncls = camgenRqstBreakExclIncls;
	}

	public CamgenRqstBreakExclIncl addCamgenRqstBreakExclIncl(CamgenRqstBreakExclIncl camgenRqstBreakExclIncl) {
		getCamgenRqstBreakExclIncls().add(camgenRqstBreakExclIncl);
		camgenRqstBreakExclIncl.setCamgenRequest(this);

		return camgenRqstBreakExclIncl;
	}

	public CamgenRqstBreakExclIncl removeCamgenRqstBreakExclIncl(CamgenRqstBreakExclIncl camgenRqstBreakExclIncl) {
		getCamgenRqstBreakExclIncls().remove(camgenRqstBreakExclIncl);
		camgenRqstBreakExclIncl.setCamgenRequest(null);

		return camgenRqstBreakExclIncl;
	}

	public List<CamgenRqstChSetTimeband> getCamgenRqstChSetTimebands() {
		return this.camgenRqstChSetTimebands;
	}

	public void setCamgenRqstChSetTimebands(List<CamgenRqstChSetTimeband> camgenRqstChSetTimebands) {
		this.camgenRqstChSetTimebands = camgenRqstChSetTimebands;
	}

	public CamgenRqstChSetTimeband addCamgenRqstChSetTimeband(CamgenRqstChSetTimeband camgenRqstChSetTimeband) {
		getCamgenRqstChSetTimebands().add(camgenRqstChSetTimeband);
		camgenRqstChSetTimeband.setCamgenRequest(this);

		return camgenRqstChSetTimeband;
	}

	public CamgenRqstChSetTimeband removeCamgenRqstChSetTimeband(CamgenRqstChSetTimeband camgenRqstChSetTimeband) {
		getCamgenRqstChSetTimebands().remove(camgenRqstChSetTimeband);
		camgenRqstChSetTimeband.setCamgenRequest(null);

		return camgenRqstChSetTimeband;
	}

	public List<CamgenRqstClimExclIncl> getCamgenRqstClimExclIncls() {
		return this.camgenRqstClimExclIncls;
	}

	public void setCamgenRqstClimExclIncls(List<CamgenRqstClimExclIncl> camgenRqstClimExclIncls) {
		this.camgenRqstClimExclIncls = camgenRqstClimExclIncls;
	}

	public CamgenRqstClimExclIncl addCamgenRqstClimExclIncl(CamgenRqstClimExclIncl camgenRqstClimExclIncl) {
		getCamgenRqstClimExclIncls().add(camgenRqstClimExclIncl);
		camgenRqstClimExclIncl.setCamgenRequest(this);

		return camgenRqstClimExclIncl;
	}

	public CamgenRqstClimExclIncl removeCamgenRqstClimExclIncl(CamgenRqstClimExclIncl camgenRqstClimExclIncl) {
		getCamgenRqstClimExclIncls().remove(camgenRqstClimExclIncl);
		camgenRqstClimExclIncl.setCamgenRequest(null);

		return camgenRqstClimExclIncl;
	}

	public List<CamgenRqstDemandSupply> getCamgenRqstDemandSupplies() {
		return this.camgenRqstDemandSupplies;
	}

	public void setCamgenRqstDemandSupplies(List<CamgenRqstDemandSupply> camgenRqstDemandSupplies) {
		this.camgenRqstDemandSupplies = camgenRqstDemandSupplies;
	}

	public CamgenRqstDemandSupply addCamgenRqstDemandSupply(CamgenRqstDemandSupply camgenRqstDemandSupply) {
		getCamgenRqstDemandSupplies().add(camgenRqstDemandSupply);
		camgenRqstDemandSupply.setCamgenRequest(this);

		return camgenRqstDemandSupply;
	}

	public CamgenRqstDemandSupply removeCamgenRqstDemandSupply(CamgenRqstDemandSupply camgenRqstDemandSupply) {
		getCamgenRqstDemandSupplies().remove(camgenRqstDemandSupply);
		camgenRqstDemandSupply.setCamgenRequest(null);

		return camgenRqstDemandSupply;
	}

	public List<CamgenRun> getCamgenRuns() {
		return this.camgenRuns;
	}

	public void setCamgenRuns(List<CamgenRun> camgenRuns) {
		this.camgenRuns = camgenRuns;
	}

	public CamgenRun addCamgenRun(CamgenRun camgenRun) {
		getCamgenRuns().add(camgenRun);
		camgenRun.setCamgenRequest(this);

		return camgenRun;
	}

	public CamgenRun removeCamgenRun(CamgenRun camgenRun) {
		getCamgenRuns().remove(camgenRun);
		camgenRun.setCamgenRequest(null);

		return camgenRun;
	}
}