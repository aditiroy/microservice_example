package com.channel4.mint.automated.spot.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenRunParamEIBandsRepository;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamEIBand;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamEIBands;

public class CamgenParamRunEIBandsServiceImplTest {

	
	@InjectMocks
	private CamgenParamRunEIBandsServiceImpl camgenParamEIBandsServiceImpl;
	
	@Mock
	private CamgenRunParamEIBandsRepository camgenParamEIBandsRepository;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);

	}
	@Test
	public void testCreateCamgenRunParamEIBands() {
		CamgenRunParamEIBands body=new CamgenRunParamEIBands();
		Mockito.doNothing().when(camgenParamEIBandsRepository).createCamgenRunParamEIBands(body, 1); 
		camgenParamEIBandsServiceImpl.createCamgenRunParamEIBands(body,1);
	}

	@Test
	public void testGetCamgenRunParamEIBands() {
		CamgenRunParamEIBands value=new CamgenRunParamEIBands();
		CamgenRunParamEIBand e= new CamgenRunParamEIBand(); e.setEiBand(1);
		value.add(e);
		when(camgenParamEIBandsRepository.getCamgenRunParamEIBands(1)).thenReturn(value);
		CamgenRunParamEIBands camgenRunParamEIBandsRes = camgenParamEIBandsServiceImpl.getCamgenRunParamEIBands(1);
		assertEquals(camgenRunParamEIBandsRes.get(0).getEiBand(),value.get(0).getEiBand());
	}

}
