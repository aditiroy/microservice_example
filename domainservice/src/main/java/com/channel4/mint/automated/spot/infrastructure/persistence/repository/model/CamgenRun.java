/*
 * 
 */
package com.channel4.mint.automated.spot.infrastructure.persistence.repository.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

// TODO: Auto-generated Javadoc
/**
 * The persistent class for the CAMGEN_RUN database table.
 * 
 */
@Entity
@Table(name = "CAMGEN_RUN")
@NamedQuery(name = "CamgenRun.findAll", query = "SELECT c FROM CamgenRun c")
public class CamgenRun implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The run id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RUN_ID")
	private long runId;

	/** The created by. */
	@Column(name = "CREATED_BY")
	private String createdBy;

	/** The created on. */
	@Column(name = "CREATED_ON")
	private Timestamp createdOn;

	/** The end date time. */
	@Temporal(TemporalType.DATE)
	@Column(name = "END_DATE_TIME")
	private Date endDateTime;

	/** The file import date. */
	@Temporal(TemporalType.DATE)
	@Column(name = "FILE_IMPORT_DATE")
	private Date fileImportDate;

	/** The is file imported. */
	@Column(name = "IS_FILE_IMPORTED")
	private BigDecimal isFileImported;

	/** The iteration number file. */
	@Column(name = "ITERATION_NUMBER_FILE")
	private BigDecimal iterationNumberFile;

	/** The modified by. */
	@Column(name = "MODIFIED_BY")
	private String modifiedBy;

	/** The modified on. */
	@Column(name = "MODIFIED_ON")
	private Timestamp modifiedOn;

	/** The note. */
	private String note;

	/** The schedule date time. */
	@Temporal(TemporalType.DATE)
	@Column(name = "SCHEDULE_DATE_TIME")
	private Date scheduleDateTime;

	/** The start date time. */
	@Temporal(TemporalType.DATE)
	@Column(name = "START_DATE_TIME")
	private Date startDateTime;

	/** The status. */
	@Column(name = "STATUS")
	private String status;

	@Column(name = "IS_SLOT")
	private BigDecimal isSlot;

	/** The camgen request. */
	// bi-directional many-to-one association to CamgenRequest
	@ManyToOne
	@JoinColumn(name = "REQUEST_ID")
	private CamgenRequest camgenRequest;

	/** The camgen run iterations. */
	// bi-directional many-to-one association to CamgenRunIteration
	@OneToMany(mappedBy = "camgenRun", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CamgenRunIteration> camgenRunIterations;

	/** The run audience group channels. */
	// bi-directional many-to-one association to RunAudienceGroupChannel
	@OneToMany(mappedBy = "camgenRun", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<RunAudienceGroupChannel> runAudienceGroupChannels;

	/** The run ei bands. */
	// bi-directional many-to-one association to RunEiBand
	@OneToMany(mappedBy = "camgenRun", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<RunEiBand> runEiBands;

	/** The run extract parameters. */
	// bi-directional many-to-one association to RunExtractParameter
	@OneToMany(mappedBy = "camgenRun", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<RunExtractParameter> runExtractParameters;

	/** The run parameters. */
	// bi-directional many-to-one association to RunParameter
	@OneToMany(mappedBy = "camgenRun", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<RunParameter> runParameters;

	/** The run station ei timebands. */
	// bi-directional many-to-one association to RunStationEiTimeband
	@OneToMany(mappedBy = "camgenRun", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<RunStationEiTimeband> runStationEiTimebands;

	/** The run station timebands. */
	// bi-directional many-to-one association to RunStationTimeband
	@OneToMany(mappedBy = "camgenRun", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<RunStationTimeband> runStationTimebands;

	/**
	 * Instantiates a new camgen run.
	 */
	public CamgenRun() {
	}

	public BigDecimal getIsSlot() {
		return isSlot;
	}

	public void setIsSlot(BigDecimal isSlot) {
		this.isSlot = isSlot;
	}

	/**
	 * Gets the run id.
	 *
	 * @return the run id
	 */
	public long getRunId() {
		return this.runId;
	}

	/**
	 * Sets the run id.
	 *
	 * @param runId
	 *            the new run id
	 */
	public void setRunId(long runId) {
		this.runId = runId;
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
	 * @param createdBy
	 *            the new created by
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
	 * @param createdOn
	 *            the new created on
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
	 * @param endDateTime
	 *            the new end date time
	 */
	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}

	/**
	 * Gets the file import date.
	 *
	 * @return the file import date
	 */
	public Date getFileImportDate() {
		return this.fileImportDate;
	}

	/**
	 * Sets the file import date.
	 *
	 * @param fileImportDate
	 *            the new file import date
	 */
	public void setFileImportDate(Date fileImportDate) {
		this.fileImportDate = fileImportDate;
	}

	/**
	 * Gets the checks if is file imported.
	 *
	 * @return the checks if is file imported
	 */
	public BigDecimal getIsFileImported() {
		return this.isFileImported;
	}

	/**
	 * Sets the checks if is file imported.
	 *
	 * @param isFileImported
	 *            the new checks if is file imported
	 */
	public void setIsFileImported(BigDecimal isFileImported) {
		this.isFileImported = isFileImported;
	}

	/**
	 * Gets the iteration number file.
	 *
	 * @return the iteration number file
	 */
	public BigDecimal getIterationNumberFile() {
		return this.iterationNumberFile;
	}

	/**
	 * Sets the iteration number file.
	 *
	 * @param iterationNumberFile
	 *            the new iteration number file
	 */
	public void setIterationNumberFile(BigDecimal iterationNumberFile) {
		this.iterationNumberFile = iterationNumberFile;
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
	 * @param modifiedBy
	 *            the new modified by
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
	 * @param modifiedOn
	 *            the new modified on
	 */
	public void setModifiedOn(Timestamp modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	/**
	 * Gets the note.
	 *
	 * @return the note
	 */
	public String getNote() {
		return this.note;
	}

	/**
	 * Sets the note.
	 *
	 * @param note
	 *            the new note
	 */
	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * Gets the schedule date time.
	 *
	 * @return the schedule date time
	 */
	public Date getScheduleDateTime() {
		return this.scheduleDateTime;
	}

	/**
	 * Sets the schedule date time.
	 *
	 * @param scheduleDateTime
	 *            the new schedule date time
	 */
	public void setScheduleDateTime(Date scheduleDateTime) {
		this.scheduleDateTime = scheduleDateTime;
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
	 * @param startDateTime
	 *            the new start date time
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
	 * @param status
	 *            the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the camgen request.
	 *
	 * @return the camgen request
	 */
	public CamgenRequest getCamgenRequest() {
		return this.camgenRequest;
	}

	/**
	 * Sets the camgen request.
	 *
	 * @param camgenRequest
	 *            the new camgen request
	 */
	public void setCamgenRequest(CamgenRequest camgenRequest) {
		this.camgenRequest = camgenRequest;
	}

	/**
	 * Gets the camgen run iterations.
	 *
	 * @return the camgen run iterations
	 */
	public List<CamgenRunIteration> getCamgenRunIterations() {
		return this.camgenRunIterations;
	}

	/**
	 * Sets the camgen run iterations.
	 *
	 * @param camgenRunIterations
	 *            the new camgen run iterations
	 */
	public void setCamgenRunIterations(List<CamgenRunIteration> camgenRunIterations) {
		this.camgenRunIterations = camgenRunIterations;
	}

	/**
	 * Adds the camgen run iteration.
	 *
	 * @param camgenRunIteration
	 *            the camgen run iteration
	 * @return the camgen run iteration
	 */
	public CamgenRunIteration addCamgenRunIteration(CamgenRunIteration camgenRunIteration) {
		getCamgenRunIterations().add(camgenRunIteration);
		camgenRunIteration.setCamgenRun(this);

		return camgenRunIteration;
	}

	/**
	 * Removes the camgen run iteration.
	 *
	 * @param camgenRunIteration
	 *            the camgen run iteration
	 * @return the camgen run iteration
	 */
	public CamgenRunIteration removeCamgenRunIteration(CamgenRunIteration camgenRunIteration) {
		getCamgenRunIterations().remove(camgenRunIteration);
		camgenRunIteration.setCamgenRun(null);

		return camgenRunIteration;
	}

	/**
	 * Gets the run audience group channels.
	 *
	 * @return the run audience group channels
	 */
	public List<RunAudienceGroupChannel> getRunAudienceGroupChannels() {
		return this.runAudienceGroupChannels;
	}

	/**
	 * Sets the run audience group channels.
	 *
	 * @param runAudienceGroupChannels
	 *            the new run audience group channels
	 */
	public void setRunAudienceGroupChannels(List<RunAudienceGroupChannel> runAudienceGroupChannels) {
		this.runAudienceGroupChannels = runAudienceGroupChannels;
	}

	/**
	 * Adds the run audience group channel.
	 *
	 * @param runAudienceGroupChannel
	 *            the run audience group channel
	 * @return the run audience group channel
	 */
	public RunAudienceGroupChannel addRunAudienceGroupChannel(RunAudienceGroupChannel runAudienceGroupChannel) {
		getRunAudienceGroupChannels().add(runAudienceGroupChannel);
		runAudienceGroupChannel.setCamgenRun(this);

		return runAudienceGroupChannel;
	}

	/**
	 * Removes the run audience group channel.
	 *
	 * @param runAudienceGroupChannel
	 *            the run audience group channel
	 * @return the run audience group channel
	 */
	public RunAudienceGroupChannel removeRunAudienceGroupChannel(RunAudienceGroupChannel runAudienceGroupChannel) {
		getRunAudienceGroupChannels().remove(runAudienceGroupChannel);
		runAudienceGroupChannel.setCamgenRun(null);

		return runAudienceGroupChannel;
	}

	/**
	 * Gets the run ei bands.
	 *
	 * @return the run ei bands
	 */
	public List<RunEiBand> getRunEiBands() {
		return this.runEiBands;
	}

	/**
	 * Sets the run ei bands.
	 *
	 * @param runEiBands
	 *            the new run ei bands
	 */
	public void setRunEiBands(List<RunEiBand> runEiBands) {
		this.runEiBands = runEiBands;
	}

	/**
	 * Adds the run ei band.
	 *
	 * @param runEiBand
	 *            the run ei band
	 * @return the run ei band
	 */
	public RunEiBand addRunEiBand(RunEiBand runEiBand) {
		getRunEiBands().add(runEiBand);
		runEiBand.setCamgenRun(this);

		return runEiBand;
	}

	/**
	 * Removes the run ei band.
	 *
	 * @param runEiBand
	 *            the run ei band
	 * @return the run ei band
	 */
	public RunEiBand removeRunEiBand(RunEiBand runEiBand) {
		getRunEiBands().remove(runEiBand);
		runEiBand.setCamgenRun(null);

		return runEiBand;
	}

	/**
	 * Gets the run extract parameters.
	 *
	 * @return the run extract parameters
	 */
	public List<RunExtractParameter> getRunExtractParameters() {
		return this.runExtractParameters;
	}

	/**
	 * Sets the run extract parameters.
	 *
	 * @param runExtractParameters
	 *            the new run extract parameters
	 */
	public void setRunExtractParameters(List<RunExtractParameter> runExtractParameters) {
		this.runExtractParameters = runExtractParameters;
	}

	/**
	 * Adds the run extract parameter.
	 *
	 * @param runExtractParameter
	 *            the run extract parameter
	 * @return the run extract parameter
	 */
	public RunExtractParameter addRunExtractParameter(RunExtractParameter runExtractParameter) {
		getRunExtractParameters().add(runExtractParameter);
		runExtractParameter.setCamgenRun(this);

		return runExtractParameter;
	}

	/**
	 * Removes the run extract parameter.
	 *
	 * @param runExtractParameter
	 *            the run extract parameter
	 * @return the run extract parameter
	 */
	public RunExtractParameter removeRunExtractParameter(RunExtractParameter runExtractParameter) {
		getRunExtractParameters().remove(runExtractParameter);
		runExtractParameter.setCamgenRun(null);

		return runExtractParameter;
	}

	/**
	 * Gets the run parameters.
	 *
	 * @return the run parameters
	 */
	public List<RunParameter> getRunParameters() {
		return this.runParameters;
	}

	/**
	 * Sets the run parameters.
	 *
	 * @param runParameters
	 *            the new run parameters
	 */
	public void setRunParameters(List<RunParameter> runParameters) {
		this.runParameters = runParameters;
	}

	/**
	 * Adds the run parameter.
	 *
	 * @param runParameter
	 *            the run parameter
	 * @return the run parameter
	 */
	public RunParameter addRunParameter(RunParameter runParameter) {
		getRunParameters().add(runParameter);
		runParameter.setCamgenRun(this);

		return runParameter;
	}

	/**
	 * Removes the run parameter.
	 *
	 * @param runParameter
	 *            the run parameter
	 * @return the run parameter
	 */
	public RunParameter removeRunParameter(RunParameter runParameter) {
		getRunParameters().remove(runParameter);
		runParameter.setCamgenRun(null);

		return runParameter;
	}

	/**
	 * Gets the run station ei timebands.
	 *
	 * @return the run station ei timebands
	 */
	public List<RunStationEiTimeband> getRunStationEiTimebands() {
		return this.runStationEiTimebands;
	}

	/**
	 * Sets the run station ei timebands.
	 *
	 * @param runStationEiTimebands
	 *            the new run station ei timebands
	 */
	public void setRunStationEiTimebands(List<RunStationEiTimeband> runStationEiTimebands) {
		this.runStationEiTimebands = runStationEiTimebands;
	}

	/**
	 * Adds the run station ei timeband.
	 *
	 * @param runStationEiTimeband
	 *            the run station ei timeband
	 * @return the run station ei timeband
	 */
	public RunStationEiTimeband addRunStationEiTimeband(RunStationEiTimeband runStationEiTimeband) {
		getRunStationEiTimebands().add(runStationEiTimeband);
		runStationEiTimeband.setCamgenRun(this);

		return runStationEiTimeband;
	}

	/**
	 * Removes the run station ei timeband.
	 *
	 * @param runStationEiTimeband
	 *            the run station ei timeband
	 * @return the run station ei timeband
	 */
	public RunStationEiTimeband removeRunStationEiTimeband(RunStationEiTimeband runStationEiTimeband) {
		getRunStationEiTimebands().remove(runStationEiTimeband);
		runStationEiTimeband.setCamgenRun(null);

		return runStationEiTimeband;
	}

	/**
	 * Gets the run station timebands.
	 *
	 * @return the run station timebands
	 */
	public List<RunStationTimeband> getRunStationTimebands() {
		return this.runStationTimebands;
	}

	/**
	 * Sets the run station timebands.
	 *
	 * @param runStationTimebands
	 *            the new run station timebands
	 */
	public void setRunStationTimebands(List<RunStationTimeband> runStationTimebands) {
		this.runStationTimebands = runStationTimebands;
	}

	/**
	 * Adds the run station timeband.
	 *
	 * @param runStationTimeband
	 *            the run station timeband
	 * @return the run station timeband
	 */
	public RunStationTimeband addRunStationTimeband(RunStationTimeband runStationTimeband) {
		getRunStationTimebands().add(runStationTimeband);
		runStationTimeband.setCamgenRun(this);

		return runStationTimeband;
	}

	/**
	 * Removes the run station timeband.
	 *
	 * @param runStationTimeband
	 *            the run station timeband
	 * @return the run station timeband
	 */
	public RunStationTimeband removeRunStationTimeband(RunStationTimeband runStationTimeband) {
		getRunStationTimebands().remove(runStationTimeband);
		runStationTimeband.setCamgenRun(null);

		return runStationTimeband;
	}

}