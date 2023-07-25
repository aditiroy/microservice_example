package com.channel4.mint.automated.spot.service;

import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyLevelObjects;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyLevels;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyObjectAttributeConditions;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyObjectAttributes;

/**
 * The Interface CamgenService Service used for getting demand supply.
 * 
 * @author HCL
 */
public interface CamgenService {

	/**
	 * Method to get attribute conditions.
	 * 
	 * @param attributeId
	 *            attribute Id
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
	 * Method to get all demand supply levels.
	 * 
	 * @return DemandSupplyLevels
	 */
	DemandSupplyLevels getDemandSupplyLevelObjectAttributes();

}
