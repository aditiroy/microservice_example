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

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenStationTimebandJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenStationTimeband;
import com.channel4.mint.automated.spot.test.util.TestUtil;
import com.channel4.mint.baseexception.MintBaseException;

public class StationTimeBandsRepositoryImplTest {

	@InjectMocks
	StationTimeBandsRepositoryImpl stationTimeBandsRepositoryImpl;

	@Mock
	private CamgenStationTimebandJpaRepository camgenStationTimebandJpaRepository;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	List<CamgenStationTimeband> camgenStationTimebandList = new ArrayList<>();
	CamgenStationTimeband camgenStationTimeband = new CamgenStationTimeband();
	TestUtil testUtil = new TestUtil();

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);

		camgenStationTimeband = testUtil.getCamgenStationTimeband();
		camgenStationTimebandList.add(camgenStationTimeband);
	}

	@Test
	public void createCamgenParamStationTimeBandsSuccessTest() throws Exception {
		when(camgenStationTimebandJpaRepository.save(Mockito.anyList())).thenReturn(camgenStationTimebandList);
		stationTimeBandsRepositoryImpl.createCamgenParamStationTimeBands(camgenStationTimebandList);
	}

	@Test
	public void createCamgenParamStationTimeBandsExceptionTest() throws Exception {
		DataRetrievalFailureException dataRetrievalFailureException = new DataRetrievalFailureException(
				"DataRetrivalFailureException");
		when(camgenStationTimebandJpaRepository.save(Mockito.anyList())).thenThrow(dataRetrievalFailureException);
		int exceptionCode = 0;
		try {
			stationTimeBandsRepositoryImpl.createCamgenParamStationTimeBands(camgenStationTimebandList);
		} catch (MintBaseException mintBaseException) {
			exceptionCode = mintBaseException.getCode();
		}
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), exceptionCode);
	}

	@Test
	public void getCamgenParamStationTimeBandsSuccessTest() throws Exception {
		when(camgenStationTimebandJpaRepository.findAll()).thenReturn(camgenStationTimebandList);
		stationTimeBandsRepositoryImpl.getCamgenParamStationTimeBands();
	}

	@Test
	public void getCamgenParamStationTimeBandsExceptionTest() throws Exception {
		DataRetrievalFailureException dataRetrievalFailureException = new DataRetrievalFailureException(
				"DataRetrivalFailureException");
		when(camgenStationTimebandJpaRepository.findAll()).thenThrow(dataRetrievalFailureException);
		int exceptionCode = 0;
		try {
			stationTimeBandsRepositoryImpl.getCamgenParamStationTimeBands();
		} catch (MintBaseException mintBaseException) {
			exceptionCode = mintBaseException.getCode();
		}
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), exceptionCode);
	}
	
	@Test
	public void getCamgenParamStationTimeBandsDataNotFoundExceptionTest() throws Exception {
		when(camgenStationTimebandJpaRepository.findAll()).thenReturn(null);
		int exceptionCode = 0;
		try {
			stationTimeBandsRepositoryImpl.getCamgenParamStationTimeBands();
		} catch (MintBaseException mintBaseException) {
			exceptionCode = mintBaseException.getCode();
		}
		assertEquals(HttpStatus.NOT_FOUND.value(), exceptionCode);
	}
	

	@Test
	public void getCamgenStationTimebandSuccessTest() throws Exception {
		when(camgenStationTimebandJpaRepository.findOne(Mockito.anyLong())).thenReturn(camgenStationTimeband);
		stationTimeBandsRepositoryImpl.getCamgenStationTimeband(1L);
	}

	@Test
	public void getCamgenStationTimebandExceptionTest() throws Exception {
		DataRetrievalFailureException dataRetrievalFailureException = new DataRetrievalFailureException(
				"DataRetrivalFailureException");
		when(camgenStationTimebandJpaRepository.findOne(Mockito.anyLong())).thenThrow(dataRetrievalFailureException);
		int exceptionCode = 0;
		try {
			stationTimeBandsRepositoryImpl.getCamgenStationTimeband(1L);
		} catch (MintBaseException mintBaseException) {
			exceptionCode = mintBaseException.getCode();
		}
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), exceptionCode);
	}

	@Test
	public void getCamgenStationTimebandDataNotFoundExceptionTest() throws Exception {
		when(camgenStationTimebandJpaRepository.findOne(Mockito.anyLong())).thenReturn(null);
		int exceptionCode = 0;
		try {
			stationTimeBandsRepositoryImpl.getCamgenStationTimeband(1L);
		} catch (MintBaseException mintBaseException) {
			exceptionCode = mintBaseException.getCode();
		}
		assertEquals(HttpStatus.NOT_FOUND.value(), exceptionCode);
	}
	
}
