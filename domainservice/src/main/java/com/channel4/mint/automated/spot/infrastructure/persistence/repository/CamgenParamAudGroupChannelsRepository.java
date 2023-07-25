package com.channel4.mint.automated.spot.infrastructure.persistence.repository;

import java.util.List;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenAudienceGroupChannel;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamAudGroupChannels;

/**
 * The Interface CamgenParamAudGroupChannels Repository.
 * 
 *  @author HCL
 */
public interface CamgenParamAudGroupChannelsRepository {

	/**
	 * method for save camgen audience hroup channel list in db.
	 *
	 * @param camgenAudienceGroupChannelList the camgen audience group channel list
	 */
	void createCamgenParamAudGroupChannels(List<CamgenAudienceGroupChannel> camgenAudienceGroupChannelList);

	/**
	 * method for get all camgen audience group channel.
	 *
	 * @return CamgenParamAudGroupChannels
	 */
	CamgenParamAudGroupChannels getCamgenParamAudGroupChannels();

	/**
	 * method or get camgen audience group channel based on id.
	 *
	 * @param id the id
	 * @return CamgenAudienceGroupChannel
	 */
	CamgenAudienceGroupChannel getCamgenAudienceGroupChannel(Long id);
}
