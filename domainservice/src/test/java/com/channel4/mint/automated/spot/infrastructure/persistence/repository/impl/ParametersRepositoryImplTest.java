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

import com.channel4.mint.automated.spot.application.util.CamgenExtractMapper;
import com.channel4.mint.automated.spot.application.util.DateTimeUtility;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenExtractParameterJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenRunJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.ParamExtractsRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.RunParameterJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenExtractParameter;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRun;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParam;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParameters;
import com.channel4.mint.automated.spot.test.util.TestUtil;
import com.channel4.mint.baseexception.MintBaseException;

public class ParametersRepositoryImplTest {

	@InjectMocks
	ParametersRepositoryImpl parametersRepositoryImpl;

	@Mock
	CamgenExtractMapper camgenExtractMapper;

	@Mock
	ParamExtractsRepository paramExtractsRepository;

	@Mock
	CamgenExtractParameterJpaRepository camgenExtractParameterJpaRepository;

	@Mock
	private CamgenRunJpaRepository camgenRunJpaRepository;

	@Mock
	private RunParameterJpaRepository runParameterJpaRepository;

	@Mock
	private DateTimeUtility dateTimeUtility;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	List<CamgenExtractParameter> camgenExtractParameterList = new ArrayList<>();
	CamgenExtractParameter camgenExtractParameter = new CamgenExtractParameter();
	CamgenRunParameters camgenRunParameters = new CamgenRunParameters();
	CamgenRunParam camgenRunParam;
	CamgenRun camgenRun;
	TestUtil testUtil = new TestUtil();

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);

		camgenExtractParameter = testUtil.getCamgenExtractParameter();
		camgenExtractParameterList.add(camgenExtractParameter);

		camgenRun = testUtil.getCamgenRun();
		camgenRunParam = testUtil.getCamgenRunParam();
		camgenRunParameters.add(camgenRunParam);
	}

	@Test
	public void createCamgenParamExtractsSuccessTest() throws Exception {
		when(camgenExtractParameterJpaRepository.save(Mockito.anyList())).thenReturn(camgenExtractParameterList);
		parametersRepositoryImpl.createCamgenParamExtracts(camgenExtractParameterList);
	}

	@Test
	public void createCamgenParamExtractsExceptionTest() throws Exception {
		DataRetrievalFailureException dataRetrievalFailureException = new DataRetrievalFailureException(
				"DataRetrivalFailureException");
		when(camgenExtractParameterJpaRepository.save(Mockito.anyList())).thenThrow(dataRetrievalFailureException);
		int exceptionCode = 0;
		try {
			parametersRepositoryImpl.createCamgenParamExtracts(camgenExtractParameterList);
		} catch (MintBaseException mintBaseException) {
			exceptionCode = mintBaseException.getCode();
		}
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), exceptionCode);
	}

	@Test
	public void getCamgenParamExtractsSuccessTest() throws Exception {
		when(camgenExtractParameterJpaRepository.findAll()).thenReturn(camgenExtractParameterList);
		parametersRepositoryImpl.getCamgenParamExtracts();
	}

	@Test
	public void getCamgenParamExtractsExceptionTest() throws Exception {
		DataRetrievalFailureException dataRetrievalFailureException = new DataRetrievalFailureException(
				"DataRetrivalFailureException");
		when(camgenExtractParameterJpaRepository.findAll()).thenThrow(dataRetrievalFailureException);
		int exceptionCode = 0;
		try {
			parametersRepositoryImpl.getCamgenParamExtracts();
		} catch (MintBaseException mintBaseException) {
			exceptionCode = mintBaseException.getCode();
		}
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), exceptionCode);
	}
	
	@Test
	public void getCamgenParamExtractsDataNotFoundExceptionTest() throws Exception {
		when(camgenExtractParameterJpaRepository.findAll()).thenReturn(null);
		int exceptionCode = 0;
		try {
			parametersRepositoryImpl.getCamgenParamExtracts();
		} catch (MintBaseException mintBaseException) {
			exceptionCode = mintBaseException.getCode();
		}
		assertEquals(HttpStatus.NOT_FOUND.value(), exceptionCode);
	}

	@Test
	public void getCamgenExtractParameterSuccessTest() throws Exception {
		when(camgenExtractParameterJpaRepository.findOne(Mockito.anyLong())).thenReturn(camgenExtractParameter);
		parametersRepositoryImpl.getCamgenExtractParameter(1L);
	}

	@Test
	public void getCamgenExtractParameterExceptionTest() throws Exception {
		DataRetrievalFailureException dataRetrievalFailureException = new DataRetrievalFailureException(
				"DataRetrivalFailureException");
		when(camgenExtractParameterJpaRepository.findOne(Mockito.anyLong())).thenThrow(dataRetrievalFailureException);
		int exceptionCode = 0;
		try {
			parametersRepositoryImpl.getCamgenExtractParameter(1L);
		} catch (MintBaseException mintBaseException) {
			exceptionCode = mintBaseException.getCode();
		}
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), exceptionCode);
	}

	@Test
	public void getCamgenExtractParameterDataNotFoundExceptionTest() {
		when(camgenExtractParameterJpaRepository.findOne(Mockito.anyLong())).thenReturn(null);
		int exc = 0;
		try {
			parametersRepositoryImpl.getCamgenExtractParameter(1L);
		} catch (MintBaseException e) {
			exc = e.getCode();
		}
		assertEquals(exc, HttpStatus.NOT_FOUND.value());
	}
	
	@Test
	public void createCamgenRunParametersSuccessTest() throws Exception {
		when(camgenRunJpaRepository.findOne(Mockito.anyLong())).thenReturn(camgenRun);
		when(runParameterJpaRepository.save(Mockito.anyList())).thenReturn(camgenRunParameters);
		parametersRepositoryImpl.createCamgenRunParameters(camgenRunParameters, 1);
	}

	@Test
	public void createCamgenRunParametersExceptionTest() throws Exception {
		DataRetrievalFailureException dataRetrievalFailureException = new DataRetrievalFailureException(
				"DataRetrivalFailureException");
		when(camgenRunJpaRepository.findOne(Mockito.anyLong())).thenReturn(camgenRun);
		when(runParameterJpaRepository.save(Mockito.anyList())).thenThrow(dataRetrievalFailureException);
		int exceptionCode = 0;
		try {
			parametersRepositoryImpl.createCamgenRunParameters(camgenRunParameters, 1);
		} catch (MintBaseException mintBaseException) {
			exceptionCode = mintBaseException.getCode();
		}
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), exceptionCode);
	}

	@Test
	public void getCamgenRunParametersSuccessTest() throws Exception {
		when(camgenRunJpaRepository.findOne(Mockito.anyLong())).thenReturn(camgenRun);
		parametersRepositoryImpl.getCamgenRunParameters(1);
	}

	@Test
	public void getCamgenRunParametersExceptionTest() throws Exception {
		DataRetrievalFailureException dataRetrievalFailureException = new DataRetrievalFailureException(
				"DataRetrivalFailureException");
		when(camgenRunJpaRepository.findOne(Mockito.anyLong())).thenThrow(dataRetrievalFailureException);
		int exceptionCode = 0;
		try {
			parametersRepositoryImpl.getCamgenRunParameters(1);
		} catch (MintBaseException mintBaseException) {
			exceptionCode = mintBaseException.getCode();
		}
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), exceptionCode);
	}

	@Test
	public void getCamgenRunParametersException() {
		when(camgenRunJpaRepository.findOne(Mockito.anyLong())).thenReturn(null);
		int exc = 0;
		try {
			parametersRepositoryImpl.getCamgenRunParameters(1);
		} catch (MintBaseException e) {
			exc = e.getCode();
		}
		assertEquals(exc, HttpStatus.NOT_FOUND.value());
	}

}
