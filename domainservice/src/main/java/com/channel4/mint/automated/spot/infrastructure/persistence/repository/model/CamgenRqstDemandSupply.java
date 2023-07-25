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
 * The persistent class for the CAMGEN_RQST_DEMAND_SUPPLY database table.
 * 
 */
@Entity
@Table(name = "CAMGEN_RQST_DEMAND_SUPPLY")
@NamedQuery(name = "CamgenRqstDemandSupply.findAll", query = "SELECT c FROM CamgenRqstDemandSupply c")
public class CamgenRqstDemandSupply implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "DEMAND_SUPPLY_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long demandSupplyId;

	@Column(name = "AMENDMENT_PERCENTAGE")
	private BigDecimal amendmentPercentage;

	private String name;

	// bi-directional many-to-one association to CamgenDemandSupplyLevel
	@ManyToOne
	@JoinColumn(name = "DEMAND_SUPPLY_LEVEL_ID")
	private CamgenDemandSupplyLevel camgenDemandSupplyLevel;

	// bi-directional many-to-one association to CamgenRequest
	@ManyToOne
	@JoinColumn(name = "REQUEST_ID")
	private CamgenRequest camgenRequest;

	// bi-directional many-to-one association to RqstDemandSupplyCriteria
	@OneToMany(mappedBy = "camgenRqstDemandSupply", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<RqstDemandSupplyCriteria> rqstDemandSupplyCriterias;

	public CamgenRqstDemandSupply() {
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

	public CamgenRequest getCamgenRequest() {
		return this.camgenRequest;
	}

	public void setCamgenRequest(CamgenRequest camgenRequest) {
		this.camgenRequest = camgenRequest;
	}

	public List<RqstDemandSupplyCriteria> getRqstDemandSupplyCriterias() {
		return this.rqstDemandSupplyCriterias;
	}

	public void setRqstDemandSupplyCriterias(List<RqstDemandSupplyCriteria> rqstDemandSupplyCriterias) {
		this.rqstDemandSupplyCriterias = rqstDemandSupplyCriterias;
	}

	public RqstDemandSupplyCriteria addRqstDemandSupplyCriteria(RqstDemandSupplyCriteria rqstDemandSupplyCriteria) {
		getRqstDemandSupplyCriterias().add(rqstDemandSupplyCriteria);
		rqstDemandSupplyCriteria.setCamgenRqstDemandSupply(this);

		return rqstDemandSupplyCriteria;
	}

	public RqstDemandSupplyCriteria removeRqstDemandSupplyCriteria(RqstDemandSupplyCriteria rqstDemandSupplyCriteria) {
		getRqstDemandSupplyCriterias().remove(rqstDemandSupplyCriteria);
		rqstDemandSupplyCriteria.setCamgenRqstDemandSupply(null);

		return rqstDemandSupplyCriteria;
	}

}