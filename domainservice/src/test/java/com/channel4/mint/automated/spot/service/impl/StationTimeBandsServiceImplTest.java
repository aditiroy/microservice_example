package com.channel4.mint.automated.spot.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.channel4.mint.automated.spot.application.util.DateTimeUtility;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.StationTimeBandsRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenStationTimeband;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamStationTimeBand;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamStationTimeBands;

public class StationTimeBandsServiceImplTest {

	@InjectMocks
	private StationTimeBandsServiceImpl stationTimeBandsServiceImpl;

	@Mock
	private StationTimeBandsRepository stationTimeBandsRepository;
	
	@Mock
	private DateTimeUtility dateTimeUtility;
 

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);

	}

	@Test
	public void testCreateCamgenParamStationTimeBands() {
		CamgenParamStationTimeBands camgenParamStationTimeBands = new CamgenParamStationTimeBands();
		CamgenParamStationTimeBand camgenParamStationTimeBand=new CamgenParamStationTimeBand();
		camgenParamStationTimeBand.setAmendDemand(1);
		camgenParamStationTimeBand.setChannelId(1);
		camgenParamStationTimeBand.setCreatedBy("createdBy");
		camgenParamStationTimeBand.setDayCode("dayCode");
		camgenParamStationTimeBand.setEiCutOff(1);
		camgenParamStationTimeBand.setEndTime("1234");
		camgenParamStationTimeBand.setExcludeFlag(true);
		camgenParamStationTimeBand.setId(1L);
		camgenParamStationTimeBand.setName("name");
		camgenParamStationTimeBand.setStartTime("3454");
		camgenParamStationTimeBand.setStationTimeBandId(1);
		camgenParamStationTimeBand.setTbProgRepetitionLimit(1);
		
		CamgenParamStationTimeBand camgenParamStationTimeBand1=new CamgenParamStationTimeBand();
		camgenParamStationTimeBand1.setAmendDemand(1);
		camgenParamStationTimeBand1.setChannelId(1);
		camgenParamStationTimeBand1.setCreatedBy("createdBy");
		camgenParamStationTimeBand1.setDayCode("dayCode");
		camgenParamStationTimeBand1.setEiCutOff(1);
		camgenParamStationTimeBand1.setEndTime("1234");
 
		camgenParamStationTimeBand1.setExcludeFlag(true);
		camgenParamStationTimeBand1.setName("name");
		camgenParamStationTimeBand1.setStartTime("3454");
		camgenParamStationTimeBand1.setStationTimeBandId(1);
		camgenParamStationTimeBand1.setTbProgRepetitionLimit(1);
		camgenParamStationTimeBands.add(camgenParamStationTimeBand1);
		camgenParamStationTimeBands.add(camgenParamStationTimeBand);
		Timestamp value=new Timestamp(System.currentTimeMillis());
		CamgenStationTimeband value1=new CamgenStationTimeband();
		when(dateTimeUtility.getCurrentTimeStamp()).thenReturn(value);
		when(stationTimeBandsRepository.getCamgenStationTimeband(1L)).thenReturn(value1);
		stationTimeBandsServiceImpl.createCamgenParamStationTimeBands(camgenParamStationTimeBands);
	}

	@Test
	public void testGetCamgenParamStationTimeBands() {
		CamgenParamStationTimeBands value = new CamgenParamStationTimeBands();
		CamgenParamStationTimeBand e = new CamgenParamStationTimeBand();
		e.setChannelId(1);
		value.add(e);
		when(stationTimeBandsRepository.getCamgenParamStationTimeBands()).thenReturn(value);
		CamgenParamStationTimeBands camgenParamStationTimeBandsRes = stationTimeBandsServiceImpl
				.getCamgenParamStationTimeBands();
		assertEquals(camgenParamStationTimeBandsRes.get(0).getChannelId(), value.get(0).getChannelId());
	}

}
