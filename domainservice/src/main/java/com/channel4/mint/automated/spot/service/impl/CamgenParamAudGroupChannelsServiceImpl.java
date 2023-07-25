package com.channel4.mint.automated.spot.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.channel4.mint.automated.spot.application.util.DateTimeUtility;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenParamAudGroupChannelsRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenAudienceGroupChannel;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamAudGroupChannel;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamAudGroupChannels;
import com.channel4.mint.automated.spot.service.CamgenParamAudGroupChannelsService;

/**
 * class for handle Camgen Audience group channel operation.
 * 
 * @author HCL
 */
@Service
public class CamgenParamAudGroupChannelsServiceImpl implements CamgenParamAudGroupChannelsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CamgenParamAudGroupChannelsServiceImpl.class);

	@Autowired
	private CamgenParamAudGroupChannelsRepository camgenParamAudGroupChannelsRepository;

	@Autowired
	private DateTimeUtility dateTimeUtility;

	/**
	 * Creates the camgen param aud group channels.
	 *
	 * @param body
	 *            payload for save
	 */
	@Transactional
	@Override
	public void createCamgenParamAudGroupChannels(CamgenParamAudGroupChannels body) {
		LOGGER.info(">> CamgenParamAudGroupChannelsServiceImpl: createCamgenParamAudGroupChannels()");
		List<CamgenAudienceGroupChannel> camgenAudienceGroupChannelList = new ArrayList<>();

		for (CamgenParamAudGroupChannel camgenParamAudGroupChannel : body) {
			CamgenAudienceGroupChannel camgenAudienceGroupChannel = null;

			if (null == camgenParamAudGroupChannel.getId()) {
				camgenAudienceGroupChannel = new CamgenAudienceGroupChannel();

				mapCamgenAudienceGroupChannel(camgenParamAudGroupChannel, camgenAudienceGroupChannel);
				camgenAudienceGroupChannel.setCreatedBy(camgenParamAudGroupChannel.getCreatedBy());
				camgenAudienceGroupChannel.setCreatedOn(dateTimeUtility.getCurrentTimeStamp());
			} else {
				camgenAudienceGroupChannel = camgenParamAudGroupChannelsRepository
						.getCamgenAudienceGroupChannel(camgenParamAudGroupChannel.getId());

				mapCamgenAudienceGroupChannel(camgenParamAudGroupChannel, camgenAudienceGroupChannel);
				camgenAudienceGroupChannel.setModifiedBy(camgenParamAudGroupChannel.getCreatedBy());
				camgenAudienceGroupChannel.setModifiedOn(dateTimeUtility.getCurrentTimeStamp());
			}
			camgenAudienceGroupChannelList.add(camgenAudienceGroupChannel);

		}

		if (!CollectionUtils.isEmpty(camgenAudienceGroupChannelList)) {
			camgenParamAudGroupChannelsRepository.createCamgenParamAudGroupChannels(camgenAudienceGroupChannelList);
		}

		LOGGER.info("<< CamgenParamAudGroupChannelsServiceImpl: createCamgenParamAudGroupChannels()");
	}

	/**
	 * Map camgen audience group channel.
	 *
	 * @param camgenParamAudGroupChannel
	 *            the camgen param aud group channel
	 * @param camgenAudienceGroupChannel
	 *            the camgen audience group channel
	 * @return CamgenAudienceGroupChannel
	 */
	private CamgenAudienceGroupChannel mapCamgenAudienceGroupChannel(
			CamgenParamAudGroupChannel camgenParamAudGroupChannel,
			CamgenAudienceGroupChannel camgenAudienceGroupChannel) {

		if (null != camgenParamAudGroupChannel.getKeyAudienceId()) {
			camgenAudienceGroupChannel.setAudienceId(BigDecimal.valueOf(camgenParamAudGroupChannel.getKeyAudienceId()));
		}

		if (null != camgenParamAudGroupChannel.getChannelId()) {
			camgenAudienceGroupChannel.setChannelId(BigDecimal.valueOf(camgenParamAudGroupChannel.getChannelId()));
		}

		if (null != camgenParamAudGroupChannel.getTargetPercentage()) {
			camgenAudienceGroupChannel
					.setTargetPercentage(new BigDecimal(camgenParamAudGroupChannel.getTargetPercentage()));
		}

		return camgenAudienceGroupChannel;

	}

	/**
	 * Gets the camgen param aud group channels.
	 *
	 * @return CamgenParamAudGroupChannels
	 */
	@Override
	public CamgenParamAudGroupChannels getCamgenParamAudGroupChannels() {
		LOGGER.info(">> CamgenParamAudGroupChannelsServiceImpl: getCamgenParamAudGroupChannels()");
		return camgenParamAudGroupChannelsRepository.getCamgenParamAudGroupChannels();
	}

}
