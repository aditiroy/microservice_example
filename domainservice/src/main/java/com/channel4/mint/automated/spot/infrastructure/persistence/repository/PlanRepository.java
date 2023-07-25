package com.channel4.mint.automated.spot.infrastructure.persistence.repository;

import java.util.List;

import org.joda.time.LocalDate;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenPlan;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRequest;
import com.channel4.mint.automated.spot.interfaces.dto.PlanSummaryWithPagination;
import com.channel4.mint.automated.spot.interfaces.dto.PlansObject;

/**
 * The Interface PlanRepository used for operation of CamgenRequest.
 * 
 * @author HCL
 */
public interface PlanRepository {
	
	/**
	 * Save plans.
	 *
	 * @param camgenRequest the camgen request
	 */
	void savePlans(CamgenPlan camgenRequest);

	/**
	 * Gets the camgen request.
	 *
	 * @param id the id
	 * @return the camgen request
	 */
	CamgenRequest getCamgenRequest(Integer id);
	
	CamgenPlan getCamgenPlan(Integer id);

	/**
	 * Gets the plan.
	 *
	 * @param planId the plan id
	 * @return the plan
	 */
	List<PlansObject> getPlan(LocalDate planDate, String dayNumber, Integer planId, Boolean includeDemandSupply,
			Boolean includeExclussions, String status);

	

	/**
	 * Gets the plans.
	 *
	 * @param page the page
	 * @param count the count
	 * @param sortOrder the sort order
	 * @param sortByField the sort by field
	 * @return the plans
	 */
	PlanSummaryWithPagination getPlans(Integer page, Long count, String sortOrder, String sortByField);

}
