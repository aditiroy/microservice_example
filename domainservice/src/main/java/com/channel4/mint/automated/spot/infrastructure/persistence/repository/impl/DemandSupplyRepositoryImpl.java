package com.channel4.mint.automated.spot.infrastructure.persistence.repository.impl;

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
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenPlanDemandSupplyJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.DemandSupplyRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenPlanDemandSupply;
import com.channel4.mint.automated.spot.interfaces.dto.CriteriaLineNormalised;
import com.channel4.mint.baseexception.MintBaseException;

/**
 * The Class DemandSupplyRepositoryImpl db related operations.
 * 
 * @author HCL
 */
@Service
public class DemandSupplyRepositoryImpl implements DemandSupplyRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(DemandSupplyRepositoryImpl.class);

	@Autowired
	private CamgenPlanDemandSupplyJpaRepository camgenPlanDemandSupplyJpaRepository;

	/**
	 * Gets the demand supply group criteria lines.
	 *
	 * @param demandSupplyGroupId
	 *            the demand supply group id
	 * @return CriteriaLineNormalised
	 */
	@Override
	public List<CriteriaLineNormalised> getDemandSupplyGroupCriteriaLines(Integer demandSupplyGroupId) {
		CamgenPlanDemandSupply camgenPlanDemandSupply = null;
		try {
			LOGGER.info(">> DemandSupplyRepositoryImpl.getDemandSupplyGroupCriteriaLines()");
			camgenPlanDemandSupply = camgenPlanDemandSupplyJpaRepository.findOne(demandSupplyGroupId.longValue());

			if (null == camgenPlanDemandSupply
					|| CollectionUtils.isEmpty(camgenPlanDemandSupply.getPlanDemandSupplyCriterias())) {
				LOGGER.error(AutomatedSpotConstants.DATA_NOT_FOUND);
				throw new MintBaseException(AutomatedSpotConstants.DATA_NOT_FOUND, HttpStatus.NOT_FOUND.value());
			}
		} catch (DataAccessException dae) {
			LOGGER.error(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE, dae);
			throw new MintBaseException(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE,
					HttpStatus.INTERNAL_SERVER_ERROR.value());
		}

		return mapCriteria(camgenPlanDemandSupply);

	}

	/**
	 * Map criteria.
	 *
	 * @param camgenPlanDemandSupply
	 *            the camgen plan demand supply
	 * @return CriteriaLineNormalised
	 */
	private List<CriteriaLineNormalised> mapCriteria(CamgenPlanDemandSupply camgenPlanDemandSupply) {
		List<CriteriaLineNormalised> criteriaLineNormalisedList = new ArrayList<>();

		camgenPlanDemandSupply.getPlanDemandSupplyCriterias().forEach(item -> {
			CriteriaLineNormalised criteriaLineNormalised = new CriteriaLineNormalised();

			if (null != item.getCamgenDemandSupplyAttribute()) {
				criteriaLineNormalised
						.setAttributeId(item.getCamgenDemandSupplyAttribute().getDemandSupplyAttributeId());
			}

			if (null != item.getCamgenDemandSupplyCondition()) {
				criteriaLineNormalised
						.setConditionId(item.getCamgenDemandSupplyCondition().getDemandSupplyConditionId());
			}

			if (null != item.getCamgenDemandSupplyObject()) {
				criteriaLineNormalised.setObjectId(item.getCamgenDemandSupplyObject().getDemandSupplyObjectId());
			}

			criteriaLineNormalised.setCriteriaLineId(item.getPlanDemandSupplyCriteriaId());
			criteriaLineNormalised.setValue(item.getValue());
			criteriaLineNormalised.setOperator(item.getOperator());

			criteriaLineNormalisedList.add(criteriaLineNormalised);
		});

		return criteriaLineNormalisedList;

	}

}
