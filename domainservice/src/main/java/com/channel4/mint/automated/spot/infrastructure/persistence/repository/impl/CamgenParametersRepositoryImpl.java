package com.channel4.mint.automated.spot.infrastructure.persistence.repository.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.channel4.mint.automated.spot.application.util.CamgenConstant;
import com.channel4.mint.automated.spot.application.util.CamgenParameterMapper;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenParameterJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenParametersRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenParameter;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamEIBands;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParameters;
import com.channel4.mint.baseexception.MintBaseException;

/**
 * class for handle camgen parameters db oprations.
 * 
 * @author HCL
 */
@Service
public class CamgenParametersRepositoryImpl implements CamgenParametersRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(CamgenParametersRepositoryImpl.class);

	@Autowired
	CamgenParameterJpaRepository camgenParameterJpaRepository;

	@Autowired
	private CamgenParameterMapper camgenParameterMapper;

	/**
	 * method for create camgen parameters.
	 *
	 * @param camgenParameterList
	 *            the camgen parameter list
	 */
	@Override
	public void createCamgenParameters(List<CamgenParameter> camgenParameterList) {
		try {
			LOGGER.error(">> ParametersRepositoryImpl.createCamgenParamExtracts ");
			camgenParameterJpaRepository.save(camgenParameterList);
		} catch (DataAccessException e) {
			LOGGER.error("Exception occur crate camgen parameters {} ", e);
			throw new MintBaseException(CamgenConstant.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
	}

	/**
	 * Gets the camgen parameter.
	 *
	 * @param id
	 *            the id
	 * @return CamgenParameter
	 */
	public CamgenParameter getCamgenParameter(Long id) {
		CamgenParameter camgenParameter = null;
		try {
			LOGGER.error(">>ParametersRepositoryImpl.getCamgenParameter ");
			camgenParameter = camgenParameterJpaRepository.findOne(id);

			if (camgenParameter == null) {
				LOGGER.error("Not Found");
				throw new MintBaseException("CamgenExtractParameter is not found", HttpStatus.NOT_FOUND.value());
			}
		} catch (DataAccessException e) {
			LOGGER.error("Exception occur get camgen parameters {} ", e);
			throw new MintBaseException("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		LOGGER.error("<< ParametersRepositoryImpl.getCamgenParameter ");
		return camgenParameter;
	}

	/**
	 * method for get camgen parameters.
	 *
	 * @return CamgenParamEIBands
	 */
	@Override
	public CamgenParamEIBands getAllSnapshots() {
		return new CamgenParamEIBands();
	}

	/**
	 * Gets the camgen parameters.
	 *
	 * @return CamgenParameters
	 */
	@Override
	public CamgenParameters getCamgenParameters() {
		try {
			LOGGER.error(">> ParametersRepositoryImpl.getCamgenParameters ");
			List<CamgenParameter> camgenParameter = camgenParameterJpaRepository.findAll();

			if (CollectionUtils.isEmpty(camgenParameter)) {
				throw new MintBaseException("CamgenParameters is not found", HttpStatus.NOT_FOUND.value());
			}
			return camgenParameterMapper.mapCamgenParamExtracts(camgenParameter);
		} catch (DataAccessException e) {
			LOGGER.error("Exception ", e);
			throw new MintBaseException("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
	}
}
