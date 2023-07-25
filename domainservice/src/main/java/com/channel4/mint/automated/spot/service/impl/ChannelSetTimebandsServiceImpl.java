package com.channel4.mint.automated.spot.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.channel4.mint.automated.spot.application.util.DateTimeUtility;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.ChannelSetTimebandsRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenChannelSetTimeband;
import com.channel4.mint.automated.spot.interfaces.dto.ChannelSetTimeBandResponse;
import com.channel4.mint.automated.spot.interfaces.dto.ChannelSetTimebandsBulkRequest;
import com.channel4.mint.automated.spot.interfaces.dto.ChannelSetTimebandsBulkRequestCreated;
import com.channel4.mint.automated.spot.interfaces.dto.ChannelSetTimebandsBulkRequestDeleted;
import com.channel4.mint.automated.spot.interfaces.dto.ChannelSetTimebandsBulkRequestModified;
import com.channel4.mint.automated.spot.interfaces.dto.ChannelSetTimebandsBulkRequestTimebands;
import com.channel4.mint.automated.spot.interfaces.dto.CriteriaLineNormalised;
import com.channel4.mint.automated.spot.service.ChannelSetTimebandsService;

/**
 * This class is used to perform get, delete and save operation on
 * hannelSetTimebands.
 * 
 * @author HCL
 */
