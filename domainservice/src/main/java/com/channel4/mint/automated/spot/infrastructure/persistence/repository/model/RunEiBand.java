/*
 * 
 */
package com.channel4.mint.automated.spot.infrastructure.persistence.repository.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

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
 * The persistent class for the RUN_EI_BAND database table.
 * 
 */
@Entity
@Table(name="RUN_EI_BAND")
@NamedQuery(name="RunEiBand.findAll", query="SELECT r FROM RunEiBand r")
public class RunEiBand implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The ei band id. */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EI_BAND_ID")
	private long eiBandId;

	/** The created by. */
	@Column(name="CREATED_BY")
	private String createdBy;

	/** The created on. */
	@Column(name="CREATED_ON")
	private Timestamp createdOn;

	/** The ei band. */
	@Column(name="EI_BAND")
	private BigDecimal eiBand;

	/** The modified by. */
	@Column(name="MODIFIED_BY")
	private String modifiedBy;

	/** The modified on. */
	@Column(name="MODIFIED_ON")
	private Timestamp modifiedOn;

	/** The camgen run. */
	//bi-directional many-to-one association to CamgenRun
	@ManyToOne
	@JoinColumn(name="RUN_ID")
	private CamgenRun camgenRun;

	/**
	 * Instantiates a new run ei band.
	 */
	public RunEiBand() {
	}

	/**
	 * Gets the ei band id.
	 *
	 * @return the ei band id
	 */
	public long getEiBandId() {
		return this.eiBandId;
	}

	/**
	 * Sets the ei band id.
	 *
	 * @param eiBandId the new ei band id
	 */
	public void setEiBandId(long eiBandId) {
		this.eiBandId = eiBandId;
	}

	/**
	 * Gets the created by.
	 *
	 * @return the created by
	 */
	public String getCreatedBy() {
		return this.createdBy;
	}

	/**
	 * Sets the created by.
	 *
	 * @param createdBy the new created by
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * Gets the created on.
	 *
	 * @return the created on
	 */
	public Timestamp getCreatedOn() {
		return this.createdOn;
	}

	/**
	 * Sets the created on.
	 *
	 * @param createdOn the new created on
	 */
	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * Gets the ei band.
	 *
	 * @return the ei band
	 */
	public BigDecimal getEiBand() {
		return this.eiBand;
	}

	/**
	 * Sets the ei band.
	 *
	 * @param eiBand the new ei band
	 */
	public void setEiBand(BigDecimal eiBand) {
		this.eiBand = eiBand;
	}

	/**
	 * Gets the modified by.
	 *
	 * @return the modified by
	 */
	public String getModifiedBy() {
		return this.modifiedBy;
	}

	/**
	 * Sets the modified by.
	 *
	 * @param modifiedBy the new modified by
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	/**
	 * Gets the modified on.
	 *
	 * @return the modified on
	 */
	public Timestamp getModifiedOn() {
		return this.modifiedOn;
	}

	/**
	 * Sets the modified on.
	 *
	 * @param modifiedOn the new modified on
	 */
	public void setModifiedOn(Timestamp modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	/**
	 * Gets the camgen run.
	 *
	 * @return the camgen run
	 */
	public CamgenRun getCamgenRun() {
		return this.camgenRun;
	}

	/**
	 * Sets the camgen run.
	 *
	 * @param camgenRun the new camgen run
	 */
	public void setCamgenRun(CamgenRun camgenRun) {
		this.camgenRun = camgenRun;
	}

}