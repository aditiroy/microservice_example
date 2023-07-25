package com.channel4.mint.automated.spot.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.channel4.mint.automated.spot.application.util.DateTimeUtility;
import com.channel4.mint.automated.spot.application.util.StationEITimeBandsMapper;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.StationEITimeBandsRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenStationEiTimeband;
import com.channel4.mint.automated.spot.interfaces.controller.impl.CamgenApiController;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamStationEITimeBand;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamStationEITimeBands;
import com.channel4.mint.automated.spot.service.StationEITimeBandsService;

/**
 * This class is used to perform get and save operation on
 * CamgenParamStationEITimeBands.
 * 
 * @author HCL
 */
@Service
public class StationEITimeBandsServiceImpl implements StationEITimeBandsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CamgenApiController.class);

	@Autowired
	private StationEITimeBandsRepository stationEITimeBandsRepository;

	@Autowired
	private StationEITimeBandsMapper stationEITimeBandsMapper;

	@Autowired
	private DateTimeUtility dateTimeUtility;

	/**
	 * method for create station eli time bands.
	 *
	 * @param camgenParamStationEITimeBands
	 *            the camgen param station EI time bands
	 */
	@Transactional
	@Override
	public void createCamgenParamStationEITimeBands(CamgenParamStationEITimeBands camgenParamStationEITimeBands) {
		LOGGER.info(">> Service StationEITimeBandsServiceImpl method createCamgenParamStationEITimeBands");

		List<CamgenStationEiTimeband> camgenStationEiTimebandList = new ArrayList<>();

		for (CamgenParamStationEITimeBand camgenParamStationEITimeBand : camgenParamStationEITimeBands) {
			CamgenStationEiTimeband camgenStationEiTimeband = null;
			if (null == camgenParamStationEITimeBand.getId()) {
				camgenStationEiTimeband = new CamgenStationEiTimeband();

				stationEITimeBandsMapper.mapCamgenParamStationEITimeBandMapper(camgenParamStationEITimeBand,
						camgenStationEiTimeband);
				camgenStationEiTimeband.setCreatedBy(camgenParamStationEITimeBand.getCreatedBy());
				camgenStationEiTimeband.setCreatedOn(dateTimeUtility.getCurrentTimeStamp());

			} else {
				camgenStationEiTimeband = stationEITimeBandsRepository
						.findCamgenParamStationEITimeBand(camgenParamStationEITimeBand.getId());
				stationEITimeBandsMapper.mapCamgenParamStationEITimeBandMapper(camgenParamStationEITimeBand,
						camgenStationEiTimeband);
				camgenStationEiTimeband.setModifiedBy(camgenParamStationEITimeBand.getCreatedBy());
				camgenStationEiTimeband.setModifiedOn(dateTimeUtility.getCurrentTimeStamp());

			}
			camgenStationEiTimebandList.add(camgenStationEiTimeband);
		}
		if (!CollectionUtils.isEmpty(camgenStationEiTimebandList)) {
			stationEITimeBandsRepository.createCamgenParamStationEITimeBands(camgenStationEiTimebandList);
		}
		LOGGER.info("<< Service StationEITimeBandsServiceImpl method createCamgenParamStationEITimeBands");
	}

	/**
	 * method for get station eli time bands.
	 *
	 * @return CamgenParamStationEITimeBands
	 */
	@Override
	public CamgenParamStationEITimeBands getCamgenParamStationEITimeBands() {
		LOGGER.info(">> Service StationEITimeBandsServiceImpl method getCamgenParamStationEITimeBands");
		return stationEITimeBandsRepository.getCamgenParamStationEITimeBands();
	}

}
