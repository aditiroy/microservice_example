
package com.channel4.mint.automated.spot.infrastructure.persistence.repository;

import java.util.List;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenStationTimeband;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamStationTimeBands;

/**
 * The Interface StationTimeBands Repository.
 * 
 *  @author HCL
 */
public interface StationTimeBandsRepository {

	/**
	 * method for create station time bands.
	 *
	 * @param camgenStationTimebandList the camgen station timeband list
	 */
	void createCamgenParamStationTimeBands(List<CamgenStationTimeband> camgenStationTimebandList);

	/**
	 * method for get station time bands.
	 *
	 * @return CamgenParamStationTimeBands
	 */
	CamgenParamStationTimeBands getCamgenParamStationTimeBands();

	/**
	 * method for get campgen station time band based on id.
	 *
	 * @param id the id
	 * @return CamgenStationTimeband
	 */
	CamgenStationTimeband getCamgenStationTimeband(Long id);

}
