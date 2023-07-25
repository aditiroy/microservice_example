package com.channel4.mint.automated.spot.infrastructure.persistence.repository.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.http.HttpStatus;

import com.channel4.mint.automated.spot.application.util.CamgenRunIterationMapper;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenRunIterationJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenRunJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRun;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRunIteration;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunIterations;
import com.channel4.mint.automated.spot.test.util.TestUtil;
import com.channel4.mint.baseexception.MintBaseException;

public class RunIterationRepositoryImplTest {

	@InjectMocks
	RunIterationRepositoryImpl runIterationRepositoryImpl;

	@Mock
	private CamgenRunIterationJpaRepository camgenRunIterationJpaRepository;

	@Mock
	private CamgenRunIterationMapper camgenRunIterationMapper;

	@Mock
	private CamgenRunJpaRepository camgenRunJpaRepository;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	List<CamgenRunIteration> camgenRunIterationList = new ArrayList<>();
	CamgenRunIteration camgenRunIteration = new CamgenRunIteration();
	com.channel4.mint.automated.spot.interfaces.dto.CamgenRunIteration camgenRunIterationDto = new com.channel4.mint.automated.spot.interfaces.dto.CamgenRunIteration();
	CamgenRunIterations camgenRunIterations;
	CamgenRun camgenRun;
	TestUtil testUtil = new TestUtil();

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);

		camgenRunIterations = testUtil.getCamgenRunIterations();
		camgenRunIterationList.add(camgenRunIteration);
		
		camgenRun= testUtil.getCamgenRun();
		camgenRunIterationDto = testUtil.getCamgenRunIteration();
	}

	@Test
	public void ccreateCamgenRunIterationsSuccessTest() throws Exception {
		when(camgenRunIterationMapper.mapCamgenRunIterations(Mockito.any(CamgenRunIterations.class))).thenReturn(camgenRunIterationList);
		when(camgenRunIterationJpaRepository.save(Mockito.anyList())).thenReturn(camgenRunIterationList);
		
		runIterationRepositoryImpl.createCamgenRunIterations(camgenRunIterations);
	}

	@Test
	public void ccreateCamgenRunIterationsExceptionTest() throws Exception {
		DataRetrievalFailureException dataRetrievalFailureException = new DataRetrievalFailureException(
				"DataRetrivalFailureException");
		when(camgenRunIterationMapper.mapCamgenRunIterations(Mockito.any(CamgenRunIterations.class))).thenThrow(dataRetrievalFailureException);
		int exceptionCode = 0;
		try {
			runIterationRepositoryImpl.createCamgenRunIterations(camgenRunIterations);
		} catch (MintBaseException mintBaseException) {
			exceptionCode = mintBaseException.getCode();
		}
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), exceptionCode);
	}

	@Test
	public void findCamgenRunSuccessTest() throws Exception {
		when(camgenRunJpaRepository.findOne(Mockito.anyLong())).thenReturn(camgenRun);
		CamgenRun response = runIterationRepositoryImpl.findCamgenRun(camgenRunIterationDto);
		assertEquals(response.getCamgenRequest().getRequestId(),camgenRun.getCamgenRequest().getRequestId());
		assertEquals(response.getCreatedBy(),camgenRun.getCreatedBy());
		assertEquals(response.getIterationNumberFile(),camgenRun.getIterationNumberFile());
		assertEquals(response.getRunId(),camgenRun.getRunId());
	}

	@Test
	public void findCamgenRunExceptionTest() throws Exception {
		DataRetrievalFailureException dataRetrievalFailureException = new DataRetrievalFailureException(
				"DataRetrivalFailureException");
		when(camgenRunJpaRepository.findOne(Mockito.anyLong())).thenThrow(dataRetrievalFailureException);
		int exceptionCode = 0;
		try {
			runIterationRepositoryImpl.findCamgenRun(camgenRunIterationDto);
		} catch (MintBaseException mintBaseException) {
			exceptionCode = mintBaseException.getCode();
		}
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), exceptionCode);
	}
	
	@Test
	public void findCamgenRunExceptionDataNotFoundExceptionTest() throws Exception {
		when(camgenRunJpaRepository.findOne(Mockito.anyLong())).thenReturn(null);
		int exceptionCode = 0;
		try {
			runIterationRepositoryImpl.findCamgenRun(camgenRunIterationDto);
		} catch (MintBaseException mintBaseException) {
			exceptionCode = mintBaseException.getCode();
		}
		assertEquals(HttpStatus.NOT_FOUND.value(), exceptionCode);
	}

	@Test
	public void getCamgenRunIterationsSuccessTest() throws Exception {
		when(camgenRunJpaRepository.findOne(Mockito.anyLong())).thenReturn(camgenRun);
		when(camgenRunIterationMapper.getCamgenRun(Mockito.any(CamgenRun.class))).thenReturn(camgenRunIterations);
		CamgenRunIterations response = runIterationRepositoryImpl.getCamgenRunIterations(1);
		assertEquals(response.get(0).getCreatedBy(), camgenRun.getCreatedBy());
		assertEquals(response.get(0).getRunId().intValue(), camgenRun.getRunId());
	}

	@Test
	public void findCamgenParamStationEITimeBandExceptionTest() throws Exception {
		DataRetrievalFailureException dataRetrievalFailureException = new DataRetrievalFailureException(
				"DataRetrivalFailureException");
		when(camgenRunJpaRepository.findOne(Mockito.anyLong())).thenThrow(dataRetrievalFailureException);
		int exceptionCode = 0;
		try {
			runIterationRepositoryImpl.getCamgenRunIterations(1);
		} catch (MintBaseException mintBaseException) {
			exceptionCode = mintBaseException.getCode();
		}
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), exceptionCode);
	}

	@Test
	public void findCamgenParamStationEITimeBandDataNotFoundExceptionTest() throws Exception {
		when(camgenRunJpaRepository.findOne(Mockito.anyLong())).thenReturn(null);
		int exceptionCode = 0;
		try {
			runIterationRepositoryImpl.getCamgenRunIterations(1);
		} catch (MintBaseException mintBaseException) {
			exceptionCode = mintBaseException.getCode();
		}
		assertEquals(HttpStatus.NOT_FOUND.value(), exceptionCode);
	}
	
}
