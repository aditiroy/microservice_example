package com.channel4.mint.automated.spot.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.ParamStationEITimeBandsRepository;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamStationEITimeBand;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamStationEITimeBands;

public class ParamStationEITimeBandsServiceImplTest {

	@InjectMocks
	private ParamStationEITimeBandsServiceImpl paramStationEITimeBandsServiceImpl;
	
	@Mock
	private ParamStationEITimeBandsRepository paramStationEITimeBandsRepository;
	
	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void testCreateCamgenRunParamStationEITimeBands() {
		CamgenRunParamStationEITimeBands body=new CamgenRunParamStationEITimeBands();
		Mockito.doNothing().when(paramStationEITimeBandsRepository).createCamgenRunParamStationEITimeBands(body, 1);
		paramStationEITimeBandsServiceImpl.createCamgenRunParamStationEITimeBands(body, 1);
	}

	@Test
	public void testGetCamgenRunParamStationEITimeBands() {
		 
		CamgenRunParamStationEITimeBands value=new CamgenRunParamStationEITimeBands();
		CamgenRunParamStationEITimeBand e=new CamgenRunParamStationEITimeBand();
		e.setEndTime("endTime");
		value.add(e);
		when(paramStationEITimeBandsServiceImpl.getCamgenRunParamStationEITimeBands(1)).thenReturn(value);
		CamgenRunParamStationEITimeBands camgenRunParamStationTimeBandsRes = paramStationEITimeBandsServiceImpl.getCamgenRunParamStationEITimeBands(1);
		assertEquals(camgenRunParamStationTimeBandsRes.get(0).getEndTime(), value.get(0).getEndTime());
	}

}
