package com.channel4.mint.automated.spot.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.SnapshotParamBatchTxLevelsImplRepository;
import com.channel4.mint.automated.spot.interfaces.dto.BatchTxLevels;
import com.channel4.mint.automated.spot.service.SnapshotParamBatchTxLevelsService;

/**
 * This class is used to perform get and save operation on
 * SnapshotParamBatchTxLevels.
 * 
 * @author HCL
 */
@Service
public class SnapshotParamBatchTxLevelsServiceImpl implements SnapshotParamBatchTxLevelsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SnapshotParamBatchTxLevelsServiceImpl.class);

	@Autowired
	private SnapshotParamBatchTxLevelsImplRepository snapshotParamBatchTxLevelsImplRepository;

	

	/**
	 * Gets the camgen run param batch tx levels.
	 *
	 * @param snapShotId
	 *            the snap shot id
	 * @return BatchTxLevels
	 */
	@Override
	public BatchTxLevels getCamgenRunParamBatchTxLevels(Integer snapShotId) {
		LOGGER.info(">>SnapshotParamBatchTxLevelsServiceImpl.createCamgenRunParamBatchTxLevelsPost()");
		return snapshotParamBatchTxLevelsImplRepository.getCamgenRunParamBatchTxLevels(snapShotId);
	}

}
