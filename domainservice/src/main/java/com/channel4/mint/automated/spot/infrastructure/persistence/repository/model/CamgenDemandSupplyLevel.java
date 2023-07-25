package com.channel4.mint.automated.spot.infrastructure.persistence.repository.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the CAMGEN_DEMAND_SUPPLY_LEVEL database table.
 * 
 */
@Entity
@Table(name = "CAMGEN_DEMAND_SUPPLY_LEVEL")
@NamedQuery(name = "CamgenDemandSupplyLevel.findAll", query = "SELECT c FROM CamgenDemandSupplyLevel c")
public class CamgenDemandSupplyLevel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "DEMAND_SUPPLY_LEVEL_ID")
	private long demandSupplyLevelId;

	@Column(name = "DEMAND_SUPPLY_LEVEL_CODE")
	private String demandSupplyLevelCode;

	@Column(name = "DEMAND_SUPPLY_LEVEL_NAME")
	private String demandSupplyLevelName;

	// bi-directional many-to-one association to CamgenDemandSupplyObject
	@OneToMany(mappedBy = "camgenDemandSupplyLevel")
	private List<CamgenDemandSupplyObject> camgenDemandSupplyObjects;

	// bi-directional many-to-one association to CamgenPlanDemandSupply
	@OneToMany(mappedBy = "camgenDemandSupplyLevel")
	private List<CamgenPlanDemandSupply> camgenPlanDemandSupplies;

	// bi-directional many-to-one association to CamgenRqstDemandSupply
	@OneToMany(mappedBy = "camgenDemandSupplyLevel")
	private List<CamgenRqstDemandSupply> camgenRqstDemandSupplies;

	public CamgenDemandSupplyLevel() {
	}

	public long getDemandSupplyLevelId() {
		return this.demandSupplyLevelId;
	}

	public void setDemandSupplyLevelId(long demandSupplyLevelId) {
		this.demandSupplyLevelId = demandSupplyLevelId;
	}

	public String getDemandSupplyLevelCode() {
		return this.demandSupplyLevelCode;
	}

	public void setDemandSupplyLevelCode(String demandSupplyLevelCode) {
		this.demandSupplyLevelCode = demandSupplyLevelCode;
	}

	public String getDemandSupplyLevelName() {
		return this.demandSupplyLevelName;
	}

	public void setDemandSupplyLevelName(String demandSupplyLevelName) {
		this.demandSupplyLevelName = demandSupplyLevelName;
	}

	public List<CamgenDemandSupplyObject> getCamgenDemandSupplyObjects() {
		return this.camgenDemandSupplyObjects;
	}

	public void setCamgenDemandSupplyObjects(List<CamgenDemandSupplyObject> camgenDemandSupplyObjects) {
		this.camgenDemandSupplyObjects = camgenDemandSupplyObjects;
	}

	public CamgenDemandSupplyObject addCamgenDemandSupplyObject(CamgenDemandSupplyObject camgenDemandSupplyObject) {
		getCamgenDemandSupplyObjects().add(camgenDemandSupplyObject);
		camgenDemandSupplyObject.setCamgenDemandSupplyLevel(this);

		return camgenDemandSupplyObject;
	}

	public CamgenDemandSupplyObject removeCamgenDemandSupplyObject(CamgenDemandSupplyObject camgenDemandSupplyObject) {
		getCamgenDemandSupplyObjects().remove(camgenDemandSupplyObject);
		camgenDemandSupplyObject.setCamgenDemandSupplyLevel(null);

		return camgenDemandSupplyObject;
	}

	public List<CamgenPlanDemandSupply> getCamgenPlanDemandSupplies() {
		return this.camgenPlanDemandSupplies;
	}

	public void setCamgenPlanDemandSupplies(List<CamgenPlanDemandSupply> camgenPlanDemandSupplies) {
		this.camgenPlanDemandSupplies = camgenPlanDemandSupplies;
	}

	public CamgenPlanDemandSupply addCamgenPlanDemandSupply(CamgenPlanDemandSupply camgenPlanDemandSupply) {
		getCamgenPlanDemandSupplies().add(camgenPlanDemandSupply);
		camgenPlanDemandSupply.setCamgenDemandSupplyLevel(this);

		return camgenPlanDemandSupply;
	}

	public CamgenPlanDemandSupply removeCamgenPlanDemandSupply(CamgenPlanDemandSupply camgenPlanDemandSupply) {
		getCamgenPlanDemandSupplies().remove(camgenPlanDemandSupply);
		camgenPlanDemandSupply.setCamgenDemandSupplyLevel(null);

		return camgenPlanDemandSupply;
	}

	public List<CamgenRqstDemandSupply> getCamgenRqstDemandSupplies() {
		return this.camgenRqstDemandSupplies;
	}

	public void setCamgenRqstDemandSupplies(List<CamgenRqstDemandSupply> camgenRqstDemandSupplies) {
		this.camgenRqstDemandSupplies = camgenRqstDemandSupplies;
	}

	public CamgenRqstDemandSupply addCamgenRqstDemandSupply(CamgenRqstDemandSupply camgenRqstDemandSupply) {
		getCamgenRqstDemandSupplies().add(camgenRqstDemandSupply);
		camgenRqstDemandSupply.setCamgenDemandSupplyLevel(this);

		return camgenRqstDemandSupply;
	}

	public CamgenRqstDemandSupply removeCamgenRqstDemandSupply(CamgenRqstDemandSupply camgenRqstDemandSupply) {
		getCamgenRqstDemandSupplies().remove(camgenRqstDemandSupply);
		camgenRqstDemandSupply.setCamgenDemandSupplyLevel(null);

		return camgenRqstDemandSupply;
	}

}