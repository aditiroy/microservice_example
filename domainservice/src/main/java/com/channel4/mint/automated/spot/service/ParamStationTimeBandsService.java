package com.channel4.mint.automated.spot.service;

import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamStationTimeBands;

/**
 * The Interface ParamStationTimeBandsService used for operation for
 * CamgenRunParamStationTimeBands.
 * 
 * @author HCL
 */
public interface ParamStationTimeBandsService {

	/**
	 * Gets the camgen run param station EI time bands.
	 *
	 * @param runId
	 *            the run id
	 * @return CamgenRunParamStationTimeBands
	 */
	CamgenRunParamStationTimeBands getCamgenRunParamStationEITimeBands(Integer runId);

	/**
	 * Creates the camgen run param station time bands.
	 *
	 * @param body
	 *            the body
	 * @param runId
	 *            the run id
	 */
	void createCamgenRunParamStationTimeBands(CamgenRunParamStationTimeBands body, Integer runId);

}
