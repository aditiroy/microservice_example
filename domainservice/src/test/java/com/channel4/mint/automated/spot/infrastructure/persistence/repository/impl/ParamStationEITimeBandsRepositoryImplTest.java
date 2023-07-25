package com.channel4.mint.automated.spot.infrastructure.persistence.repository.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.http.HttpStatus;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenRunJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.RunStationEiTimebandJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRun;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.RunStationEiTimeband;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamStationEITimeBand;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamStationEITimeBands;
import com.channel4.mint.automated.spot.test.util.TestUtil;
import com.channel4.mint.baseexception.MintBaseException;

public class ParamStationEITimeBandsRepositoryImplTest {
	@InjectMocks
	private ParamStationEITimeBandsRepositoryImpl paramStationEITimeBandsRepositoryImpl;

	@Mock
	private RunStationEiTimebandJpaRepository runStationEiTimebandJpaRepository;

	@Mock
	private CamgenRunJpaRepository camgenRunJpaRepository;

	CamgenRun camgenRun;
	TestUtil testUtil = new TestUtil();

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		camgenRun = testUtil.getCamgenRun();
	}

	@Test
	public void testCreateCamgenRunParamStationEITimeBands() {
		CamgenRunParamStationEITimeBands stationEiBands = getCamgenRunParamStationEITimeBands();
		Integer runId = 1;
		CamgenRun value = new CamgenRun();
		value.setCreatedBy("mintUser");
		when(camgenRunJpaRepository.findOne(Long.valueOf(runId))).thenReturn(value);
		RunStationEiTimeband valuezxcv = new RunStationEiTimeband();
		when(runStationEiTimebandJpaRepository.save(Mockito.any(RunStationEiTimeband.class))).thenReturn(valuezxcv);
		paramStationEITimeBandsRepositoryImpl.createCamgenRunParamStationEITimeBands(stationEiBands, runId);
	}

	private CamgenRunParamStationEITimeBands getCamgenRunParamStationEITimeBands() {
		CamgenRunParamStationEITimeBands stationEiBands = new CamgenRunParamStationEITimeBands();
		CamgenRunParamStationEITimeBand camgenRunParamStationEITimeBand = new CamgenRunParamStationEITimeBand();
		camgenRunParamStationEITimeBand.setDayCode("dayCode");
		camgenRunParamStationEITimeBand.setEndTime("1233");
		camgenRunParamStationEITimeBand.setStartTime("1234");
		stationEiBands.add(camgenRunParamStationEITimeBand);
		return stationEiBands;
	}

	@Test
	public void testCreateCamgenRunParamStationEITimeBandsException() {
		CamgenRunParamStationEITimeBands stationEiBands = getCamgenRunParamStationEITimeBands();

		when(camgenRunJpaRepository.findOne(Mockito.anyLong())).thenReturn(null);
		int exc = 0;
		try {
			Integer runId = 1;
			paramStationEITimeBandsRepositoryImpl.createCamgenRunParamStationEITimeBands(stationEiBands, runId);
		} catch (MintBaseException e) {
			exc = e.getCode();
		}
		assertEquals(exc, HttpStatus.NOT_FOUND.value());
	}

	@Test
	public void testCreateCamgenRunParamStationTimeBandsException1Test() {
		CamgenRunParamStationEITimeBands stationEiBands = getCamgenRunParamStationEITimeBands();
		when(camgenRunJpaRepository.findOne(Mockito.anyLong()))
				.thenThrow(new DataRetrievalFailureException("Exception from database"));
		int exc = 0;
		try {
			Integer runId = 1;
			paramStationEITimeBandsRepositoryImpl.createCamgenRunParamStationEITimeBands(stationEiBands, runId);
		} catch (MintBaseException e) {
			exc = e.getCode();
		}
		assertEquals(exc, HttpStatus.INTERNAL_SERVER_ERROR.value());
	}

	@Test
	public void getCamgenRunParamStationEITimeBandsSuccessTest() throws Exception {
		when(camgenRunJpaRepository.findOne(Mockito.anyLong())).thenReturn(camgenRun);
		paramStationEITimeBandsRepositoryImpl.getCamgenRunParamStationEITimeBands(1);
	}

	@Test
	public void getCamgenRunParamStationEITimeBandsExceptionTest() throws Exception {
		DataRetrievalFailureException dataRetrievalFailureException = new DataRetrievalFailureException(
				"DataRetrivalFailureException");
		when(camgenRunJpaRepository.findOne(Mockito.anyLong())).thenThrow(dataRetrievalFailureException);
		int exceptionCode = 0;
		try {
			paramStationEITimeBandsRepositoryImpl.getCamgenRunParamStationEITimeBands(1);
		} catch (MintBaseException mintBaseException) {
			exceptionCode = mintBaseException.getCode();
		}
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), exceptionCode);
	}

	@Test
	public void getCamgenRunParamStationEITimeBandsException() {
		when(camgenRunJpaRepository.findOne(Mockito.anyLong())).thenReturn(null);
		int exc = 0;
		try {
			paramStationEITimeBandsRepositoryImpl.getCamgenRunParamStationEITimeBands(1);
		} catch (MintBaseException e) {
			exc = e.getCode();
		}
		assertEquals(exc, HttpStatus.NOT_FOUND.value());
	}
}
