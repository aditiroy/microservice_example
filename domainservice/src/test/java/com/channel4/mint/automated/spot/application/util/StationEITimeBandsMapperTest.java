package com.channel4.mint.automated.spot.application.util;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenEiBand;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenStationEiTimeband;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamEIBand;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamEIBands;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamStationEITimeBand;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamStationEITimeBands;
import com.channel4.mint.automated.spot.test.util.TestUtil;

public class StationEITimeBandsMapperTest {

	@InjectMocks
	StationEITimeBandsMapper stationEITimeBandsMapper;

	TestUtil testUtil = new TestUtil();
	CamgenParamStationEITimeBand camgenParamStationEITimeBand;
	CamgenStationEiTimeband camgenStationEiTimeband;
	CamgenParamEIBand camgenParamEIBand;
	CamgenEiBand camgenEiBandEntity;
	List<CamgenEiBand> listOfCamgenEiBand = new ArrayList<>();
	List<CamgenStationEiTimeband> listOfCamgenStationEiTimeband = new ArrayList<>();

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);

		camgenEiBandEntity = testUtil.getCamgenEiBand();
		listOfCamgenEiBand.add(camgenEiBandEntity);
		camgenParamEIBand = testUtil.getcamgenParamEIBand();
		camgenStationEiTimeband = testUtil.getCamgenStationEiTimeband();
		camgenParamStationEITimeBand = testUtil.getCamgenParamStationEITimeBand();
		listOfCamgenStationEiTimeband.add(camgenStationEiTimeband);
	}

	@Test
	public void tesmapEntityListToCamgenParamStationEITimeBands() {
		CamgenParamStationEITimeBands response = stationEITimeBandsMapper
				.mapEntityListToCamgenParamStationEITimeBands(listOfCamgenStationEiTimeband);
		assertEquals(response.get(0).getCreatedBy(), listOfCamgenStationEiTimeband.get(0).getCreatedBy());
		assertEquals(response.get(0).getDayCode(), listOfCamgenStationEiTimeband.get(0).getApplicableDay());
		assertEquals(response.get(0).getId().longValue(),
				listOfCamgenStationEiTimeband.get(0).getStationEiTimebandId());
	}

	@Test
	public void testmapCamgenParamStationEITimeBandMapper() {
		stationEITimeBandsMapper.mapCamgenParamStationEITimeBandMapper(camgenParamStationEITimeBand,
				camgenStationEiTimeband);
	}

	@Test
	public void testmapEntityListToCamgenParamEIBands() {
		CamgenParamEIBands response = stationEITimeBandsMapper.mapEntityListToCamgenParamEIBands(listOfCamgenEiBand);
		assertEquals(response.get(0).getCreatedBy(), listOfCamgenEiBand.get(0).getCreatedBy());
		assertEquals(response.get(0).getEiBand().intValue(), listOfCamgenEiBand.get(0).getEiBand().intValue());
		assertEquals(response.get(0).getId().longValue(), listOfCamgenEiBand.get(0).getEiBandId());
	}

	@Test
	public void testmapCamgenEiBandMapper() {
		 stationEITimeBandsMapper.mapCamgenEiBandMapper(camgenParamEIBand, camgenEiBandEntity);
	}
}
