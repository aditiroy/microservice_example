package com.channel4.mint.automated.spot.service.impl;

import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.channel4.mint.automated.spot.application.util.CamgenExtractMapper;
import com.channel4.mint.automated.spot.application.util.DateTimeUtility;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.ParametersRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenExtractParameter;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamExtract;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamExtracts;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParameters;
import com.channel4.mint.automated.spot.test.util.TestUtil;

public class ExtractParametersServiceImplTest {

	@InjectMocks
	private ExtractParametersServiceImpl extractParametersServiceImpl;

	@Mock
	private ParametersRepository parametersRepository;

	@Mock
	CamgenExtractMapper camgenExtractMapper;

	@Mock
	private DateTimeUtility dateTimeUtility;
	
	TestUtil testUtil = new TestUtil();
	CamgenParamExtract  camgenParamExtract;
	CamgenExtractParameter camgenExtractParameter ;
	CamgenParamExtracts camgenParamExtracts = new CamgenParamExtracts();

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		
		camgenParamExtract = testUtil.getCamgenParamExtract();
		camgenParamExtracts.add(camgenParamExtract);
		camgenParamExtracts.add(getCamgenParamExtract());
		
		camgenExtractParameter = testUtil.getCamgenExtractParameter();

	}
	private CamgenParamExtract getCamgenParamExtract() {
		CamgenParamExtract camgenParamExtract = new CamgenParamExtract();
		camgenParamExtract.setCreatedBy("abc");
		camgenParamExtract.setParameter("abc");
		camgenParamExtract.setValue("abc");
		return camgenParamExtract;
	}
	@Test
	public void testcreateCamgenParamExtracts() {
		
		when( parametersRepository.getCamgenExtractParameter(Mockito.anyLong())).thenReturn(camgenExtractParameter);
		Mockito.doNothing().when(parametersRepository).createCamgenParamExtracts(Mockito.anyList());
		 extractParametersServiceImpl.createCamgenParamExtracts(camgenParamExtracts);
	}

	@Test
	public void testgetCamgenParamExtracts() {
		
		when(parametersRepository.getCamgenParamExtracts()).thenReturn(camgenParamExtracts);
		 extractParametersServiceImpl.getCamgenParamExtracts();
	}
	@Test
	public void getCamgenRunParametersTest() {
		CamgenRunParameters camgenParamExtracts1=new CamgenRunParameters();
		when(parametersRepository.getCamgenRunParameters(1)).thenReturn(camgenParamExtracts1);
		 extractParametersServiceImpl.getCamgenRunParameters(1);
	}
	
	@Test
	public void createCamgenRunParametersTest() {
		CamgenRunParameters camgenParamExtracts1=new CamgenRunParameters();
		when(parametersRepository.getCamgenRunParameters(1)).thenReturn(camgenParamExtracts1);
		 CamgenRunParameters body=new CamgenRunParameters();
		Integer runId=1;
		 
		Mockito.doNothing().when(parametersRepository).createCamgenRunParameters(body, runId);
		extractParametersServiceImpl.createCamgenRunParameters(body, runId);
			}
}
