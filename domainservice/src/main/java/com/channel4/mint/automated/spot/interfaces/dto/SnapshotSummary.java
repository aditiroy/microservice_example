/*
 * 
 */
package com.channel4.mint.automated.spot.interfaces.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.joda.time.DateTime;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * SnapshotSummary
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-14T09:04:29.792Z")

public class SnapshotSummary {
	@JsonProperty("snapshotrequestID")
	private Long snapshotrequestID = null;

	@JsonProperty("creationDate")
	private DateTime creationDate = null;

	@JsonProperty("txLevels")
	@Valid
	private List<SnapshotSummaryTxLevels> txLevels = null;

	@JsonProperty("snpashotStartEndDate")
	private StartEndDate snpashotStartEndDate = null;

	@JsonProperty("channelSetId")
	private Long channelSetId = null;

	@JsonProperty("snapshotPlanID")
	private Long snapshotPlanID = null;

	@JsonProperty("requestType")
	private String requestType = null;

	@JsonProperty("status")
	private String status = null;

	@JsonProperty("fillingStartDate")
	private DateTime fillingStartDate = null;

	@JsonProperty("fillingEndDate")
	private DateTime fillingEndDate = null;

	@JsonProperty("scheduledDate")
	private DateTime scheduledDate = null;

	@JsonProperty("run")
	private Boolean run = null;

	@JsonProperty("slot")
	private Boolean slot = null;

	@JsonProperty("lastModifiedBy")
	private String lastModifiedBy = null;

	@JsonProperty("startTime")
	private DateTime startTime = null;

	public SnapshotSummary snapshotrequestID(Long snapshotrequestID) {
		this.snapshotrequestID = snapshotrequestID;
		return this;
	}

	/**
	 * Get snapshotrequestID
	 * 
	 * @return snapshotrequestID
	 **/
	@ApiModelProperty(value = "")

	public Long getSnapshotrequestID() {
		return snapshotrequestID;
	}

	public void setSnapshotrequestID(Long snapshotrequestID) {
		this.snapshotrequestID = snapshotrequestID;
	}

	public SnapshotSummary creationDate(DateTime creationDate) {
		this.creationDate = creationDate;
		return this;
	}

	/**
	 * Get creationDate
	 * 
	 * @return creationDate
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public DateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(DateTime creationDate) {
		this.creationDate = creationDate;
	}

	public SnapshotSummary txLevels(List<SnapshotSummaryTxLevels> txLevels) {
		this.txLevels = txLevels;
		return this;
	}

	public SnapshotSummary addTxLevelsItem(SnapshotSummaryTxLevels txLevelsItem) {
		if (this.txLevels == null) {
			this.txLevels = new ArrayList<SnapshotSummaryTxLevels>();
		}
		this.txLevels.add(txLevelsItem);
		return this;
	}

	/**
	 * Get txLevels
	 * 
	 * @return txLevels
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public List<SnapshotSummaryTxLevels> getTxLevels() {
		return txLevels;
	}

	public void setTxLevels(List<SnapshotSummaryTxLevels> txLevels) {
		this.txLevels = txLevels;
	}

	public SnapshotSummary snpashotStartEndDate(StartEndDate snpashotStartEndDate) {
		this.snpashotStartEndDate = snpashotStartEndDate;
		return this;
	}

	/**
	 * Get snpashotStartEndDate
	 * 
	 * @return snpashotStartEndDate
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public StartEndDate getSnpashotStartEndDate() {
		return snpashotStartEndDate;
	}

	public void setSnpashotStartEndDate(StartEndDate snpashotStartEndDate) {
		this.snpashotStartEndDate = snpashotStartEndDate;
	}

	public SnapshotSummary channelSetId(Long channelSetId) {
		this.channelSetId = channelSetId;
		return this;
	}

	/**
	 * Get channelSetId
	 * 
	 * @return channelSetId
	 **/
	@ApiModelProperty(value = "")

	public Long getChannelSetId() {
		return channelSetId;
	}

	public void setChannelSetId(Long channelSetId) {
		this.channelSetId = channelSetId;
	}

	public SnapshotSummary snapshotPlanID(Long snapshotPlanID) {
		this.snapshotPlanID = snapshotPlanID;
		return this;
	}

	/**
	 * Get snapshotPlanID
	 * 
	 * @return snapshotPlanID
	 **/
	@ApiModelProperty(value = "")

	public Long getSnapshotPlanID() {
		return snapshotPlanID;
	}

	public void setSnapshotPlanID(Long snapshotPlanID) {
		this.snapshotPlanID = snapshotPlanID;
	}

	public SnapshotSummary requestType(String requestType) {
		this.requestType = requestType;
		return this;
	}

	/**
	 * Get requestType
	 * 
	 * @return requestType
	 **/
	@ApiModelProperty(value = "")

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public SnapshotSummary status(String status) {
		this.status = status;
		return this;
	}

	/**
	 * Get status
	 * 
	 * @return status
	 **/
	@ApiModelProperty(value = "")

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public SnapshotSummary fillingStartDate(DateTime fillingStartDate) {
		this.fillingStartDate = fillingStartDate;
		return this;
	}

