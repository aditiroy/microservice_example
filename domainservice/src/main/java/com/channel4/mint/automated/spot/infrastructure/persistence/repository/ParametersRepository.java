package com.channel4.mint.automated.spot.infrastructure.persistence.repository;

import java.util.List;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenExtractParameter;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamExtracts;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParameters;

/**
 * The Interface Parameters Repository.
 * 
 *  @author HCL
 */
public interface ParametersRepository {

	/**
	 * Gets the camgen run parameters.
	 *
	 * @param runId the run id
	 * @return CamgenRunParameters
	 */
	CamgenRunParameters getCamgenRunParameters(Integer runId);

	/**
	 * Creates the camgen run parameters.
	 *
	 * @param body            the body
	 * @param runId the run id
	 */
	void createCamgenRunParameters(CamgenRunParameters body, Integer runId);

	/**
	 * Gets the camgen param extracts.
	 *
	 * @return CamgenParamExtracts
	 */
	CamgenParamExtracts getCamgenParamExtracts();

	/**
	 * Gets the camgen extract parameter.
	 *
	 * @param id
	 *            the id
	 * @return CamgenExtractParameter
	 */
	CamgenExtractParameter getCamgenExtractParameter(Long id);

	/**
	 * Creates the camgen param extracts.
	 *
	 * @param camgenExtractParameterRequest
	 *            the camgen extract parameter request
	 */
	void createCamgenParamExtracts(List<CamgenExtractParameter> camgenExtractParameterRequest);

}
