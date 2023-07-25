package com.channel4.mint.automated.spot.service;

import com.channel4.mint.automated.spot.interfaces.dto.BatchTxLevels;

/**
 * The Interface SnapshotParamBatchTxLevelsServiceused used for operation for
 * BatchTxLevels.
 * 
 * @author HCL
 */
public interface SnapshotParamBatchTxLevelsService {

	/**
	 * Gets the camgen run param batch tx levels.
	 *
	 * @param snapShotId
	 *            the snap shot id
	 * @return BatchTxLevels
	 */
	BatchTxLevels getCamgenRunParamBatchTxLevels(Integer snapShotId);

}
