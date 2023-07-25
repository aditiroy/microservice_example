package com.channel4.mint.automated.spot.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.channel4.mint.automated.spot.application.util.CamgenParameterMapper;
import com.channel4.mint.automated.spot.application.util.DateTimeUtility;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenParametersRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenParameter;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParam;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParameters;
import com.channel4.mint.automated.spot.service.CamgenParametersService;

/**
 * class for handle camgen parameters operations.
 * 
 * @author HCL
 */
@Service
public class CamgenParametersServiceImpl implements CamgenParametersService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CamgenParametersServiceImpl.class);

	@Autowired
	private CamgenParametersRepository camgenParametersRepository;

	@Autowired
	private CamgenParameterMapper camgenParameterMapper;

	@Autowired
	private DateTimeUtility dateTimeUtility;

	/**
	 * method for create camgen parameters.
	 *
	 * @param camgenParameters
	 *            the camgen parameters
	 */
	@Transactional
	@Override
	public void createCamgenParameters(CamgenParameters camgenParameters) {
		LOGGER.info(">> Service CamgenParametersServiceImpl method createCamgenParameters");
		List<CamgenParameter> camgenParameterRequest = new ArrayList<>();

		for (CamgenParam camgenParam : camgenParameters) {
			CamgenParameter camgenParameter = null;
			if (null == camgenParam.getId()) {
				camgenParameter = new CamgenParameter();
				camgenParameterMapper.mapCamgenParameterMapper(camgenParam, camgenParameter);
				camgenParameter.setCreatedBy(camgenParam.getCreatedBy());
				camgenParameter.setCreatedOn(dateTimeUtility.getCurrentTimeStamp());

			} else {
				camgenParameter = camgenParametersRepository.getCamgenParameter(camgenParam.getId());
				camgenParameterMapper.mapCamgenParameterMapper(camgenParam, camgenParameter);
				camgenParameter.setModifiedBy(camgenParam.getCreatedBy());
				camgenParameter.setModifiedOn(dateTimeUtility.getCurrentTimeStamp());
			}

			camgenParameterRequest.add(camgenParameter);
		}

		if (!CollectionUtils.isEmpty(camgenParameterRequest)) {
			camgenParametersRepository.createCamgenParameters(camgenParameterRequest);
		}

		LOGGER.info("<< Service CamgenParametersServiceImpl method createCamgenParameters");
	}

	/**
	 * Gets the camgen parameters.
	 *
	 * @return CamgenParameters
	 */
	@Override
	public CamgenParameters getCamgenParameters() {
		return camgenParametersRepository.getCamgenParameters();
	}

}
