package com.channel4.mint.automated.spot.service;

import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamExtracts;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParameters;

/**
 * The Interface ParametersService used for operation for CamgenRunParameters.
 * 
 * @author HCL
 */
public interface ExtractParametersService {

	/**
	 * Gets the camgen run parameters.
	 *
	 * @param runId
	 *            the run id
	 * @return CamgenRunParameters
	 */
	CamgenRunParameters getCamgenRunParameters(Integer runId);

	/**
	 * Creates the camgen run parameters.
	 *
	 * @param body
	 *            the body
	 * @param runId
	 *            the run id
	 */
	void createCamgenRunParameters(CamgenRunParameters body, Integer runId);

	/**
	 * Creates the camgen param extracts.
	 *
	 * @param body
	 *            the body
	 */
	void createCamgenParamExtracts(CamgenParamExtracts body);

	/**
	 * Gets the camgen param extracts.
	 *
	 * @return the camgen param extracts
	 */
	CamgenParamExtracts getCamgenParamExtracts();

}