@Service
public class ChannelSetTimebandsServiceImpl implements ChannelSetTimebandsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ChannelSetTimebandsServiceImpl.class);

	@Autowired
	private ChannelSetTimebandsRepository channelSetTimebandsRepository;

	@Autowired
	private DateTimeUtility dateTimeUtility;

	/**
	 * Gets the camgen param channel set timebands.
	 *
	 * @param channelSetID
	 *            the channel set ID
	 * @return ChannelSetTimeBandResponse
	 */
	@Override
	public List<ChannelSetTimeBandResponse> getCamgenParamChannelSetTimebands(Integer channelSetID) {
		LOGGER.info("Class ChannelSetTimebandsServiceImpl method getCamgenParamChannelSetTimebands() ");
		return channelSetTimebandsRepository.getCamgenParamChannelSetTimebands(channelSetID);
	}

	/**
	 * Creates the camgen param channel set timebands.
	 *
	 * @param body
	 *            the body
	 */
	@Override
	@Transactional
	public void createCamgenParamChannelSetTimebands(List<ChannelSetTimebandsBulkRequest> body) {

		for (ChannelSetTimebandsBulkRequest channelSetTimebandsBulkRequest : body) {

			if (!CollectionUtils.isEmpty(channelSetTimebandsBulkRequest.getCreated())) {
				createTimeBands(channelSetTimebandsBulkRequest.getCreated(),
						channelSetTimebandsBulkRequest.getCreatedBy());
			}

			if (!CollectionUtils.isEmpty(channelSetTimebandsBulkRequest.getModified())) {
				modifyTimeBand(channelSetTimebandsBulkRequest.getModified(),
						channelSetTimebandsBulkRequest.getCreatedBy());
			}

			if (!CollectionUtils.isEmpty(channelSetTimebandsBulkRequest.getDeleted())) {
				deleteTimeBands(channelSetTimebandsBulkRequest.getDeleted());
			}

		}

	}

	/**
	 * Delete time bands.
	 *
	 * @param channelSetTimebandsBulkRequestDeletedList
	 *            the channel set timebands bulk request deleted list
	 */
	private void deleteTimeBands(
			List<ChannelSetTimebandsBulkRequestDeleted> channelSetTimebandsBulkRequestDeletedList) {
		for (ChannelSetTimebandsBulkRequestDeleted channelSetTimebandsBulkRequestDeleted : channelSetTimebandsBulkRequestDeletedList) {
			channelSetTimebandsRepository.deleteTimeBand(channelSetTimebandsBulkRequestDeleted.getTimebandId());
		}
	}

	/**
	 * Creates the time bands.
	 *
	 * @param channelSetTimebandsBulkRequestCreatedList
	 *            the channel set timebands bulk request created list
	 * @param createdBy
	 *            the created by
	 */
	private void createTimeBands(List<ChannelSetTimebandsBulkRequestCreated> channelSetTimebandsBulkRequestCreatedList,
			String createdBy) {

		for (ChannelSetTimebandsBulkRequestCreated channelSetTimebandsBulkRequestCreated : channelSetTimebandsBulkRequestCreatedList) {

			List<CamgenChannelSetTimeband> camgenChannelSetTimebandList = mapCamgenRqstChSetTimeband(
					channelSetTimebandsBulkRequestCreated.getTimebands(),
					channelSetTimebandsBulkRequestCreated.getChannelSetId(), createdBy);

			channelSetTimebandsRepository.saveTimeBand(camgenChannelSetTimebandList);
		}
	}

	/**
	 * Modify time band.
	 *
	 * @param channelSetTimebandsBulkRequestModifiedList
	 *            the channel set timebands bulk request modified list
	 * @param createdBy
	 *            the created by
	 */
	private void modifyTimeBand(List<ChannelSetTimebandsBulkRequestModified> channelSetTimebandsBulkRequestModifiedList,
			String createdBy) {
		List<CamgenChannelSetTimeband> camgenChannelSetTimebandList = new ArrayList<>();
		for (ChannelSetTimebandsBulkRequestModified channelSetTimebandsBulkRequestModified : channelSetTimebandsBulkRequestModifiedList) {

			for (ChannelSetTimebandsBulkRequestTimebands channelSetTimebandsBulkRequestTimebands : channelSetTimebandsBulkRequestModified
					.getTimebands()) {
				CamgenChannelSetTimeband camgenChannelSetTimeband = channelSetTimebandsRepository
						.getTimeBand(channelSetTimebandsBulkRequestTimebands.getTimebandId());

				mapTimeBandForSaveAndUpdate(channelSetTimebandsBulkRequestModified.getChannelSetId(),
						channelSetTimebandsBulkRequestTimebands, camgenChannelSetTimeband);

				camgenChannelSetTimeband.setModifiedBy(createdBy);
				camgenChannelSetTimeband.setModifiedOn(dateTimeUtility.getCurrentTimeStamp());

				camgenChannelSetTimebandList.add(camgenChannelSetTimeband);
			}

		}

		channelSetTimebandsRepository.saveTimeBand(camgenChannelSetTimebandList);
	}

	/**
	 * Map camgen rqst ch set timeband.
	 *
	 * @param channelSetTimebandsBulkRequestTimebandsList
	 *            the channel set timebands bulk request timebands list
	 * @param camgenRequest
	 *            the camgen request
	 * @param createdBy
	 *            the created by
	 * @return the list
	 */
	private List<CamgenChannelSetTimeband> mapCamgenRqstChSetTimeband(
			List<ChannelSetTimebandsBulkRequestTimebands> channelSetTimebandsBulkRequestTimebandsList,
			Integer channelSetId, String createdBy) {
		List<CamgenChannelSetTimeband> camgenChannelSetTimebandList = new ArrayList<>();

		for (ChannelSetTimebandsBulkRequestTimebands channelSetTimebandsBulkRequestTimebands : channelSetTimebandsBulkRequestTimebandsList) {
			CamgenChannelSetTimeband camgenChannelSetTimeband = new CamgenChannelSetTimeband();

			mapTimeBandForSaveAndUpdate(channelSetId, channelSetTimebandsBulkRequestTimebands,
					camgenChannelSetTimeband);
			camgenChannelSetTimeband.setCreatedBy(createdBy);
			camgenChannelSetTimeband.setCreatedOn(dateTimeUtility.getCurrentTimeStamp());

			camgenChannelSetTimebandList.add(camgenChannelSetTimeband);
		}

		return camgenChannelSetTimebandList;
	}

	/**
	 * method for map time band
	 * 
	 * @param channelSetId
	 * @param channelSetTimebandsBulkRequestTimebands
	 * @param camgenChannelSetTimeband
	 */
	private void mapTimeBandForSaveAndUpdate(Integer channelSetId,
			ChannelSetTimebandsBulkRequestTimebands channelSetTimebandsBulkRequestTimebands,
			CamgenChannelSetTimeband camgenChannelSetTimeband) {
		camgenChannelSetTimeband.setApplicableDay(channelSetTimebandsBulkRequestTimebands.getDay());
		camgenChannelSetTimeband.setAvailabilityPercentage(channelSetTimebandsBulkRequestTimebands.getAvailability());
		camgenChannelSetTimeband.setTimeband(channelSetTimebandsBulkRequestTimebands.getTimeBand());
		camgenChannelSetTimeband.setStartTime(channelSetTimebandsBulkRequestTimebands.getStartTime());
		camgenChannelSetTimeband.setEndTime(channelSetTimebandsBulkRequestTimebands.getEndTime());
		camgenChannelSetTimeband.setChannelSetId(new BigDecimal(channelSetId));
	}

	public List<CriteriaLineNormalised> getCriteriaLineNormalised(Integer demandSupplyGroupId, Integer planId) {
		return channelSetTimebandsRepository.getCriteriaLineNormalised(demandSupplyGroupId, planId);
	}
}
