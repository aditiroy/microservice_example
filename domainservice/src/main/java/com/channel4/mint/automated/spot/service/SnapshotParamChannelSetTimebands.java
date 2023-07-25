package com.channel4.mint.automated.spot.service;

import com.channel4.mint.automated.spot.interfaces.dto.ChannelSetTimeBands;

/**
 * The Interface SnapshotParamChannelSetTimebands used for operation for
 * ChannelSetTimeBands.
 * 
 * @author HCL
 */
public interface SnapshotParamChannelSetTimebands {

	/**
	 * Gets the camgen run param channel set timebands.
	 *
	 * @param snapshotId
	 *            the snapshot id
	 * @return ChannelSetTimeBands
	 */
	ChannelSetTimeBands getCamgenRunParamChannelSetTimebands(Integer snapshotId);

}
