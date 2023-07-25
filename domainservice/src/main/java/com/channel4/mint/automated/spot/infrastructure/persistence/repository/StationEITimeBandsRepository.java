package com.channel4.mint.automated.spot.infrastructure.persistence.repository;

import java.util.List;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenStationEiTimeband;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamStationEITimeBands;

/**
 * The Interface StationEITimeBandsRepository used for StationEITimeBands.
 * 
 *  @author HCL
 */
public interface StationEITimeBandsRepository {

	/**
	 * method for create station eli time bands.
	 *
	 * @param camgenStationEiTimebandList the camgen station ei timeband list
	 */
	void createCamgenParamStationEITimeBands(List<CamgenStationEiTimeband> camgenStationEiTimebandList);

	/**
	 * method for get station eli time bands.
	 *
	 * @return CamgenParamStationEITimeBands
	 */
	CamgenParamStationEITimeBands getCamgenParamStationEITimeBands();

	/**
	 * finds CamgenParamStationEITimeBand.
	 *
	 * @param id the id
	 * @return CamgenParamStationEITimeBand
	 */
	CamgenStationEiTimeband findCamgenParamStationEITimeBand(Long id);
}
