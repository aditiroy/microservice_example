package com.channel4.mint.automated.spot.service;

import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamEIBands;

/**
 * The Interface CamgenParamEIBandsService used for opertion of
 * CamgenParamEIBands.
 * 
 * @author HCL
 */
public interface CamgenParamEIBandsService {

	/**
	 * Creates the camgen parameters.
	 *
	 * @param camgenParamEIBandsRequest
	 *            the camgen param EI bands request
	 */
	void createCamgenParameters(CamgenParamEIBands camgenParamEIBandsRequest);

	/**
	 * Gets the camgen param EI bands.
	 *
	 * @return CamgenParamEIBands
	 */
	CamgenParamEIBands getCamgenParamEIBands();

}
