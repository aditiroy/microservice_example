package com.channel4.mint.automated.spot.infrastructure.persistence.repository.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.channel4.mint.automated.spot.application.util.AutomatedSpotConstants;
import com.channel4.mint.automated.spot.application.util.CamgenConstant;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenRunJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.ParamStationEITimeBandsRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.RunStationEiTimebandJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRun;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.RunStationEiTimeband;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamStationEITimeBand;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamStationEITimeBands;
import com.channel4.mint.automated.spot.service.impl.SnapshotRunDetailsServiceImpl;
import com.channel4.mint.baseexception.MintBaseException;

/**
 * class for handle CamgenRunParamStationEITimeBands db related operations.
 * 
 * @author HCL
 */
@Repository
public class ParamStationEITimeBandsRepositoryImpl implements ParamStationEITimeBandsRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(SnapshotRunDetailsServiceImpl.class);

	@Autowired
	private RunStationEiTimebandJpaRepository runStationEiTimebandJpaRepository;

	@Autowired
	private CamgenRunJpaRepository camgenRunJpaRepository;

	/**
	 * Creates the camgen run param station EI time bands.
	 *
	 * @param stationEiBands
	 *            the station ei bands
	 * @param runId
	 *            the run id
	 */
	@Override
	public void createCamgenRunParamStationEITimeBands(CamgenRunParamStationEITimeBands stationEiBands, Integer runId) {
		LOGGER.info(" >> ParamStationEITimeBandsRepositoryImpl : createCamgenRunParamStationEITimeBands()");
		try {
			List<RunStationEiTimeband> runStationEiTimebandList = mapCamgenRunParamStationEITimeBands(stationEiBands,
					runId);
			runStationEiTimebandJpaRepository.save(runStationEiTimebandList);
		} catch (DataAccessException e) {
			LOGGER.error("Exception during creating CamgenRunParamStationEITimeBands {}", e);
			throw new MintBaseException(CamgenConstant.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		LOGGER.info(" << ParamStationEITimeBandsRepositoryImpl : createCamgenRunParamStationEITimeBands()");
	}

	/**
	 * Map camgen run param station EI time bands.
	 *
	 * @param stationEiBands
	 *            the station ei bands
	 * @param runId
	 *            the run id
	 * @return RunStationEiTimeband
	 */
	private List<RunStationEiTimeband> mapCamgenRunParamStationEITimeBands(
			CamgenRunParamStationEITimeBands stationEiBands, Integer runId) {
		CamgenRun camgenRun = camgenRunJpaRepository.findOne(Long.valueOf(runId));
		if (camgenRun == null) {
			throw new MintBaseException("Data Not Found For Run Id " + runId, HttpStatus.NOT_FOUND.value());
		}

		List<RunStationEiTimeband> runStationEiTimeband = new ArrayList<>();
		stationEiBands.stream().forEach(stationEiBand -> {

			RunStationEiTimeband runStationEiTimebandObj = new RunStationEiTimeband();
			runStationEiTimebandObj.setApplicableDay(stationEiBand.getDayCode());
			runStationEiTimebandObj.setCreatedBy(camgenRun.getCreatedBy());
			runStationEiTimebandObj.setCreatedOn(new Timestamp(System.currentTimeMillis()));
			runStationEiTimebandObj.setStartTime(stationEiBand.getStartTime());
			runStationEiTimebandObj.setEndTime(stationEiBand.getEndTime());
			runStationEiTimebandObj.setCamgenRun(camgenRun);
			runStationEiTimeband.add(runStationEiTimebandObj);
		});

		return runStationEiTimeband;
	}

	/**
	 * Gets the camgen run param station EI time bands.
	 *
	 * @param runId
	 *            the run id
	 * @return CamgenRunParamStationEITimeBands
	 */
	@Override
	public CamgenRunParamStationEITimeBands getCamgenRunParamStationEITimeBands(Integer runId) {
		LOGGER.info(" >> ParamStationEITimeBandsRepositoryImpl : getCamgenRunParamStationEITimeBands()");
		CamgenRun camgenRun = null;
		try {
			camgenRun = camgenRunJpaRepository.findOne(runId.longValue());

			if (null == camgenRun || CollectionUtils.isEmpty(camgenRun.getRunStationEiTimebands())) {
				LOGGER.error(AutomatedSpotConstants.DATA_NOT_FOUND);
				throw new MintBaseException(AutomatedSpotConstants.DATA_NOT_FOUND, HttpStatus.NOT_FOUND.value());
			}

		} catch (DataAccessException e) {
			LOGGER.error("Exception during creating getCamgenRunParamStationEITimeBands {}", e);
			throw new MintBaseException(CamgenConstant.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		LOGGER.info(" << ParamStationEITimeBandsRepositoryImpl : getCamgenRunParamStationEITimeBands()");

		return mapCamgenRunParamStationEITimeBands(camgenRun);
	}

	/**
	 * Map camgen run param station EI time bands.
	 *
	 * @param camgenRun
	 *            the camgen run
	 * @return CamgenRunParamStationEITimeBands
	 */
	private CamgenRunParamStationEITimeBands mapCamgenRunParamStationEITimeBands(CamgenRun camgenRun) {
		CamgenRunParamStationEITimeBands camgenRunParamStationEITimeBands = new CamgenRunParamStationEITimeBands();

		camgenRun.getRunStationEiTimebands().forEach(item -> {
			CamgenRunParamStationEITimeBand camgenRunParamStationEITimeBand = new CamgenRunParamStationEITimeBand();

			camgenRunParamStationEITimeBand.setDayCode(item.getApplicableDay());
			camgenRunParamStationEITimeBand.setEndTime(item.getEndTime());
			camgenRunParamStationEITimeBand.setStartTime(item.getStartTime());
			camgenRunParamStationEITimeBand.setRunParameterStationEITimeBandId(
					Integer.parseInt(String.valueOf(item.getStationEiTimebandId())));

			camgenRunParamStationEITimeBands.add(camgenRunParamStationEITimeBand);
		});

		return camgenRunParamStationEITimeBands;

	}

}
