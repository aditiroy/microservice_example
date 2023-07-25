package com.channel4.mint.automated.spot.infrastructure.persistence.repository.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.channel4.mint.automated.spot.application.util.SnapshotParamBatchTxLevelsImplMapper;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenBatchTxLevelJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenRequestJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenRqstBatchTxLevelJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.SnapshotParamBatchTxLevelsImplRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenBatchTxLevel;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRequest;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRqstBatchTxLevel;
import com.channel4.mint.automated.spot.interfaces.dto.BatchTxLevel;
import com.channel4.mint.automated.spot.interfaces.dto.BatchTxLevels;
import com.channel4.mint.baseexception.MintBaseException;

/**
 * The Class SnapshotParamBatchTxLevelsImplRepositoryImpl.
 * 
 * @author HCL
 */
@Repository
public class SnapshotParamBatchTxLevelsImplRepositoryImpl implements SnapshotParamBatchTxLevelsImplRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(SnapshotParamBatchTxLevelsImplRepositoryImpl.class);

	@Autowired
	private CamgenRequestJpaRepository camgenRequestJpaRepository;

	@Autowired
	private CamgenRqstBatchTxLevelJpaRepository camgenRqstBatchTxLevelJpaRepository;

	@Autowired
	private CamgenBatchTxLevelJpaRepository camgenBatchTxLevelJpaRepository;

	@Autowired
	private SnapshotParamBatchTxLevelsImplMapper snapshotParamBatchTxLevelsImplMapper;

	/**
	 * Gets the camgen request find one.
	 *
	 * @param snapShotId
	 *            the snap shot id
	 * @return the camgen request find one
	 */
	@Override
	public CamgenRequest getCamgenRequestFindOne(Long snapShotId) {
		CamgenRequest camgenRequest = camgenRequestJpaRepository.findOne(snapShotId);
		if (null == camgenRequest) {
			throw new MintBaseException("No value fonud in camgenRequest for snapshot id=" + snapShotId,
					HttpStatus.NOT_FOUND.value());
		}
		return camgenRequest;
	}

	/**
	 * Save param batch tx levels.
	 *
	 * @param camgenRqstBatchTxLevelList
	 *            the camgen rqst batch tx level list
	 * @return the list
	 */
	@Override
	public List<CamgenRqstBatchTxLevel> saveParamBatchTxLevels(
			List<CamgenRqstBatchTxLevel> camgenRqstBatchTxLevelList) {
		LOGGER.info(">>SnapshotParamBatchTxLevelsImplRepositoryImpl.saveParamBatchTxLevels()");
		List<CamgenRqstBatchTxLevel> returnedCamgenRqstBatchTxLevelList = null;
		try {
			returnedCamgenRqstBatchTxLevelList = camgenRqstBatchTxLevelJpaRepository.save(camgenRqstBatchTxLevelList);
			if (CollectionUtils.isEmpty(returnedCamgenRqstBatchTxLevelList)) {
				throw new MintBaseException("No return found on posting data=", HttpStatus.NOT_FOUND.value());
			}
		} catch (DataAccessException e) {
			LOGGER.error("Exception occur saveParamBatchTxLevels of SnapshotParamBatchTxLevelsImplRepositoryImpl{} ",
					e);
			throw new MintBaseException("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		LOGGER.info("<<SnapshotParamBatchTxLevelsImplRepositoryImpl.saveParamBatchTxLevels()");
		return returnedCamgenRqstBatchTxLevelList;
	}

	/**
	 * Gets the camgen run param batch tx levels.
	 *
	 * @param snapShotId
	 *            the snap shot id
	 * @return the camgen run param batch tx levels
	 */
	@Override
	public BatchTxLevels getCamgenRunParamBatchTxLevels(Integer snapShotId) {
		LOGGER.info(">>SnapshotParamBatchTxLevelsImplRepositoryImpl.getCamgenRunParamBatchTxLevels()");
		CamgenRequest camgenRequest = null;
		try {
			
			if(null != snapShotId){
				camgenRequest = camgenRequestJpaRepository.findOne(snapShotId.longValue());
				
				if(null == camgenRequest){
					throw new MintBaseException("Camgen Request Not Found", HttpStatus.NOT_FOUND.value());
				}

				if (CollectionUtils.isEmpty(camgenRequest.getCamgenRqstBatchTxLevels())) {
					return loadCamgenRunParamBatchTxLevelsFromMasterData();
				}
			} else {
				return loadCamgenRunParamBatchTxLevelsFromMasterData();
			}

		} catch (DataAccessException e) {
			LOGGER.error("Exception occur saveParamBatchTxLevels of SnapshotParamBatchTxLevelsImplRepositoryImpl{} ",
					e);
			throw new MintBaseException("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		
		LOGGER.info("<<SnapshotParamBatchTxLevelsImplRepositoryImpl.saveParamBatchTxLevels()");
		return snapshotParamBatchTxLevelsImplMapper
				.mapCamgenRqstBatchTxLevelToBatchTxLevels(camgenRequest.getCamgenRqstBatchTxLevels());
	}

	private BatchTxLevels loadCamgenRunParamBatchTxLevelsFromMasterData() {

		List<CamgenBatchTxLevel> camgenBatchTxLevelList = null;
		try {
			camgenBatchTxLevelList = camgenBatchTxLevelJpaRepository.findAll();
			if (CollectionUtils.isEmpty(camgenBatchTxLevelList)) {
				throw new MintBaseException("Batch Tx Levels Not found", HttpStatus.NOT_FOUND.value());
			}

		} catch (DataAccessException e) {
			LOGGER.error("Exception occur saveParamBatchTxLevels of SnapshotParamBatchTxLevelsImplRepositoryImpl{} ",
					e);
			throw new MintBaseException("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value());
		}

		LOGGER.info("<<SnapshotParamBatchTxLevelsImplRepositoryImpl.saveParamBatchTxLevels()");
		return mapCamgenRqstBatchTxLevel(camgenBatchTxLevelList);
	}

	private BatchTxLevels mapCamgenRqstBatchTxLevel(List<CamgenBatchTxLevel> camgenBatchTxLevelList) {
		BatchTxLevels batchTxLevels = new BatchTxLevels();

		for (CamgenBatchTxLevel camgenBatchTxLevel : camgenBatchTxLevelList) {
			BatchTxLevel batchTxLevel = new BatchTxLevel();
			batchTxLevel.setBatchTxLevelValue(camgenBatchTxLevel.getBatchValue().intValue());
			batchTxLevel.setId((int) camgenBatchTxLevel.getBatchTxLevelId());
			batchTxLevel.setTxLevelId(camgenBatchTxLevel.getTransmissionLevelId().longValue());
			batchTxLevels.add(batchTxLevel);
		}

		return batchTxLevels;
	}

}
