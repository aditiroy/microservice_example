package com.channel4.mint.automated.spot.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.channel4.mint.automated.spot.application.util.DateTimeUtility;
import com.channel4.mint.automated.spot.application.util.StationEITimeBandsMapper;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenParamEIBandsRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenEiBand;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamEIBand;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamEIBands;

public class CamgenParamEIBandsServiceImplTest {

	@InjectMocks
	private   CamgenParamEIBandsServiceImpl  camgenParamEIBandsServiceImpl;
	
	@Mock
	private CamgenParamEIBandsRepository camgenParamEIBandsRepository;
	
	@Mock
	private DateTimeUtility dateTimeUtility;
	
	
	@Mock
	private StationEITimeBandsMapper stationEITimeBandsMapper;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void testCreateCamgenParameters() {
		CamgenParamEIBands camgenParamEIBandsRequest=new CamgenParamEIBands();
		CamgenParamEIBand e=new CamgenParamEIBand();
		e.setCreatedBy("createdBy");
		e.setEiBand(1);
		e.setId(1L);
		CamgenParamEIBand e1=new CamgenParamEIBand();
		e1.setCreatedBy("createdBy");
		e1.setEiBand(1);
		camgenParamEIBandsRequest.add(e);
		camgenParamEIBandsRequest.add(e1);
		CamgenEiBand value=new CamgenEiBand();
		when(camgenParamEIBandsRepository.findCamgenParamEIBand(1L)).thenReturn(value);
		Mockito.doNothing().when(stationEITimeBandsMapper).mapCamgenEiBandMapper(Mockito.any(CamgenParamEIBand.class), Mockito.any(CamgenEiBand.class));
		camgenParamEIBandsServiceImpl.createCamgenParameters(camgenParamEIBandsRequest);
	}

	@Test
	public void testGetCamgenParamEIBands() {
		CamgenParamEIBands camgenParamEIBandsRequest=new CamgenParamEIBands();
		CamgenParamEIBand e=new CamgenParamEIBand();
		e.setCreatedBy("createdBy");
		e.setEiBand(1);
		e.setId(1L);
		camgenParamEIBandsRequest.add(e);
		when(camgenParamEIBandsRepository.getCamgenParamEIBands()).thenReturn(camgenParamEIBandsRequest);
		CamgenParamEIBands camgenParamEIBandsRes = camgenParamEIBandsServiceImpl.getCamgenParamEIBands();
		assertEquals(camgenParamEIBandsRes.get(0).getId(),camgenParamEIBandsRequest.get(0).getId());
	}
	 
}
