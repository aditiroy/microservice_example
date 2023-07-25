package com.channel4.mint.automated.spot.application.util;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRequest;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRqstChSetTimeband;
import com.channel4.mint.automated.spot.interfaces.dto.ChannelSetTimeBand;
import com.channel4.mint.automated.spot.interfaces.dto.ChannelSetTimeBands;
import com.channel4.mint.automated.spot.test.util.TestUtil;

public class SnapshotParamChannelSetTimebandsMapperTest {

	@InjectMocks
	private SnapshotParamChannelSetTimebandsMapper snapshotParamChannelSetTimebandsMapper;
	@Mock
	DateTimeUtility dateTimeUtility;
	private ChannelSetTimeBand channelSetTimeBand;
	private CamgenRqstChSetTimeband camgenRqstChSetTimeband;
	private CamgenRequest camgenRequest;
	private List<CamgenRqstChSetTimeband> camgenRqstChSetTimebandList;

	private TestUtil test = new TestUtil();

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		channelSetTimeBand = test.getChannelSetTimeBand();
		camgenRqstChSetTimeband = test.getCamgenRqstChSetTimeband();
		camgenRequest = camgenRqstChSetTimeband.getCamgenRequest();
		camgenRqstChSetTimebandList = test.getListCamgenRqstChSetTimeband();

	}

	@Test
	public void testMapPostChannelSetTimebandsMapper() {
		when(dateTimeUtility.getCurrentTimeStamp()).thenReturn(new Timestamp(System.currentTimeMillis()));
		CamgenRqstChSetTimeband response = snapshotParamChannelSetTimebandsMapper
				.mapPostChannelSetTimebandsMapper(camgenRequest, channelSetTimeBand);
		assertEquals(response.getApplicableDay(), camgenRqstChSetTimeband.getApplicableDay());
		assertEquals(response.getAvailabilityPercentage(), camgenRqstChSetTimeband.getAvailabilityPercentage());
		assertEquals(response.getEndTime(), camgenRqstChSetTimeband.getEndTime());
		assertEquals(response.getStartTime(), camgenRqstChSetTimeband.getStartTime());
	}

	@Test
	public void testMapGetChannelSetTimebandsMapper() {
		ChannelSetTimeBands response = snapshotParamChannelSetTimebandsMapper
				.mapGetChannelSetTimebandsMapper(camgenRqstChSetTimebandList);
		assertEquals(new BigDecimal(response.get(0).getAvailability()),
				camgenRqstChSetTimebandList.get(0).getAvailabilityPercentage());
	}

}
