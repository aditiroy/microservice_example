package com.channel4.mint.automated.spot.infrastructure.persistence.repository.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.channel4.mint.automated.spot.application.util.AutomatedSpotConstants;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenParamAudGroupChannelsJPARepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenParamAudGroupChannelsRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenAudienceGroupChannel;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamAudGroupChannel;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamAudGroupChannels;
import com.channel4.mint.baseexception.MintBaseException;

/**
 * class for handle camgen audience group channel db related operations.
 * 
 * @author HCL
 */
@Repository
public class CamgenParamAudGroupChannelsRepositoryImpl implements CamgenParamAudGroupChannelsRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(CamgenParamAudGroupChannelsRepositoryImpl.class);

	@Autowired
	private CamgenParamAudGroupChannelsJPARepository camgenParamAudGroupChannelsJPARepository;

	/**
	 * method for save camgen audience hroup channel list in db.
	 *
	 * @param camgenAudienceGroupChannelList
	 *            the camgen audience group channel list
	 */
	@Override
	public void createCamgenParamAudGroupChannels(List<CamgenAudienceGroupChannel> camgenAudienceGroupChannelList) {
		try {
			LOGGER.info(">> CamgenParamAudGroupChannelsRepositoryImpl.createCamgenParamAudGroupChannels(");
			camgenParamAudGroupChannelsJPARepository.save(camgenAudienceGroupChannelList);
		} catch (DataAccessException e) {
			LOGGER.error("Exception during save camgen audience group channel {}", e);
			throw new MintBaseException(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE,
					HttpStatus.INTERNAL_SERVER_ERROR.value());
		}

	}

	/**
	 * method for get all camgen audience group channel.
	 *
	 * @return CamgenParamAudGroupChannels
	 */
	@Override
	public CamgenParamAudGroupChannels getCamgenParamAudGroupChannels() {
		List<CamgenAudienceGroupChannel> camgenAudienceGroupChannelList = null;

		try {
			LOGGER.info(">> CamgenParamAudGroupChannelsRepositoryImpl.getCamgenParamAudGroupChannels(");
			camgenAudienceGroupChannelList = camgenParamAudGroupChannelsJPARepository.findAll();
			if (CollectionUtils.isEmpty(camgenAudienceGroupChannelList)) {
				LOGGER.error(AutomatedSpotConstants.DATA_NOT_FOUND);
				throw new MintBaseException(AutomatedSpotConstants.DATA_NOT_FOUND, HttpStatus.NOT_FOUND.value());
			}

		} catch (DataAccessException e) {
			LOGGER.error("Exception during get all camgen audience group channel {}", e);
			throw new MintBaseException(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE,
					HttpStatus.INTERNAL_SERVER_ERROR.value());
		}

		return mapCamgenAudienceGroupChannel(camgenAudienceGroupChannelList);
	}

	/**
	 * method or get camgen audience group channel based on id.
	 *
	 * @param id
	 *            the id
	 * @return CamgenAudienceGroupChannel
	 */
	public CamgenAudienceGroupChannel getCamgenAudienceGroupChannel(Long id) {
		CamgenAudienceGroupChannel camgenAudienceGroupChannel = null;
		try {
			LOGGER.info(">> CamgenParamAudGroupChannelsRepositoryImpl.getCamgenAudienceGroupChannel(");
			camgenAudienceGroupChannel = camgenParamAudGroupChannelsJPARepository.findOne(id);
			if (null == camgenAudienceGroupChannel) {
				LOGGER.error(AutomatedSpotConstants.DATA_NOT_FOUND);
				throw new MintBaseException(AutomatedSpotConstants.DATA_NOT_FOUND, HttpStatus.NOT_FOUND.value());
			}
		} catch (DataAccessException e) {
			LOGGER.error("Exception during get camgen audience group channel {}", e);
			throw new MintBaseException(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE,
					HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		LOGGER.info("<< CamgenParamAudGroupChannelsRepositoryImpl.getCamgenAudienceGroupChannel(");
		return camgenAudienceGroupChannel;
	}

	/**
	 * Map camgen audience group channel.
	 *
	 * @param camgenAudienceGroupChannelList
	 *            the camgen audience group channel list
	 * @return the camgen param aud group channels
	 */
	private CamgenParamAudGroupChannels mapCamgenAudienceGroupChannel(
			List<CamgenAudienceGroupChannel> camgenAudienceGroupChannelList) {
		CamgenParamAudGroupChannels camgenParamAudGroupChannels = new CamgenParamAudGroupChannels();

		camgenAudienceGroupChannelList.forEach(item -> {
			CamgenParamAudGroupChannel camgenParamAudGroupChannel = new CamgenParamAudGroupChannel();

			camgenParamAudGroupChannel.setChannelId(item.getChannelId().intValue());
			camgenParamAudGroupChannel.setId(item.getAudienceGroupChannelId());
			camgenParamAudGroupChannel.setCreatedBy(item.getCreatedBy());
			camgenParamAudGroupChannel.setTargetPercentage(item.getTargetPercentage().toString());
			camgenParamAudGroupChannel.setKeyAudienceId(item.getAudienceId().intValue());
			camgenParamAudGroupChannel.setCreatedBy(item.getCreatedBy());

			camgenParamAudGroupChannels.add(camgenParamAudGroupChannel);
		});

		return camgenParamAudGroupChannels;
	}

}
