
package com.channel4.mint.automated.spot.infrastructure.persistence.repository;

import java.util.List;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRequest;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRqstChSetTimeband;
import com.channel4.mint.automated.spot.interfaces.dto.ChannelSetTimeBands;

/**
 * The Interface SnapshotParamChannelSetTimebands Repository.
 * 
 *  @author HCL
 */
public interface SnapshotParamChannelSetTimebandsRepository {

	/**
	 * Gets the snapshot param channel set timebands.
	 *
	 * @param snapShotId the snap shot id
	 * @return CamgenRequest
	 */
	CamgenRequest getSnapshotParamChannelSetTimebands(Long snapShotId);

	/**
	 * Creates the camgen param channel set timebands.
	 *
	 * @param lstCamgenRqstChSetTimeband the lst camgen rqst ch set timeband
	 */
	void createCamgenParamChannelSetTimebands(List<CamgenRqstChSetTimeband> lstCamgenRqstChSetTimeband);

	/**
	 * Gets the camgen run param channel set timebands.
	 *
	 * @param snapshotId the snapshot id
	 * @return ChannelSetTimeBands
	 */
	ChannelSetTimeBands getCamgenRunParamChannelSetTimebands(Integer snapshotId);

}
