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

import com.channel4.mint.automated.spot.application.util.CamgenParameterMapper;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenParameterJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenParameter;
import com.channel4.mint.automated.spot.test.util.TestUtil;
import com.channel4.mint.baseexception.MintBaseException;

public class CamgenParametersRepositoryImplTest {

	@InjectMocks
	CamgenParametersRepositoryImpl camgenParametersRepositoryImpl;

	@Mock
	CamgenParameterJpaRepository camgenParameterJpaRepository;

	@Mock
	private CamgenParameterMapper camgenParameterMapper;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	List<CamgenParameter> camgenParameterList = new ArrayList<>();
	CamgenParameter camgenParameter = new CamgenParameter();
	TestUtil testUtil = new TestUtil();

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);

		camgenParameter = testUtil.getCamgenParameter();
		camgenParameterList.add(camgenParameter);
	}

	@Test
	public void createCamgenParametersSuccessTest() throws Exception {
		when(camgenParameterJpaRepository.save(Mockito.anyList())).thenReturn(camgenParameterList);
		camgenParametersRepositoryImpl.createCamgenParameters(camgenParameterList);
	}

	@Test
	public void createCamgenParametersExceptionTest() throws Exception {
		DataRetrievalFailureException dataRetrievalFailureException = new DataRetrievalFailureException(
				"DataRetrivalFailureException");
		when(camgenParameterJpaRepository.save(Mockito.anyList())).thenThrow(dataRetrievalFailureException);
		int exceptionCode = 0;
		try {
			camgenParametersRepositoryImpl.createCamgenParameters(camgenParameterList);
		} catch (MintBaseException mintBaseException) {
			exceptionCode = mintBaseException.getCode();
		}
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), exceptionCode);
	}
	
	@Test
	public void getCamgenParametersSuccessTest() throws Exception {
		when(camgenParameterJpaRepository.findAll()).thenReturn(camgenParameterList);
		camgenParametersRepositoryImpl.getCamgenParameters();
	}
	
	@Test
	
	public void getCamgenParametersDataNotFoundException(){
		when(camgenParameterJpaRepository.findAll()).thenReturn(null);
		int exc = 0;
		try {
			camgenParametersRepositoryImpl.getCamgenParameters();
		} catch (MintBaseException e) {
			exc = e.getCode();
		}
		assertEquals(exc, HttpStatus.NOT_FOUND.value());
	}
	@Test
	public void getCamgenParametersExceptionTest() throws Exception {
		DataRetrievalFailureException dataRetrievalFailureException = new DataRetrievalFailureException(
				"DataRetrivalFailureException");
		when(camgenParameterJpaRepository.findAll()).thenThrow(dataRetrievalFailureException);
		int exceptionCode = 0;
		try {
			camgenParametersRepositoryImpl.getCamgenParameters();
		} catch (MintBaseException mintBaseException) {
			exceptionCode = mintBaseException.getCode();
		}
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), exceptionCode);
	}

	@Test
	public void getCamgenParameterSuccessTest() throws Exception {
		when(camgenParameterJpaRepository.findOne(Mockito.anyLong())).thenReturn(camgenParameter);
		camgenParametersRepositoryImpl.getCamgenParameter(1L);
	}
	@Test
	public void getCamgenParameterException(){
		when(camgenParameterJpaRepository.findOne(Mockito.anyLong())).thenReturn(null);
		int exc = 0;
		try {
			camgenParametersRepositoryImpl.getCamgenParameter(1L);
		} catch (MintBaseException e) {
			exc = e.getCode();
		}
		assertEquals(exc, HttpStatus.NOT_FOUND.value());
	}
	@Test
	public void getCamgenParameterExceptionTest() throws Exception {
		DataRetrievalFailureException dataRetrievalFailureException = new DataRetrievalFailureException(
				"DataRetrivalFailureException");
		when(camgenParameterJpaRepository.findOne(Mockito.anyLong())).thenThrow(dataRetrievalFailureException);
		int exceptionCode = 0;
		try {
			camgenParametersRepositoryImpl.getCamgenParameter(1L);
		} catch (MintBaseException mintBaseException) {
			exceptionCode = mintBaseException.getCode();
		}
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), exceptionCode);
	}

}
