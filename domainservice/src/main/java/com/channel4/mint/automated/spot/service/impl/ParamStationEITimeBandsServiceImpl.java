package com.channel4.mint.automated.spot.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.ParamStationEITimeBandsRepository;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamStationEITimeBands;
import com.channel4.mint.automated.spot.service.ParamStationEITimeBandsService;

/**
 * This class is used to perform get and save operation on
 * CamgenRunParamStationEITimeBands.
 * 
 * @author HCL
 */
@Service
public class ParamStationEITimeBandsServiceImpl implements ParamStationEITimeBandsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ParamStationEITimeBandsServiceImpl.class);

	@Autowired
	private ParamStationEITimeBandsRepository paramStationEITimeBandsRepository;

	/**
	 * Creates the camgen run param station EI time bands.
	 *
	 * @param body
	 *            the body
	 * @param runId
	 *            the run id
	 */
	@Transactional
	@Override
	public void createCamgenRunParamStationEITimeBands(CamgenRunParamStationEITimeBands body, Integer runId) {
		LOGGER.info(">> ParamStationEITimeBandsServiceImpl: createCamgenRunParamStationEITimeBands()");
		paramStationEITimeBandsRepository.createCamgenRunParamStationEITimeBands(body, runId);
		LOGGER.info(">> ParamStationEITimeBandsServiceImpl: createCamgenRunParamStationEITimeBands()");
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
		LOGGER.info(">> ParamStationEITimeBandsServiceImpl: getCamgenRunParamStationEITimeBands()");
		return paramStationEITimeBandsRepository.getCamgenRunParamStationEITimeBands(runId);
	}

}
