/*****************************************************************
 * Copy right (c) Channel4 , All rights reserved.
 * 
 * 
 * Application Name: automated-spot-domain-service
 * 
 * This application is used for managing add sales of C4.
 * Which is a public media company of UK.
 * 
 * 
 * File Name:  SnapshotRunDetailsService.java
 * File created Date : 01-Jun-2018
 * 
 *
 * 
 *****************************************************************/
package com.channel4.mint.automated.spot.service;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;

import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamAudGroupChannels;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenSnapshotRunDetail;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenSnapshotRunDetails;
import com.channel4.mint.automated.spot.interfaces.dto.Field;
import com.channel4.mint.automated.spot.interfaces.dto.NewEntityCreated;
import com.channel4.mint.automated.spot.interfaces.dto.SnapshotDetail;
import com.channel4.mint.automated.spot.interfaces.dto.SnapshotSummaryWithPagination;

/**
 * The Interface SnapshotRunDetailsService used for operation for CamgenSnapshotRunDetails.
 * 
 * @author HCL
 */
public interface SnapshotRunDetailsService {

	/**
	 * method for create camgen snapshot details.
	 *
	 * @param camgenSnapshotRunDetails
	 *            the camgen snapshot run details
	 */
	NewEntityCreated createCamgenSnapshotRunDetails(CamgenSnapshotRunDetail camgenSnapshotRunDetail);

	/**
	 * Update camgen snapshot run details.
	 *
	 * @param camgenSnapshotRunDetails
	 *            the camgen snapshot run details
	 */
	void updateCamgenSnapshotRunDetails(CamgenSnapshotRunDetails camgenSnapshotRunDetails);

	/**
	 * method for get camgen snap shot run details.
	 *
	 * @param runId
	 *            the run id
	 * @param scheduledDate
	 *            scheduledDate
	 *            
	 * @return CamgenSnapshotRunDetails
	 */
	List<CamgenSnapshotRunDetail> getCamgenSnapshotRunDetails(Integer runId, DateTime scheduledDate, String requestStatus, String runStatus);

	/**
	 * Gets the camgen run param aud group channels.
	 *
	 * @param runId
	 *            the run id
	 * @return CamgenRunParamAudGroupChannels
	 */
	CamgenRunParamAudGroupChannels getCamgenRunParamAudGroupChannels(Integer runId);

	/**
	 * Creates the camgen run param aud group channels.
	 *
	 * @param body
	 *            the body
	 * @param runId
	 *            the run id
	 */
	void createCamgenRunParamAudGroupChannels(CamgenRunParamAudGroupChannels body, Integer runId);

	/**
	 * Gets the snapshot.
	 *
	 * @param snapshotId
	 *            the snapshot id
	 * @return SnapshotPlanDetail
	 */
	List<SnapshotDetail> getSnapshot(Integer snapshotId, LocalDate scheduledDate, String scheduledStartTime, String scheduledEndTime, String status);

	/**
	 * Gets the all snapshots.
	 *
	 * @param page
	 *            the page
	 * @param count
	 *            the count
	 * @param sortOrder
	 *            the sort order
	 * @param sortByField
	 *            the sort by field
	 * @return SnapshotSummaryWithPagination
	 */
	SnapshotSummaryWithPagination getAllSnapshots(Integer page, Long count, String sortOrder, String sortByField);

	/**
	 * Creates the snapshot.
	 *
	 * @param body
	 *            the body
	 * @return Field
	 */
	List<Field> createSnapshot(List<SnapshotDetail> snapshots);

	/**
	 * Gets the camgen snapshot run details by snapshot id.
	 *
	 * @param snapshotId
	 *            the snapshot id
	 * @return CamgenSnapshotRunDetails
	 */
	CamgenSnapshotRunDetails getCamgenSnapshotRunDetailsBySnapshotId(Integer snapshotId);

	/**
	 * Delete snapshot.
	 *
	 * @param snapshotId
	 *            the snapshot id
	 */
	void deleteSnapshot(Integer snapshotId);

	/**
	 * Update snapshots.
	 *
	 * @param snapshots
	 *            the snapshots
	 */
	void updateSnapshots(SnapshotDetail snapshots);

}
