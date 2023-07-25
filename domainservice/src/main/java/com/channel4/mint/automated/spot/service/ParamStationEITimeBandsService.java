package com.channel4.mint.automated.spot.service;

import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamStationEITimeBands;

/**
 * The Interface ParamStationEITimeBandsService used for operation for
 * CamgenRunParamStationEITimeBands.
 * 
 * @author HCL
 */
public interface ParamStationEITimeBandsService {

	/**
	 * Creates the camgen run param station EI time bands.
	 *
	 * @param body
	 *            the body
	 * @param runId
	 *            the run id
	 */
	void createCamgenRunParamStationEITimeBands(CamgenRunParamStationEITimeBands body, Integer runId);

	/**
	 * Gets the camgen run param station EI time bands.
	 *
	 * @param runId
	 *            the run id
	 * @return CamgenRunParamStationEITimeBands
	 */
	CamgenRunParamStationEITimeBands getCamgenRunParamStationEITimeBands(Integer runId);

}
