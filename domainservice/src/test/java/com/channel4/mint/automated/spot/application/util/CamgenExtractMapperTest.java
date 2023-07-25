package com.channel4.mint.automated.spot.application.util;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenExtractParameter;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamExtract;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamExtracts;
import com.channel4.mint.automated.spot.test.util.TestUtil;

public class CamgenExtractMapperTest {

	@InjectMocks
	CamgenExtractMapper camgenExtractMapper;

	TestUtil testUtil = new TestUtil();
	CamgenParamExtract camgenParamExtract;
	CamgenExtractParameter camgenExtractParameter;
	List<com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenExtractParameter> camgenExtractParameterList = new ArrayList<>();

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);

		camgenParamExtract = testUtil.getCamgenParamExtract();
		camgenExtractParameter = testUtil.getCamgenExtractParameter();

		camgenExtractParameterList.add(camgenExtractParameter);
	}

	@Test
	public void testMapCamgenExtractMapper() {
		CamgenExtractParameter response = camgenExtractMapper.mapCamgenExtractMapper(camgenParamExtract,
				camgenExtractParameter);
		assertEquals(response.getCreatedBy(), camgenExtractParameter.getCreatedBy());
		assertEquals(response.getExtractParameterName(), camgenExtractParameter.getExtractParameterName());
		assertEquals(response.getValue(), camgenExtractParameter.getValue());
	}

	@Test
	public void testMapCamgenParamExtracts() {
		CamgenParamExtracts response = camgenExtractMapper.mapCamgenParamExtracts(camgenExtractParameterList);
		assertEquals(response.get(0).getCreatedBy(), camgenExtractParameterList.get(0).getCreatedBy());
		assertEquals(response.get(0).getParameter(), camgenExtractParameterList.get(0).getExtractParameterName());
		assertEquals(response.get(0).getValue(), camgenExtractParameterList.get(0).getValue());
	}

}
