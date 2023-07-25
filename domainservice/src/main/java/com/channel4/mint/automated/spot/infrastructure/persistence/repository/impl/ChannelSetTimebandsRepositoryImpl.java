package com.channel4.mint.automated.spot.infrastructure.persistence.repository.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.channel4.mint.automated.spot.application.util.AutomatedSpotConstants;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenChannelSetTimebandJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenPlanDemandSupplyJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.ChannelSetTimebandsRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenChannelSetTimeband;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenPlanDemandSupply;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.PlanDemandSupplyCriteria;
import com.channel4.mint.automated.spot.interfaces.dto.ChannelSetTimeBandResponse;
import com.channel4.mint.automated.spot.interfaces.dto.CriteriaLineNormalised;
import com.channel4.mint.baseexception.MintBaseException;

/**
 * The Class ChannelSetTimebandsRepositoryImpl db related operations.
 * 
 * @author HCL
 */
@Service
public class ChannelSetTimebandsRepositoryImpl implements ChannelSetTimebandsRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(ChannelSetTimebandsRepositoryImpl.class);

	@Autowired
	private CamgenChannelSetTimebandJpaRepository camgenChannelSetTimebandJpaRepository;

	@Autowired
	private CamgenPlanDemandSupplyJpaRepository camgenPlanDemandSupplyJpaRepository;

	/**
	 * Gets the camgen param channel set timebands.
	 *
	 * @param channelSetID
	 *            the channel set ID
	 * @return ChannelSetTimeBandResponse
	 */
	@Override
	public List<ChannelSetTimeBandResponse> getCamgenParamChannelSetTimebands(Integer channelSetID) {
		List<CamgenChannelSetTimeband> camgenChannelSetTimeband = null;

		try {
			LOGGER.info(" << ChannelSetTimebandsRepositoryImpl : getCamgenParamChannelSetTimebands()");
			camgenChannelSetTimeband = camgenChannelSetTimebandJpaRepository
					.findAllByChannelSetId(new BigDecimal(channelSetID));
			if (CollectionUtils.isEmpty(camgenChannelSetTimeband)) {
				LOGGER.error("ChannelSet Not Found");
				throw new MintBaseException("ChannelSet Not Found", HttpStatus.NOT_FOUND.value());
			}

		} catch (DataAccessException e) {
			LOGGER.error("Exception during get ChannelSet {}", e);
			throw new MintBaseException(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE,
					HttpStatus.INTERNAL_SERVER_ERROR.value());
		}

		return mapChannelSetTimeBand(camgenChannelSetTimeband);
	}

	/**
	 * Map channel set time band.
	 *
	 * @param camgenRequestList
	 *            the camgen request list
	 * @return the list
	 */
	private List<ChannelSetTimeBandResponse> mapChannelSetTimeBand(
			List<CamgenChannelSetTimeband> camgenChannelSetTimebandList) {
		List<ChannelSetTimeBandResponse> channelSetTimeBandResponseList = new ArrayList<>();

		for (CamgenChannelSetTimeband camgenChannelSetTimeband : camgenChannelSetTimebandList) {

			ChannelSetTimeBandResponse channelSetTimeBandResponse = new ChannelSetTimeBandResponse();

			channelSetTimeBandResponse.setAvailability(camgenChannelSetTimeband.getAvailabilityPercentage());
			channelSetTimeBandResponse.setEndTime(camgenChannelSetTimeband.getEndTime());
			channelSetTimeBandResponse.setStartTime(camgenChannelSetTimeband.getStartTime());
			channelSetTimeBandResponse.setDay(camgenChannelSetTimeband.getApplicableDay());

			channelSetTimeBandResponse.setTimeBandId(Integer.parseInt(String.valueOf(camgenChannelSetTimeband.getCamgenChannelSetTimebandId())));

			channelSetTimeBandResponse.setName(camgenChannelSetTimeband.getTimeband());

			channelSetTimeBandResponseList.add(channelSetTimeBandResponse);

		}

		return channelSetTimeBandResponseList;
	}

	/**
	 * Delete time band.
	 *
	 * @param id
	 *            the id
	 */
	@Override
	public void deleteTimeBand(Integer id) {
		CamgenChannelSetTimeband camgenChannelSetTimeband = null;
		try {
			LOGGER.info(" << ChannelSetTimebandsRepositoryImpl : deleteTimeBand()");
			camgenChannelSetTimeband = camgenChannelSetTimebandJpaRepository.findOne(Long.valueOf(id));
			if (null == camgenChannelSetTimeband) {
				LOGGER.error("ChannelSetTimeBand Not Found");
				throw new MintBaseException("ChannelSetTimeBand Not Found", HttpStatus.NOT_FOUND.value());
			}
			camgenChannelSetTimebandJpaRepository.delete(camgenChannelSetTimeband.getCamgenChannelSetTimebandId());
		} catch (DataAccessException e) {
			LOGGER.error("Exception during deleteTimeBand {}", e);
			throw new MintBaseException(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE,
					HttpStatus.INTERNAL_SERVER_ERROR.value());
		}

	}

	/**
	 * Method to get time band.
	 * 
	 * @param id
	 *            id
	 * @return CamgenChannelSetTimeband
	 */
	@Override
	public CamgenChannelSetTimeband getTimeBand(Integer id) {
		CamgenChannelSetTimeband camgenChannelSetTimeband = null;
		try {
			LOGGER.info(" << ChannelSetTimebandsRepositoryImpl : getCamgenRequest()");
			camgenChannelSetTimeband = camgenChannelSetTimebandJpaRepository.findOne(Long.valueOf(id));
			if (null == camgenChannelSetTimeband) {
				LOGGER.error("Channel Set Time Band Not Found for {} ", id);
				throw new MintBaseException("Channel Set Time Band Not Found", HttpStatus.NOT_FOUND.value());
			}
		} catch (DataAccessException e) {
			LOGGER.error("Exception during getCamgenRequest {}", e);
			throw new MintBaseException(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE,
					HttpStatus.INTERNAL_SERVER_ERROR.value());
		}

		return camgenChannelSetTimeband;
	}

	/**
	 * Save time band.
	 *
	 * @param camgenChannelSetTimebandList
	 *            camgen channel set timeband list
	 */
	@Override
	public void saveTimeBand(List<CamgenChannelSetTimeband> camgenChannelSetTimebandList) {
		try {
			LOGGER.info(" << ChannelSetTimebandsRepositoryImpl : saveTimeBand()");
			camgenChannelSetTimebandJpaRepository.save(camgenChannelSetTimebandList);

		} catch (DataAccessException e) {
			LOGGER.error("Exception during saveTimeBand {}", e);
			throw new MintBaseException(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE,
					HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
	}

	public List<CriteriaLineNormalised> getCriteriaLineNormalised(Integer demandSupplyGroupId, Integer planId) {
		CamgenPlanDemandSupply camgenPlanDemandSupply = null;
		try {
			LOGGER.info(" << ChannelSetTimebandsRepositoryImpl : getCriteriaLineNormalised()");
			camgenPlanDemandSupply = camgenPlanDemandSupplyJpaRepository
					.findOneByDemandSupplyIdAndCamgenPlan_PlanId(new Long(demandSupplyGroupId), new Long(planId));
			if (null == camgenPlanDemandSupply
					|| CollectionUtils.isEmpty(camgenPlanDemandSupply.getPlanDemandSupplyCriterias())) {
				LOGGER.error("Criteria Line Not Found In DB ");
				throw new MintBaseException("Criteria Line Not Found", HttpStatus.NOT_FOUND.value());
			}
		} catch (DataAccessException e) {
			LOGGER.error("Exception during getCamgenRequest {}", e);
			throw new MintBaseException(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE,
					HttpStatus.INTERNAL_SERVER_ERROR.value());
		}

		return mapCriteriaLine(camgenPlanDemandSupply.getPlanDemandSupplyCriterias());
	}

	private List<CriteriaLineNormalised> mapCriteriaLine(List<PlanDemandSupplyCriteria> planDemandSupplyCriteriaList) {
		List<CriteriaLineNormalised> criteriaLineNormalisedList = new ArrayList<>();

		for (PlanDemandSupplyCriteria planDemandSupplyCriteria : planDemandSupplyCriteriaList) {
			CriteriaLineNormalised criteriaLineNormalised = new CriteriaLineNormalised();

			criteriaLineNormalised.setCriteriaLineId(planDemandSupplyCriteria.getPlanDemandSupplyCriteriaId());

			if (null != planDemandSupplyCriteria.getCamgenDemandSupplyAttribute()) {
				criteriaLineNormalised.setAttributeId(
						planDemandSupplyCriteria.getCamgenDemandSupplyAttribute().getDemandSupplyAttributeId());
			}

			if (null != planDemandSupplyCriteria.getCamgenDemandSupplyCondition()) {
				criteriaLineNormalised.setConditionId(
						planDemandSupplyCriteria.getCamgenDemandSupplyCondition().getDemandSupplyConditionId());
			}

			if (null != planDemandSupplyCriteria.getCamgenDemandSupplyObject()) {
				criteriaLineNormalised
						.setObjectId(planDemandSupplyCriteria.getCamgenDemandSupplyObject().getDemandSupplyObjectId());
			}

			criteriaLineNormalised.setOperator(planDemandSupplyCriteria.getOperator());
			criteriaLineNormalised.setValue(planDemandSupplyCriteria.getValue());

			criteriaLineNormalisedList.add(criteriaLineNormalised);
		}

		return criteriaLineNormalisedList;

	}

}
