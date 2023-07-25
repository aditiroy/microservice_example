package com.channel4.mint.automated.spot.infrastructure.persistence.repository.model;

import java.io.Serializable;
import java.util.List;

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

/**
 * The persistent class for the CAMGEN_DEMAND_SUPPLY_ATTRIBUTE database table.
 * 
 */
@Entity
@Table(name = "CAMGEN_DEMAND_SUPPLY_ATTRIBUTE")
@NamedQuery(name = "CamgenDemandSupplyAttribute.findAll", query = "SELECT c FROM CamgenDemandSupplyAttribute c")
public class CamgenDemandSupplyAttribute implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "DEMAND_SUPPLY_ATTRIBUTE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long demandSupplyAttributeId;

	@Column(name = "DEMAND_SUPPLY_ATTRIBUTE_CODE")
	private String demandSupplyAttributeCode;

	@Column(name = "DEMAND_SUPPLY_ATTRIBUTE_NAME")
	private String demandSupplyAttributeName;

	// bi-directional many-to-one association to CamgenDemandSupplyObject
	@ManyToOne
	@JoinColumn(name = "DEMAND_SUPPLY_OBJECT_ID")
	private CamgenDemandSupplyObject camgenDemandSupplyObject;

	// bi-directional many-to-one association to CamgenDemandSupplyAttrCond
	@OneToMany(mappedBy = "camgenDemandSupplyAttribute")
	private List<CamgenDemandSupplyAttrCond> camgenDemandSupplyAttrConds;

	// bi-directional many-to-one association to PlanDemandSupplyCriteria
	@OneToMany(mappedBy = "camgenDemandSupplyAttribute")
	private List<PlanDemandSupplyCriteria> planDemandSupplyCriterias;

	// bi-directional many-to-one association to RqstDemandSupplyCriteria
	@OneToMany(mappedBy = "camgenDemandSupplyAttribute")
	private List<RqstDemandSupplyCriteria> rqstDemandSupplyCriterias;

	public CamgenDemandSupplyAttribute() {
	}

	public long getDemandSupplyAttributeId() {
		return this.demandSupplyAttributeId;
	}

	public void setDemandSupplyAttributeId(long demandSupplyAttributeId) {
		this.demandSupplyAttributeId = demandSupplyAttributeId;
	}

	public String getDemandSupplyAttributeCode() {
		return this.demandSupplyAttributeCode;
	}

	public void setDemandSupplyAttributeCode(String demandSupplyAttributeCode) {
		this.demandSupplyAttributeCode = demandSupplyAttributeCode;
	}

	public String getDemandSupplyAttributeName() {
		return this.demandSupplyAttributeName;
	}

	public void setDemandSupplyAttributeName(String demandSupplyAttributeName) {
		this.demandSupplyAttributeName = demandSupplyAttributeName;
	}

	public CamgenDemandSupplyObject getCamgenDemandSupplyObject() {
		return this.camgenDemandSupplyObject;
	}

	public void setCamgenDemandSupplyObject(CamgenDemandSupplyObject camgenDemandSupplyObject) {
		this.camgenDemandSupplyObject = camgenDemandSupplyObject;
	}

	public List<CamgenDemandSupplyAttrCond> getCamgenDemandSupplyAttrConds() {
		return this.camgenDemandSupplyAttrConds;
	}

	public void setCamgenDemandSupplyAttrConds(List<CamgenDemandSupplyAttrCond> camgenDemandSupplyAttrConds) {
		this.camgenDemandSupplyAttrConds = camgenDemandSupplyAttrConds;
	}

	public CamgenDemandSupplyAttrCond addCamgenDemandSupplyAttrCond(
			CamgenDemandSupplyAttrCond camgenDemandSupplyAttrCond) {
		getCamgenDemandSupplyAttrConds().add(camgenDemandSupplyAttrCond);
		camgenDemandSupplyAttrCond.setCamgenDemandSupplyAttribute(this);

		return camgenDemandSupplyAttrCond;
	}

	public CamgenDemandSupplyAttrCond removeCamgenDemandSupplyAttrCond(
			CamgenDemandSupplyAttrCond camgenDemandSupplyAttrCond) {
		getCamgenDemandSupplyAttrConds().remove(camgenDemandSupplyAttrCond);
		camgenDemandSupplyAttrCond.setCamgenDemandSupplyAttribute(null);

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
		planDemandSupplyCriteria.setCamgenDemandSupplyAttribute(this);

		return planDemandSupplyCriteria;
	}

	public PlanDemandSupplyCriteria removePlanDemandSupplyCriteria(PlanDemandSupplyCriteria planDemandSupplyCriteria) {
		getPlanDemandSupplyCriterias().remove(planDemandSupplyCriteria);
		planDemandSupplyCriteria.setCamgenDemandSupplyAttribute(null);

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
		rqstDemandSupplyCriteria.setCamgenDemandSupplyAttribute(this);

		return rqstDemandSupplyCriteria;
	}

	public RqstDemandSupplyCriteria removeRqstDemandSupplyCriteria(RqstDemandSupplyCriteria rqstDemandSupplyCriteria) {
		getRqstDemandSupplyCriterias().remove(rqstDemandSupplyCriteria);
		rqstDemandSupplyCriteria.setCamgenDemandSupplyAttribute(null);

		return rqstDemandSupplyCriteria;
	}

}