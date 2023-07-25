package com.channel4.mint.automated.spot.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.channel4.mint.automated.spot.application.util.DateTimeUtility;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenParamAudGroupChannelsRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenParametersRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenAudienceGroupChannel;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamAudGroupChannel;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamAudGroupChannels;

public class CamgenParamAudGroupChannelsServiceImplTest {
	@InjectMocks
	private   CamgenParamAudGroupChannelsServiceImpl  camgenParamAudGroupChannelsServiceImpl;
	
	@Mock
	private CamgenParametersRepository camgenParametersRepository;
	
	@Mock
	private DateTimeUtility dateTimeUtility;
	
	@Mock
	private CamgenParamAudGroupChannelsRepository camgenParamAudGroupChannelsRepository;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void testCreateCamgenParamAudGroupChannels() {
		CamgenParamAudGroupChannels camgenParamAudGroupChannelList=new CamgenParamAudGroupChannels();
		CamgenParamAudGroupChannel camgenParamAudGroupChannel=new CamgenParamAudGroupChannel();
		camgenParamAudGroupChannel.setAudienceGroupId(1);
		camgenParamAudGroupChannel.setChannelId(1);
		camgenParamAudGroupChannel.setCreatedBy("createdBy");
		camgenParamAudGroupChannel.setId(1L);
		camgenParamAudGroupChannel.setKeyAudienceId(1);
		camgenParamAudGroupChannel.setTargetPercentage("12");
		
		CamgenParamAudGroupChannel camgenParamAudGroupChannel1=new CamgenParamAudGroupChannel();
		camgenParamAudGroupChannel1.setAudienceGroupId(1);
		camgenParamAudGroupChannel1.setChannelId(1);
		camgenParamAudGroupChannel1.setCreatedBy("createdBy");
		camgenParamAudGroupChannel1.setKeyAudienceId(1);
		camgenParamAudGroupChannel1.setTargetPercentage("12");
		camgenParamAudGroupChannelList.add(camgenParamAudGroupChannel1);
		camgenParamAudGroupChannelList.add(camgenParamAudGroupChannel); 
		Timestamp value=new Timestamp(System.currentTimeMillis());
		when(dateTimeUtility.getCurrentTimeStamp()).thenReturn(value);
		CamgenAudienceGroupChannel zxcv=new CamgenAudienceGroupChannel();
		when(camgenParamAudGroupChannelsRepository.getCamgenAudienceGroupChannel(1L)).thenReturn(zxcv);
		camgenParamAudGroupChannelsServiceImpl.createCamgenParamAudGroupChannels(camgenParamAudGroupChannelList);
	}

	@Test
	public void testGetCamgenParamAudGroupChannels() {
		CamgenParamAudGroupChannels value=new CamgenParamAudGroupChannels();
		CamgenParamAudGroupChannel camgenParamAudGroupChannel=new CamgenParamAudGroupChannel();
		camgenParamAudGroupChannel.setId(1L);
		value.add(camgenParamAudGroupChannel);
		when(camgenParamAudGroupChannelsRepository.getCamgenParamAudGroupChannels()).thenReturn(value);
		CamgenParamAudGroupChannels camgenParamAudGroupChannelsRes = camgenParamAudGroupChannelsServiceImpl.getCamgenParamAudGroupChannels();
		assertEquals(camgenParamAudGroupChannelsRes.get(0).getId(),value.get(0).getId());
	}

}
