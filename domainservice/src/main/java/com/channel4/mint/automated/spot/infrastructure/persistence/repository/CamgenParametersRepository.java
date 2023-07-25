package com.channel4.mint.automated.spot.infrastructure.persistence.repository;

import java.util.List;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenParameter;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamEIBands;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParameters;

/**
 * The Interface CamgenParameters Repository.
 * 
 *  @author HCL
 */
public interface CamgenParametersRepository {

	/**
	 * method for create camgen parameters.
	 *
	 * @param camgenParameterList
	 *            the camgen parameter list
	 */
	void createCamgenParameters(List<CamgenParameter> camgenParameterList);

	/**
	 * method for get camgen parameters.
	 *
	 * @return CamgenParamEIBands
	 */
	CamgenParamEIBands getAllSnapshots();

	/**
	 * Gets the camgen parameter.
	 *
	 * @param id
	 *            the id
	 * @return CamgenParameter
	 */
	CamgenParameter getCamgenParameter(Long id);

	/**
	 * Gets the camgen parameters.
	 *
	 * @return CamgenParameters
	 */
	CamgenParameters getCamgenParameters();

}
