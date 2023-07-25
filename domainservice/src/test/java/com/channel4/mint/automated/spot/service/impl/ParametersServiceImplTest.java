package com.channel4.mint.automated.spot.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.ParametersRepository;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParam;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParameters;

public class ParametersServiceImplTest {
	@InjectMocks
	private ExtractParametersServiceImpl parametersServiceImpl;
	
	@Mock
	private ParametersRepository parametersRepository;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);

	}
	@Test
	public void testGetCamgenRunParameters() {
		CamgenRunParameters value=new CamgenRunParameters();
		CamgenRunParam e=new CamgenRunParam();
		e.setParameter("parameter");
		value.add(e);
		when(parametersRepository.getCamgenRunParameters(1)).thenReturn(value);
		CamgenRunParameters camgenRunParametersRes = parametersServiceImpl.getCamgenRunParameters(1);
		assertEquals(camgenRunParametersRes.get(0).getParameter(), value.get(0).getParameter());
	}

	@Test
	public void testCreateCamgenRunParameters() {
		CamgenRunParameters body=new CamgenRunParameters();
		Mockito.doNothing().when(parametersRepository).createCamgenRunParameters(body, 1);
		parametersServiceImpl.createCamgenRunParameters(body, 1);
	}

}
