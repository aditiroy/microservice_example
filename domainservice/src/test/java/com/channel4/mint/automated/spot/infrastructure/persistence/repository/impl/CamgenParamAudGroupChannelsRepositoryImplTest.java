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

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenParamAudGroupChannelsJPARepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenAudienceGroupChannel;
import com.channel4.mint.automated.spot.test.util.TestUtil;
import com.channel4.mint.baseexception.MintBaseException;

public class CamgenParamAudGroupChannelsRepositoryImplTest {

	@InjectMocks
	CamgenParamAudGroupChannelsRepositoryImpl camgenParamAudGroupChannelsRepositoryImpl;

	@Mock
	CamgenParamAudGroupChannelsJPARepository camgenParamAudGroupChannelsJPARepository;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	List<CamgenAudienceGroupChannel> camgenAudienceGroupChannelList = new ArrayList<>();
	CamgenAudienceGroupChannel camgenAudienceGroupChannel = new CamgenAudienceGroupChannel();
	TestUtil testUtil = new TestUtil();

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);

		camgenAudienceGroupChannel = testUtil.getCamgenAudienceGroupChannel();
		camgenAudienceGroupChannelList.add(camgenAudienceGroupChannel);
	}

	@Test
	public void createCamgenParamAudGroupChannelsSuccessTest() throws Exception {
		when(camgenParamAudGroupChannelsJPARepository.save(Mockito.anyList())).thenReturn(camgenAudienceGroupChannelList);
		camgenParamAudGroupChannelsRepositoryImpl.createCamgenParamAudGroupChannels(camgenAudienceGroupChannelList);
	}

	@Test
	public void createCamgenParamAudGroupChannelsExceptionTest() throws Exception {
		DataRetrievalFailureException dataRetrievalFailureException = new DataRetrievalFailureException(
				"DataRetrivalFailureException");
		when(camgenParamAudGroupChannelsJPARepository.save(Mockito.anyList())).thenThrow(dataRetrievalFailureException);
		int exceptionCode = 0;
		try {
			camgenParamAudGroupChannelsRepositoryImpl.createCamgenParamAudGroupChannels(camgenAudienceGroupChannelList);
		} catch (MintBaseException mintBaseException) {
			exceptionCode = mintBaseException.getCode();
		}
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), exceptionCode);
	}

	@Test
	public void getCamgenParamAudGroupChannelsSuccessTest() throws Exception {
		when(camgenParamAudGroupChannelsJPARepository.findAll()).thenReturn(camgenAudienceGroupChannelList);
		camgenParamAudGroupChannelsRepositoryImpl.getCamgenParamAudGroupChannels();
	}

	@Test
	public void getCamgenParamAudGroupChannelsExceptionTest() throws Exception {
		DataRetrievalFailureException dataRetrievalFailureException = new DataRetrievalFailureException(
				"DataRetrivalFailureException");
		when(camgenParamAudGroupChannelsJPARepository.findAll()).thenThrow(dataRetrievalFailureException);
		int exceptionCode = 0;
		try {
			camgenParamAudGroupChannelsRepositoryImpl.getCamgenParamAudGroupChannels();
		} catch (MintBaseException mintBaseException) {
			exceptionCode = mintBaseException.getCode();
		}
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), exceptionCode);
	}
	
	@Test
	public void getCamgenParamAudGroupChannelsDataNotFoundExceptionTest() throws Exception {
		when(camgenParamAudGroupChannelsJPARepository.findAll()).thenReturn(null);
		int exceptionCode = 0;
		try {
			camgenParamAudGroupChannelsRepositoryImpl.getCamgenParamAudGroupChannels();
		} catch (MintBaseException mintBaseException) {
			exceptionCode = mintBaseException.getCode();
		}
		assertEquals(HttpStatus.NOT_FOUND.value(), exceptionCode);
	}
	

	@Test
	public void getCamgenAudienceGroupChannelSuccessTest() throws Exception {
		when(camgenParamAudGroupChannelsJPARepository.findOne(Mockito.anyLong())).thenReturn(camgenAudienceGroupChannel);
		camgenParamAudGroupChannelsRepositoryImpl.getCamgenAudienceGroupChannel(1L);
	}

	@Test
	public void getCamgenAudienceGroupChannelExceptionTest() throws Exception {
		DataRetrievalFailureException dataRetrievalFailureException = new DataRetrievalFailureException(
				"DataRetrivalFailureException");
		when(camgenParamAudGroupChannelsJPARepository.findOne(Mockito.anyLong())).thenThrow(dataRetrievalFailureException);
		int exceptionCode = 0;
		try {
			camgenParamAudGroupChannelsRepositoryImpl.getCamgenAudienceGroupChannel(1L);
		} catch (MintBaseException mintBaseException) {
			exceptionCode = mintBaseException.getCode();
		}
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), exceptionCode);
	}
	
	@Test
	public void getCamgenAudienceGroupChannelDataNotFoundExceptionTest() throws Exception {
		when(camgenParamAudGroupChannelsJPARepository.findOne(Mockito.anyLong())).thenReturn(null);
		int exceptionCode = 0;
		try {
			camgenParamAudGroupChannelsRepositoryImpl.getCamgenAudienceGroupChannel(1L);
		} catch (MintBaseException mintBaseException) {
			exceptionCode = mintBaseException.getCode();
		}
		assertEquals(HttpStatus.NOT_FOUND.value(), exceptionCode);
	}

}
