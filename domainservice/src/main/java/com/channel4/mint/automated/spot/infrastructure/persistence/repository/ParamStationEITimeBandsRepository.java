package com.channel4.mint.automated.spot.infrastructure.persistence.repository;

import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamStationEITimeBands;

/**
 * The Interface ParamStationEITimeBands Repository.
 * 
 *  @author HCL
 */
public interface ParamStationEITimeBandsRepository {

	/**
	 * Creates the camgen run param station EI time bands.
	 *
	 * @param body the body
	 * @param runId the run id
	 */
	void createCamgenRunParamStationEITimeBands(CamgenRunParamStationEITimeBands body, Integer runId);

	/**
	 * Gets the camgen run param station EI time bands.
	 *
	 * @param runId the run id
	 * @return CamgenRunParamStationEITimeBands
	 */
	CamgenRunParamStationEITimeBands getCamgenRunParamStationEITimeBands(Integer runId);

}
