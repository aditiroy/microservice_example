package com.channel4.mint.automated.spot.service;

import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamAudGroupChannels;

/**
 * The Interface CamgenParamAudGroupChannelsService used for handling
 * CamgenParamAudGroup.
 * 
 * @author HCL
 */
public interface CamgenParamAudGroupChannelsService {

	/**
	 * Creates the camgen param aud group channels.
	 *
	 * @param body
	 *            the body
	 */
	void createCamgenParamAudGroupChannels(CamgenParamAudGroupChannels body);

	/**
	 * Gets the camgen param aud group channels.
	 *
	 * @return CamgenParamAudGroupChannels
	 */
	CamgenParamAudGroupChannels getCamgenParamAudGroupChannels();

}
