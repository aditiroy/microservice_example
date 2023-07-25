package com.channel4.mint.automated.spot.service.impl;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.SnapshotRunDetailsRepository;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamAudGroupChannels;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenSnapshotRunDetail;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenSnapshotRunDetails;
import com.channel4.mint.automated.spot.interfaces.dto.Field;
import com.channel4.mint.automated.spot.interfaces.dto.NewEntityCreated;
import com.channel4.mint.automated.spot.interfaces.dto.SnapshotDetail;
import com.channel4.mint.automated.spot.interfaces.dto.SnapshotSummaryWithPagination;
import com.channel4.mint.automated.spot.service.SnapshotRunDetailsService;

/**
 * class for handle snap shot details operations.
 * 
 * @author HCL
 */
@Service
public class SnapshotRunDetailsServiceImpl implements SnapshotRunDetailsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SnapshotRunDetailsServiceImpl.class);

	@Autowired
	private SnapshotRunDetailsRepository snapshotRunDetailsRepository;

	/**
	 * method for create camgen snapshot details.
	 *
	 * @param camgenSnapshotRunDetail
	 *            the camgen snapshot run details
	 */
	@Transactional
	@Override
	public NewEntityCreated createCamgenSnapshotRunDetails(CamgenSnapshotRunDetail camgenSnapshotRunDetail) {
		LOGGER.info(">> Service SnapshotRunDetailsServiceImpl method createCamgenSnapshotRunDetails");
		NewEntityCreated newEntityCreated=snapshotRunDetailsRepository.createCamgenSnapshotRunDetails(camgenSnapshotRunDetail);
		LOGGER.info("<< Service SnapshotRunDetailsServiceImpl method createCamgenSnapshotRunDetails");
		return newEntityCreated;
	}

	/**
	 * Update camgen snapshot run details.
	 *
	 * @param camgenSnapshotRunDetails
	 *            the camgen snapshot run details
	 */
	@Transactional
	@Override
	public void updateCamgenSnapshotRunDetails(CamgenSnapshotRunDetails camgenSnapshotRunDetails) {
		LOGGER.info(">> Service SnapshotRunDetailsServiceImpl method updateCamgenSnapshotRunDetails");
		snapshotRunDetailsRepository.updateCamgenSnapshotRunDetails(camgenSnapshotRunDetails);
		LOGGER.info("<< Service SnapshotRunDetailsServiceImpl method updateCamgenSnapshotRunDetails");
	}

	/**
	 * method for get camgen snap shot run details.
	 *
	 * @param runId
	 *            the run id
	 * @return CamgenSnapshotRunDetails
	 */
	@Override
	public List<CamgenSnapshotRunDetail> getCamgenSnapshotRunDetails(Integer runId,DateTime scheduledDate, String requestStatus,String runStatus) {
		LOGGER.info(">> Service SnapshotRunDetailsServiceImpl method getCamgenSnapshotRunDetails");
		return snapshotRunDetailsRepository.getCamgenSnapshotRunDetails(runId, scheduledDate, requestStatus,runStatus);
	}

	/**
	 * Gets the camgen run param aud group channels.
	 *
	 * @param runId
	 *            the run id
	 * @return CamgenRunParamAudGroupChannels
	 */
	@Override
	public CamgenRunParamAudGroupChannels getCamgenRunParamAudGroupChannels(Integer runId) {
		LOGGER.info(">> Service SnapshotRunDetailsServiceImpl method getCamgenRunParamAudGroupChannels");
		return snapshotRunDetailsRepository.getCamgenRunParamAudGroupChannels(runId);

	}

	/**
	 * Creates the camgen run param aud group channels.
	 *
	 * @param body
	 *            the body
	 * @param runId
	 *            the run id
	 */
	@Transactional
	@Override
	public void createCamgenRunParamAudGroupChannels(CamgenRunParamAudGroupChannels body, Integer runId) {
		LOGGER.info(">> Service SnapshotRunDetailsServiceImpl method createCamgenRunParamAudGroupChannels");
		snapshotRunDetailsRepository.createCamgenRunParamAudGroupChannels(body, runId);

	}

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
	@Override
	public SnapshotSummaryWithPagination getAllSnapshots(Integer page, Long count, String sortOrder,
			String sortByField) {
		LOGGER.info(">> Service SnapshotRunDetailsServiceImpl method getAllSnapshots");
		return snapshotRunDetailsRepository.getAllSnapshots(page, count, sortOrder, sortByField);
	}

	/**
	 * Gets the snapshot.
	 *
	 * @param snapshotId
	 *            the snapshot id
	 * @return SnapshotPlanDetail
	 */
	@Override
	public List<SnapshotDetail> getSnapshot(Integer snapshotId, LocalDate scheduledDate, String scheduledStartTime, String scheduledEndTime, String status) {
		LOGGER.info(">> Service SnapshotRunDetailsServiceImpl method getSnapshot");
		return snapshotRunDetailsRepository.getSnapshot(snapshotId,scheduledDate,scheduledStartTime,scheduledEndTime, status);
	}

	/**
	 * Creates the snapshot.
	 *
	 * @param manualSnapshot
	 *            the manualSnapshot
	 * @return Field
	 */
	@Transactional
	@Override
	public List<Field> createSnapshot(List<SnapshotDetail> snapshots) {
		LOGGER.info(">> Service SnapshotRunDetailsServiceImpl method createSnapshot");
		return snapshotRunDetailsRepository.createSnapshot(snapshots);
	}

	/**
	 * Gets the camgen snapshot run details by snapshot id.
	 *
	 * @param snapshotId
	 *            the snapshot id
	 * @return CamgenSnapshotRunDetails
	 */
	@Override
	public CamgenSnapshotRunDetails getCamgenSnapshotRunDetailsBySnapshotId(Integer snapshotId) {
		LOGGER.info(">> Service SnapshotRunDetailsServiceImpl method getCamgenSnapshotRunDetailsBySnapshotId");
		return snapshotRunDetailsRepository.getCamgenSnapshotRunDetailsBySnapshotId(snapshotId);

	}
	

	/**
	 * Delete snapshot.
	 *
	 * @param snapshotId
	 *            the snapshot id
	 */
	@Transactional
	@Override
	public void deleteSnapshot(Integer snapshotId) {
		LOGGER.info(">> Service SnapshotRunDetailsServiceImpl method deleteSnapshot");
		snapshotRunDetailsRepository.deleteSnapshot(snapshotId);
	}

	/**
	 * Update snapshots.
	 *
	 * @param snapshots
	 *            the snapshots
	 */
	@Transactional
	@Override
	public void updateSnapshots(SnapshotDetail snapshots) {
		LOGGER.info(">> Service SnapshotRunDetailsServiceImpl method updateSnapshots");
		snapshotRunDetailsRepository.updateSnapshots(snapshots);
	}

}
