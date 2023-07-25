package com.channel4.mint.automated.spot.infrastructure.persistence.repository;

import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamStationTimeBands;

/**
 * The Interface ParamStationTimeBands Repository.
 * 
 *  @author HCL
 */
public interface ParamStationTimeBandsRepository {

	/**
	 * Gets the camgen run param station EI time bands.
	 *
	 * @param runId the run id
	 * @return CamgenRunParamStationTimeBands
	 */
	CamgenRunParamStationTimeBands getCamgenRunParamStationEITimeBands(Integer runId);

	/**
	 * Creates the camgen run param station time bands.
	 *
	 * @param body the body
	 * @param runId the run id
	 */
	void createCamgenRunParamStationTimeBands(CamgenRunParamStationTimeBands body, Integer runId);

}
