package com.channel4.mint.automated.spot.infrastructure.persistence.repository.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.channel4.mint.automated.spot.application.util.SnapshotParamChannelSetTimebandsMapper;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenChannelSetTimebandJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenRequestJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenRqstChSetTimebandJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.SnapshotParamChannelSetTimebandsRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenChannelSetTimeband;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRequest;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRqstChSetTimeband;
import com.channel4.mint.automated.spot.interfaces.dto.ChannelSetTimeBand;
import com.channel4.mint.automated.spot.interfaces.dto.ChannelSetTimeBands;
import com.channel4.mint.baseexception.MintBaseException;

/**
 * The Class Snapshot Param ChannelSet Timebands Repository Impl.
 * 
 * @author HCL
 */
@Repository
public class SnapshotParamChannelSetTimebandsRepositoryImpl implements SnapshotParamChannelSetTimebandsRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(SnapshotParamChannelSetTimebandsRepositoryImpl.class);

	@Autowired
	private CamgenRequestJpaRepository camgenRequestJpaRepository;

	@Autowired
	private CamgenRqstChSetTimebandJpaRepository camgenRqstChSetTimebandJpaRepository;

	@Autowired
	private SnapshotParamChannelSetTimebandsMapper snapshotParamChannelSetTimebandsMapper;

	@Autowired
	private CamgenChannelSetTimebandJpaRepository camgenChannelSetTimebandJpaRepository;

	/**
	 * Gets the snapshot param channel set timebands.
	 *
	 * @param snapShotId
	 *            the snap shot id
	 * @return CamgenRequest
	 */
	@Override
	public CamgenRequest getSnapshotParamChannelSetTimebands(Long snapShotId) {
		LOGGER.error(">>SnapshotParamChannelSetTimebandsRepositoryImpl.getSnapshotParamChannelSetTimebands ");
		CamgenRequest camgenRequest = camgenRequestJpaRepository.findOne(snapShotId);
		if (null == camgenRequest) {
			LOGGER.error("Camgen Request Not Found");
			throw new MintBaseException("CamgenRequest is not found for snapShotid=" + snapShotId,
					HttpStatus.NOT_FOUND.value());
		}
		LOGGER.error("<<SnapshotParamChannelSetTimebandsRepositoryImpl.getSnapshotParamChannelSetTimebands ");
		return camgenRequest;
	}

	/**
	 * Creates the camgen param channel set timebands.
	 *
	 * @param lstCamgenRqstChSetTimeband
	 *            the lst camgen rqst ch set timeband
	 */
	@Override
	public void createCamgenParamChannelSetTimebands(List<CamgenRqstChSetTimeband> lstCamgenRqstChSetTimeband) {
		try {
			LOGGER.error(">> SnapshotParamChannelSetTimebandsRepositoryImpl.createCamgenParamChannelSetTimebands ");
			camgenRqstChSetTimebandJpaRepository.save(lstCamgenRqstChSetTimeband);
		} catch (DataAccessException e) {
			LOGGER.error("Exception occur createCamgenParamChannelSetTimebands {} ", e);
			throw new MintBaseException("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
	}

	/**
	 * Gets the camgen run param channel set timebands.
	 *
	 * @param snapshotId
	 *            the snapshot id
	 * @return ChannelSetTimeBands
	 */
	@Override
	public ChannelSetTimeBands getCamgenRunParamChannelSetTimebands(Integer snapshotId) {
		try {
			CamgenRequest camgenRequest =null;
			if(null != snapshotId){
				LOGGER.error(">> SnapshotParamChannelSetTimebandsRepositoryImpl.getCamgenRunParamChannelSetTimebands ");
				camgenRequest = camgenRequestJpaRepository.findOne(snapshotId.longValue());

				if(null == camgenRequest){
					throw new MintBaseException("Camgen Request Not Found", HttpStatus.NOT_FOUND.value());
				}
				
				if (CollectionUtils.isEmpty(camgenRequest.getCamgenRqstChSetTimebands())) {
					return loadChannelSetTimeBandFromMasterData();
				}
			} else {
				return loadChannelSetTimeBandFromMasterData();
			}
			
			return snapshotParamChannelSetTimebandsMapper
					.mapGetChannelSetTimebandsMapper(camgenRequest.getCamgenRqstChSetTimebands());
		} catch (DataAccessException e) {
			LOGGER.error("Exception ", e);
			throw new MintBaseException("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value());
		}

	}

	private ChannelSetTimeBands loadChannelSetTimeBandFromMasterData() {
		List<CamgenChannelSetTimeband> camgenChannelSetTimebandList = null;
		try {
			camgenChannelSetTimebandList = camgenChannelSetTimebandJpaRepository.findAll();
			if (CollectionUtils.isEmpty(camgenChannelSetTimebandList)) {
				throw new MintBaseException("Channelset timeband not found", HttpStatus.NOT_FOUND.value());
			}

		} catch (DataAccessException e) {
			LOGGER.error("Exception occur createCamgenParamChannelSetTimebands {} ", e);
			throw new MintBaseException("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value());
		}

		return mapChannelSetTimeBands(camgenChannelSetTimebandList);
	}

	private ChannelSetTimeBands mapChannelSetTimeBands(List<CamgenChannelSetTimeband> camgenChannelSetTimebandList) {
		ChannelSetTimeBands channelSetTimeBands = new ChannelSetTimeBands();
		for(CamgenChannelSetTimeband camgenChannelSetTimeband : camgenChannelSetTimebandList) {
			ChannelSetTimeBand channelSetTimeBand = new ChannelSetTimeBand();
			channelSetTimeBand.setAvailability(camgenChannelSetTimeband.getAvailabilityPercentage().doubleValue());
			channelSetTimeBand.setChannelSetId(camgenChannelSetTimeband.getChannelSetId().intValue());
			channelSetTimeBand.setDay(camgenChannelSetTimeband.getApplicableDay());
			channelSetTimeBand.setEndTime(camgenChannelSetTimeband.getEndTime());
			channelSetTimeBand.setName(camgenChannelSetTimeband.getTimeband());
			channelSetTimeBand.setStartTime(camgenChannelSetTimeband.getStartTime());
			channelSetTimeBand.setId((int) camgenChannelSetTimeband.getCamgenChannelSetTimebandId());
			channelSetTimeBands.add(channelSetTimeBand);
		}
		return channelSetTimeBands;
	}

}
