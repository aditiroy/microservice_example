package com.channel4.mint.automated.spot.service;

import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamStationEITimeBands;

/**
 * The Interface StationEITimeBandsService used for operation for
 * CamgenParamStationEITimeBands.
 * 
 * @author HCL
 */
public interface StationEITimeBandsService {

	/**
	 * method for create station eli time bands.
	 *
	 * @param camgenParamStationEITimeBands
	 *            the camgen param station EI time bands
	 */
	void createCamgenParamStationEITimeBands(CamgenParamStationEITimeBands camgenParamStationEITimeBands);

	/**
	 * method for get station eli time bands.
	 *
	 * @return CamgenParamStationEITimeBands
	 */
	CamgenParamStationEITimeBands getCamgenParamStationEITimeBands();

}
