package com.channel4.mint.automated.spot.service.impl;

import java.util.List;

import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.channel4.mint.automated.spot.application.util.CamgenPlanMapper;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.PlanRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenPlan;
import com.channel4.mint.automated.spot.interfaces.dto.PlanSummaryWithPagination;
import com.channel4.mint.automated.spot.interfaces.dto.PlansObject;
import com.channel4.mint.automated.spot.service.PlanService;

/**
 * The Class PlanServiceImpl.
 */
@Service
public class PlanServiceImpl implements PlanService {

	private static final Logger LOGGER = LoggerFactory.getLogger(PlanServiceImpl.class);

	@Autowired
	private PlanRepository planRepository;

	@Autowired
	private CamgenPlanMapper camgenPlanMapper;

	/**
	 * Creates the plans.
	 *
	 * @param body
	 *            the body
	 */
	@Override
	public void createPlans(PlansObject body) {
		LOGGER.info("In Service PlanServiceImpl method createPlans()");
		CamgenPlan camgenPlan = camgenPlanMapper.mapCreatePlan(body);
		planRepository.savePlans(camgenPlan);
	}

	/**
	 * Gets the plan.
	 *
	 * @param planId
	 *            the plan id
	 * @return PlansRequest
	 */
	@Override
	public List<PlansObject> getPlan(LocalDate planDate, String dayNumber, Integer planId,
			Boolean includeDemandSupply, Boolean includeExclussions, String status) {
		LOGGER.info("In Service PlanServiceImpl method getPlan()");
		return planRepository.getPlan(planDate, dayNumber, planId, includeDemandSupply,
				includeExclussions, status);
	}

	

	
	/**
	 * Gets the plans.
	 *
	 * @param page
	 *            the page
	 * @param count
	 *            the count
	 * @param sortOrder
	 *            the sort order
	 * @param sortByField
	 *            the sort by field
	 * @return PlanSummaryWithPagination
	 */
	@Override
	public PlanSummaryWithPagination getPlans(Integer page, Long count, String sortOrder, String sortByField) {
		LOGGER.info("In Service PlanServiceImpl method getPlans() pagination");
		return planRepository.getPlans(page, count, sortOrder, sortByField);
	}

	/**
	 * Update plans.
	 *
	 * @param body
	 *            the body
	 */
	@Override
	public void updatePlans(PlansObject body) {
		LOGGER.info("In Service PlanServiceImpl method updatePlans()");
		CamgenPlan camgenPlan = planRepository.getCamgenPlan(body.getPlanId());
		camgenPlan = camgenPlanMapper.mapUpdatePlan(camgenPlan, body);
		planRepository.savePlans(camgenPlan);
	}
}
