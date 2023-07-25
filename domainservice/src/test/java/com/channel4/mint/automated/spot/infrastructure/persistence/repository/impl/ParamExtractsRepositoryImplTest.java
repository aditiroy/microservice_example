package com.channel4.mint.automated.spot.infrastructure.persistence.repository.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

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
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.RunExtractParameterJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRun;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.RunExtractParameter;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParam;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamExtract;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamExtracts;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParameters;
import com.channel4.mint.automated.spot.test.util.TestUtil;
import com.channel4.mint.baseexception.MintBaseException;

public class ParamExtractsRepositoryImplTest {

	@InjectMocks
	private ParamExtractsRepositoryImpl paramExtractsRepositoryImpl;
	
	@Mock
	private RunExtractParameterJpaRepository runExtractParameterJpaRepository;

	@Mock
	private CamgenRunJpaRepository camgenRunJpaRepository;

	@Mock
	private DateTimeUtility dateTimeUtility;
	
	List<RunExtractParameter> runExtractParameterRequest = new ArrayList<>();
	CamgenRunParameters camgenRunParameters = new CamgenRunParameters();
	CamgenRunParamExtracts camgenRunParamExtracts = new CamgenRunParamExtracts();
	CamgenRunParamExtract camgenRunParamExtract = new CamgenRunParamExtract();
	RunExtractParameter runExtractParameter;
	CamgenRunParam camgenRunParam; 
	TestUtil testUtil = new TestUtil();
	CamgenRun camgenRun;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);

		runExtractParameter = testUtil.getrunExtractParameter();
		camgenRun = testUtil.getCamgenRun();
		camgenRunParamExtract = testUtil.getCamgenRunParamExtract();
		camgenRunParamExtracts.add(camgenRunParamExtract);
	}
	
	@Test
	public void createCamgenRunParamExtractsSuccessTest() throws Exception {
		when(camgenRunJpaRepository.findOne(Mockito.anyLong())).thenReturn(camgenRun);
		when(runExtractParameterJpaRepository.save(Mockito.anyList())).thenReturn(runExtractParameterRequest);
		paramExtractsRepositoryImpl.createCamgenRunParamExtracts(camgenRunParamExtracts,1);
	}
	
	@Test
	public void createCamgenRunParamExtractsExceptionTest() throws Exception {
		DataRetrievalFailureException dataRetrievalFailureException = new DataRetrievalFailureException(
				"DataRetrivalFailureException");
		when(camgenRunJpaRepository.findOne(Mockito.anyLong())).thenReturn(camgenRun);
		when(runExtractParameterJpaRepository.save(Mockito.anyList())).thenThrow(dataRetrievalFailureException);
		int exceptionCode = 0;
		try {
			paramExtractsRepositoryImpl.createCamgenRunParamExtracts(camgenRunParamExtracts,1);
		} catch (MintBaseException mintBaseException) {
			exceptionCode = mintBaseException.getCode();
		}
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), exceptionCode);
	}
	
	@Test
	public void findRunParameterNullException() {
		when(camgenRunJpaRepository.findOne(Mockito.anyLong())).thenReturn(null);
		int exc=0;
		try{
			paramExtractsRepositoryImpl.createCamgenRunParamExtracts(camgenRunParamExtracts,1);
		}catch(MintBaseException e){
			exc=e.getCode();
		}
		assertEquals(exc,HttpStatus.NOT_FOUND.value());
	}
	
	@Test
	public void findRunParameterExceptionTest() throws Exception {
		DataRetrievalFailureException dataRetrievalFailureException = new DataRetrievalFailureException(
				"DataRetrivalFailureException");
		when(camgenRunJpaRepository.findOne(Mockito.anyLong())).thenThrow(dataRetrievalFailureException);
		int exceptionCode = 0;
		try {
			paramExtractsRepositoryImpl.createCamgenRunParamExtracts(camgenRunParamExtracts,1);
		} catch (MintBaseException mintBaseException) {
			exceptionCode = mintBaseException.getCode();
		}
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), exceptionCode);
	}
	
	@Test
	public void getCamgenRunParamExtractsSuccessTest() throws Exception {
		when(camgenRunJpaRepository.findOne(Mockito.anyLong())).thenReturn(camgenRun);
		paramExtractsRepositoryImpl.getCamgenRunParamExtracts(1);
	}
	
	@Test
	public void getCamgenRunParamExtractsExceptionTest() throws Exception {
		DataRetrievalFailureException dataRetrievalFailureException = new DataRetrievalFailureException(
				"DataRetrivalFailureException");
		when(camgenRunJpaRepository.findOne(Mockito.anyLong())).thenThrow(dataRetrievalFailureException);
		int exceptionCode = 0;
		try {
			paramExtractsRepositoryImpl.getCamgenRunParamExtracts(1);
		} catch (MintBaseException mintBaseException) {
			exceptionCode = mintBaseException.getCode();
		}
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), exceptionCode);
	}
	
	@Test
	public void getCamgenRunParamExtractsException() {
		when(camgenRunJpaRepository.findOne(Mockito.anyLong())).thenReturn(null);
		int exc=0;
		try{
			paramExtractsRepositoryImpl.getCamgenRunParamExtracts(1);
		}catch(MintBaseException e){
			exc=e.getCode();
		}
		assertEquals(exc,HttpStatus.NOT_FOUND.value());
	}

}
