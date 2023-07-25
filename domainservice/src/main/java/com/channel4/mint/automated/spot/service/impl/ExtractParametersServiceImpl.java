package com.channel4.mint.automated.spot.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.channel4.mint.automated.spot.application.util.CamgenExtractMapper;
import com.channel4.mint.automated.spot.application.util.DateTimeUtility;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.ParametersRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenExtractParameter;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamExtract;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamExtracts;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParameters;
import com.channel4.mint.automated.spot.service.ExtractParametersService;

/**
 * This class is used to perform get and save operation on ExtractParameters.
 * 
 * @author HCL
 */
@Service
public class ExtractParametersServiceImpl implements ExtractParametersService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExtractParametersServiceImpl.class);

	@Autowired
	private ParametersRepository parametersRepository;

	@Autowired
	CamgenExtractMapper camgenExtractMapper;

	@Autowired
	private DateTimeUtility dateTimeUtility;

	/**
	 * Gets the camgen run parameters.
	 *
	 * @param runId
	 *            the run id
	 * @return CamgenRunParameters
	 */
	@Override
	public CamgenRunParameters getCamgenRunParameters(Integer runId) {
		LOGGER.info(">> ParametersServiceImpl: getCamgenRunParameters()");
		return parametersRepository.getCamgenRunParameters(runId);

	}

	/**
	 * Creates the camgen run parameters.
	 *
	 * @param body
	 *            the body
	 * @param runId
	 *            the run id
	 */
	@Transactional
	@Override
	public void createCamgenRunParameters(CamgenRunParameters body, Integer runId) {
		LOGGER.info(">> ParametersServiceImpl: createCamgenRunParameters()");
		parametersRepository.createCamgenRunParameters(body, runId);
		LOGGER.info("<< ParametersServiceImpl: createCamgenRunParameters()");
	}

	/**
	 * Creates the camgen param extracts.
	 *
	 * @param camgenParamExtracts
	 *            the camgen param extracts
	 */
	@Transactional
	@Override
	public void createCamgenParamExtracts(CamgenParamExtracts camgenParamExtracts) {

		LOGGER.info(">> Service ParametersServiceImpl method createCamgenParamExtracts");
		List<CamgenExtractParameter> camgenExtractParameterRequest = new ArrayList<>();

		for (CamgenParamExtract camgenParamExtract : camgenParamExtracts) {
			CamgenExtractParameter camgenExtractParameter = null;
			if (null == camgenParamExtract.getId()) {
				camgenExtractParameter = new CamgenExtractParameter();
				camgenExtractMapper.mapCamgenExtractMapper(camgenParamExtract, camgenExtractParameter);
				camgenExtractParameter.setCreatedBy(camgenParamExtract.getCreatedBy());
				camgenExtractParameter.setCreatedOn(dateTimeUtility.getCurrentTimeStamp());
			} else {
				camgenExtractParameter = parametersRepository.getCamgenExtractParameter(camgenParamExtract.getId());
				camgenExtractMapper.mapCamgenExtractMapper(camgenParamExtract, camgenExtractParameter);
				camgenExtractParameter.setModifiedBy(camgenParamExtract.getCreatedBy());
				camgenExtractParameter.setModifiedOn(dateTimeUtility.getCurrentTimeStamp());
			}

			camgenExtractParameterRequest.add(camgenExtractParameter);
		}
		if (!CollectionUtils.isEmpty(camgenExtractParameterRequest)) {
			parametersRepository.createCamgenParamExtracts(camgenExtractParameterRequest);
		}
		LOGGER.info("<< ParametersServiceImpl: createCamgenParamExtracts");

	}

	/**
	 * Gets the camgen param extracts.
	 *
	 * @return CamgenParamExtracts
	 */
	@Override
	public CamgenParamExtracts getCamgenParamExtracts() {
		LOGGER.info(">> ParametersServiceImpl: getCamgenParamExtracts()");
		return parametersRepository.getCamgenParamExtracts();
	}

}
