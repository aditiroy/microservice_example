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

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenChannelSetTimebandJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenPlanDemandSupplyJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenRequestJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenRqstChSetTimebandJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenChannelSetTimeband;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRequest;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRqstChSetTimeband;
import com.channel4.mint.automated.spot.interfaces.dto.ChannelSetTimeBandResponse;
import com.channel4.mint.automated.spot.interfaces.dto.CriteriaLineNormalised;
import com.channel4.mint.automated.spot.test.util.TestUtil;
import com.channel4.mint.baseexception.MintBaseException;

public class ChannelSetTimebandsRepositoryImplTest {

	@InjectMocks
	private ChannelSetTimebandsRepositoryImpl channelSetTimebandsRepositoryImpl;

	@Mock
	private CamgenRequestJpaRepository camgenRequestJpaRepository;

	@Mock
	private CamgenRqstChSetTimebandJpaRepository camgenRqstChSetTimebandJpaRepository;
	
	@Mock
	private CamgenPlanDemandSupplyJpaRepository camgenPlanDemandSupplyJpaRepository;
	
	@Mock
	private CamgenChannelSetTimebandJpaRepository camgenChannelSetTimebandJpaRepository;

	private TestUtil testUtil = new TestUtil();
	private ChannelSetTimeBandResponse channelSetTimeBandResponse;
	private List<ChannelSetTimeBandResponse> channelSetTimeBandResponseList = new ArrayList<>();
	private List<CamgenRqstChSetTimeband> amgenRqstChSetTimebandList = new ArrayList<>();;
	CamgenRqstChSetTimeband camgenRqstChSetTimeband;
	private List<CamgenRequest> camgenRequestList = new ArrayList<>();;
	private CamgenRequest camgenRequest;
	List<CamgenRqstChSetTimeband> camgenRqstChSetTimebandList = new ArrayList<>();
	List<CamgenChannelSetTimeband> camgenChannelSetTimebandList = new ArrayList<>();
	CamgenChannelSetTimeband camgenChannelSetTimeband;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);

		channelSetTimeBandResponse = testUtil.getChannelSetTimeBandResponse();
		channelSetTimeBandResponseList.add(channelSetTimeBandResponse);

		camgenRqstChSetTimeband = testUtil.getCamgenRqstChSetTimeband();
		amgenRqstChSetTimebandList.add(camgenRqstChSetTimeband);

		camgenRequest = testUtil.getCamgenRequest();
		camgenRequestList.add(camgenRequest);

		camgenRqstChSetTimebandList.add(camgenRqstChSetTimeband);
		
		camgenChannelSetTimeband = testUtil.getCamgenChannelSetTimeband();
		camgenChannelSetTimebandList.add(camgenChannelSetTimeband);

	}

	@Test
	public void testgetCamgenParamChannelSetTimebandsSuccess() {
		when(camgenChannelSetTimebandJpaRepository.findAllByChannelSetId(Mockito.any())).thenReturn(camgenChannelSetTimebandList);
		List<ChannelSetTimeBandResponse> response = channelSetTimebandsRepositoryImpl
				.getCamgenParamChannelSetTimebands(1);
		assertEquals(response.get(0).getTimeBandId().intValue(), camgenRequestList.get(0).getChannelSetId().intValue());
	}

	@Test
	public void testgetCamgenParamChannelSetTimebands_Exception() {
		when(camgenChannelSetTimebandJpaRepository.findAllByChannelSetId(Mockito.any()))
				.thenThrow(new DataRetrievalFailureException("Exception from database"));
		int exc = 0;
		try {
			channelSetTimebandsRepositoryImpl.getCamgenParamChannelSetTimebands(1);
		} catch (MintBaseException e) {
			exc = e.getCode();
		}
		assertEquals(exc, HttpStatus.INTERNAL_SERVER_ERROR.value());
	}

	@Test
	public void testgetCamgenParamChannelSetTimebands_NullPointer() {
		when(camgenRequestJpaRepository.findAllByChannelSetId(Mockito.any())).thenReturn(null);
		int exc = 0;
		try {
			channelSetTimebandsRepositoryImpl.getCamgenParamChannelSetTimebands(1);
		} catch (MintBaseException e) {
			exc = e.getCode();
		}
		assertEquals(exc, HttpStatus.NOT_FOUND.value());
	}

	@Test
	public void testdeleteTimeBandSuccess() {
		when(camgenChannelSetTimebandJpaRepository.findOne(Mockito.anyLong())).thenReturn(camgenChannelSetTimeband);
		channelSetTimebandsRepositoryImpl.deleteTimeBand(1);
	}

	@Test
	public void testdeleteTimeBand_Exception() {
		DataRetrievalFailureException dataRetrievalFailureException = new DataRetrievalFailureException(
				"DataRetrivalFailureException");
		when(camgenRqstChSetTimebandJpaRepository.findOne(Mockito.anyLong()))
				.thenThrow(dataRetrievalFailureException);
		int exc = 0;
		try {
			channelSetTimebandsRepositoryImpl.deleteTimeBand(1);
		} catch (MintBaseException e) {
			exc = e.getCode();
		}
		assertEquals(exc, HttpStatus.NOT_FOUND.value());
	}

	@Test
	public void testdeleteTimeBand_NullPointer() {
		when(camgenRqstChSetTimebandJpaRepository.findOne(Mockito.anyLong())).thenReturn(null);
		int exc = 0;
		try {
			channelSetTimebandsRepositoryImpl.deleteTimeBand(1);
		} catch (MintBaseException e) {
			exc = e.getCode();
		}
		assertEquals(exc, HttpStatus.NOT_FOUND.value());
	}

	@Test
	public void testgetCamgenRequestSuccess() {
		when(camgenChannelSetTimebandJpaRepository.findOne(Mockito.anyLong())).thenReturn(camgenChannelSetTimeband);
		CamgenChannelSetTimeband response = channelSetTimebandsRepositoryImpl.getTimeBand(1);
		assertEquals(response.getCreatedBy(), camgenChannelSetTimeband.getCreatedBy());
		assertEquals(response.getChannelSetId(), camgenChannelSetTimeband.getChannelSetId());
		assertEquals(response.getCamgenChannelSetTimebandId(), camgenChannelSetTimeband.getCamgenChannelSetTimebandId());
	}

	@Test
	public void testgetCamgenRequest_Exception() {
		when(camgenChannelSetTimebandJpaRepository.findOne(Mockito.anyLong()))
				.thenThrow(new DataRetrievalFailureException("Exception from database"));
		int exc = 0;
		try {
			channelSetTimebandsRepositoryImpl.getTimeBand(1);
		} catch (MintBaseException e) {
			exc = e.getCode();
		}
		assertEquals(exc, HttpStatus.INTERNAL_SERVER_ERROR.value());
	}

	@Test
	public void testgetCamgenRequest_NullPointer() {
		when(camgenRequestJpaRepository.findOne(Mockito.anyLong())).thenReturn(null);
		int exc = 0;
		try {
			channelSetTimebandsRepositoryImpl.getTimeBand(1);
		} catch (MintBaseException e) {
			exc = e.getCode();
		}
		assertEquals(exc, HttpStatus.NOT_FOUND.value());
	}

	@Test
	public void testsaveTimeBandSuccess() {
		when(camgenChannelSetTimebandJpaRepository.save(Mockito.anyList())).thenReturn(camgenRqstChSetTimebandList);
		channelSetTimebandsRepositoryImpl.saveTimeBand(camgenChannelSetTimebandList);
	}

	@Test
	public void testsaveTimeBand_Exception() {
		when(camgenChannelSetTimebandJpaRepository.save(Mockito.anyList()))
				.thenThrow(new DataRetrievalFailureException("Exception from database"));
		int exc = 0;
		try {
			channelSetTimebandsRepositoryImpl.saveTimeBand(camgenChannelSetTimebandList);
		} catch (MintBaseException e) {
			exc = e.getCode();
		}
		assertEquals(exc, HttpStatus.INTERNAL_SERVER_ERROR.value());
	}
	
	@Test
	public void testGetCriteriaLineNormalised(){
		
		when(camgenPlanDemandSupplyJpaRepository
				.findOneByDemandSupplyIdAndCamgenPlan_PlanId(Mockito.anyLong(), Mockito.anyLong())).thenReturn(testUtil.getCamgenPlanDemandSupply());
		List<CriteriaLineNormalised> response = channelSetTimebandsRepositoryImpl.getCriteriaLineNormalised(1, 1);
		
	}
	
	@Test
	public void testGetCriteriaLineNormalised_Fail() throws Exception {
		when(camgenPlanDemandSupplyJpaRepository.findOneByDemandSupplyIdAndCamgenPlan_PlanId(Mockito.anyLong(), Mockito.anyLong()))
				.thenThrow(new DataRetrievalFailureException("Exception from database"));
		int exc = 0;
		try {
			channelSetTimebandsRepositoryImpl.getCriteriaLineNormalised(1, 1);
		} catch (MintBaseException e) {
			exc = e.getCode();
		}
		assertEquals(exc, HttpStatus.INTERNAL_SERVER_ERROR.value());
	}

	@Test
	public void testGetCriteriaLineNormalisedDatNotFound_Fail() throws Exception {
		when(camgenPlanDemandSupplyJpaRepository.findOneByDemandSupplyIdAndCamgenPlan_PlanId(Mockito.anyLong(), Mockito.anyLong())).thenReturn(null);
		int exceptionCode = 0;
		try {
			channelSetTimebandsRepositoryImpl.getCriteriaLineNormalised(1, 1);
		} catch (MintBaseException mintBaseException) {
			exceptionCode = mintBaseException.getCode();
		}
		assertEquals(HttpStatus.NOT_FOUND.value(), exceptionCode);
	}
	

}