	/**
	 * Get fillingStartDate
	 * 
	 * @return fillingStartDate
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public DateTime getFillingStartDate() {
		return fillingStartDate;
	}

	public void setFillingStartDate(DateTime fillingStartDate) {
		this.fillingStartDate = fillingStartDate;
	}

	public SnapshotSummary fillingEndDate(DateTime fillingEndDate) {
		this.fillingEndDate = fillingEndDate;
		return this;
	}

	/**
	 * Get fillingEndDate
	 * 
	 * @return fillingEndDate
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public DateTime getFillingEndDate() {
		return fillingEndDate;
	}

	public void setFillingEndDate(DateTime fillingEndDate) {
		this.fillingEndDate = fillingEndDate;
	}

	public SnapshotSummary scheduledDate(DateTime scheduledDate) {
		this.scheduledDate = scheduledDate;
		return this;
	}

	/**
	 * Get scheduledDate
	 * 
	 * @return scheduledDate
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public DateTime getScheduledDate() {
		return scheduledDate;
	}

	public void setScheduledDate(DateTime scheduledDate) {
		this.scheduledDate = scheduledDate;
	}

	public SnapshotSummary run(Boolean run) {
		this.run = run;
		return this;
	}

	/**
	 * Get run
	 * 
	 * @return run
	 **/
	@ApiModelProperty(value = "")

	public Boolean isRun() {
		return run;
	}

	public void setRun(Boolean run) {
		this.run = run;
	}

	public SnapshotSummary slot(Boolean slot) {
		this.slot = slot;
		return this;
	}

	/**
	 * Get slot
	 * 
	 * @return slot
	 **/
	@ApiModelProperty(value = "")

	public Boolean isSlot() {
		return slot;
	}

	public void setSlot(Boolean slot) {
		this.slot = slot;
	}

	public SnapshotSummary lastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
		return this;
	}

	/**
	 * Get lastModifiedBy
	 * 
	 * @return lastModifiedBy
	 **/
	@ApiModelProperty(value = "")

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public SnapshotSummary startTime(DateTime startTime) {
		this.startTime = startTime;
		return this;
	}

	/**
	 * Get startTime
	 * 
	 * @return startTime
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public DateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(DateTime startTime) {
		this.startTime = startTime;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		SnapshotSummary snapshotSummary = (SnapshotSummary) o;
		return Objects.equals(this.snapshotrequestID, snapshotSummary.snapshotrequestID)
				&& Objects.equals(this.creationDate, snapshotSummary.creationDate)
				&& Objects.equals(this.txLevels, snapshotSummary.txLevels)
				&& Objects.equals(this.snpashotStartEndDate, snapshotSummary.snpashotStartEndDate)
				&& Objects.equals(this.channelSetId, snapshotSummary.channelSetId)
				&& Objects.equals(this.snapshotPlanID, snapshotSummary.snapshotPlanID)
				&& Objects.equals(this.requestType, snapshotSummary.requestType)
				&& Objects.equals(this.status, snapshotSummary.status)
				&& Objects.equals(this.fillingStartDate, snapshotSummary.fillingStartDate)
				&& Objects.equals(this.fillingEndDate, snapshotSummary.fillingEndDate)
				&& Objects.equals(this.scheduledDate, snapshotSummary.scheduledDate)
				&& Objects.equals(this.run, snapshotSummary.run) && Objects.equals(this.slot, snapshotSummary.slot)
				&& Objects.equals(this.lastModifiedBy, snapshotSummary.lastModifiedBy)
				&& Objects.equals(this.startTime, snapshotSummary.startTime);
	}

	@Override
	public int hashCode() {
		return Objects.hash(snapshotrequestID, creationDate, txLevels, snpashotStartEndDate, channelSetId,
				snapshotPlanID, requestType, status, fillingStartDate, fillingEndDate, scheduledDate, run, slot,
				lastModifiedBy, startTime);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class SnapshotSummary {\n");

		sb.append("    snapshotrequestID: ").append(toIndentedString(snapshotrequestID)).append("\n");
		sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
		sb.append("    txLevels: ").append(toIndentedString(txLevels)).append("\n");
		sb.append("    snpashotStartEndDate: ").append(toIndentedString(snpashotStartEndDate)).append("\n");
		sb.append("    channelSetId: ").append(toIndentedString(channelSetId)).append("\n");
		sb.append("    snapshotPlanID: ").append(toIndentedString(snapshotPlanID)).append("\n");
		sb.append("    requestType: ").append(toIndentedString(requestType)).append("\n");
		sb.append("    status: ").append(toIndentedString(status)).append("\n");
		sb.append("    fillingStartDate: ").append(toIndentedString(fillingStartDate)).append("\n");
		sb.append("    fillingEndDate: ").append(toIndentedString(fillingEndDate)).append("\n");
		sb.append("    scheduledDate: ").append(toIndentedString(scheduledDate)).append("\n");
		sb.append("    run: ").append(toIndentedString(run)).append("\n");
		sb.append("    slot: ").append(toIndentedString(slot)).append("\n");
		sb.append("    lastModifiedBy: ").append(toIndentedString(lastModifiedBy)).append("\n");
		sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
