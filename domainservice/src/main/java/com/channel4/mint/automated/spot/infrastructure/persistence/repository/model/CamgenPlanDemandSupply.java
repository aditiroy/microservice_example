/*
 * 
 */
package com.channel4.mint.automated.spot.infrastructure.persistence.repository.model;

import java.io.Serializable;
import java.math.BigDecimal;
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

// TODO: Auto-generated Javadoc
/**
 * The persistent class for the CAMGEN_PLAN_DEMAND_SUPPLY database table.
 * 
 */
@Entity
@Table(name = "CAMGEN_PLAN_DEMAND_SUPPLY")
@NamedQuery(name = "CamgenPlanDemandSupply.findAll", query = "SELECT c FROM CamgenPlanDemandSupply c")
public class CamgenPlanDemandSupply implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DEMAND_SUPPLY_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long demandSupplyId;

	@Column(name="AMENDMENT_PERCENTAGE")
	private BigDecimal amendmentPercentage;

	private String name;

	//bi-directional many-to-one association to CamgenDemandSupplyLevel
	@ManyToOne
	@JoinColumn(name="DEMAND_SUPPLY_LEVEL_ID")
	private CamgenDemandSupplyLevel camgenDemandSupplyLevel;

	//bi-directional many-to-one association to CamgenPlan
	@ManyToOne
	@JoinColumn(name="PLAN_ID")
	private CamgenPlan camgenPlan;

	//bi-directional many-to-one association to PlanDemandSupplyCriteria
	@OneToMany(mappedBy="camgenPlanDemandSupply", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PlanDemandSupplyCriteria> planDemandSupplyCriterias;

	public CamgenPlanDemandSupply() {
	}

	public long getDemandSupplyId() {
		return this.demandSupplyId;
	}

	public void setDemandSupplyId(long demandSupplyId) {
		this.demandSupplyId = demandSupplyId;
	}

	public BigDecimal getAmendmentPercentage() {
		return this.amendmentPercentage;
	}

	public void setAmendmentPercentage(BigDecimal amendmentPercentage) {
		this.amendmentPercentage = amendmentPercentage;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CamgenDemandSupplyLevel getCamgenDemandSupplyLevel() {
		return this.camgenDemandSupplyLevel;
	}

	public void setCamgenDemandSupplyLevel(CamgenDemandSupplyLevel camgenDemandSupplyLevel) {
		this.camgenDemandSupplyLevel = camgenDemandSupplyLevel;
	}

	public CamgenPlan getCamgenPlan() {
		return this.camgenPlan;
	}

	public void setCamgenPlan(CamgenPlan camgenPlan) {
		this.camgenPlan = camgenPlan;
	}

	public List<PlanDemandSupplyCriteria> getPlanDemandSupplyCriterias() {
		return this.planDemandSupplyCriterias;
	}

	public void setPlanDemandSupplyCriterias(List<PlanDemandSupplyCriteria> planDemandSupplyCriterias) {
		this.planDemandSupplyCriterias = planDemandSupplyCriterias;
	}

	public PlanDemandSupplyCriteria addPlanDemandSupplyCriteria(PlanDemandSupplyCriteria planDemandSupplyCriteria) {
		getPlanDemandSupplyCriterias().add(planDemandSupplyCriteria);
		planDemandSupplyCriteria.setCamgenPlanDemandSupply(this);

		return planDemandSupplyCriteria;
	}

	public PlanDemandSupplyCriteria removePlanDemandSupplyCriteria(PlanDemandSupplyCriteria planDemandSupplyCriteria) {
		getPlanDemandSupplyCriterias().remove(planDemandSupplyCriteria);
		planDemandSupplyCriteria.setCamgenPlanDemandSupply(null);

		return planDemandSupplyCriteria;
	}

}