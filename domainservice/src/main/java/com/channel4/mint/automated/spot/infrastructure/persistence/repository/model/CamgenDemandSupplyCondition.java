package com.channel4.mint.automated.spot.infrastructure.persistence.repository.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the CAMGEN_DEMAND_SUPPLY_CONDITION database table.
 * 
 */
@Entity
@Table(name="CAMGEN_DEMAND_SUPPLY_CONDITION")
@NamedQuery(name="CamgenDemandSupplyCondition.findAll", query="SELECT c FROM CamgenDemandSupplyCondition c")
public class CamgenDemandSupplyCondition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DEMAND_SUPPLY_CONDITION_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long demandSupplyConditionId;

	@Column(name="DEMAND_SUPPLY_CONDITION_CODE")
	private String demandSupplyConditionCode;

	@Column(name="DEMAND_SUPPLY_CONDITION_DESC")
	private String demandSupplyConditionDesc;

	//bi-directional many-to-one association to CamgenDemandSupplyAttrCond
	@OneToMany(mappedBy="camgenDemandSupplyCondition")
	private List<CamgenDemandSupplyAttrCond> camgenDemandSupplyAttrConds;

	//bi-directional many-to-one association to PlanDemandSupplyCriteria
	@OneToMany(mappedBy="camgenDemandSupplyCondition")
	private List<PlanDemandSupplyCriteria> planDemandSupplyCriterias;

	//bi-directional many-to-one association to RqstDemandSupplyCriteria
	@OneToMany(mappedBy="camgenDemandSupplyCondition")
	private List<RqstDemandSupplyCriteria> rqstDemandSupplyCriterias;

	public CamgenDemandSupplyCondition() {
	}

	public long getDemandSupplyConditionId() {
		return this.demandSupplyConditionId;
	}

	public void setDemandSupplyConditionId(long demandSupplyConditionId) {
		this.demandSupplyConditionId = demandSupplyConditionId;
	}

	public String getDemandSupplyConditionCode() {
		return this.demandSupplyConditionCode;
	}

	public void setDemandSupplyConditionCode(String demandSupplyConditionCode) {
		this.demandSupplyConditionCode = demandSupplyConditionCode;
	}

	public String getDemandSupplyConditionDesc() {
		return this.demandSupplyConditionDesc;
	}

	public void setDemandSupplyConditionDesc(String demandSupplyConditionDesc) {
		this.demandSupplyConditionDesc = demandSupplyConditionDesc;
	}

	public List<CamgenDemandSupplyAttrCond> getCamgenDemandSupplyAttrConds() {
		return this.camgenDemandSupplyAttrConds;
	}

	public void setCamgenDemandSupplyAttrConds(List<CamgenDemandSupplyAttrCond> camgenDemandSupplyAttrConds) {
		this.camgenDemandSupplyAttrConds = camgenDemandSupplyAttrConds;
	}

	public CamgenDemandSupplyAttrCond addCamgenDemandSupplyAttrCond(CamgenDemandSupplyAttrCond camgenDemandSupplyAttrCond) {
		getCamgenDemandSupplyAttrConds().add(camgenDemandSupplyAttrCond);
		camgenDemandSupplyAttrCond.setCamgenDemandSupplyCondition(this);

		return camgenDemandSupplyAttrCond;
	}

	public CamgenDemandSupplyAttrCond removeCamgenDemandSupplyAttrCond(CamgenDemandSupplyAttrCond camgenDemandSupplyAttrCond) {
		getCamgenDemandSupplyAttrConds().remove(camgenDemandSupplyAttrCond);
		camgenDemandSupplyAttrCond.setCamgenDemandSupplyCondition(null);

		return camgenDemandSupplyAttrCond;
	}

	public List<PlanDemandSupplyCriteria> getPlanDemandSupplyCriterias() {
		return this.planDemandSupplyCriterias;
	}

	public void setPlanDemandSupplyCriterias(List<PlanDemandSupplyCriteria> planDemandSupplyCriterias) {
		this.planDemandSupplyCriterias = planDemandSupplyCriterias;
	}

	public PlanDemandSupplyCriteria addPlanDemandSupplyCriteria(PlanDemandSupplyCriteria planDemandSupplyCriteria) {
		getPlanDemandSupplyCriterias().add(planDemandSupplyCriteria);
		planDemandSupplyCriteria.setCamgenDemandSupplyCondition(this);

		return planDemandSupplyCriteria;
	}

	public PlanDemandSupplyCriteria removePlanDemandSupplyCriteria(PlanDemandSupplyCriteria planDemandSupplyCriteria) {
		getPlanDemandSupplyCriterias().remove(planDemandSupplyCriteria);
		planDemandSupplyCriteria.setCamgenDemandSupplyCondition(null);

		return planDemandSupplyCriteria;
	}

	public List<RqstDemandSupplyCriteria> getRqstDemandSupplyCriterias() {
		return this.rqstDemandSupplyCriterias;
	}

	public void setRqstDemandSupplyCriterias(List<RqstDemandSupplyCriteria> rqstDemandSupplyCriterias) {
		this.rqstDemandSupplyCriterias = rqstDemandSupplyCriterias;
	}

	public RqstDemandSupplyCriteria addRqstDemandSupplyCriteria(RqstDemandSupplyCriteria rqstDemandSupplyCriteria) {
		getRqstDemandSupplyCriterias().add(rqstDemandSupplyCriteria);
		rqstDemandSupplyCriteria.setCamgenDemandSupplyCondition(this);

		return rqstDemandSupplyCriteria;
	}

	public RqstDemandSupplyCriteria removeRqstDemandSupplyCriteria(RqstDemandSupplyCriteria rqstDemandSupplyCriteria) {
		getRqstDemandSupplyCriterias().remove(rqstDemandSupplyCriteria);
		rqstDemandSupplyCriteria.setCamgenDemandSupplyCondition(null);

		return rqstDemandSupplyCriteria;
	}

}