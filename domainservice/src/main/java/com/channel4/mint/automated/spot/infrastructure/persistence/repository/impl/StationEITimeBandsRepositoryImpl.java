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
import com.channel4.mint.automated.spot.application.util.StationEITimeBandsMapper;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenStationEiTimebandJPARepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.StationEITimeBandsRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenStationEiTimeband;
import com.channel4.mint.automated.spot.interfaces.controller.impl.CamgenApiController;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamStationEITimeBands;
import com.channel4.mint.baseexception.MintBaseException;

/**
 * class for handle station eli time bands db operations.
 * 
 * @author HCL
 */
@Service
public class StationEITimeBandsRepositoryImpl implements StationEITimeBandsRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(CamgenApiController.class);

	@Autowired
	private CamgenStationEiTimebandJPARepository camgenStationEiTimebandJPARepository;

	@Autowired
	private StationEITimeBandsMapper stationEITimeBandsMapper;

	/**
	 * method for create station eli time bands.
	 *
	 * @param camgenStationEiTimebandList
	 *            the camgen station ei timeband list
	 */
	@Override
	public void createCamgenParamStationEITimeBands(List<CamgenStationEiTimeband> camgenStationEiTimebandList) {
		LOGGER.info(" >> StationEITimeBandsRepositoryImpl : createCamgenParamStationEITimeBands()");
		try {
			camgenStationEiTimebandJPARepository.save(camgenStationEiTimebandList);
		} catch (DataAccessException e) {
			LOGGER.error("Exception during creating CamgenParamStationEITimeBands {}", e);
			throw new MintBaseException(CamgenConstant.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
	}

	/**
	 * method for get station eli time bands.
	 *
	 * @return CamgenParamStationEITimeBands
	 */
	public CamgenParamStationEITimeBands getCamgenParamStationEITimeBands() {
		CamgenParamStationEITimeBands camgenParamStationEITimeBands = null;
		try {
			LOGGER.info(" >> StationEITimeBandsRepositoryImpl : getCamgenParamStationEITimeBands()");
			List<CamgenStationEiTimeband> listOfCamgenStationEiTimeband = camgenStationEiTimebandJPARepository
					.findAll();
			if (CollectionUtils.isEmpty(listOfCamgenStationEiTimeband)) {
				throw new MintBaseException("Data Not Found", HttpStatus.NOT_FOUND.value());
			}
			camgenParamStationEITimeBands = stationEITimeBandsMapper
					.mapEntityListToCamgenParamStationEITimeBands(listOfCamgenStationEiTimeband);
		} catch (DataAccessException e) {
			LOGGER.error("Exception during getting CamgenParamStationEITimeBands {}", e);
			throw new MintBaseException("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		return camgenParamStationEITimeBands;
	}

	/**
	 * finds CamgenParamStationEITimeBand.
	 *
	 * @param id
	 *            the id
	 * @return CamgenParamStationEITimeBand
	 */
	@Override
	public CamgenStationEiTimeband findCamgenParamStationEITimeBand(Long id) {
		LOGGER.info(" >> StationEITimeBandsRepositoryImpl : findCamgenParamStationEITimeBand()");
		CamgenStationEiTimeband camgenStationEiTimeband = null;
		try {
			camgenStationEiTimeband = camgenStationEiTimebandJPARepository.findOne(id);

			if (null == camgenStationEiTimeband) {
				throw new MintBaseException("Data Not Found", HttpStatus.NOT_FOUND.value());
			}
		} catch (DataAccessException e) {
			LOGGER.error("Exception during getting CamgenParamStationEITimeBands {}", e);
			throw new MintBaseException("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		LOGGER.info(" << StationEITimeBandsRepositoryImpl : findCamgenParamStationEITimeBand()");
		return camgenStationEiTimeband;
	}

}
