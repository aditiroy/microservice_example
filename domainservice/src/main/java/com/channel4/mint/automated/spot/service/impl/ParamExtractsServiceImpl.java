package com.channel4.mint.automated.spot.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.ParamExtractsRepository;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamExtracts;
import com.channel4.mint.automated.spot.service.ParamExtractsService;

/**
 * This class is used to perform get and save operation on
 * CamgenRunParamExtracts.
 * 
 * @author HCL
 */
@Service
public class ParamExtractsServiceImpl implements ParamExtractsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExtractParametersServiceImpl.class);

	@Autowired
	private ParamExtractsRepository paramExtractsRepository;

	/**
	 * Gets the camgen run param extracts.
	 *
	 * @param runId
	 *            the run id
	 * @return CamgenRunParamExtracts
	 */
	@Override
	public CamgenRunParamExtracts getCamgenRunParamExtracts(Integer runId) {
		LOGGER.info(">> ParamExtractsServiceImpl: getCamgenRunParamExtracts()");
		return paramExtractsRepository.getCamgenRunParamExtracts(runId);
	}

	/**
	 * Creates the camgen run param extracts.
	 *
	 * @param body
	 *            the body
	 * @param runId
	 *            the run id
	 */
	@Transactional
	@Override
	public void createCamgenRunParamExtracts(CamgenRunParamExtracts body, Integer runId) {
		LOGGER.info(">> ParamExtractsServiceImpl: createCamgenRunParamExtracts()");
		paramExtractsRepository.createCamgenRunParamExtracts(body, runId);
		LOGGER.info(">> ParamExtractsServiceImpl: createCamgenRunParamExtracts()");

	}

}
