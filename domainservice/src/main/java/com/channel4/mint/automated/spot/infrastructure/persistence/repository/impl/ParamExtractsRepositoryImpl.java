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
import com.channel4.mint.automated.spot.application.util.DateTimeUtility;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenRunJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.ParamExtractsRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.RunExtractParameterJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRun;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.RunExtractParameter;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamExtract;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamExtracts;
import com.channel4.mint.baseexception.MintBaseException;

/**
 * class for handle CamgenRunParamExtracts db related operations.
 * 
 * @author HCL
 */
@Repository
public class ParamExtractsRepositoryImpl implements ParamExtractsRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(ParametersRepositoryImpl.class);

	@Autowired
	private RunExtractParameterJpaRepository runExtractParameterJpaRepository;

	@Autowired
	private CamgenRunJpaRepository camgenRunJpaRepository;

	@Autowired
	private DateTimeUtility dateTimeUtility;

	/**
	 * Gets the camgen run param extracts.
	 *
	 * @param runId
	 *            the run id
	 * @return CamgenRunParamExtracts
	 */
	@Override
	public CamgenRunParamExtracts getCamgenRunParamExtracts(Integer runId) {
		CamgenRun camgenRun = null;
		try {
			LOGGER.info(">> ParamExtractsRepositoryImpl.getCamgenRunParamExtracts()");
			camgenRun = camgenRunJpaRepository.findOne(runId.longValue());
			if (null == camgenRun || CollectionUtils.isEmpty(camgenRun.getRunExtractParameters())) {
				LOGGER.error(AutomatedSpotConstants.DATA_NOT_FOUND);
				throw new MintBaseException(AutomatedSpotConstants.DATA_NOT_FOUND, HttpStatus.NOT_FOUND.value());
			}
		} catch (DataAccessException dae) {
			LOGGER.error(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE, dae);
			throw new MintBaseException(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE,
					HttpStatus.INTERNAL_SERVER_ERROR.value());
		}

		return mapCamgenRunParamExtracts(camgenRun);
	}

	/**
	 * Map camgen run param extracts.
	 *
	 * @param camgenRun
	 *            the camgen run
	 * @return the camgen run param extracts
	 */
	private CamgenRunParamExtracts mapCamgenRunParamExtracts(CamgenRun camgenRun) {
		CamgenRunParamExtracts camgenRunParamExtracts = new CamgenRunParamExtracts();

		camgenRun.getRunExtractParameters().forEach(item -> {
			CamgenRunParamExtract camgenRunParamExtract = new CamgenRunParamExtract();

			camgenRunParamExtract.setCreatedBy(item.getCreatedBy());
			camgenRunParamExtract.setRunParameterExtractId(Integer.parseInt(String.valueOf(item.getExtractParameterId())));
			camgenRunParamExtract.setParameter(item.getExtractParameterName());
			camgenRunParamExtract.setValue(item.getValue());

			camgenRunParamExtracts.add(camgenRunParamExtract);
		});

		return camgenRunParamExtracts;

	}

	/**
	 * Creates the camgen run param extracts.
	 *
	 * @param body
	 *            the body
	 * @param runId
	 *            the run id
	 */
	@Override
	public void createCamgenRunParamExtracts(CamgenRunParamExtracts body, Integer runId) {
		try {
			LOGGER.info(">> ParamExtractsRepositoryImpl.createCamgenRunParamExtracts()");
			CamgenRun camgenRun = findRunParameter(runId);
			List<RunExtractParameter> runExtractParameterRequest = mapRunExtractParameter(body, camgenRun);
			runExtractParameterJpaRepository.save(runExtractParameterRequest);
		} catch (DataAccessException dae) {
			LOGGER.error(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE, dae);
			throw new MintBaseException(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE,
					HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
	}

	/**
	 * Map run extract parameter.
	 *
	 * @param camgenRunParamExtracts
	 *            the camgen run param extracts
	 * @param camgenRun
	 *            the camgen run
	 * @return RunExtractParameter
	 */
	private List<RunExtractParameter> mapRunExtractParameter(CamgenRunParamExtracts camgenRunParamExtracts,
			CamgenRun camgenRun) {
		List<RunExtractParameter> runExtractParameterList = new ArrayList<>();

		for (CamgenRunParamExtract camgenRunParamExtract : camgenRunParamExtracts) {
			RunExtractParameter runExtractParameter = new RunExtractParameter();

			runExtractParameter.setValue(camgenRunParamExtract.getValue());
			runExtractParameter.setExtractParameterName(camgenRunParamExtract.getParameter());
			runExtractParameter.setCreatedOn(dateTimeUtility.getCurrentTimeStamp());
			runExtractParameter.setCreatedBy(camgenRunParamExtract.getCreatedBy());
			runExtractParameter.setCamgenRun(camgenRun);

			runExtractParameterList.add(runExtractParameter);
		}

		return runExtractParameterList;
	}

	/**
	 * Find run parameter.
	 *
	 * @param runId
	 *            the run id
	 * @return CamgenRun
	 */
	@Override
	public CamgenRun findRunParameter(Integer runId) {
		CamgenRun camgenRun = null;
		try {
			LOGGER.info(">> ParamExtractsRepositoryImpl.findRunParameter()");
			camgenRun = camgenRunJpaRepository.findOne(runId.longValue());
			if (null == camgenRun) {
				LOGGER.info("camgen Request not found ");
				throw new MintBaseException(AutomatedSpotConstants.DATA_NOT_FOUND, HttpStatus.NOT_FOUND.value());
			}
		} catch (DataAccessException dae) {
			LOGGER.error(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE, dae);
			throw new MintBaseException(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE,
					HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		LOGGER.info("<<ParamExtractsRepositoryImpl.findRunParameter()");
		return camgenRun;
	}

}
