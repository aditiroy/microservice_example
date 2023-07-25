
package com.channel4.mint.automated.spot.infrastructure.persistence.repository;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRun;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamExtracts;

/**
 * The Interface ParamExtracts Repository.
 * 
 *  @author HCL
 */
public interface ParamExtractsRepository {

	/**
	 * Gets the camgen run param extracts.
	 *
	 * @param runId the run id
	 * @return CamgenRunParamExtracts
	 */
	CamgenRunParamExtracts getCamgenRunParamExtracts(Integer runId);

	/**
	 * Creates the camgen run param extracts.
	 *
	 * @param body the body
	 * @param runId the run id
	 */
	void createCamgenRunParamExtracts(CamgenRunParamExtracts body, Integer runId);
	
	/**
	 * Find run parameter.
	 *
	 * @param runId the run id
	 * @return the camgen run
	 */
	CamgenRun findRunParameter(Integer runId);


}
