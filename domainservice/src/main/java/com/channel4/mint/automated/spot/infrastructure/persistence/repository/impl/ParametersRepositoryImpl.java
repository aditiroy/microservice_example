package com.channel4.mint.automated.spot.infrastructure.persistence.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.channel4.mint.automated.spot.application.util.AutomatedSpotConstants;
import com.channel4.mint.automated.spot.application.util.CamgenConstant;
import com.channel4.mint.automated.spot.application.util.CamgenExtractMapper;
import com.channel4.mint.automated.spot.application.util.DateTimeUtility;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenExtractParameterJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenRunJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.ParamExtractsRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.ParametersRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.RunParameterJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenExtractParameter;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRun;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.RunParameter;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamExtracts;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParam;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParameters;
import com.channel4.mint.baseexception.MintBaseException;

/**
 * class for handle CamgenExtractParameter db related operations.
 * 
 * @author HCL
 */
@Repository
public class ParametersRepositoryImpl implements ParametersRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(ParametersRepositoryImpl.class);

	@Autowired
	private CamgenExtractMapper camgenExtractMapper;

	@Autowired
	private CamgenExtractParameterJpaRepository camgenExtractParameterJpaRepository;

	@Autowired
	private CamgenRunJpaRepository camgenRunJpaRepository;

	@Autowired
	private RunParameterJpaRepository runParameterJpaRepository;

	@Autowired
	private DateTimeUtility dateTimeUtility;

	@Autowired
	private ParamExtractsRepository paramExtractsRepository;

	/**
	 * Gets the camgen run parameters.
	 *
	 * @param runId
	 *            the run id
	 * @return CamgenRunParameters
	 */
	@Override
	public CamgenRunParameters getCamgenRunParameters(Integer runId) {
		CamgenRun camgenRun = null;

		try {
			LOGGER.info(">> ParametersRepositoryImpl.getCamgenRunParameters()");
			camgenRun = camgenRunJpaRepository.findOne(runId.longValue());
			if (null == camgenRun || CollectionUtils.isEmpty(camgenRun.getRunParameters())) {
				LOGGER.error(AutomatedSpotConstants.DATA_NOT_FOUND);
				throw new MintBaseException(AutomatedSpotConstants.DATA_NOT_FOUND, HttpStatus.NOT_FOUND.value());
			}
		} catch (DataAccessException dae) {
			LOGGER.error(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE, dae);
			throw new MintBaseException(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE,
					HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		return mapCamgenRunParameters(camgenRun);
	}

	/**
	 * Map camgen run parameters.
	 *
	 * @param camgenRun
	 *            the camgen run
	 * @return CamgenRunParameters
	 */
	private CamgenRunParameters mapCamgenRunParameters(CamgenRun camgenRun) {
		CamgenRunParameters camgenRunParameters = new CamgenRunParameters();

		camgenRun.getRunParameters().forEach(item -> {
			CamgenRunParam camgenRunParam = new CamgenRunParam();

			camgenRunParam.setCreatedBy(item.getCreatedBy());
			camgenRunParam.setParameter(item.getParameterName());
			camgenRunParam.setRunParameterId(Integer.parseInt(String.valueOf(item.getParameterId())));
			camgenRunParam.setValue(item.getValue());
			camgenRunParam.setRemarks(item.getDescription());

			camgenRunParameters.add(camgenRunParam);
		});

		return camgenRunParameters;

	}

	/**
	 * Creates the camgen run parameters.
	 *
	 * @param body
	 *            the body
	 * @param runId
	 *            the run id
	 */
	@Override
	public void createCamgenRunParameters(CamgenRunParameters body, Integer runId) {
		try {
			LOGGER.info(">>ParametersRepositoryImpl.createCamgenRunParameters()");
			CamgenRun camgenRun = paramExtractsRepository.findRunParameter(runId);
			List<RunParameter> runParameterRequest = mapCamgenRunParameter(body, camgenRun);
			runParameterJpaRepository.save(runParameterRequest);
		} catch (DataAccessException dae) {
			LOGGER.error(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE, dae);
			throw new MintBaseException(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE,
					HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
	}

	/**
	 * Map camgen run parameter.
	 *
	 * @param camgenRunParameters
	 *            the camgen run parameters
	 * @param camgenRun
	 *            the camgen run
	 * @return RunParameter
	 */
	private List<RunParameter> mapCamgenRunParameter(CamgenRunParameters camgenRunParameters, CamgenRun camgenRun) {
		List<RunParameter> runParameterList = new ArrayList<>();

		for (CamgenRunParam camgenRunParam : camgenRunParameters) {

			RunParameter runParameter = new RunParameter();
			runParameter.setParameterName(camgenRunParam.getParameter());
			runParameter.setValue(camgenRunParam.getValue());
			runParameter.setDescription(camgenRunParam.getRemarks());
			runParameter.setCreatedBy(camgenRunParam.getCreatedBy());
			runParameter.setCreatedOn(dateTimeUtility.getCurrentTimeStamp());
			runParameter.setCamgenRun(camgenRun);

			runParameterList.add(runParameter);
		}
		return runParameterList;
	}

	/**
	 * Creates the camgen param extracts.
	 *
	 * @param camgenExtractParameterList
	 *            the camgen extract parameter list
	 */
	@Override
	public void createCamgenParamExtracts(List<CamgenExtractParameter> camgenExtractParameterList) {
		try {
			LOGGER.info(">> ParametersRepositoryImpl.createCamgenParamExtracts()");
			camgenExtractParameterJpaRepository.save(camgenExtractParameterList);
		} catch (DataAccessException e) {
			LOGGER.error("Exception during creating createCamgenParamExtracts {}", e);
			throw new MintBaseException(CamgenConstant.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
	}

	/**
	 * Gets the camgen param extracts.
	 *
	 * @return CamgenParamExtracts
	 */
	@Override
	public CamgenParamExtracts getCamgenParamExtracts() {
		try {
			LOGGER.error(">>ParametersRepositoryImpl.getCamgenParamExtracts ");
			List<CamgenExtractParameter> camgenExtractParameter = camgenExtractParameterJpaRepository.findAll();

			if (camgenExtractParameter == null) {
				throw new MintBaseException("CamgenExtractParameter is not found", HttpStatus.NOT_FOUND.value());
			}
			return camgenExtractMapper.mapCamgenParamExtracts(camgenExtractParameter);
		} catch (DataAccessException e) {
			LOGGER.error("Exception ", e);
			throw new MintBaseException("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
	}

	/**
	 * Gets the camgen extract parameter.
	 *
	 * @param id
	 *            the id
	 * @return CamgenExtractParameter
	 */
	@Override
	public CamgenExtractParameter getCamgenExtractParameter(Long id) {
		CamgenExtractParameter camgenExtractParameter = null;
		try {
			LOGGER.error(">>ParametersRepositoryImpl.getCamgenParamExtracts ");
			camgenExtractParameter = camgenExtractParameterJpaRepository.findOne(id);
			if (camgenExtractParameter == null) {
				throw new MintBaseException("CamgenExtractParameter is not found", HttpStatus.NOT_FOUND.value());
			}
		} catch (DataAccessException e) {
			LOGGER.error("Exception ", e);
			throw new MintBaseException("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		return camgenExtractParameter;
	}

}
