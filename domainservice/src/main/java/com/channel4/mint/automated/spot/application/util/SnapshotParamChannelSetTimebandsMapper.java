/*
 * 
 */
package com.channel4.mint.automated.spot.application.util;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRequest;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRqstChSetTimeband;
import com.channel4.mint.automated.spot.interfaces.dto.ChannelSetTimeBand;
import com.channel4.mint.automated.spot.interfaces.dto.ChannelSetTimeBands;

// TODO: Auto-generated Javadoc
/**
 * The Class Snapshot Param Channel Set Timebands Mapper.
 */
@Component
public class SnapshotParamChannelSetTimebandsMapper {

	/** The date time utility. */
	@Autowired
	DateTimeUtility dateTimeUtility;

	/**
	 * Map post channel set timebands mapper.
	 *
	 * @param camgenRequest
	 *            the camgen request
	 * @param channelSetTimeBand
	 *            the channel set time band
	 * @return CamgenRqstChSetTimeband
	 */
	public CamgenRqstChSetTimeband mapPostChannelSetTimebandsMapper(CamgenRequest camgenRequest,
			ChannelSetTimeBand channelSetTimeBand) {
		CamgenRqstChSetTimeband camgenRqstChSetTimeband = new CamgenRqstChSetTimeband();

		camgenRqstChSetTimeband.setApplicableDay(channelSetTimeBand.getDay());
		camgenRqstChSetTimeband.setAvailabilityPercentage(new BigDecimal(channelSetTimeBand.getAvailability()));
		camgenRqstChSetTimeband.setCamgenRequest(camgenRequest);
		camgenRqstChSetTimeband.setCamgenRqstChSetTimebandId(channelSetTimeBand.getChannelSetId());
		camgenRqstChSetTimeband.setEndTime(channelSetTimeBand.getEndTime());
		camgenRqstChSetTimeband.setStartTime(channelSetTimeBand.getStartTime());
		camgenRqstChSetTimeband.setTimeband(channelSetTimeBand.getName());
		camgenRqstChSetTimeband.setCreatedBy(camgenRequest.getCreatedBy());
		camgenRqstChSetTimeband.setCreatedOn(dateTimeUtility.getCurrentTimeStamp());
		return camgenRqstChSetTimeband;
	}

	/**
	 * Map get channel set timebands mapper.
	 *
	 * @param camgenRqstChSetTimebandList
	 *            the camgen rqst ch set timeband list
	 * @return ChannelSetTimeBands
	 */
	public ChannelSetTimeBands mapGetChannelSetTimebandsMapper(
			List<CamgenRqstChSetTimeband> camgenRqstChSetTimebandList) {
		ChannelSetTimeBands channelSetTimeBands = new ChannelSetTimeBands();
		for (CamgenRqstChSetTimeband itrCamgenRqstChSetTimeband : camgenRqstChSetTimebandList) {
			ChannelSetTimeBand channelSetTimeBand = new ChannelSetTimeBand();
			channelSetTimeBand.setAvailability(itrCamgenRqstChSetTimeband.getAvailabilityPercentage().doubleValue());

			if (null != itrCamgenRqstChSetTimeband.getCamgenRequest().getChannelSetId()) {
				channelSetTimeBand
						.setChannelSetId(itrCamgenRqstChSetTimeband.getCamgenRequest().getChannelSetId().intValue());
			}

			channelSetTimeBand.setDay(itrCamgenRqstChSetTimeband.getApplicableDay());
			channelSetTimeBand.setEndTime(itrCamgenRqstChSetTimeband.getEndTime());
			channelSetTimeBand.setId((int) itrCamgenRqstChSetTimeband.getCamgenRqstChSetTimebandId());
			channelSetTimeBand.setStartTime(itrCamgenRqstChSetTimeband.getStartTime());
			channelSetTimeBand.setName(itrCamgenRqstChSetTimeband.getTimeband());
			channelSetTimeBands.add(channelSetTimeBand);
		}

		return channelSetTimeBands;
	}

}
