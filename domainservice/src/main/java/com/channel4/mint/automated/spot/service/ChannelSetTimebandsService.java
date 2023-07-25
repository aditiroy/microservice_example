package com.channel4.mint.automated.spot.service;

import java.util.List;

import com.channel4.mint.automated.spot.interfaces.dto.ChannelSetTimeBandResponse;
import com.channel4.mint.automated.spot.interfaces.dto.ChannelSetTimebandsBulkRequest;
import com.channel4.mint.automated.spot.interfaces.dto.CriteriaLineNormalised;

/**
 * The Interface ChannelSetTimebands Service used for handling operations of
 * ChannelSetTimeBandResponse.
 * 
 * @author HCL
 */
public interface ChannelSetTimebandsService {

	/**
	 * Gets the camgen param channel set timebands.
	 *
	 * @param channelSetID
	 *            the channel set ID
	 * @return ChannelSetTimeBandResponse
	 */
	List<ChannelSetTimeBandResponse> getCamgenParamChannelSetTimebands(Integer channelSetID);

	/**
	 * Creates the camgen param channel set timebands.
	 *
	 * @param body
	 *            the body
	 */
	void createCamgenParamChannelSetTimebands(List<ChannelSetTimebandsBulkRequest> body);

	List<CriteriaLineNormalised> getCriteriaLineNormalised(Integer demandSupplyGroupId, Integer planId);

}
