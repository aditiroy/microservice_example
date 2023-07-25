package com.channel4.mint.automated.spot.infrastructure.persistence.repository;

import java.util.List;

import com.channel4.mint.automated.spot.interfaces.dto.CriteriaLineNormalised;

/**
 * The Interface DemandSupply Repository.
 * 
 *  @author HCL
 */
public interface DemandSupplyRepository {
	
	/**
	 * Gets the demand supply group criteria lines.
	 *
	 * @param demandSupplyGroupId the demand supply group id
	 * @return CriteriaLineNormalised
	 */
	List<CriteriaLineNormalised> getDemandSupplyGroupCriteriaLines(Integer demandSupplyGroupId);

}
