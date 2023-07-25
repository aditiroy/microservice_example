package com.channel4.mint.automated.spot.service;

import java.util.List;

import com.channel4.mint.automated.spot.interfaces.dto.CriteriaLineNormalised;

/**
 * The Interface DemandSupplyService used for operation for
 * CriteriaLineNormalised.
 * 
 * @author HCL
 */
public interface DemandSupplyService {

	/**
	 * Gets the demand supply group criteria lines.
	 *
	 * @param demandSupplyGroupId
	 *            the demand supply group id
	 * @return CriteriaLineNormalised
	 */
	List<CriteriaLineNormalised> getDemandSupplyGroupCriteriaLines(Integer demandSupplyGroupId);

}
