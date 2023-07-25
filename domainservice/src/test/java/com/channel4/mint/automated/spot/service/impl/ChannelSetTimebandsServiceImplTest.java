package com.channel4.mint.automated.spot.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.channel4.mint.automated.spot.application.util.DateTimeUtility;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.ChannelSetTimebandsRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenChannelSetTimeband;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRequest;
import com.channel4.mint.automated.spot.interfaces.dto.ChannelSetTimeBandResponse;
import com.channel4.mint.automated.spot.interfaces.dto.ChannelSetTimebandsBulkRequest;
import com.channel4.mint.automated.spot.interfaces.dto.CriteriaLineNormalised;
import com.channel4.mint.automated.spot.test.util.TestUtil;

public class ChannelSetTimebandsServiceImplTest {

	@InjectMocks
	private ChannelSetTimebandsServiceImpl channelSetTimebandsServiceImpl;

	@Mock
	private ChannelSetTimebandsRepository channelSetTimebandsRepository;

	@Mock
	DateTimeUtility dateTimeUtility;
	
	private List<ChannelSetTimeBandResponse> listChannelSetTimeBandResponse;
	private List<ChannelSetTimebandsBulkRequest> channelSetTimebandsBulkRequestList = new ArrayList<>();
	ChannelSetTimebandsBulkRequest channelSetTimebandsBulkRequest;
	CamgenChannelSetTimeband camgenChannelSetTimeband;
	private TestUtil test = new TestUtil();
	private CamgenRequest camgenRequest;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		listChannelSetTimeBandResponse = test.getListChannelSetTimeBandResponse();
		camgenRequest = test.getCamgenRequest();
		camgenChannelSetTimeband = test.getCamgenChannelSetTimeband();
		channelSetTimebandsBulkRequest = test.getChannelSetTimebandsBulkRequest();
		channelSetTimebandsBulkRequestList.add(channelSetTimebandsBulkRequest);
	}

	@Test
	public void testGetCamgenParamChannelSetTimebands() {
		when(channelSetTimebandsRepository.getCamgenParamChannelSetTimebands(Mockito.anyInt()))
				.thenReturn(listChannelSetTimeBandResponse);
		List<ChannelSetTimeBandResponse> response = channelSetTimebandsServiceImpl.getCamgenParamChannelSetTimebands(1);
		assertEquals(response.get(0).getAvailability(), listChannelSetTimeBandResponse.get(0).getAvailability());
		assertEquals(response.get(0).getDay(), listChannelSetTimeBandResponse.get(0).getDay());
		assertEquals(response.get(0).getTimeBandId(), listChannelSetTimeBandResponse.get(0).getTimeBandId());
		assertEquals(response.get(0).getName(), listChannelSetTimeBandResponse.get(0).getName());
		assertEquals(response.get(0).getEndTime(), listChannelSetTimeBandResponse.get(0).getEndTime());
	}

	@Test
	public void testCreateCamgenParamChannelSetTimebands() {
		Mockito.doNothing().when(channelSetTimebandsRepository).deleteTimeBand(1);
		Mockito.doNothing().when(channelSetTimebandsRepository).saveTimeBand(Mockito.anyList());
		when(channelSetTimebandsRepository.getTimeBand(1)).thenReturn(camgenChannelSetTimeband);
		Mockito.doNothing().when(channelSetTimebandsRepository).saveTimeBand(Mockito.anyList());

		channelSetTimebandsServiceImpl.createCamgenParamChannelSetTimebands(channelSetTimebandsBulkRequestList);
	}
	
	@Test
	public void testGetCriteriaLineNormalised() throws Exception{
		
		List<CriteriaLineNormalised> criteriaLineNormalisedList = new ArrayList<>();
		CriteriaLineNormalised criteriaLineNormalised = new CriteriaLineNormalised();
		criteriaLineNormalised.setAttributeId(1L);
		criteriaLineNormalised.setConditionId(1L);
		criteriaLineNormalised.setCriteriaLineId(1L);
		criteriaLineNormalised.setObjectId(1L);
		criteriaLineNormalised.setOperator("abc");
		criteriaLineNormalised.setValue("abc");
		criteriaLineNormalisedList.add(criteriaLineNormalised);
		when(channelSetTimebandsRepository.getCriteriaLineNormalised(Mockito.anyInt(), Mockito.anyInt())).thenReturn(criteriaLineNormalisedList);
		List<CriteriaLineNormalised> response = channelSetTimebandsServiceImpl.getCriteriaLineNormalised(1, 1);
		assertNotNull(response);
		assertEquals(response.get(0).getAttributeId(), criteriaLineNormalisedList.get(0).getAttributeId());
		assertEquals(response.get(0).getCriteriaLineId(), criteriaLineNormalisedList.get(0).getCriteriaLineId());
		assertEquals(response.get(0).getValue(), criteriaLineNormalisedList.get(0).getValue());
	}

}
