package com.channel4.mint.automated.spot.service;

import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamStationTimeBands;

/**
 * The Interface StationTimeBandsService used for operation for
 * CamgenParamStationTimeBands.
 * 
 * @author HCL
 */
public interface StationTimeBandsService {

	/**
	 * method for create station time bands.
	 *
	 * @param camgenParamStationTimeBands
	 *            the camgen param station time bands
	 */
	void createCamgenParamStationTimeBands(CamgenParamStationTimeBands camgenParamStationTimeBands);

	/**
	 * method for get station time bands.
	 *
	 * @return CamgenParamStationTimeBands
	 */
	CamgenParamStationTimeBands getCamgenParamStationTimeBands();

}
