package com.channel4.mint.automated.spot.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.channel4.mint.automated.spot.interfaces.dto.CamgenGlobalParametersRequest;
import com.channel4.mint.automated.spot.service.CamgenParamAudGroupChannelsService;
import com.channel4.mint.automated.spot.service.CamgenParamEIBandsService;
import com.channel4.mint.automated.spot.service.CamgenParametersService;
import com.channel4.mint.automated.spot.service.ExtractParametersService;
import com.channel4.mint.automated.spot.service.GlobalParametersService;
import com.channel4.mint.automated.spot.service.StationEITimeBandsService;
import com.channel4.mint.automated.spot.service.StationTimeBandsService;

/**
 * 
 * This class is used to perform save operation on GlobalParameters.
 * 
 * @author HCL
 */
@Service
public class GlobalParametersServiceImpl implements GlobalParametersService {

	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalParametersServiceImpl.class);

	@Autowired
	private StationTimeBandsService stationTimeBandsService;

	@Autowired
	private CamgenParamAudGroupChannelsService camgenParamAudGroupChannelsService;

	@Autowired
	private CamgenParametersService camgenParametersService;

	@Autowired
	private ExtractParametersService extractParametersService;

	@Autowired
	private CamgenParamEIBandsService camgenParamEIBandsService;

	@Autowired
	private StationEITimeBandsService stationEITimeBandsService;

	/**
	 * Update global parameters.
	 *
	 * @param body
	 *            the body
	 */
	@Transactional
	@Override
	public void updateGlobalParameters(CamgenGlobalParametersRequest body) {

		LOGGER.info(">> GlobalParametersServiceImpl service method updateGlobalParameters()");

		if (!CollectionUtils.isEmpty(body.getCamgenParamAudGroupChannels())) {
			camgenParamAudGroupChannelsService.createCamgenParamAudGroupChannels(body.getCamgenParamAudGroupChannels());
		}

		if (!CollectionUtils.isEmpty(body.getCamgenParamStationTimeBands())) {
			stationTimeBandsService.createCamgenParamStationTimeBands(body.getCamgenParamStationTimeBands());
		}

		if (!CollectionUtils.isEmpty(body.getCamgenParameters())) {
			camgenParametersService.createCamgenParameters(body.getCamgenParameters());
		}

		if (!CollectionUtils.isEmpty(body.getCamgenParamExtracts())) {
			extractParametersService.createCamgenParamExtracts(body.getCamgenParamExtracts());
		}

		if (!CollectionUtils.isEmpty(body.getCamgenParamEIBands())) {
			camgenParamEIBandsService.createCamgenParameters(body.getCamgenParamEIBands());
		}

		if (!CollectionUtils.isEmpty(body.getCamgenParamStationEITimeBands())) {
			stationEITimeBandsService.createCamgenParamStationEITimeBands(body.getCamgenParamStationEITimeBands());
		}

		LOGGER.info("<< GlobalParametersServiceImpl service method updateGlobalParameters()");

	}

}
