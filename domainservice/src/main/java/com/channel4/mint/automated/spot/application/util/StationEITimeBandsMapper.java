/*
 * 
 */
package com.channel4.mint.automated.spot.application.util;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Component;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenEiBand;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenStationEiTimeband;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamEIBand;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamEIBands;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamStationEITimeBand;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamStationEITimeBands;

// TODO: Auto-generated Javadoc
/**
 * The Class StationEITimeBandsMapper.
 */
@Component
public class StationEITimeBandsMapper {

	/**
	 * Map entity list to camgen param station EI time bands.
	 *
	 * @param listOfCamgenStationEiTimeband the list of camgen station ei timeband
	 * @return the camgen param station EI time bands
	 */
	public CamgenParamStationEITimeBands mapEntityListToCamgenParamStationEITimeBands(List<CamgenStationEiTimeband> listOfCamgenStationEiTimeband) {
		CamgenParamStationEITimeBands camgenParamStationEITimeBands = new CamgenParamStationEITimeBands();
		listOfCamgenStationEiTimeband.stream().forEach(eiTimeBand -> {
			CamgenParamStationEITimeBand camgenParamStationEITimeBand = new CamgenParamStationEITimeBand();
			camgenParamStationEITimeBand.setDayCode(eiTimeBand.getApplicableDay());
			camgenParamStationEITimeBand.setStartTime(eiTimeBand.getStartTime());
			camgenParamStationEITimeBand.setEndTime(eiTimeBand.getEndTime());
			camgenParamStationEITimeBand.setCreatedBy(eiTimeBand.getCreatedBy());
			camgenParamStationEITimeBand.setId(eiTimeBand.getStationEiTimebandId());
			camgenParamStationEITimeBands.add(camgenParamStationEITimeBand);
		});
		return camgenParamStationEITimeBands;
	}

	/**
	 * Map camgen param station EI time band mapper.
	 *
	 * @param camgenParamStationEITimeBand the camgen param station EI time band
	 * @param camgenStationEiTimeband the camgen station ei timeband
	 */
	public void mapCamgenParamStationEITimeBandMapper(CamgenParamStationEITimeBand camgenParamStationEITimeBand,
			CamgenStationEiTimeband camgenStationEiTimeband) {
		camgenStationEiTimeband.setEndTime(camgenParamStationEITimeBand.getEndTime());
		camgenStationEiTimeband.setApplicableDay(camgenParamStationEITimeBand.getDayCode());
		camgenStationEiTimeband.setStartTime(camgenParamStationEITimeBand.getStartTime());
	}

	/**
	 * Map entity list to camgen param EI bands.
	 *
	 * @param listOfCamgenEiBand the list of camgen ei band
	 * @return the camgen param EI bands
	 */
	public CamgenParamEIBands mapEntityListToCamgenParamEIBands(List<CamgenEiBand> listOfCamgenEiBand) {
		CamgenParamEIBands camgenParamEIBands=new CamgenParamEIBands();
		listOfCamgenEiBand.stream().forEach( eiBand ->{
			CamgenParamEIBand camgenParamEIBand=new CamgenParamEIBand();
			camgenParamEIBand.setEiBand(eiBand.getEiBand().intValue());
			camgenParamEIBand.setCreatedBy(eiBand.getCreatedBy());
			camgenParamEIBand.setId(eiBand.getEiBandId());
			camgenParamEIBands.add(camgenParamEIBand);
		});
		return camgenParamEIBands;
	}

	/**
	 * Map camgen ei band mapper.
	 *
	 * @param camgenParamEIBand the camgen param EI band
	 * @param camgenEiBandEntity the camgen ei band entity
	 */
	public void mapCamgenEiBandMapper(CamgenParamEIBand camgenParamEIBand, CamgenEiBand camgenEiBandEntity) {
		camgenEiBandEntity.setEiBand(BigDecimal.valueOf(camgenParamEIBand.getEiBand()));
	}

}
