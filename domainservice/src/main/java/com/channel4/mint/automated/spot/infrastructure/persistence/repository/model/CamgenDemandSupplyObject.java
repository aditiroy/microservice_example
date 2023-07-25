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
 * The persistent class for the CAMGEN_DEMAND_SUPPLY_OBJECT database table.
 * 
 */
@Entity
@Table(name="CAMGEN_DEMAND_SUPPLY_OBJECT")
@NamedQuery(name="CamgenDemandSupplyObject.findAll", query="SELECT c FROM CamgenDemandSupplyObject c")
public class CamgenDemandSupplyObject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DEMAND_SUPPLY_OBJECT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long demandSupplyObjectId;

	@Column(name="DEMAND_SUPPLY_OBJECT_CODE")
	private String demandSupplyObjectCode;

	@Column(name="DEMAND_SUPPLY_OBJECT_NAME")
	private String demandSupplyObjectName;

	//bi-directional many-to-one association to CamgenDemandSupplyAttribute
	@OneToMany(mappedBy="camgenDemandSupplyObject")
	private List<CamgenDemandSupplyAttribute> camgenDemandSupplyAttributes;

	//bi-directional many-to-one association to CamgenDemandSupplyLevel
	@ManyToOne
	@JoinColumn(name="DEMAND_SUPPLY_LEVEL_ID")
	private CamgenDemandSupplyLevel camgenDemandSupplyLevel;

	//bi-directional many-to-one association to PlanDemandSupplyCriteria
	@OneToMany(mappedBy="camgenDemandSupplyObject")
	private List<PlanDemandSupplyCriteria> planDemandSupplyCriterias;

	//bi-directional many-to-one association to RqstDemandSupplyCriteria
	@OneToMany(mappedBy="camgenDemandSupplyObject")
	private List<RqstDemandSupplyCriteria> rqstDemandSupplyCriterias;

	public CamgenDemandSupplyObject() {
	}

	public long getDemandSupplyObjectId() {
		return this.demandSupplyObjectId;
	}

	public void setDemandSupplyObjectId(long demandSupplyObjectId) {
		this.demandSupplyObjectId = demandSupplyObjectId;
	}

	public String getDemandSupplyObjectCode() {
		return this.demandSupplyObjectCode;
	}

	public void setDemandSupplyObjectCode(String demandSupplyObjectCode) {
		this.demandSupplyObjectCode = demandSupplyObjectCode;
	}

	public String getDemandSupplyObjectName() {
		return this.demandSupplyObjectName;
	}

	public void setDemandSupplyObjectName(String demandSupplyObjectName) {
		this.demandSupplyObjectName = demandSupplyObjectName;
	}

	public List<CamgenDemandSupplyAttribute> getCamgenDemandSupplyAttributes() {
		return this.camgenDemandSupplyAttributes;
	}

	public void setCamgenDemandSupplyAttributes(List<CamgenDemandSupplyAttribute> camgenDemandSupplyAttributes) {
		this.camgenDemandSupplyAttributes = camgenDemandSupplyAttributes;
	}

	public CamgenDemandSupplyAttribute addCamgenDemandSupplyAttribute(CamgenDemandSupplyAttribute camgenDemandSupplyAttribute) {
		getCamgenDemandSupplyAttributes().add(camgenDemandSupplyAttribute);
		camgenDemandSupplyAttribute.setCamgenDemandSupplyObject(this);

		return camgenDemandSupplyAttribute;
	}

	public CamgenDemandSupplyAttribute removeCamgenDemandSupplyAttribute(CamgenDemandSupplyAttribute camgenDemandSupplyAttribute) {
		getCamgenDemandSupplyAttributes().remove(camgenDemandSupplyAttribute);
		camgenDemandSupplyAttribute.setCamgenDemandSupplyObject(null);

		return camgenDemandSupplyAttribute;
	}

	public CamgenDemandSupplyLevel getCamgenDemandSupplyLevel() {
		return this.camgenDemandSupplyLevel;
	}

	public void setCamgenDemandSupplyLevel(CamgenDemandSupplyLevel camgenDemandSupplyLevel) {
		this.camgenDemandSupplyLevel = camgenDemandSupplyLevel;
	}

	public List<PlanDemandSupplyCriteria> getPlanDemandSupplyCriterias() {
		return this.planDemandSupplyCriterias;
	}

	public void setPlanDemandSupplyCriterias(List<PlanDemandSupplyCriteria> planDemandSupplyCriterias) {
		this.planDemandSupplyCriterias = planDemandSupplyCriterias;
	}

	public PlanDemandSupplyCriteria addPlanDemandSupplyCriteria(PlanDemandSupplyCriteria planDemandSupplyCriteria) {
		getPlanDemandSupplyCriterias().add(planDemandSupplyCriteria);
		planDemandSupplyCriteria.setCamgenDemandSupplyObject(this);

		return planDemandSupplyCriteria;
	}

	public PlanDemandSupplyCriteria removePlanDemandSupplyCriteria(PlanDemandSupplyCriteria planDemandSupplyCriteria) {
		getPlanDemandSupplyCriterias().remove(planDemandSupplyCriteria);
		planDemandSupplyCriteria.setCamgenDemandSupplyObject(null);

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
		rqstDemandSupplyCriteria.setCamgenDemandSupplyObject(this);

		return rqstDemandSupplyCriteria;
	}

	public RqstDemandSupplyCriteria removeRqstDemandSupplyCriteria(RqstDemandSupplyCriteria rqstDemandSupplyCriteria) {
		getRqstDemandSupplyCriterias().remove(rqstDemandSupplyCriteria);
		rqstDemandSupplyCriteria.setCamgenDemandSupplyObject(null);

		return rqstDemandSupplyCriteria;
	}

}