package com.channel4.mint.automated.spot.infrastructure.persistence.repository;

import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamEIBands;

/**
 * The Interface CamgenRunParamEIBands Repository.
 * 
 *  @author HCL
 */
public interface CamgenRunParamEIBandsRepository {

	/**
	 * Creates the camgen run param EI bands.
	 *
	 * @param body the body
	 * @param runId the run id
	 */
	void createCamgenRunParamEIBands(CamgenRunParamEIBands body, Integer runId);

	/**
	 * Gets the camgen run param EI bands.
	 *
	 * @param runId the run id
	 * @return CamgenRunParamEIBands
	 */
	CamgenRunParamEIBands getCamgenRunParamEIBands(Integer runId);

}
