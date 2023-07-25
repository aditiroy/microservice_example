/*
 * 
 */
package com.channel4.mint.automated.spot.infrastructure.persistence.repository.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


// TODO: Auto-generated Javadoc
/**
 * The persistent class for the CAMGEN_RUN_ITERATION database table.
 * 
 */
@Entity
@Table(name="CAMGEN_RUN_ITERATION")
@NamedQuery(name="CamgenRunIteration.findAll", query="SELECT c FROM CamgenRunIteration c")
public class CamgenRunIteration implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The iteration id. */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ITERATION_ID")
	private long iterationId;

	/** The created by. */
	@Column(name="CREATED_BY")
	private String createdBy;

	/** The created on. */
	@Column(name="CREATED_ON")
	private Timestamp createdOn;

	/** The end date time. */
	@Temporal(TemporalType.DATE)
	@Column(name="END_DATE_TIME")
	private Date endDateTime;

	/** The iteration number. */
	@Column(name="ITERATION_NUMBER")
	private BigDecimal iterationNumber;

	/** The iteration solution file name. */
	@Column(name="ITERATION_SOLUTION_FILE_NAME")
	private String iterationSolutionFileName;

	/** The start date time. */
	@Temporal(TemporalType.DATE)
	@Column(name="START_DATE_TIME")
	private Date startDateTime;

	/** The status. */
	private String status;

	/** The camgen run. */
	//bi-directional many-to-one association to CamgenRun
	@ManyToOne
	@JoinColumn(name="RUN_ID")
	private CamgenRun camgenRun;

	/**
	 * Instantiates a new camgen run iteration.
	 */
	public CamgenRunIteration() {
	}

	/**
	 * Gets the iteration id.
	 *
	 * @return the iteration id
	 */
	public long getIterationId() {
		return this.iterationId;
	}

	/**
	 * Sets the iteration id.
	 *
	 * @param iterationId the new iteration id
	 */
	public void setIterationId(long iterationId) {
		this.iterationId = iterationId;
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
	 * Gets the end date time.
	 *
	 * @return the end date time
	 */
	public Date getEndDateTime() {
		return this.endDateTime;
	}

	/**
	 * Sets the end date time.
	 *
	 * @param endDateTime the new end date time
	 */
	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}

	/**
	 * Gets the iteration number.
	 *
	 * @return the iteration number
	 */
	public BigDecimal getIterationNumber() {
		return this.iterationNumber;
	}

	/**
	 * Sets the iteration number.
	 *
	 * @param iterationNumber the new iteration number
	 */
	public void setIterationNumber(BigDecimal iterationNumber) {
		this.iterationNumber = iterationNumber;
	}

	/**
	 * Gets the iteration solution file name.
	 *
	 * @return the iteration solution file name
	 */
	public String getIterationSolutionFileName() {
		return this.iterationSolutionFileName;
	}

	/**
	 * Sets the iteration solution file name.
	 *
	 * @param iterationSolutionFileName the new iteration solution file name
	 */
	public void setIterationSolutionFileName(String iterationSolutionFileName) {
		this.iterationSolutionFileName = iterationSolutionFileName;
	}

	/**
	 * Gets the start date time.
	 *
	 * @return the start date time
	 */
	public Date getStartDateTime() {
		return this.startDateTime;
	}

	/**
	 * Sets the start date time.
	 *
	 * @param startDateTime the new start date time
	 */
	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return this.status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(String status) {
		this.status = status;
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