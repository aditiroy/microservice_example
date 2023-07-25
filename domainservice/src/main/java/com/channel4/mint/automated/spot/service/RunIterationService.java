package com.channel4.mint.automated.spot.service;

import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunIterations;

/**
 * The Interface RunIterationService used for operation for CamgenRunIterations.
 * 
 * @author HCL
 */
public interface RunIterationService {

	/**
	 * method for create new run iteration.
	 *
	 * @param camgenRunIterations
	 *            the camgen run iterations
	 */
	void createCamgenRunIterations(CamgenRunIterations camgenRunIterations);

	/**
	 * method for get camgen run iteration based on run id.
	 *
	 * @param runId
	 *            the run id
	 * @return CamgenRunIterations
	 */
	CamgenRunIterations getCamgenRunIterations(Integer runId);
}
