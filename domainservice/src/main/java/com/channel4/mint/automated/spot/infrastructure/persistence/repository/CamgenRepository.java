package com.channel4.mint.automated.spot.infrastructure.persistence.repository;

import java.util.Map;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenDemandSupplyAttribute;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenDemandSupplyCondition;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenDemandSupplyLevel;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenDemandSupplyObject;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyLevelObjects;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyLevels;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyObjectAttributeConditions;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyObjectAttributes;

/**
 * The CamgenRepository service is used to get demand supply.
 * 
 * @author HCL
 *
 */
public interface CamgenRepository {
	/**
	 * Method to object attribute conditions.
	 * 
	 * @param attributeId
	 *            attribute id
	 * @return DemandSupplyObjectAttributeConditions
	 */
	DemandSupplyObjectAttributeConditions getDemandSupplyLevelObjectAttributeConditions(Integer attributeId);

	/**
	 * Method to get object attributes.
	 * 
	 * @param objectId
	 *            object id
	 * @return DemandSupplyObjectAttributes
	 */
	DemandSupplyObjectAttributes getDemandSupplyLevelObjectAttributes(Integer objectId);

	/**
	 * Method to get level objects.
	 * 
	 * @param levelId
	 *            level id
	 * @return DemandSupplyLevelObjects
	 */
	DemandSupplyLevelObjects getDemandSupplyLevelObjects(Integer levelId);

	/**
	 * Method to get levels.
	 * 
	 * @return DemandSupplyLevels
	 */
	DemandSupplyLevels getDemandSupplyLevelObjectAttributes();

	/**
	 * Method to get all camgen demand supply level map.
	 * 
	 * @return Map
	 */
	Map<Long, CamgenDemandSupplyLevel> getAllCamgenDemandSupplyLevelMap();

	/**
	 * Method to get all camgen demand supply attribute map.
	 * 
	 * @return Map
	 */
	Map<Long, CamgenDemandSupplyAttribute> getAllCamgenDemandSupplyAttributeMap();

	/**
	 * Method to get all camgen demand supply condition map.
	 * 
	 * @return Ma
	 */
	Map<Long, CamgenDemandSupplyCondition> getAllCamgenDemandSupplyConditionMap();

	/**
	 * Method to get all camgen demand supply object map.
	 * 
	 * @return Map
	 */
	Map<Long, CamgenDemandSupplyObject> getAllCamgenDemandSupplyObjectMap();

}
