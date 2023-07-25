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

import com.channel4.mint.automated.spot.application.util.CamgenParameterMapper;
import com.channel4.mint.automated.spot.application.util.DateTimeUtility;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenParametersRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenParameter;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParam;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParameters;

public class CamgenParametersServiceImplTest {
	@InjectMocks
	private   CamgenParametersServiceImpl  camgenParametersServiceImpl;
	
	@Mock
	private CamgenParametersRepository camgenParametersRepository;

	private List<CamgenParameter> camgenParameterList = new ArrayList<>();
	
	@Mock
	private DateTimeUtility dateTimeUtility;
	
	@Mock
	private CamgenParameterMapper camgenParameterMapper;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void testCreateCamgenParameters() {
		CamgenParameters camgenParameters=new CamgenParameters();
		CamgenParam camgenParam=new CamgenParam();
		camgenParam.setCreatedBy("createdBy");
		camgenParam.setId(1L);
		camgenParam.setParameter("parameter");
		camgenParam.setRemarks("remarks");
		camgenParam.setStandardvalue("standardvalue");
		camgenParam.setValue("value");
		camgenParam.setViewOrder(500);
		
		CamgenParam camgenParam1=new CamgenParam();
		camgenParam1.setCreatedBy("createdBy");
		camgenParam1.setParameter("parameter");
		camgenParam1.setRemarks("remarks");
		camgenParam1.setStandardvalue("standardvalue");
		camgenParam1.setValue("value");
		camgenParam1.setViewOrder(500);
		
		camgenParameters.add(camgenParam);
		camgenParameters.add(camgenParam1);
		Timestamp value=new Timestamp(System.currentTimeMillis());
		when(dateTimeUtility.getCurrentTimeStamp()).thenReturn(value);
		CamgenParameter value12=new CamgenParameter();
		value12.setCreatedBy("createdBy");
		
		when(camgenParameterMapper.mapCamgenParameterMapper(Mockito.any(CamgenParam.class), Mockito.any(CamgenParameter.class))).thenReturn(value12);
		CamgenParameter valueyu=new CamgenParameter();
		when(camgenParametersRepository.getCamgenParameter(Mockito.anyLong())).thenReturn(valueyu);
		Mockito.doNothing().when(camgenParametersRepository).createCamgenParameters(camgenParameterList);
		camgenParametersServiceImpl.createCamgenParameters(camgenParameters);
	}

	@Test
	public void testCamgenParameters() {
		CamgenParameters value1=new CamgenParameters();
		CamgenParam e=new CamgenParam();e.setId(1L);
		value1.add(e);
		when(camgenParametersRepository.getCamgenParameters()).thenReturn(value1);
		CamgenParameters zxc = camgenParametersServiceImpl.getCamgenParameters();
		assertEquals(zxc.get(0).getId(), value1.get(0).getId());
	}

}
