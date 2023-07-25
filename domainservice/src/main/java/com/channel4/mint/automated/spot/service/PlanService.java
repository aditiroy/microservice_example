package com.channel4.mint.automated.spot.service;

import java.util.List;

import org.joda.time.LocalDate;

import com.channel4.mint.automated.spot.interfaces.dto.PlanSummaryWithPagination;
import com.channel4.mint.automated.spot.interfaces.dto.PlansObject;

/**
 * The Interface PlanService used for operation for PlansRequest.
 * 
 * @author HCL
 */
public interface PlanService {
	
	/**
	 * Creates the plans.
	 *
	 * @param body the body
	 */
	void createPlans(PlansObject body); 
	
	
	
	/**
	 * Gets the plans.
	 *
	 * @param page the page
	 * @param count the count
	 * @param sortOrder the sort order
	 * @param sortByField the sort by field
	 * @return PlanSummaryWithPagination
	 */
	PlanSummaryWithPagination getPlans(Integer page, Long count, String sortOrder, String sortByField);
	
	/**
	 * Update plans.
	 *
	 * @param body the body
	 */
	void updatePlans(PlansObject body);
 
	/**
	 * Gets the plan.
	 * @param planDate
	 * @param dayNumber
	 * @param planId
	 * @param includeDemandSupply
	 * @param includeExclussions
	 * @return PlansObject : List of PlansObject
	 */
	List<PlansObject> getPlan(LocalDate planDate, String dayNumber, Integer planId, Boolean includeDemandSupply,
			Boolean includeExclussions, String status);

}
