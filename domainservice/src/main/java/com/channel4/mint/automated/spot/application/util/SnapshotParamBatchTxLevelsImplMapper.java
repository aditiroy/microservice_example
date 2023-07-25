/*
 * 
 */
package com.channel4.mint.automated.spot.application.util;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRequest;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRqstBatchTxLevel;
import com.channel4.mint.automated.spot.interfaces.dto.BatchTxLevel;
import com.channel4.mint.automated.spot.interfaces.dto.BatchTxLevels;

// TODO: Auto-generated Javadoc
/**
 * The Class SnapshotParamBatchTxLevelsImplMapper.
 */
@Component
public class SnapshotParamBatchTxLevelsImplMapper {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(SnapshotParamBatchTxLevelsImplMapper.class);

	/** The date time utility. */
	@Autowired
	DateTimeUtility dateTimeUtility;

	/**
	 * Map create camgen run param batch tx levels post.
	 *
	 * @param camgenRequestFindOne
	 *            the camgen request find one
	 * @param batchTxLevel
	 *            the batch tx level
	 * @return the camgen rqst batch tx level
	 */
	public CamgenRqstBatchTxLevel mapCreateCamgenRunParamBatchTxLevelsPost(CamgenRequest camgenRequestFindOne,
			BatchTxLevel batchTxLevel) {
		LOGGER.info(">>SnapshotParamBatchTxLevelsImplMapper.mapCreateCamgenRunParamBatchTxLevelsPost()");
		CamgenRqstBatchTxLevel camgenRqstBatchTxLevel = new CamgenRqstBatchTxLevel();

		if (null != batchTxLevel.getBatchTxLevelValue()) {
			camgenRqstBatchTxLevel.setBatchValue(new BigDecimal(batchTxLevel.getBatchTxLevelValue()));
		}
		camgenRqstBatchTxLevel.setCamgenRequest(camgenRequestFindOne);
		camgenRqstBatchTxLevel.setCreatedBy(camgenRequestFindOne.getCreatedBy());
		if (null != batchTxLevel.getTxLevelId()){
			camgenRqstBatchTxLevel.setTransmissionLevelId(new BigDecimal(batchTxLevel.getTxLevelId()));
		}
		camgenRqstBatchTxLevel.setCreatedOn(dateTimeUtility.getCurrentTimeStamp());

		LOGGER.info("<<SnapshotParamBatchTxLevelsImplMapper.mapCreateCamgenRunParamBatchTxLevelsPost()");
		return camgenRqstBatchTxLevel;
	}

	/**
	 * Map camgen rqst batch tx level to batch tx levels.
	 *
	 * @param returnedCamgenRqstBatchTxLevelList
	 *            the returned camgen rqst batch tx level list
	 * @return the batch tx levels
	 */
	public BatchTxLevels mapCamgenRqstBatchTxLevelToBatchTxLevels(
			List<CamgenRqstBatchTxLevel> returnedCamgenRqstBatchTxLevelList) {
		BatchTxLevels batchTxLevels = new BatchTxLevels();
		for (CamgenRqstBatchTxLevel itrCamgenRqstBatchTxLevel : returnedCamgenRqstBatchTxLevelList) {
			BatchTxLevel batchTxLevel = new BatchTxLevel();
			if (null != itrCamgenRqstBatchTxLevel.getBatchValue()) {
				batchTxLevel.setBatchTxLevelValue(itrCamgenRqstBatchTxLevel.getBatchValue().intValue());
			}
			batchTxLevel.setId((int) itrCamgenRqstBatchTxLevel.getBatchTxLevelId());
			if (null != itrCamgenRqstBatchTxLevel.getTransmissionLevelId()) {
				batchTxLevel.setTxLevelId(itrCamgenRqstBatchTxLevel.getTransmissionLevelId().longValue());
			}
			batchTxLevels.add(batchTxLevel);
		}
		return batchTxLevels;
	}

}
