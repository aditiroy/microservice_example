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
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenEiBandJPARepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenEiBand;
import com.channel4.mint.automated.spot.test.util.TestUtil;
import com.channel4.mint.baseexception.MintBaseException;

public class CamgenParamEIBandsRepositoryImplTest {

	@InjectMocks
	CamgenParamEIBandsRepositoryImpl camgenParamEIBandsRepositoryImpl;

	@Mock
	CamgenEiBandJPARepository camgenEiBandJPARepository;

	@Mock
	private StationEITimeBandsMapper stationEITimeBandsMapper;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	List<CamgenEiBand> camgenEiBandList = new ArrayList<>();
	CamgenEiBand camgenEiBand = new CamgenEiBand();
	TestUtil testUtil = new TestUtil();

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);

		camgenEiBand = testUtil.getCamgenEiBand();
		camgenEiBandList.add(camgenEiBand);
	}

	@Test
	public void createCamgenParamEIBandsSuccessTest() throws Exception {
		when(camgenEiBandJPARepository.save(Mockito.anyList())).thenReturn(camgenEiBandList);
		camgenParamEIBandsRepositoryImpl.createCamgenParamEIBands(camgenEiBandList);
	}

	@Test
	public void createCamgenParamEIBandsExceptionTest() throws Exception {
		DataRetrievalFailureException dataRetrievalFailureException = new DataRetrievalFailureException(
				"DataRetrivalFailureException");
		when(camgenEiBandJPARepository.save(Mockito.anyList())).thenThrow(dataRetrievalFailureException);
		int exceptionCode = 0;
		try {
			camgenParamEIBandsRepositoryImpl.createCamgenParamEIBands(camgenEiBandList);
		} catch (MintBaseException mintBaseException) {
			exceptionCode = mintBaseException.getCode();
		}
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), exceptionCode);
	}

	@Test
	public void getCamgenParamEIBandsSuccessTest() throws Exception {
		when(camgenEiBandJPARepository.findAll()).thenReturn(camgenEiBandList);
		camgenParamEIBandsRepositoryImpl.getCamgenParamEIBands();
	}

	@Test
	public void getCamgenParamEIBandsExceptionTest() throws Exception {
		DataRetrievalFailureException dataRetrievalFailureException = new DataRetrievalFailureException(
				"DataRetrivalFailureException");
		when(camgenEiBandJPARepository.findAll()).thenThrow(dataRetrievalFailureException);
		int exceptionCode = 0;
		try {
			camgenParamEIBandsRepositoryImpl.getCamgenParamEIBands();
		} catch (MintBaseException mintBaseException) {
			exceptionCode = mintBaseException.getCode();
		}
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), exceptionCode);
	}
	
	@Test
	public void getCamgenParamEIBandsDataNotFoundExceptionTest() throws Exception {
		when(camgenEiBandJPARepository.findAll()).thenReturn(null);
		int exceptionCode = 0;
		try {
			camgenParamEIBandsRepositoryImpl.getCamgenParamEIBands();
		} catch (MintBaseException mintBaseException) {
			exceptionCode = mintBaseException.getCode();
		}
		assertEquals(HttpStatus.NOT_FOUND.value(), exceptionCode);
	}


	@Test
	public void findCamgenParamEIBandSuccessTest() throws Exception {
		when(camgenEiBandJPARepository.findOne(Mockito.anyLong())).thenReturn(camgenEiBand);
		camgenParamEIBandsRepositoryImpl.findCamgenParamEIBand(1L);
	}

	@Test
	public void findCamgenParamEIBandExceptionTest() throws Exception {
		DataRetrievalFailureException dataRetrievalFailureException = new DataRetrievalFailureException(
				"DataRetrivalFailureException");
		when(camgenEiBandJPARepository.findOne(Mockito.anyLong())).thenThrow(dataRetrievalFailureException);
		int exceptionCode = 0;
		try {
			camgenParamEIBandsRepositoryImpl.findCamgenParamEIBand(1L);
		} catch (MintBaseException mintBaseException) {
			exceptionCode = mintBaseException.getCode();
		}
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), exceptionCode);
	}
	
	@Test
	public void findCamgenParamEIBandDataNotFoundExceptionTest() throws Exception {
		when(camgenEiBandJPARepository.findOne(Mockito.anyLong())).thenReturn(null);
		int exceptionCode = 0;
		try {
			camgenParamEIBandsRepositoryImpl.findCamgenParamEIBand(1L);
		} catch (MintBaseException mintBaseException) {
			exceptionCode = mintBaseException.getCode();
		}
		assertEquals(HttpStatus.NOT_FOUND.value(), exceptionCode);
	}

}
