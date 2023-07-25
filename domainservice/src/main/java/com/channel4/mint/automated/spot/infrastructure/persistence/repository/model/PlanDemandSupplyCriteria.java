/*
 * 
 */
package com.channel4.mint.automated.spot.infrastructure.persistence.repository.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The persistent class for the PLAN_DEMAND_SUPPLY_CRITERIA database table.
 * 
 */
@Entity
@Table(name = "PLAN_DEMAND_SUPPLY_CRITERIA")
@NamedQuery(name = "PlanDemandSupplyCriteria.findAll", query = "SELECT p FROM PlanDemandSupplyCriteria p")
public class PlanDemandSupplyCriteria implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "PLAN_DEMAND_SUPPLY_CRITERIA_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long planDemandSupplyCriteriaId;

	private String operator;

	@Column(name = "VALUE")
	private String value;

	// bi-directional many-to-one association to CamgenDemandSupplyAttribute
	@ManyToOne
	@JoinColumn(name = "DEMAND_SUPPLY_ATTRIBUTE_ID")
	private CamgenDemandSupplyAttribute camgenDemandSupplyAttribute;

	// bi-directional many-to-one association to CamgenDemandSupplyCondition
	@ManyToOne
	@JoinColumn(name = "DEMAND_SUPPLY_CONDITION_ID")
	private CamgenDemandSupplyCondition camgenDemandSupplyCondition;

	// bi-directional many-to-one association to CamgenDemandSupplyObject
	@ManyToOne
	@JoinColumn(name = "DEMAND_SUPPLY_OBJECT_ID")
	private CamgenDemandSupplyObject camgenDemandSupplyObject;

	// bi-directional many-to-one association to CamgenPlanDemandSupply
	@ManyToOne
	@JoinColumn(name = "DEMAND_SUPPLY_ID")
	private CamgenPlanDemandSupply camgenPlanDemandSupply;

	public PlanDemandSupplyCriteria() {
	}

	public long getPlanDemandSupplyCriteriaId() {
		return this.planDemandSupplyCriteriaId;
	}

	public void setPlanDemandSupplyCriteriaId(long planDemandSupplyCriteriaId) {
		this.planDemandSupplyCriteriaId = planDemandSupplyCriteriaId;
	}

	public String getOperator() {
		return this.operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public CamgenDemandSupplyAttribute getCamgenDemandSupplyAttribute() {
		return this.camgenDemandSupplyAttribute;
	}

	public void setCamgenDemandSupplyAttribute(CamgenDemandSupplyAttribute camgenDemandSupplyAttribute) {
		this.camgenDemandSupplyAttribute = camgenDemandSupplyAttribute;
	}

	public CamgenDemandSupplyCondition getCamgenDemandSupplyCondition() {
		return this.camgenDemandSupplyCondition;
	}

	public void setCamgenDemandSupplyCondition(CamgenDemandSupplyCondition camgenDemandSupplyCondition) {
		this.camgenDemandSupplyCondition = camgenDemandSupplyCondition;
	}

	public CamgenDemandSupplyObject getCamgenDemandSupplyObject() {
		return this.camgenDemandSupplyObject;
	}

	public void setCamgenDemandSupplyObject(CamgenDemandSupplyObject camgenDemandSupplyObject) {
		this.camgenDemandSupplyObject = camgenDemandSupplyObject;
	}

	public CamgenPlanDemandSupply getCamgenPlanDemandSupply() {
		return this.camgenPlanDemandSupply;
	}

	public void setCamgenPlanDemandSupply(CamgenPlanDemandSupply camgenPlanDemandSupply) {
		this.camgenPlanDemandSupply = camgenPlanDemandSupply;
	}

}