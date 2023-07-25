package com.channel4.mint.automated.spot.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.channel4.mint.automated.spot.application.util.DateTimeUtility;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.StationTimeBandsRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenStationTimeband;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamStationTimeBand;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamStationTimeBands;
import com.channel4.mint.automated.spot.service.StationTimeBandsService;

/**
 * class for handle station time band operations.
 *
 * @author HCL
 */
@Service
public class StationTimeBandsServiceImpl implements StationTimeBandsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(StationTimeBandsServiceImpl.class);

	@Autowired
	private StationTimeBandsRepository stationTimeBandsRepository;

	@Autowired
	private DateTimeUtility dateTimeUtility;

	/**
	 * method for create station time bands.
	 *
	 * @param camgenParamStationTimeBands
	 *            the camgen param station time bands
	 */
	@Transactional
	@Override
	public void createCamgenParamStationTimeBands(CamgenParamStationTimeBands camgenParamStationTimeBands) {
		LOGGER.info(">> Service StationTimeBandsServiceImpl method createCamgenParamStationTimeBands");
		List<CamgenStationTimeband> camgenStationTimebandList = new ArrayList<>();

		for (CamgenParamStationTimeBand camgenParamStationTimeBand : camgenParamStationTimeBands) {
			CamgenStationTimeband camgenStationTimeband = null;

			if (null == camgenParamStationTimeBand.getId()) {
				camgenStationTimeband = new CamgenStationTimeband();
				mapRunStationTimeband(camgenParamStationTimeBand, camgenStationTimeband);
				camgenStationTimeband.setCreatedBy(camgenParamStationTimeBand.getCreatedBy());
				camgenStationTimeband.setCreatedOn(dateTimeUtility.getCurrentTimeStamp());
			} else {
				camgenStationTimeband = stationTimeBandsRepository
						.getCamgenStationTimeband(camgenParamStationTimeBand.getId());
				mapRunStationTimeband(camgenParamStationTimeBand, camgenStationTimeband);
				camgenStationTimeband.setModifiedBy(camgenParamStationTimeBand.getCreatedBy());
				camgenStationTimeband.setModifiedOn(dateTimeUtility.getCurrentTimeStamp());
			}

			camgenStationTimebandList.add(camgenStationTimeband);
		}

		if (!CollectionUtils.isEmpty(camgenStationTimebandList)) {
			stationTimeBandsRepository.createCamgenParamStationTimeBands(camgenStationTimebandList);
		}

		LOGGER.info("<< Service StationTimeBandsServiceImpl method createCamgenParamStationTimeBands");
	}

	/**
	 * Map run station timeband.
	 *
	 * @param camgenParamStationTimeBand
	 *            the camgen param station time band
	 * @param camgenStationTimeband
	 *            the camgen station timeband
	 * @return CamgenStationTimeband
	 */
	private CamgenStationTimeband mapRunStationTimeband(CamgenParamStationTimeBand camgenParamStationTimeBand,
			CamgenStationTimeband camgenStationTimeband) {

		if (null != camgenParamStationTimeBand.getChannelId()) {
			camgenStationTimeband.setChannelId(BigDecimal.valueOf(camgenParamStationTimeBand.getChannelId()));
		}

		camgenStationTimeband.setTimeband(camgenParamStationTimeBand.getName());
		camgenStationTimeband.setApplicableDay(camgenParamStationTimeBand.getDayCode());
		camgenStationTimeband.setStartTime(camgenParamStationTimeBand.getStartTime());
		camgenStationTimeband.setEndTime(camgenParamStationTimeBand.getEndTime());
		camgenStationTimeband.setEiCutOff(BigDecimal.valueOf(camgenParamStationTimeBand.getEiCutOff()));
		camgenStationTimeband
				.setTbProgRepititionLimit(BigDecimal.valueOf(camgenParamStationTimeBand.getTbProgRepetitionLimit()));
		camgenStationTimeband.setAmendDemand(BigDecimal.valueOf(camgenParamStationTimeBand.getAmendDemand()));
		camgenStationTimeband
				.setIsExclude(camgenParamStationTimeBand.getExcludeFlag() ? new BigDecimal(1) : new BigDecimal(0));

		return camgenStationTimeband;

	}

	/**
	 * method for get station time bands.
	 *
	 * @return CamgenParamStationTimeBands
	 */
	@Override
	public CamgenParamStationTimeBands getCamgenParamStationTimeBands() {
		LOGGER.info(">> Service RunIterationServiceImpl method getCamgenRunIterations");
		return stationTimeBandsRepository.getCamgenParamStationTimeBands();
	}

}
