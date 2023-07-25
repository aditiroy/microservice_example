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

import com.channel4.mint.automated.spot.application.util.SnapshotParamChannelSetTimebandsMapper;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenChannelSetTimebandJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenRequestJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenRqstChSetTimebandJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenChannelSetTimeband;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRequest;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRqstChSetTimeband;
import com.channel4.mint.automated.spot.interfaces.dto.ChannelSetTimeBands;
import com.channel4.mint.automated.spot.test.util.TestUtil;
import com.channel4.mint.baseexception.MintBaseException;

public class SnapshotParamChannelSetTimebandsRepositoryImplTest {

	@InjectMocks
	SnapshotParamChannelSetTimebandsRepositoryImpl snapshotParamChannelSetTimebandsRepositoryImpl;

	@Mock
	private CamgenRqstChSetTimebandJpaRepository camgenRqstChSetTimebandJpaRepository;

	@Mock
	private CamgenRequestJpaRepository camgenRequestJpaRepository;

	@Mock
	private CamgenChannelSetTimebandJpaRepository camgenChannelSetTimebandJpaRepository;

	@Mock
	private SnapshotParamChannelSetTimebandsMapper snapshotParamChannelSetTimebandsMapper;
	private List<CamgenRqstChSetTimeband> lstValue;
	private ChannelSetTimeBands channelSetTimeBands;
	private List<CamgenRqstChSetTimeband> lstcamgenRqstChSetTimebands;
	private TestUtil test = new TestUtil();

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		lstValue = test.getListCamgenRqstChSetTimeband();
		channelSetTimeBands = test.getChannelSetTimeBands();
		lstcamgenRqstChSetTimebands = test.getListCamgenRqstChSetTimeband();
	}

	@Test
	public void testGetSnapshotParamChannelSetTimebands() {
		CamgenRequest camgenRequest = new CamgenRequest();
		camgenRequest.setChannelSetId(new BigDecimal(1));
		camgenRequest.setRequestId(1l);
		when(camgenRequestJpaRepository.findOne(1l)).thenReturn(camgenRequest);
		snapshotParamChannelSetTimebandsRepositoryImpl.getSnapshotParamChannelSetTimebands(1l);
	}

	@Test
	public void testGetSnapshotParamChannelSetTimebands_exception() {
		CamgenRequest camgenRequest = new CamgenRequest();
		camgenRequest.setChannelSetId(new BigDecimal(1));
		camgenRequest.setRequestId(1l);
		when(camgenRequestJpaRepository.findOne(Mockito.anyLong())).thenReturn(null);
		int exc = 0;
		try {
			snapshotParamChannelSetTimebandsRepositoryImpl.getSnapshotParamChannelSetTimebands(1l);
		} catch (MintBaseException e) {
			exc = e.getCode();
		}
		assertEquals(exc, HttpStatus.NOT_FOUND.value());
	}

	@Test
	public void testCreateCamgenParamChannelSetTimebands() {
		when(camgenRqstChSetTimebandJpaRepository.save(lstValue)).thenReturn(lstValue);
		snapshotParamChannelSetTimebandsRepositoryImpl.createCamgenParamChannelSetTimebands(lstValue);
	}

	@Test
	public void testCreateCamgenParamChannelSetTimebandsException() {

		when(camgenRqstChSetTimebandJpaRepository.save(lstValue))
				.thenThrow(new DataRetrievalFailureException("Exception from Database"));
		int exc = 0;
		try {
			snapshotParamChannelSetTimebandsRepositoryImpl.createCamgenParamChannelSetTimebands(lstValue);
		} catch (MintBaseException e) {
			exc = e.getCode();
		}
		assertEquals(exc, HttpStatus.INTERNAL_SERVER_ERROR.value());
	}

	@Test
	public void testGetCamgenRunParamChannelSetTimebands() {
		CamgenRequest camgenRequest = new CamgenRequest();
		camgenRequest.setChannelSetId(new BigDecimal(1));
		camgenRequest.setRequestId(1l);
		camgenRequest.setCamgenRqstChSetTimebands(lstcamgenRqstChSetTimebands);
		when(camgenRequestJpaRepository.findOne(Mockito.anyLong())).thenReturn(camgenRequest);
		when(snapshotParamChannelSetTimebandsMapper.mapGetChannelSetTimebandsMapper(lstcamgenRqstChSetTimebands))
				.thenReturn(channelSetTimeBands);
		snapshotParamChannelSetTimebandsRepositoryImpl.getCamgenRunParamChannelSetTimebands(Mockito.anyInt());
	}

	@Test
	public void testGetCamgenRunParamChannelSetTimebandsEmptyTest_Success() {
		CamgenRequest camgenRequest = new CamgenRequest();
		camgenRequest.setChannelSetId(new BigDecimal(1));
		camgenRequest.setRequestId(1l);
		List<CamgenChannelSetTimeband> camgenChannelSetTimebandList = new ArrayList<>();
		CamgenChannelSetTimeband camgenChannelSetTimeband = new CamgenChannelSetTimeband();
		camgenChannelSetTimeband.setApplicableDay("Mon");
		camgenChannelSetTimeband.setAvailabilityPercentage(new BigDecimal(1));
		camgenChannelSetTimeband.setChannelSetId(new BigDecimal(1));
		camgenChannelSetTimeband.setEndTime("12:00:00");
		camgenChannelSetTimeband.setTimeband("timeband");
		camgenChannelSetTimeband.setStartTime("09:00:00");
		camgenChannelSetTimeband.setCamgenChannelSetTimebandId(1);
		camgenChannelSetTimebandList.add(camgenChannelSetTimeband);
		when(camgenRequestJpaRepository.findOne(Mockito.anyLong())).thenReturn(camgenRequest);
		when(camgenChannelSetTimebandJpaRepository.findAll()).thenReturn(camgenChannelSetTimebandList);
		when(snapshotParamChannelSetTimebandsMapper.mapGetChannelSetTimebandsMapper(lstcamgenRqstChSetTimebands))
				.thenReturn(channelSetTimeBands);
		snapshotParamChannelSetTimebandsRepositoryImpl.getCamgenRunParamChannelSetTimebands(Mockito.anyInt());
	}

	@Test
	public void testGetCamgenRunParamChannelSetTimebandsEmptyTest_Failure() {
		CamgenRequest camgenRequest = new CamgenRequest();
		camgenRequest.setChannelSetId(new BigDecimal(1));
		camgenRequest.setRequestId(1l);
		List<CamgenChannelSetTimeband> camgenChannelSetTimebandList = new ArrayList<>();
		int exceptionCode = 0;
		try {
			when(camgenRequestJpaRepository.findOne(Mockito.anyLong())).thenReturn(camgenRequest);
			when(camgenChannelSetTimebandJpaRepository.findAll()).thenReturn(camgenChannelSetTimebandList);
			when(snapshotParamChannelSetTimebandsMapper.mapGetChannelSetTimebandsMapper(lstcamgenRqstChSetTimebands))
					.thenReturn(channelSetTimeBands);
			snapshotParamChannelSetTimebandsRepositoryImpl.getCamgenRunParamChannelSetTimebands(Mockito.anyInt());
		} catch (MintBaseException mintBaseException) {
			exceptionCode = mintBaseException.getCode();
		}
		assertEquals(exceptionCode, HttpStatus.NOT_FOUND.value());
	}

	@Test
	public void testGetCamgenRunParamChannelSetTimebandsDBTest_Failure() {
		CamgenRequest camgenRequest = new CamgenRequest();
		camgenRequest.setChannelSetId(new BigDecimal(1));
		camgenRequest.setRequestId(1l);
		List<CamgenChannelSetTimeband> camgenChannelSetTimebandList = new ArrayList<>();
		int exceptionCode = 0;
		when(camgenRequestJpaRepository.findOne(Mockito.anyLong())).thenReturn(camgenRequest);
		when(camgenChannelSetTimebandJpaRepository.findAll())
				.thenThrow(new DataRetrievalFailureException("Exception from Database"));
		when(snapshotParamChannelSetTimebandsMapper.mapGetChannelSetTimebandsMapper(lstcamgenRqstChSetTimebands))
				.thenReturn(channelSetTimeBands);
		try {
			snapshotParamChannelSetTimebandsRepositoryImpl.getCamgenRunParamChannelSetTimebands(Mockito.anyInt());
		} catch (MintBaseException mintBaseException) {
			exceptionCode = mintBaseException.getCode();
		}
		assertEquals(exceptionCode, HttpStatus.INTERNAL_SERVER_ERROR.value());
	}

	@Test
	public void testGetCamgenRunParamChannelSetTimebandsException1() {

		when(camgenRequestJpaRepository.findOne(Mockito.anyLong())).thenReturn(null);
		int exc = 0;
		try {
			snapshotParamChannelSetTimebandsRepositoryImpl.getCamgenRunParamChannelSetTimebands(Mockito.anyInt());
		} catch (MintBaseException e) {
			exc = e.getCode();
		}
		assertEquals(exc, HttpStatus.NOT_FOUND.value());
	}

	@Test
	public void testGetCamgenRunParamChannelSetTimebandsException2() {

		when(camgenRequestJpaRepository.findOne(Mockito.anyLong()))
				.thenThrow(new DataRetrievalFailureException("Exception from Database"));
		int exc = 0;
		try {
			snapshotParamChannelSetTimebandsRepositoryImpl.getCamgenRunParamChannelSetTimebands(Mockito.anyInt());
		} catch (MintBaseException e) {
			exc = e.getCode();
		}
		assertEquals(exc, HttpStatus.INTERNAL_SERVER_ERROR.value());
	}
}
