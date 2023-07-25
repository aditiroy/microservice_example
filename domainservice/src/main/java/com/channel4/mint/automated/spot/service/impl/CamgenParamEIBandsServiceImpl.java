package com.channel4.mint.automated.spot.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.channel4.mint.automated.spot.application.util.DateTimeUtility;
import com.channel4.mint.automated.spot.application.util.StationEITimeBandsMapper;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenParamEIBandsRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenEiBand;
import com.channel4.mint.automated.spot.interfaces.controller.impl.CamgenApiController;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamEIBands;
import com.channel4.mint.automated.spot.service.CamgenParamEIBandsService;

/**
 * This class is used to perform get and save operation on CamgenParamEIBands.
 * 
 * @author HCL
 */
@Service
public class CamgenParamEIBandsServiceImpl implements CamgenParamEIBandsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CamgenApiController.class);

	@Autowired
	private CamgenParamEIBandsRepository camgenParamEIBandsRepository;

	@Autowired
	private StationEITimeBandsMapper stationEITimeBandsMapper;

	@Autowired
	private DateTimeUtility dateTimeUtility;

	/**
	 * Creates the camgen parameters.
	 *
	 * @param camgenParamEIBandsRequest
	 *            the camgen param EI bands request
	 */
	@Transactional
	@Override
	public void createCamgenParameters(CamgenParamEIBands camgenParamEIBandsRequest) {
		LOGGER.info(">> Service CamgenParamEIBandsServiceImpl method createCamgenParameters");
		List<CamgenEiBand> camgenEiBandList = new ArrayList<>();
		camgenParamEIBandsRequest.stream().forEach(camgenParamEIBand -> {
			CamgenEiBand camgenEiBandEntity = null;
			if (null == camgenParamEIBand.getId()) {
				camgenEiBandEntity = new CamgenEiBand();
				stationEITimeBandsMapper.mapCamgenEiBandMapper(camgenParamEIBand, camgenEiBandEntity);
				camgenEiBandEntity.setCreatedBy(camgenParamEIBand.getCreatedBy());
				camgenEiBandEntity.setCreatedOn(dateTimeUtility.getCurrentTimeStamp());

			} else {
				camgenEiBandEntity = camgenParamEIBandsRepository.findCamgenParamEIBand(camgenParamEIBand.getId());
				stationEITimeBandsMapper.mapCamgenEiBandMapper(camgenParamEIBand, camgenEiBandEntity);
				camgenEiBandEntity.setModifiedBy(camgenParamEIBand.getCreatedBy());
				camgenEiBandEntity.setModifiedOn(dateTimeUtility.getCurrentTimeStamp());

			}
			camgenEiBandList.add(camgenEiBandEntity);
		});
		camgenParamEIBandsRepository.createCamgenParamEIBands(camgenEiBandList);
		LOGGER.info(">> Service CamgenParamEIBandsServiceImpl method createCamgenParameters");
	}

	/**
	 * Gets the camgen param EI bands.
	 *
	 * @return CamgenParamEIBands
	 */
	@Override
	public CamgenParamEIBands getCamgenParamEIBands() {
		LOGGER.info(">> Service CamgenParamEIBandsServiceImpl method getCamgenParamEIBands");
		return camgenParamEIBandsRepository.getCamgenParamEIBands();

	}

}
