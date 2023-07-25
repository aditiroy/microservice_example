package com.channel4.mint.automated.spot.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.ParamExtractsRepository;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamExtract;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamExtracts;

public class ParamExtractsServiceImplTest {
	@InjectMocks
	private  ParamExtractsServiceImpl paramExtractsServiceImpl;
	
	@Mock
	private  ParamExtractsRepository paramExtractsRepository;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);

	}
	@Test
	public void testGetCamgenRunParamExtracts() {
		CamgenRunParamExtracts value=new CamgenRunParamExtracts();
		CamgenRunParamExtract e=new CamgenRunParamExtract();
		e.setParameter("parameter");
		value.add(e);
		when(paramExtractsRepository.getCamgenRunParamExtracts(1)).thenReturn(value);
		CamgenRunParamExtracts camgenRunParamExtractsRes = paramExtractsServiceImpl.getCamgenRunParamExtracts(1);
        assertEquals(camgenRunParamExtractsRes.get(0).getParameter(), value.get(0).getParameter());
	}

	@Test
	public void testCreateCamgenRunParamExtracts() {
		CamgenRunParamExtracts body=new CamgenRunParamExtracts();
		Mockito.doNothing().when(paramExtractsRepository).createCamgenRunParamExtracts(body, 1); 
		paramExtractsServiceImpl.createCamgenRunParamExtracts(body, 1);
	}

}
