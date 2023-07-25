package com.channel4.mint.automated.spot.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.RunIterationRepository;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunIteration;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunIterations;

public class RunIterationServiceImplTest {
	@InjectMocks
	private   RunIterationServiceImpl  runIterationServiceImpl;
	
	@Mock
	private RunIterationRepository runIterationRepository;
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void testCreateCamgenRunIterations() {
		CamgenRunIterations camgenRunIterations=new CamgenRunIterations();
		Mockito.doNothing().when(runIterationRepository).createCamgenRunIterations(camgenRunIterations);
		runIterationServiceImpl.createCamgenRunIterations(camgenRunIterations);
	}

	@Test
	public void testGetCamgenRunIterations() {
		Integer runId=1;
		CamgenRunIterations value=new CamgenRunIterations();
		CamgenRunIteration e=new CamgenRunIteration();e.setRunId(1);
		value.add(e);
		when(runIterationRepository.getCamgenRunIterations(runId)).thenReturn(value);
		CamgenRunIterations camgenRunIterationsRes = runIterationServiceImpl.getCamgenRunIterations(runId);
		assertEquals(camgenRunIterationsRes.get(0).getRunId(), value.get(0).getRunId());
	}

}
