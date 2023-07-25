package com.channel4.mint.automated.spot.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.channel4.mint.automated.spot.application.util.SnapshotParamChannelSetTimebandsMapper;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.SnapshotParamChannelSetTimebandsRepository;
import com.channel4.mint.automated.spot.interfaces.dto.ChannelSetTimeBands;
import com.channel4.mint.automated.spot.service.SnapshotParamChannelSetTimebands;

/**
 * This class is used to perform get and save operation on
 * SnapshotParamChannelSetTimebands.
 *
 * @author HCL
 */
@Service
public class SnapshotParamChannelSetTimebandsImpl implements SnapshotParamChannelSetTimebands {

	private static final Logger LOGGER = LoggerFactory.getLogger(SnapshotParamChannelSetTimebandsImpl.class);

	@Autowired
	private SnapshotParamChannelSetTimebandsRepository snapshotParamChannelSetTimebandsRepository;

	@Autowired
	private SnapshotParamChannelSetTimebandsMapper snapshotParamChannelSetTimebandsMapper;

	/**
	 * Gets the camgen run param channel set timebands.
	 *
	 * @param snapshotId
	 *            the snapshot id
	 * @return ChannelSetTimeBands
	 */
	@Override
	public ChannelSetTimeBands getCamgenRunParamChannelSetTimebands(Integer snapshotId) {
		LOGGER.info("<< Service CamgenParametersServiceImpl method getCamgenRunParamChannelSetTimebands");
		return snapshotParamChannelSetTimebandsRepository.getCamgenRunParamChannelSetTimebands(snapshotId);
	}

}
