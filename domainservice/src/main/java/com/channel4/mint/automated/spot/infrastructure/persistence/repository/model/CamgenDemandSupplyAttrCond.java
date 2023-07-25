package com.channel4.mint.automated.spot.infrastructure.persistence.repository.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the CAMGEN_DEMAND_SUPPLY_ATTR_COND database table.
 * 
 */
@Entity
@Table(name="CAMGEN_DEMAND_SUPPLY_ATTR_COND")
@NamedQuery(name="CamgenDemandSupplyAttrCond.findAll", query="SELECT c FROM CamgenDemandSupplyAttrCond c")
public class CamgenDemandSupplyAttrCond implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DEMAND_SUPPLY_ATTR_COND_ID")
	private long demandSupplyAttrCondId;

	//bi-directional many-to-one association to CamgenDemandSupplyAttribute
	@ManyToOne
	@JoinColumn(name="DEMAND_SUPPLY_ATTRIBUTE_ID")
	private CamgenDemandSupplyAttribute camgenDemandSupplyAttribute;

	//bi-directional many-to-one association to CamgenDemandSupplyCondition
	@ManyToOne
	@JoinColumn(name="DEMAND_SUPPLY_CONDITION_ID")
	private CamgenDemandSupplyCondition camgenDemandSupplyCondition;

	public CamgenDemandSupplyAttrCond() {
	}

	public long getDemandSupplyAttrCondId() {
		return this.demandSupplyAttrCondId;
	}

	public void setDemandSupplyAttrCondId(long demandSupplyAttrCondId) {
		this.demandSupplyAttrCondId = demandSupplyAttrCondId;
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

}