package com.channel4.mint.automated.spot.service;

import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamExtracts;

/**
 * The Interface ParamExtractsService used for operation for
 * CamgenRunParamExtracts.
 * 
 * @author HCL
 */
public interface ParamExtractsService {

	/**
	 * Gets the camgen run param extracts.
	 *
	 * @param runId
	 *            the run id
	 * @return CamgenRunParamExtracts
	 */
	CamgenRunParamExtracts getCamgenRunParamExtracts(Integer runId);

	/**
	 * Creates the camgen run param extracts.
	 *
	 * @param body
	 *            the body
	 * @param runId
	 *            the run id
	 */
	void createCamgenRunParamExtracts(CamgenRunParamExtracts body, Integer runId);

}
