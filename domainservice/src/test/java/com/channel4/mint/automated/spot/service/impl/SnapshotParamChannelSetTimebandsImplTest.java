package com.channel4.mint.automated.spot.service.impl;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.channel4.mint.automated.spot.application.util.SnapshotParamChannelSetTimebandsMapper;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.SnapshotParamChannelSetTimebandsRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRequest;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRqstChSetTimeband;
import com.channel4.mint.automated.spot.interfaces.dto.ChannelSetTimeBand;
import com.channel4.mint.automated.spot.interfaces.dto.ChannelSetTimeBands;
import com.channel4.mint.automated.spot.test.util.TestUtil;

public class SnapshotParamChannelSetTimebandsImplTest {
	@InjectMocks
	SnapshotParamChannelSetTimebandsImpl snapshotParamChannelSetTimebandsImpl;
	
	@Mock
	private SnapshotParamChannelSetTimebandsRepository snapshotParamChannelSetTimebandsRepository;
	
	@Mock
	private SnapshotParamChannelSetTimebandsMapper snapshotParamChannelSetTimebandsMapper;
	private ChannelSetTimeBands channelSetTimeBands;
	private ChannelSetTimeBand channelSetTimeBand;
	private CamgenRequest camgenRequest;
	private List<CamgenRqstChSetTimeband> lstCamgenRqstChSetTimeband ;
	private CamgenRqstChSetTimeband camgenRqstChSetTimeband;
	TestUtil test = new TestUtil();

	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
		channelSetTimeBands = test.getChannelSetTimeBands();
		channelSetTimeBand=test.getChannelSetTimeBand();
		lstCamgenRqstChSetTimeband=test.getListCamgenRqstChSetTimeband();
		camgenRqstChSetTimeband= test.getCamgenRqstChSetTimeband();
	}
	
	

	@Test
	public void testGetCamgenRunParamChannelSetTimebands() {
		snapshotParamChannelSetTimebandsImpl.getCamgenRunParamChannelSetTimebands(1);
	}

}
