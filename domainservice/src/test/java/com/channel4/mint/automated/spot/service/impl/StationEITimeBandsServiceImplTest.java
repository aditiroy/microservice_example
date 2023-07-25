package com.channel4.mint.automated.spot.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.channel4.mint.automated.spot.application.util.DateTimeUtility;
import com.channel4.mint.automated.spot.application.util.StationEITimeBandsMapper;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.StationEITimeBandsRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenStationEiTimeband;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamStationEITimeBand;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamStationEITimeBands;

public class StationEITimeBandsServiceImplTest {

	@InjectMocks
	private  StationEITimeBandsServiceImpl stationEITimeBandsServiceImpl;
	
	@Mock
	private StationEITimeBandsRepository stationEITimeBandsRepository;
	
	@Mock
	private StationEITimeBandsMapper stationEITimeBandsMapper;
	
		
	@Mock
	private DateTimeUtility dateTimeUtility;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void testCreateCamgenParamStationEITimeBands() {
		List<CamgenStationEiTimeband> camgenParamStationEITimeBands=new ArrayList<>();
		CamgenParamStationEITimeBands camgenParamStationEITimeBandsObj=new CamgenParamStationEITimeBands();
		CamgenParamStationEITimeBand camgenParamStationEITimeBand=new CamgenParamStationEITimeBand();
		camgenParamStationEITimeBand.setCreatedBy("mintuser1");
		camgenParamStationEITimeBand.setDayCode("code");
		camgenParamStationEITimeBand.setEndTime("1234");
		camgenParamStationEITimeBand.setId(34L);
		camgenParamStationEITimeBand.setStartTime("0000");
		
		
		CamgenParamStationEITimeBand camgenParamStationEITimeBand1=new CamgenParamStationEITimeBand();
		camgenParamStationEITimeBand1.setCreatedBy("mintuser1");
		camgenParamStationEITimeBand1.setDayCode("code");
		camgenParamStationEITimeBand1.setEndTime("1234");
		 
		camgenParamStationEITimeBand1.setStartTime("0000");
		camgenParamStationEITimeBandsObj.add(camgenParamStationEITimeBand1);
		camgenParamStationEITimeBandsObj.add(camgenParamStationEITimeBand);
		Timestamp value=new Timestamp(System.currentTimeMillis());
		when(dateTimeUtility.getCurrentTimeStamp()).thenReturn(value);
		
		CamgenStationEiTimeband valuewer=new CamgenStationEiTimeband();
		when(stationEITimeBandsRepository.findCamgenParamStationEITimeBand(Mockito.anyLong())).thenReturn(valuewer);
		stationEITimeBandsServiceImpl.createCamgenParamStationEITimeBands(camgenParamStationEITimeBandsObj);
	}

	@Test
	public void testGetCamgenParamStationEITimeBands() {
		CamgenParamStationEITimeBands value=new CamgenParamStationEITimeBands();
		CamgenParamStationEITimeBand e=new CamgenParamStationEITimeBand();
		e.setDayCode("dayCode");
		value.add(e);
		when(stationEITimeBandsRepository.getCamgenParamStationEITimeBands()).thenReturn(value);
		CamgenParamStationEITimeBands reszx=stationEITimeBandsServiceImpl.getCamgenParamStationEITimeBands();
		assertEquals(reszx.get(0).getDayCode(), value.get(0).getDayCode());
	}

}
