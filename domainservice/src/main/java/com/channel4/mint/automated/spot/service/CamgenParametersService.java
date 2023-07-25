/*
 * 
 */
package com.channel4.mint.automated.spot.service;

import com.channel4.mint.automated.spot.interfaces.dto.CamgenParameters;

/**
 * The Interface CamgenParametersService.
 */
public interface CamgenParametersService {

	/**
	 * method for create camgen parameters.
	 *
	 * @param camgenParameters
	 *            the camgen parameters
	 */
	void createCamgenParameters(CamgenParameters camgenParameters);

	/**
	 * Gets the camgen parameters.
	 *
	 * @return CamgenParameters
	 */
	CamgenParameters getCamgenParameters();

}
