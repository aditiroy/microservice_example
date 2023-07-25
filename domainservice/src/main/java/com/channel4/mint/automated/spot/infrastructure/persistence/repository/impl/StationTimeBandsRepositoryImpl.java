package com.channel4.mint.automated.spot.infrastructure.persistence.repository.impl;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.channel4.mint.automated.spot.application.util.AutomatedSpotConstants;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenStationTimebandJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.StationTimeBandsRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenStationTimeband;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamStationTimeBand;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamStationTimeBands;
import com.channel4.mint.baseexception.MintBaseException;

/**
 * class for handle station time bands db operations.
 * 
 * @author HCL
 */
@Service
public class StationTimeBandsRepositoryImpl implements StationTimeBandsRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(StationTimeBandsRepositoryImpl.class);

	@Autowired
	private CamgenStationTimebandJpaRepository camgenStationTimebandJpaRepository;

	/**
	 * method for create station time bands.
	 *
	 * @param camgenStationTimebandList
	 *            the camgen station timeband list
	 */
	@Override
	public void createCamgenParamStationTimeBands(List<CamgenStationTimeband> camgenStationTimebandList) {
		try {
			LOGGER.info(" << StationEITimeBandsRepositoryImpl : createCamgenParamStationTimeBands()");
			camgenStationTimebandJpaRepository.save(camgenStationTimebandList);
		} catch (DataAccessException e) {
			LOGGER.error("Exception during save station time band {}", e);
			throw new MintBaseException(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE,
					HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
	}

	/**
	 * method for get station time bands.
	 *
	 * @return CamgenParamStationTimeBands
	 */
	@Override
	public CamgenParamStationTimeBands getCamgenParamStationTimeBands() {
		List<CamgenStationTimeband> camgenStationTimebandList = null;

		try {
			camgenStationTimebandList = camgenStationTimebandJpaRepository.findAll();
			if (CollectionUtils.isEmpty(camgenStationTimebandList)) {
				LOGGER.error(AutomatedSpotConstants.DATA_NOT_FOUND);
				throw new MintBaseException(AutomatedSpotConstants.DATA_NOT_FOUND, HttpStatus.NOT_FOUND.value());
			}

		} catch (DataAccessException e) {
			LOGGER.error("Exception during get all station time band {}", e);
			throw new MintBaseException(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE,
					HttpStatus.INTERNAL_SERVER_ERROR.value());
		}

		return mapCamgenParamStationTimeBands(camgenStationTimebandList);
	}

	/**
	 * method for get campgen station time band based on id.
	 *
	 * @param id
	 *            the id
	 * @return CamgenStationTimeband
	 */
	public CamgenStationTimeband getCamgenStationTimeband(Long id) {
		CamgenStationTimeband camgenStationTimeband = null;
		try {
			camgenStationTimeband = camgenStationTimebandJpaRepository.findOne(id);
			if (null == camgenStationTimeband) {
				LOGGER.error(AutomatedSpotConstants.DATA_NOT_FOUND);
				throw new MintBaseException(AutomatedSpotConstants.DATA_NOT_FOUND, HttpStatus.NOT_FOUND.value());
			}

		} catch (DataAccessException e) {
			LOGGER.error("Exception during get station time band {}", e);
			throw new MintBaseException(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE,
					HttpStatus.INTERNAL_SERVER_ERROR.value());
		}

		return camgenStationTimeband;
	}

	/**
	 * Map camgen param station time bands.
	 *
	 * @param camgenStationTimebandList
	 *            the camgen station timeband list
	 * @return the camgen param station time bands
	 */
	private CamgenParamStationTimeBands mapCamgenParamStationTimeBands(
			List<CamgenStationTimeband> camgenStationTimebandList) {
		CamgenParamStationTimeBands camgenParamStationTimeBands = new CamgenParamStationTimeBands();

		for (CamgenStationTimeband camgenStationTimeband : camgenStationTimebandList) {
			CamgenParamStationTimeBand camgenParamStationTimeBand = new CamgenParamStationTimeBand();

			camgenParamStationTimeBand.setChannelId(camgenStationTimeband.getChannelId().intValue());
			camgenParamStationTimeBand.setId(camgenStationTimeband.getStationTimebandId());
			camgenParamStationTimeBand.setName(camgenStationTimeband.getTimeband());
			camgenParamStationTimeBand
					.setExcludeFlag(camgenStationTimeband.getIsExclude() == new BigDecimal(1) ? true : false);
			camgenParamStationTimeBand.setDayCode(camgenStationTimeband.getApplicableDay());
			camgenParamStationTimeBand.setStartTime(camgenStationTimeband.getStartTime());
			camgenParamStationTimeBand.setEndTime(camgenStationTimeband.getEndTime());
			camgenParamStationTimeBand.setEiCutOff(camgenStationTimeband.getEiCutOff().intValue());
			camgenParamStationTimeBand
					.setTbProgRepetitionLimit(camgenStationTimeband.getTbProgRepititionLimit().intValue());
			camgenParamStationTimeBand.setAmendDemand(camgenStationTimeband.getAmendDemand().intValue());
			camgenParamStationTimeBand.setCreatedBy(camgenStationTimeband.getCreatedBy());

			camgenParamStationTimeBands.add(camgenParamStationTimeBand);
		}

		return camgenParamStationTimeBands;

	}
}
