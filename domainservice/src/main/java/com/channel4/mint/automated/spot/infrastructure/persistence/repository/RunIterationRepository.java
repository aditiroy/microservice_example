package com.channel4.mint.automated.spot.infrastructure.persistence.repository;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRun;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunIterations;

/**
 * The Interface RunIteration Repository.
 * 
 *  @author HCL
 */
public interface RunIterationRepository {

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

	/**
	 * Find camgen run.
	 *
	 * @param camgenRunIterations
	 *            the camgen run iterations
	 * @return CamgenRun
	 */
	CamgenRun findCamgenRun(com.channel4.mint.automated.spot.interfaces.dto.CamgenRunIteration camgenRunIterations);

}
