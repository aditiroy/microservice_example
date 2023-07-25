package com.channel4.mint.automated.spot.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.ParamStationTimeBandsRepository;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamStationTimeBands;
import com.channel4.mint.automated.spot.service.ParamStationTimeBandsService;

/**
 * This class is used to perform get and save operation on
 * CamgenRunParamStationTimeBands.
 * 
 * @author HCL
 */
@Service
public class ParamStationTimeBandsServiceImpl implements ParamStationTimeBandsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ParamStationTimeBandsServiceImpl.class);

	@Autowired
	private ParamStationTimeBandsRepository paramStationTimeBandsRepository;

	/**
	 * Gets the camgen run param station EI time bands.
	 *
	 * @param runId
	 *            the run id
	 * @return CamgenRunParamStationTimeBands
	 */
	@Override
	public CamgenRunParamStationTimeBands getCamgenRunParamStationEITimeBands(Integer runId) {
		LOGGER.info(">> ParamStationTimeBandsServiceImpl: getCamgenRunParamStationEITimeBands()");
		return paramStationTimeBandsRepository.getCamgenRunParamStationEITimeBands(runId);
	}

	/**
	 * Creates the camgen run param station time bands.
	 *
	 * @param body
	 *            the body
	 * @param runId
	 *            the run id
	 */
	@Transactional
	@Override
	public void createCamgenRunParamStationTimeBands(CamgenRunParamStationTimeBands body, Integer runId) {
		LOGGER.info(">> ParamStationTimeBandsServiceImpl: createCamgenRunParamStationTimeBands()");
		paramStationTimeBandsRepository.createCamgenRunParamStationTimeBands(body, runId);
		LOGGER.info(">> ParamStationTimeBandsServiceImpl: createCamgenRunParamStationTimeBands()");

	}

}
