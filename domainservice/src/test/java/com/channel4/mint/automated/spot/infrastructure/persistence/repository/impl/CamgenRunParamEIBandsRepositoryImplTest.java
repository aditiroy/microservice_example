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

import com.channel4.mint.automated.spot.application.util.DateTimeUtility;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenRunJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.ParamExtractsRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.RunEiBandJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRun;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamEIBand;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamEIBands;
import com.channel4.mint.automated.spot.test.util.TestUtil;
import com.channel4.mint.baseexception.MintBaseException;

public class CamgenRunParamEIBandsRepositoryImplTest {

	@InjectMocks
	private CamgenRunParamEIBandsRepositoryImpl camgenRunParamEIBandsRepositoryImpl;

	@Mock
	private CamgenRunJpaRepository camgenRunJpaRepository;

	@Mock
	private RunEiBandJpaRepository runEiBandJpaRepository;

	@Mock
	private DateTimeUtility dateTimeUtility;

	@Mock
	ParamExtractsRepository paramExtractsRepository;

	CamgenRunParamEIBands camgenRunParamEIBands = new CamgenRunParamEIBands();
	CamgenRunParamEIBand camgenRunParamEIBand;
	TestUtil testUtil = new TestUtil();
	CamgenRun camgenRun;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);

		camgenRun = testUtil.getCamgenRun();
		camgenRunParamEIBand = testUtil.getCamgenRunParamEIBand();
		camgenRunParamEIBands.add(camgenRunParamEIBand);
	}

	@Test
	public void createCamgenRunParamExtractsSuccessTest() throws Exception {
		when(camgenRunJpaRepository.findOne(Mockito.anyLong())).thenReturn(camgenRun);
		when(runEiBandJpaRepository.save(Mockito.anyList())).thenReturn(camgenRunParamEIBands);
		camgenRunParamEIBandsRepositoryImpl.createCamgenRunParamEIBands(camgenRunParamEIBands, 1);
	}

	@Test
	public void createCamgenRunParamExtractsExceptionTest() throws Exception {
		DataRetrievalFailureException dataRetrievalFailureException = new DataRetrievalFailureException(
				"DataRetrivalFailureException");
		when(camgenRunJpaRepository.findOne(Mockito.anyLong())).thenReturn(camgenRun);
		when(runEiBandJpaRepository.save(Mockito.anyList())).thenThrow(dataRetrievalFailureException);
		int exceptionCode = 0;
		try {
			camgenRunParamEIBandsRepositoryImpl.createCamgenRunParamEIBands(camgenRunParamEIBands, 1);
		} catch (MintBaseException mintBaseException) {
			exceptionCode = mintBaseException.getCode();
		}
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), exceptionCode);
	}

	@Test
	public void getCamgenRunParamEIBandsSuccessTest() throws Exception {
		when(camgenRunJpaRepository.findOne(Mockito.anyLong())).thenReturn(camgenRun);
		camgenRunParamEIBandsRepositoryImpl.getCamgenRunParamEIBands(1);
	}

	@Test
	public void getCamgenRunParamEIBandsExceptionTest() throws Exception {
		DataRetrievalFailureException dataRetrievalFailureException = new DataRetrievalFailureException(
				"DataRetrivalFailureException");
		when(camgenRunJpaRepository.findOne(Mockito.anyLong())).thenThrow(dataRetrievalFailureException);
		int exceptionCode = 0;
		try {
			camgenRunParamEIBandsRepositoryImpl.getCamgenRunParamEIBands(1);
		} catch (MintBaseException mintBaseException) {
			exceptionCode = mintBaseException.getCode();
		}
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), exceptionCode);
	}

	@Test
	public void getCamgenRunParamEIBandsException() {
		when(camgenRunJpaRepository.findOne(Mockito.anyLong())).thenReturn(null);
		int exc = 0;
		try {
			camgenRunParamEIBandsRepositoryImpl.getCamgenRunParamEIBands(1);
		} catch (MintBaseException e) {
			exc = e.getCode();
		}
		assertEquals(exc, HttpStatus.NOT_FOUND.value());
	}

}
