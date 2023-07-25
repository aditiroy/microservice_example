/*
 * 
 */
package com.channel4.mint.automated.spot.infrastructure.persistence.repository;

import java.util.List;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRequest;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRqstBatchTxLevel;
import com.channel4.mint.automated.spot.interfaces.dto.BatchTxLevels;

/**
 * The Interface SnapshotParamBatchTxLevelsImplRepository used for operation of CamgenRequest.
 * 
 * @author HCL
 */
public interface SnapshotParamBatchTxLevelsImplRepository {

	/**
	 * Gets the camgen request find one.
	 *
	 * @param snapShotId the snap shot id
	 * @return the camgen request find one
	 */
	CamgenRequest getCamgenRequestFindOne(Long snapShotId);

	/**
	 * Save param batch tx levels.
	 *
	 * @param camgenRqstBatchTxLevelList the camgen rqst batch tx level list
	 * @return the list
	 */
	List<CamgenRqstBatchTxLevel> saveParamBatchTxLevels(List<CamgenRqstBatchTxLevel> camgenRqstBatchTxLevelList);

	/**
	 * Gets the camgen run param batch tx levels.
	 *
	 * @param snapShotId the snap shot id
	 * @return the camgen run param batch tx levels
	 */
	BatchTxLevels getCamgenRunParamBatchTxLevels(Integer snapShotId);

}
