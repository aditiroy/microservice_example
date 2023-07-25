package com.channel4.mint.automated.spot.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.ParamStationTimeBandsRepository;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamStationTimeBand;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamStationTimeBands;

public class ParamStationTimeBandsServiceImplTest {
	
	@InjectMocks
	private ParamStationTimeBandsServiceImpl paramStationTimeBandsServiceImpl;

	@Mock
	private  ParamStationTimeBandsRepository paramStationTimeBandsRepository;
	
	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void testGetCamgenRunParamStationEITimeBands() {
		CamgenRunParamStationTimeBands value=new CamgenRunParamStationTimeBands();
		CamgenRunParamStationTimeBand arg0=new CamgenRunParamStationTimeBand();
		arg0.setChannelId(1);
		value.add(arg0);
		when(paramStationTimeBandsRepository.getCamgenRunParamStationEITimeBands(1)).thenReturn(value);
		CamgenRunParamStationTimeBands camgenRunParamStationTimeBandsRes = paramStationTimeBandsServiceImpl.getCamgenRunParamStationEITimeBands(1);
		assertEquals(camgenRunParamStationTimeBandsRes.get(0).getChannelId(), value.get(0).getChannelId());
	}

	@Test
	public void testCreateCamgenRunParamStationTimeBands() {
		CamgenRunParamStationTimeBands body=new CamgenRunParamStationTimeBands();
		Mockito.doNothing().when(paramStationTimeBandsRepository).createCamgenRunParamStationTimeBands(body, 1);
		paramStationTimeBandsServiceImpl.createCamgenRunParamStationTimeBands(body, 1);
	}

}
