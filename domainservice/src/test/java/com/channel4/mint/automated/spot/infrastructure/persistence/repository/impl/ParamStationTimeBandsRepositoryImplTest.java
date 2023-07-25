package com.channel4.mint.automated.spot.infrastructure.persistence.repository.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.http.HttpStatus;

import com.channel4.mint.automated.spot.application.util.DateTimeUtility;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenRunJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.RunStationTimebandJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenPlan;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRequest;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRun;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.RunStationTimeband;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamStationTimeBand;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamStationTimeBands;
import com.channel4.mint.automated.spot.test.util.TestUtil;
import com.channel4.mint.baseexception.MintBaseException;

public class ParamStationTimeBandsRepositoryImplTest {

	@InjectMocks
	private ParamStationTimeBandsRepositoryImpl paramStationTimeBandsRepositoryImpl;

	@Mock
	private RunStationTimebandJpaRepository runStationTimebandJpaRepository;

	@Mock
	private CamgenRunJpaRepository camgenRunJpaRepository;

	@Mock
	DateTimeUtility dateTimeUtility;

	TestUtil testUtil = new TestUtil();
	CamgenRun camgenRun;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);

		camgenRun = testUtil.getCamgenRun();
	}

	@Test
	public void testCreateCamgenRunParamStationTimeBands_success() throws Exception {
		List<RunStationTimeband> runStationEiTimebandList = new ArrayList<>();
		RunStationTimeband runStationTimeband = new RunStationTimeband();
		runStationTimeband.setAmendDemand(new BigDecimal(1));
		runStationTimeband.setApplicableDay("applicableDay");
		runStationTimeband.setChannelId(new BigDecimal(1));
		runStationTimeband.setCreatedBy("createdBy");
		runStationTimeband.setEiCutOff(new BigDecimal(1));
		runStationTimeband.setEndTime("endTime");
		runStationTimeband.setIsExclude(new BigDecimal(1));
		runStationTimeband.setModifiedBy("modifiedBy");
		runStationTimeband.setStartTime("startTime");
		runStationTimeband.setStationTimebandId(1l);
		runStationTimeband.setTbProgRepititionLimit(new BigDecimal(1));
		runStationTimeband.setTimeband("timeband");
		runStationEiTimebandList.add(runStationTimeband);
		CamgenRunParamStationTimeBands camgenRunParamStationTimeBands = getCamgenRunParamStationTimeBands();
		CamgenRun camgenRun = new CamgenRun();
		camgenRun.setRunId(1);
		camgenRun.setCreatedBy("createdBy");
		CamgenRequest camgenRequest = new CamgenRequest();
		CamgenPlan camgenPlan = new CamgenPlan();
		camgenRequest.setCamgenPlan(camgenPlan);
		camgenRun.setCamgenRequest(camgenRequest);
		when(camgenRunJpaRepository.findOne(1l)).thenReturn(camgenRun);
		when(runStationTimebandJpaRepository.save(runStationEiTimebandList)).thenReturn(runStationEiTimebandList);
		paramStationTimeBandsRepositoryImpl.createCamgenRunParamStationTimeBands(camgenRunParamStationTimeBands, 1);
	}

	private CamgenRunParamStationTimeBands getCamgenRunParamStationTimeBands() {
		CamgenRunParamStationTimeBands camgenRunParamStationTimeBands = new CamgenRunParamStationTimeBands();

		CamgenRunParamStationTimeBand camgenRunParamStationTimeBand = new CamgenRunParamStationTimeBand();
		camgenRunParamStationTimeBand.setAmendDemand(1);
		camgenRunParamStationTimeBand.setChannelId(1);
		camgenRunParamStationTimeBand.setDayCode("dayCode");
		camgenRunParamStationTimeBand.setEiCutOff(1);
		camgenRunParamStationTimeBand.setEndTime("endTime");
		camgenRunParamStationTimeBand.setExcludeFlag("excludeFlag");
		camgenRunParamStationTimeBand.setName("name");
		camgenRunParamStationTimeBand.setStartTime("startTime");
		camgenRunParamStationTimeBand.setStationTimeBandId(1);
		camgenRunParamStationTimeBand.setTbProgRepetitionLimit(1);
		camgenRunParamStationTimeBands.add(camgenRunParamStationTimeBand);
		return camgenRunParamStationTimeBands;
	}

	@Test
	public void testCreateCamgenRunParamStationTimeBandsException() {
		CamgenRunParamStationTimeBands camgenRunParamStationTimeBands = getCamgenRunParamStationTimeBands();
		when(camgenRunJpaRepository.findOne(Mockito.anyLong())).thenReturn(null);
		int exc = 0;
		try {
			paramStationTimeBandsRepositoryImpl.createCamgenRunParamStationTimeBands(camgenRunParamStationTimeBands, 1);
		} catch (MintBaseException e) {
			exc = e.getCode();
		}
		assertEquals(exc, HttpStatus.NOT_FOUND.value());
	}

	@Test
	public void testCreateCamgenRunParamStationTimeBandsException1Test() {
		CamgenRunParamStationTimeBands camgenRunParamStationTimeBands = getCamgenRunParamStationTimeBands();
		when(camgenRunJpaRepository.findOne(Mockito.anyLong()))
				.thenThrow(new DataRetrievalFailureException("Exception from database"));
		int exc = 0;
		try {
			paramStationTimeBandsRepositoryImpl.createCamgenRunParamStationTimeBands(camgenRunParamStationTimeBands, 1);
		} catch (MintBaseException e) {
			exc = e.getCode();
		}
		assertEquals(exc, HttpStatus.INTERNAL_SERVER_ERROR.value());
	}

	@Test
	public void getCamgenRunParamStationEITimeBandsSuccessTest() throws Exception {
		when(camgenRunJpaRepository.findOne(Mockito.anyLong())).thenReturn(camgenRun);
		paramStationTimeBandsRepositoryImpl.getCamgenRunParamStationEITimeBands(1);
	}

	@Test
	public void getCamgenRunParamStationEITimeBandsExceptionTest() throws Exception {
		DataRetrievalFailureException dataRetrievalFailureException = new DataRetrievalFailureException(
				"DataRetrivalFailureException");
		when(camgenRunJpaRepository.findOne(Mockito.anyLong())).thenThrow(dataRetrievalFailureException);
		int exceptionCode = 0;
		try {
			paramStationTimeBandsRepositoryImpl.getCamgenRunParamStationEITimeBands(1);
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
			paramStationTimeBandsRepositoryImpl.getCamgenRunParamStationEITimeBands(1);
		} catch (MintBaseException e) {
			exc = e.getCode();
		}
		assertEquals(exc, HttpStatus.NOT_FOUND.value());
	}

}
