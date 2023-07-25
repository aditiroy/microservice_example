package com.channel4.mint.automated.spot.infrastructure.persistence.repository.impl;

import java.math.BigDecimal;
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
import com.channel4.mint.automated.spot.application.util.DateTimeUtility;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenRunJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.ParamStationTimeBandsRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.RunStationTimebandJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRun;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.RunStationTimeband;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamStationTimeBand;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamStationTimeBands;
import com.channel4.mint.baseexception.MintBaseException;

/**
 * class for handle CamgenRunParamStationTimeBands db related operations.
 * 
 * @author HCL
 */
@Repository
public class ParamStationTimeBandsRepositoryImpl implements ParamStationTimeBandsRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(ParamStationTimeBandsRepositoryImpl.class);

	@Autowired
	private RunStationTimebandJpaRepository runStationTimebandJpaRepository;

	@Autowired
	private CamgenRunJpaRepository camgenRunJpaRepository;

	@Autowired
	private DateTimeUtility dateTimeUtility;

	/**
	 * Gets the camgen run param station EI time bands.
	 *
	 * @param runId
	 *            the run id
	 * @return CamgenRunParamStationTimeBands
	 */
	@Override
	public CamgenRunParamStationTimeBands getCamgenRunParamStationEITimeBands(Integer runId) {
		LOGGER.info(">> ParamStationTimeBandsRepositoryImpl : getCamgenRunParamStationEITimeBands()");
		CamgenRun camgenRun = null;
		try {
			camgenRun = camgenRunJpaRepository.findOne(runId.longValue());

			if (null == camgenRun || CollectionUtils.isEmpty(camgenRun.getRunStationTimebands())) {
				LOGGER.error(AutomatedSpotConstants.DATA_NOT_FOUND);
				throw new MintBaseException(AutomatedSpotConstants.DATA_NOT_FOUND, HttpStatus.NOT_FOUND.value());
			}
		} catch (DataAccessException e) {
			LOGGER.error("Exception during creating getCamgenRunParamStationEITimeBands {}", e);
			throw new MintBaseException(CamgenConstant.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		LOGGER.info(">> ParamStationTimeBandsRepositoryImpl : mapCamgenRunParamStationTimeBands()");
		return mapCamgenRunParamStationTimeBands(camgenRun);
	}

	/**
	 * Map camgen run param station time bands.
	 *
	 * @param camgenRun
	 *            the camgen run
	 * @return CamgenRunParamStationTimeBands
	 */
	private CamgenRunParamStationTimeBands mapCamgenRunParamStationTimeBands(CamgenRun camgenRun) {
		CamgenRunParamStationTimeBands camgenRunParamStationTimeBands = new CamgenRunParamStationTimeBands();

		camgenRun.getRunStationTimebands().forEach(item -> {
			CamgenRunParamStationTimeBand camgenRunParamStationTimeBand = new CamgenRunParamStationTimeBand();

			setCamgenRunParamSatationTimeBand(item, camgenRunParamStationTimeBand);

			mapCamgenRunParamStationTimeBand(camgenRun, item, camgenRunParamStationTimeBand);

			camgenRunParamStationTimeBands.add(camgenRunParamStationTimeBand);
		});

		return camgenRunParamStationTimeBands;

	}

	/**
	 * Sets the camgen run param satation time band.
	 *
	 * @param item
	 *            the item
	 * @param camgenRunParamStationTimeBand
	 *            the camgen run param station time band
	 */
	private void setCamgenRunParamSatationTimeBand(RunStationTimeband item,
			CamgenRunParamStationTimeBand camgenRunParamStationTimeBand) {
		camgenRunParamStationTimeBand.setAmendDemand(Integer.parseInt(String.valueOf(item.getAmendDemand())));
		camgenRunParamStationTimeBand.setChannelId(Integer.parseInt(String.valueOf(item.getChannelId())));
		camgenRunParamStationTimeBand.setDayCode(item.getApplicableDay());
		camgenRunParamStationTimeBand.setEiCutOff(Integer.parseInt(String.valueOf(item.getEiCutOff())));

		if (null != item.getIsExclude()) {
			camgenRunParamStationTimeBand.setExcludeFlag(item.getIsExclude() == new BigDecimal(1) ? "true" : "false");
		}
	}

	/**
	 * Map camgen run param station time band.
	 *
	 * @param camgenRun
	 *            the camgen run
	 * @param item
	 *            the item
	 * @param camgenRunParamStationTimeBand
	 *            the camgen run param station time band
	 */
	private void mapCamgenRunParamStationTimeBand(CamgenRun camgenRun, RunStationTimeband item,
			CamgenRunParamStationTimeBand camgenRunParamStationTimeBand) {
		camgenRunParamStationTimeBand.setEndTime(item.getEndTime());
		camgenRunParamStationTimeBand.setStationTimeBandId(Integer.parseInt(String.valueOf(item.getStationTimebandId())));
		camgenRunParamStationTimeBand.setName(item.getTimeband());
		camgenRunParamStationTimeBand.setStartTime(item.getStartTime());
		camgenRunParamStationTimeBand
				.setStationTimeBandId(Integer.parseInt(String.valueOf(item.getStationTimebandId())));
		camgenRunParamStationTimeBand
				.setTbProgRepetitionLimit(Integer.parseInt(String.valueOf(item.getTbProgRepititionLimit())));
	}

	/**
	 * Creates the camgen run param station time bands.
	 *
	 * @param camgenRunParamStationTimeBands
	 *            the camgen run param station time bands
	 * @param runId
	 *            the run id
	 */
	@Override
	public void createCamgenRunParamStationTimeBands(CamgenRunParamStationTimeBands camgenRunParamStationTimeBands,
			Integer runId) {

		LOGGER.info(">> ParamStationTimeBandsRepositoryImpl : createCamgenRunParamStationTimeBands()");
		try {
			List<RunStationTimeband> runStationEiTimebandList = mapCamgenRunParamStationTimeBands(
					camgenRunParamStationTimeBands, runId);
			runStationTimebandJpaRepository.save(runStationEiTimebandList);
		} catch (DataAccessException e) {
			LOGGER.error("Exception during creating CamgenRunParamStationEITimeBands {}", e);
			throw new MintBaseException(CamgenConstant.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		LOGGER.info("<< ParamStationTimeBandsRepositoryImpl : createCamgenRunParamStationTimeBands()");
	}

	/**
	 * Map camgen run param station time bands.
	 *
	 * @param camgenRunParamStationTimeBands
	 *            the camgen run param station time bands
	 * @param runId
	 *            the run id
	 * @return RunStationTimeband
	 */
	private List<RunStationTimeband> mapCamgenRunParamStationTimeBands(
			CamgenRunParamStationTimeBands camgenRunParamStationTimeBands, Integer runId) {

		CamgenRun camgenRun = camgenRunJpaRepository.findOne(Long.valueOf(runId));
		if (camgenRun == null) {
			throw new MintBaseException("Data Not Found For Run Id " + runId, HttpStatus.NOT_FOUND.value());
		}

		List<RunStationTimeband> runStationTimeBandList = new ArrayList<>();
		camgenRunParamStationTimeBands.stream().forEach(stationTimeBands -> {

			RunStationTimeband runStationTimeband = new RunStationTimeband();
			runStationTimeband.setAmendDemand(BigDecimal.valueOf(stationTimeBands.getAmendDemand()));
			runStationTimeband.setApplicableDay(stationTimeBands.getDayCode());
			runStationTimeband.setCamgenRun(camgenRun);
			runStationTimeband.setChannelId(BigDecimal.valueOf(stationTimeBands.getChannelId()));
			runStationTimeband.setCreatedBy(stationTimeBands.getCreatedBy());
			runStationTimeband.setCreatedOn(dateTimeUtility.getCurrentTimeStamp());
			runStationTimeband.setEiCutOff(BigDecimal.valueOf(stationTimeBands.getEiCutOff()));
			runStationTimeband.setEndTime(stationTimeBands.getEndTime());
			runStationTimeband.setIsExclude(
					"true".equals(stationTimeBands.getExcludeFlag()) ? new BigDecimal(1) : new BigDecimal(0));
			runStationTimeband.setStartTime(stationTimeBands.getStartTime());
			runStationTimeband.setStationTimebandId(stationTimeBands.getStationTimeBandId());
			runStationTimeband
					.setTbProgRepititionLimit(BigDecimal.valueOf(stationTimeBands.getTbProgRepetitionLimit()));
			runStationTimeband.setTimeband(stationTimeBands.getName());
			runStationTimeBandList.add(runStationTimeband);
		});

		return runStationTimeBandList;
	}

}
