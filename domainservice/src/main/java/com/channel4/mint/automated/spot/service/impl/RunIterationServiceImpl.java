
package com.channel4.mint.automated.spot.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.RunIterationRepository;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunIterations;
import com.channel4.mint.automated.spot.service.RunIterationService;

/**
 * class for handle run iteration.
 * 
 * @author HCL
 */
@Service
public class RunIterationServiceImpl implements RunIterationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(RunIterationServiceImpl.class);

	@Autowired
	private RunIterationRepository runIterationRepository;

	/**
	 * method for create new run iteration.
	 *
	 * @param camgenRunIterations
	 *            the camgen run iterations
	 */
	@Transactional
	@Override
	public void createCamgenRunIterations(CamgenRunIterations camgenRunIterations) {
		LOGGER.info(">> Service RunIterationServiceImpl method createCamgenRunIterations");
		runIterationRepository.createCamgenRunIterations(camgenRunIterations);
		LOGGER.info("<< Service RunIterationServiceImpl method createCamgenRunIterations");
	}

	/**
	 * method for get camgen run iteration based on run id.
	 *
	 * @param runId
	 *            the run id
	 * @return CamgenRunIterations
	 */
	@Override
	public CamgenRunIterations getCamgenRunIterations(Integer runId) {
		LOGGER.info(">> Service RunIterationServiceImpl method getCamgenRunIterations");
		return runIterationRepository.getCamgenRunIterations(runId);
	}

}
