package com.channel4.mint.automated.spot.infrastructure.persistence.repository;

import java.util.List;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenEiBand;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamEIBands;

/**
 * The Interface CamgenParamEIBands Repository.
 * 
 *  @author HCL
 */
public interface CamgenParamEIBandsRepository {

	/**
	 * Creates the camgen param EI bands.
	 *
	 * @param camgenEiBandList the camgen ei band list
	 */
	void createCamgenParamEIBands(List<CamgenEiBand> camgenEiBandList);

	/**
	 * Gets the camgen param EI bands.
	 *
	 * @return CamgenParamEIBands
	 */
	CamgenParamEIBands getCamgenParamEIBands();

	/**
	 * Find camgen param EI band.
	 *
	 * @param id the id
	 * @return  CamgenEiBand
	 */
	CamgenEiBand findCamgenParamEIBand(Long id);

}
