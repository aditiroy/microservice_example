package com.channel4.mint.automated.spot.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenRepository;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyLevelObjects;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyLevels;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyObjectAttributeConditions;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyObjectAttributes;
import com.channel4.mint.automated.spot.service.CamgenService;

/**
 * The CamgenServiceImpl service is used to get camgen demand supply.
 * 
 * @author HCL
 *
 */
@Service
public class CamgenServiceImpl implements CamgenService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CamgenServiceImpl.class);

	@Autowired
	private CamgenRepository camgenRepository;

	/**
	 * Method to get object attribute conditions.
	 * 
	 * @param attributeId
	 *            attribute id
	 * @return DemandSupplyObjectAttributeConditions
	 */
	@Override
	public DemandSupplyObjectAttributeConditions getDemandSupplyLevelObjectAttributeConditions(Integer attributeId) {
		LOGGER.info(">> getDemandSupplyLevelObjectAttributeConditions() of CamgenServiceImpl.");
		return camgenRepository.getDemandSupplyLevelObjectAttributeConditions(attributeId);
	}

	/**
	 * Method to get object attributes.
	 * 
	 * @param objectId
	 *            object id
	 * @return DemandSupplyObjectAttributes
	 */
	@Override
	public DemandSupplyObjectAttributes getDemandSupplyLevelObjectAttributes(Integer objectId) {
		LOGGER.info(">> getDemandSupplyLevelObjectAttributeConditions() of CamgenServiceImpl.");
		return camgenRepository.getDemandSupplyLevelObjectAttributes(objectId);
	}

	/**
	 * Method to get level objects.
	 * 
	 * @param levelId
	 *            level id
	 * @return DemandSupplyLevelObjects
	 */
	@Override
	public DemandSupplyLevelObjects getDemandSupplyLevelObjects(Integer levelId) {
		LOGGER.info(">> getDemandSupplyLevelObjectAttributeConditions() of CamgenServiceImpl.");
		return camgenRepository.getDemandSupplyLevelObjects(levelId);
	}

	/**
	 * Method to get all demand supply levels.
	 * 
	 * @return DemandSupplyLevels
	 */
	@Override
	public DemandSupplyLevels getDemandSupplyLevelObjectAttributes() {
		LOGGER.info(">> getDemandSupplyLevelObjectAttributeConditions() of CamgenServiceImpl.");
		return camgenRepository.getDemandSupplyLevelObjectAttributes();
	}

}
