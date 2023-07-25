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

import com.channel4.mint.automated.spot.application.util.StationEITimeBandsMapper;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenStationEiTimebandJPARepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenStationEiTimeband;
import com.channel4.mint.automated.spot.test.util.TestUtil;
import com.channel4.mint.baseexception.MintBaseException;

public class StationEITimeBandsRepositoryImplTest {

	@InjectMocks
	StationEITimeBandsRepositoryImpl stationEITimeBandsRepositoryImpl;

	@Mock
	private CamgenStationEiTimebandJPARepository camgenStationEiTimebandJPARepository;

	@Mock
	private StationEITimeBandsMapper stationEITimeBandsMapper;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	List<CamgenStationEiTimeband> camgenStationEiTimebandList = new ArrayList<>();
	CamgenStationEiTimeband camgenStationEiTimeband = new CamgenStationEiTimeband();
	TestUtil testUtil = new TestUtil();

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);

		camgenStationEiTimeband = testUtil.getCamgenStationEiTimeband();
		camgenStationEiTimebandList.add(camgenStationEiTimeband);
	}

	@Test
	public void createCamgenParamStationEITimeBandsSuccessTest() throws Exception {
		when(camgenStationEiTimebandJPARepository.save(Mockito.anyList())).thenReturn(camgenStationEiTimebandList);
		stationEITimeBandsRepositoryImpl.createCamgenParamStationEITimeBands(camgenStationEiTimebandList);
	}

	@Test
	public void createCamgenParamStationEITimeBandsExceptionTest() throws Exception {
		DataRetrievalFailureException dataRetrievalFailureException = new DataRetrievalFailureException(
				"DataRetrivalFailureException");
		when(camgenStationEiTimebandJPARepository.save(Mockito.anyList())).thenThrow(dataRetrievalFailureException);
		int exceptionCode = 0;
		try {
			stationEITimeBandsRepositoryImpl.createCamgenParamStationEITimeBands(camgenStationEiTimebandList);
		} catch (MintBaseException mintBaseException) {
			exceptionCode = mintBaseException.getCode();
		}
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), exceptionCode);
	}

	@Test
	public void getCamgenParamStationEITimeBandsSuccessTest() throws Exception {
		when(camgenStationEiTimebandJPARepository.findAll()).thenReturn(camgenStationEiTimebandList);
		stationEITimeBandsRepositoryImpl.getCamgenParamStationEITimeBands();
	}

	@Test
	public void getCamgenParamStationEITimeBandsExceptionTest() throws Exception {
		DataRetrievalFailureException dataRetrievalFailureException = new DataRetrievalFailureException(
				"DataRetrivalFailureException");
		when(camgenStationEiTimebandJPARepository.findAll()).thenThrow(dataRetrievalFailureException);
		int exceptionCode = 0;
		try {
			stationEITimeBandsRepositoryImpl.getCamgenParamStationEITimeBands();
		} catch (MintBaseException mintBaseException) {
			exceptionCode = mintBaseException.getCode();
		}
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), exceptionCode);
	}
	
	@Test
	public void getCamgenParamStationEITimeBandsDataNotFoundExceptionTest() throws Exception {
		when(camgenStationEiTimebandJPARepository.findAll()).thenReturn(null);
		int exceptionCode = 0;
		try {
			stationEITimeBandsRepositoryImpl.getCamgenParamStationEITimeBands();
		} catch (MintBaseException mintBaseException) {
			exceptionCode = mintBaseException.getCode();
		}
		assertEquals(HttpStatus.NOT_FOUND.value(), exceptionCode);
	}
	

	@Test
	public void findCamgenParamStationEITimeBandSuccessTest() throws Exception {
		when(camgenStationEiTimebandJPARepository.findOne(Mockito.anyLong())).thenReturn(camgenStationEiTimeband);
		stationEITimeBandsRepositoryImpl.findCamgenParamStationEITimeBand(1L);
	}

	@Test
	public void findCamgenParamStationEITimeBandExceptionTest() throws Exception {
		DataRetrievalFailureException dataRetrievalFailureException = new DataRetrievalFailureException(
				"DataRetrivalFailureException");
		when(camgenStationEiTimebandJPARepository.findOne(Mockito.anyLong())).thenThrow(dataRetrievalFailureException);
		int exceptionCode = 0;
		try {
			stationEITimeBandsRepositoryImpl.findCamgenParamStationEITimeBand(1L);
		} catch (MintBaseException mintBaseException) {
			exceptionCode = mintBaseException.getCode();
		}
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), exceptionCode);
	}
	
	@Test
	public void findCamgenParamStationEITimeBandDataNotFoundExceptionTest() throws Exception {
		when(camgenStationEiTimebandJPARepository.findOne(Mockito.anyLong())).thenReturn(null);
		int exceptionCode = 0;
		try {
			stationEITimeBandsRepositoryImpl.findCamgenParamStationEITimeBand(1L);
		} catch (MintBaseException mintBaseException) {
			exceptionCode = mintBaseException.getCode();
		}
		assertEquals(HttpStatus.NOT_FOUND.value(), exceptionCode);
	}

}
