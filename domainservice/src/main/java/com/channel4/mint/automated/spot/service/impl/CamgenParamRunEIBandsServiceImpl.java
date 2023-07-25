package com.channel4.mint.automated.spot.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenRunParamEIBandsRepository;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamEIBands;
import com.channel4.mint.automated.spot.service.CamgenParamRunEIBandsService;

/**
 * This class is used to perform get and save operation on
 * createCamgenRunParamEIBands.
 * 
 * @author HCL
 */
@Service
public class CamgenParamRunEIBandsServiceImpl implements CamgenParamRunEIBandsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CamgenParamRunEIBandsServiceImpl.class);

	@Autowired
	private CamgenRunParamEIBandsRepository camgenParamEIBandsRepository;

	/**
	 * Creates the camgen run param EI bands.
	 *
	 * @param body
	 *            the body
	 * @param runId
	 *            the run id
	 */
	@Transactional
	@Override
	public void createCamgenRunParamEIBands(CamgenRunParamEIBands body, Integer runId) {
		LOGGER.info(">> CamgenParamEIBandsServiceImpl: createCamgenRunParamEIBands()");
		camgenParamEIBandsRepository.createCamgenRunParamEIBands(body, runId);
		LOGGER.info("<< CamgenParamEIBandsServiceImpl: createCamgenRunParamEIBands()");
	}

	/**
	 * Gets the camgen run param EI bands.
	 *
	 * @param runId
	 *            the run id
	 * @return CamgenRunParamEIBands
	 */
	@Override
	public CamgenRunParamEIBands getCamgenRunParamEIBands(Integer runId) {
		LOGGER.info(">> CamgenParamEIBandsServiceImpl: getCamgenRunParamEIBands()");
		return camgenParamEIBandsRepository.getCamgenRunParamEIBands(runId);
	}

}
