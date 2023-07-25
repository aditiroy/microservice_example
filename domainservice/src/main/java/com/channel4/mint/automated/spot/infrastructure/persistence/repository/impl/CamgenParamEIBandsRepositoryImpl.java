package com.channel4.mint.automated.spot.infrastructure.persistence.repository.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.channel4.mint.automated.spot.application.util.CamgenConstant;
import com.channel4.mint.automated.spot.application.util.StationEITimeBandsMapper;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenEiBandJPARepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenParamEIBandsRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenEiBand;
import com.channel4.mint.automated.spot.interfaces.controller.impl.CamgenApiController;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamEIBands;
import com.channel4.mint.baseexception.MintBaseException;

/**
 * class for handle CamgenEiBand db related operations.
 * 
 * @author HCL
 */
@Repository
public class CamgenParamEIBandsRepositoryImpl implements CamgenParamEIBandsRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(CamgenApiController.class);

	@Autowired
	private CamgenEiBandJPARepository camgenEiBandJPARepository;

	@Autowired
	private StationEITimeBandsMapper stationEITimeBandsMapper;

	/**
	 * Creates the camgen param EI bands.
	 *
	 * @param camgenEiBandList
	 *            the camgen ei band list
	 */
	@Override
	public void createCamgenParamEIBands(List<CamgenEiBand> camgenEiBandList) {
		LOGGER.info(" >> StationEITimeBandsRepositoryImpl : createCamgenParamStationEITimeBands()");
		try {
			camgenEiBandJPARepository.save(camgenEiBandList);
		} catch (DataAccessException e) {
			LOGGER.error("Exception during creating CamgenParamStationEITimeBands {}", e);
			throw new MintBaseException(CamgenConstant.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
	}

	/**
	 * Gets the camgen param EI bands.
	 *
	 * @return CamgenParamEIBands
	 */
	@Override
	public CamgenParamEIBands getCamgenParamEIBands() {
		LOGGER.info(" << CamgenParamEIBandsRepositoryImpl : getCamgenParamEIBands()");
		CamgenParamEIBands camgenParamEIBands = null;
		try {
			List<CamgenEiBand> listOfCamgenEiBand = camgenEiBandJPARepository.findAll();
			if (CollectionUtils.isEmpty(listOfCamgenEiBand)) {
				throw new MintBaseException("Data Not Found", HttpStatus.NOT_FOUND.value());
			}
			camgenParamEIBands = stationEITimeBandsMapper.mapEntityListToCamgenParamEIBands(listOfCamgenEiBand);
		} catch (DataAccessException e) {
			LOGGER.error("Exception during getting CamgenParamEIBands {}", e);
			throw new MintBaseException("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		LOGGER.info(" << CamgenParamEIBandsRepositoryImpl : getCamgenParamEIBands()");
		return camgenParamEIBands;
	}

	/**
	 * Find camgen param EI band.
	 *
	 * @param id
	 *            the id
	 * @return CamgenEiBand
	 */
	@Override
	public CamgenEiBand findCamgenParamEIBand(Long id) {
		LOGGER.info(" >> CamgenParamEIBandsRepositoryImpl : findCamgenParamStationEITimeBand()");
		CamgenEiBand camgenEIBand = null;
		try {
			camgenEIBand = camgenEiBandJPARepository.findOne(id);
			if (null == camgenEIBand) {
				throw new MintBaseException("Data Not Found", HttpStatus.NOT_FOUND.value());
			}
		} catch (DataAccessException e) {
			LOGGER.error("Exception during getting CamgenParamEIBand {}", e);
			throw new MintBaseException("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		LOGGER.info(" << CamgenParamEIBandsRepositoryImpl : findCamgenParamEIBand()");
		return camgenEIBand;
	}

}
