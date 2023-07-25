package com.channel4.mint.automated.spot.infrastructure.persistence.repository.impl;

import java.math.BigDecimal;
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
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenRunParamEIBandsRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.ParamExtractsRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.RunEiBandJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRun;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.RunEiBand;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamEIBand;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamEIBands;
import com.channel4.mint.baseexception.MintBaseException;

/**
 * class for handle CamgenRunParamEIBands db related operations.
 * 
 * @author HCL
 */
@Repository
public class CamgenRunParamEIBandsRepositoryImpl implements CamgenRunParamEIBandsRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(ParamStationEITimeBandsRepositoryImpl.class);

	@Autowired
	private CamgenRunJpaRepository camgenRunJpaRepository;

	@Autowired
	private RunEiBandJpaRepository runEiBandJpaRepository;

	@Autowired
	private DateTimeUtility dateTimeUtility;

	@Autowired
	private ParamExtractsRepository paramExtractsRepository;

	/**
	 * Creates the camgen run param EI bands.
	 *
	 * @param body
	 *            the body
	 * @param runId
	 *            the run id
	 */
	@Override
	public void createCamgenRunParamEIBands(CamgenRunParamEIBands body, Integer runId) {
		try {
			LOGGER.info(">>CamgenRunParamEIBandsRepositoryImpl.createCamgenRunParamEIBands()");
			CamgenRun camgenRun = paramExtractsRepository.findRunParameter(runId);

			List<RunEiBand> runParameterRequest = mapRunEiBand(body, camgenRun);
			runEiBandJpaRepository.save(runParameterRequest);
		} catch (DataAccessException dae) {
			LOGGER.error(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE, dae);
			throw new MintBaseException(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE,
					HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
	}

	/**
	 * Map run ei band.
	 *
	 * @param camgenRunParamEIBands
	 *            the camgen run param EI bands
	 * @param camgenRun
	 *            the camgen run
	 * @return RunEiBand
	 */
	private List<RunEiBand> mapRunEiBand(CamgenRunParamEIBands camgenRunParamEIBands, CamgenRun camgenRun) {
		List<RunEiBand> runEiBandList = new ArrayList<>();
		for (CamgenRunParamEIBand camgenRunParamEIBand : camgenRunParamEIBands) {
			RunEiBand runEiBand = new RunEiBand();

			runEiBand.setEiBand(new BigDecimal(camgenRunParamEIBand.getEiBand()));
			runEiBand.setCreatedOn(dateTimeUtility.getCurrentTimeStamp());
			runEiBand.setCreatedBy(camgenRunParamEIBand.getCreatedBy());
			runEiBand.setCamgenRun(camgenRun);
			runEiBandList.add(runEiBand);
		}
		return runEiBandList;
	}

	/**
	 * Gets the camgen run param EI bands.
	 *
	 * @param runId
	 *            the run id
	 * @return CamgenRunParamEIBands
	 */
	@Override
	public CamgenRunParamEIBands getCamgenRunParamEIBands(Integer runId) {
		CamgenRun camgenRun = null;
		try {
			LOGGER.info(">>CamgenRunParamEIBandsRepositoryImpl.getCamgenRunParamEIBands()");
			camgenRun = camgenRunJpaRepository.findOne(runId.longValue());

			if (null == camgenRun || CollectionUtils.isEmpty(camgenRun.getRunEiBands())) {
				LOGGER.error(AutomatedSpotConstants.DATA_NOT_FOUND);
				throw new MintBaseException(AutomatedSpotConstants.DATA_NOT_FOUND, HttpStatus.NOT_FOUND.value());
			}
		} catch (DataAccessException dae) {
			LOGGER.error(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE, dae);
			throw new MintBaseException(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE,
					HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		LOGGER.info("<< CamgenRunParamEIBandsRepositoryImpl.getCamgenRunParamEIBands()");
		return mapCamgenRunParamEIBands(camgenRun);
	}

	/**
	 * Map camgen run param EI bands.
	 *
	 * @param camgenRun
	 *            the camgen run
	 * @return CamgenRunParamEIBands
	 */
	private CamgenRunParamEIBands mapCamgenRunParamEIBands(CamgenRun camgenRun) {
		CamgenRunParamEIBands camgenRunParamEIBands = new CamgenRunParamEIBands();

		camgenRun.getRunEiBands().forEach(item -> {
			CamgenRunParamEIBand camgenRunParamEIBand = new CamgenRunParamEIBand();

			camgenRunParamEIBand.setCreatedBy(item.getCreatedBy());
			camgenRunParamEIBand.setEiBand(Integer.parseInt(String.valueOf(item.getEiBand())));
			camgenRunParamEIBand.setRunParameterEIBandId(Integer.parseInt(String.valueOf(item.getEiBandId())));

			camgenRunParamEIBands.add(camgenRunParamEIBand);
		});

		return camgenRunParamEIBands;

	}

}
