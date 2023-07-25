package com.channel4.mint.automated.spot.infrastructure.persistence.repository;

import java.util.List;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenChannelSetTimeband;
import com.channel4.mint.automated.spot.interfaces.dto.ChannelSetTimeBandResponse;
import com.channel4.mint.automated.spot.interfaces.dto.CriteriaLineNormalised;

/**
 * The Interface ChannelSetTimebandsRepository use for operation of
 * ChannelSetTimeBand.
 * 
 * @author HCL
 */
public interface ChannelSetTimebandsRepository {

	/**
	 * Gets the camgen param channel set timebands.
	 *
	 * @param channelSetID
	 *            the channel set ID
	 * @return ChannelSetTimeBandResponse
	 */
	List<ChannelSetTimeBandResponse> getCamgenParamChannelSetTimebands(Integer channelSetID);

	/**
	 * Delete time band.
	 *
	 * @param id
	 *            the id
	 */
	void deleteTimeBand(Integer id);

	/**
	 * Save time band.
	 *
	 * @param camgenChannelSetTimebandList
	 *            camgen channel set timeband list
	 */
	void saveTimeBand(List<CamgenChannelSetTimeband> camgenChannelSetTimebandList);

	/**
	 * 
	 * @param id
	 * 		id
	 * @return CamgenChannelSetTimeband
	 */
	CamgenChannelSetTimeband getTimeBand(Integer id);

	List<CriteriaLineNormalised> getCriteriaLineNormalised(Integer demandSupplyGroupId, Integer planId);

}
