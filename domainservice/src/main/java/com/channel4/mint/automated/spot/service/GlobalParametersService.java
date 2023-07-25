package com.channel4.mint.automated.spot.service;

import com.channel4.mint.automated.spot.interfaces.dto.CamgenGlobalParametersRequest;

/**
 * The Interface GlobalParametersService used for operation for
 * GlobalParameters.
 * 
 * @author HCL
 */
public interface GlobalParametersService {

	/**
	 * Update global parameters.
	 *
	 * @param body
	 *            the body
	 */
	void updateGlobalParameters(CamgenGlobalParametersRequest body);

}
