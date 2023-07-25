package com.channel4.mint.automated.spot.infrastructure.persistence.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.channel4.mint.automated.spot.application.util.AutomatedSpotConstants;
import com.channel4.mint.automated.spot.application.util.CamgenConstant;
import com.channel4.mint.automated.spot.application.util.CamgenPlanMapper;
import com.channel4.mint.automated.spot.application.util.PlanSummaryUtil;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenPlanJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenRequestJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.PlanRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenPlan;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRequest;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.PlanSpecification;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.SearchCriteria;
import com.channel4.mint.automated.spot.interfaces.dto.PlanSummary;
import com.channel4.mint.automated.spot.interfaces.dto.PlanSummaryWithPagination;
import com.channel4.mint.automated.spot.interfaces.dto.PlansObject;
import com.channel4.mint.baseexception.MintBaseException;

/**
 * The Class PlanRepositoryImpl db related operations.
 * 
 * @author HCL
 */
@Service
public class PlanRepositoryImpl implements PlanRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(PlanRepositoryImpl.class);

	@Autowired
	private CamgenRequestJpaRepository camgenRequestJpaRepository;

	@Autowired
	private CamgenPlanJpaRepository camgenPlanJpaRepository;

	@Autowired
	private CamgenPlanMapper camgenPlanMapper;

	@Autowired
	private PlanSummaryUtil planSummaryUtil;

	

	/**
	 * Save plans.
	 *
	 * @param camgenPlan
	 *            the camgen plan
	 */
	@Override
	public void savePlans(CamgenPlan camgenPlan) {
		try {
			LOGGER.info(">> PlanRepositoryImpl.createPlans()");
			camgenPlanJpaRepository.save(camgenPlan);
		} catch (DataAccessException dae) {
			LOGGER.error("Exception during create new camgen plan {}", dae);
			throw new MintBaseException("Exception during create new camgen plan",
					HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
	}

	/**
	 * Gets the camgen request.
	 *
	 * @param id
	 *            the id
	 * @return the camgen request
	 */
	@Override
	public CamgenRequest getCamgenRequest(Integer id) {
		CamgenRequest camgenRequest = null;
		try {
			LOGGER.info(">> PlanRepositoryImpl.getCamgenRequest()");
			camgenRequest = camgenRequestJpaRepository.findOne(Long.valueOf(id));

			if (null == camgenRequest) {
				LOGGER.info("Camgen Request Not Found {}", id);
				throw new MintBaseException("Camgen Request Not Found", HttpStatus.NOT_FOUND.value());
			}
		} catch (DataAccessException dae) {
			LOGGER.error("Exception during get camgen request {}", dae);
			throw new MintBaseException("Exception during get camgen request",
					HttpStatus.INTERNAL_SERVER_ERROR.value());
		}

		return camgenRequest;
	}

	@Override
	public CamgenPlan getCamgenPlan(Integer id) {
		CamgenPlan camgenPlan = null;
		try {
			LOGGER.info(">> PlanRepositoryImpl.getCamgenRequest()");
			camgenPlan = camgenPlanJpaRepository.findOne(Long.valueOf(id));

			if (null == camgenPlan) {
				LOGGER.info("Camgen Plan Not Found {}", id);
				throw new MintBaseException("Camgen Request Not Found", HttpStatus.NOT_FOUND.value());
			}
		} catch (DataAccessException dae) {
			LOGGER.error("Exception during get camgen request {}", dae);
			throw new MintBaseException("Exception during get camgen request",
					HttpStatus.INTERNAL_SERVER_ERROR.value());
		}

		return camgenPlan;
	}

	/**
	 * Gets the plan.
	 *
	 * @param planId
	 *            the plan id
	 * @return the plan
	 */
	@Override
	public List<PlansObject> getPlan(LocalDate planDate, String dayNumber, Integer planId,
			Boolean includeDemandSupply, Boolean includeExclussions, String status) {
		try {
			LOGGER.info(">> PlanRepositoryImpl.getPlan()");
			List<CamgenPlan> camgenPlanList = camgenPlanJpaRepository
					.findAll(getSpec(planDate, dayNumber, planId, status));
			if (CollectionUtils.isEmpty(camgenPlanList)) {
				LOGGER.info("camgenPlan not found ");
				throw new MintBaseException(AutomatedSpotConstants.DATA_NOT_FOUND, HttpStatus.NOT_FOUND.value());
			}

			return camgenPlanMapper.getPlansObject(camgenPlanList, includeDemandSupply, includeExclussions);
		} catch (DataAccessException dae) {
			LOGGER.error(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE, dae);
			throw new MintBaseException(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE,
					HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
	}

	private Specification<CamgenPlan> getSpec(LocalDate planDate, String dayNumber,
			Integer planId, String status) {
		List<SearchCriteria> criterias = new ArrayList<>();

		if (null != planId) {
			SearchCriteria searchCriteria = new SearchCriteria("planId", "[eq]", planId.toString());
			criterias.add(searchCriteria);
		}

		if (null != planDate) {
			SearchCriteria searchCriteriaStartDate = new SearchCriteria("startDate", "[lt]", planDate.toString());
			criterias.add(searchCriteriaStartDate);
			
			SearchCriteria searchCriteriaEndDate = new SearchCriteria("endDate", "[gt]", planDate.toString());
			criterias.add(searchCriteriaEndDate);
		}
		
		if (StringUtils.isNotEmpty(status)) {
			SearchCriteria searchCriteria = new SearchCriteria("status", "[eq]", status);
			criterias.add(searchCriteria);
		}


		if (StringUtils.isNotEmpty(dayNumber)) {
			SearchCriteria searchCriteria = new SearchCriteria("runDay", "[eq]",
					CamgenConstant.DAY_OF_WEEK.get(Integer.parseInt(dayNumber)));
			criterias.add(searchCriteria);
		}

		List<Specification<CamgenPlan>> specs = new ArrayList<>();
		for (SearchCriteria criteria : criterias) {
			specs.add(new PlanSpecification(criteria));
		}

		Specification<CamgenPlan> result = null;

		if (!CollectionUtils.isEmpty(criterias)) {
			result = specs.get(0);

			for (int i = 1; i < specs.size(); i++) {
				result = Specifications.where(result).and(specs.get(i));
			}
		}

		return result;
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
	 * @return the plans
	 */
	public PlanSummaryWithPagination getPlans(Integer page, Long count, String sortOrder, String sortByField) {

		LOGGER.info(" >> PlanRepositoryImpl.getPlans()");
		PlanSummaryWithPagination planSummaryWithPagination = null;
		Page<CamgenPlan> camgenPlanPageList = null;
		List<PlanSummary> planSummaryList = null;

		try {
			camgenPlanPageList = camgenPlanJpaRepository.findAll(getPageRequest(page, count, sortOrder, sortByField));
			if (CollectionUtils.isEmpty(camgenPlanPageList.getContent())) {
				throw new MintBaseException("Data Not Found", HttpStatus.NOT_FOUND.value());
			}

			LOGGER.info(" >> camgenPlanMapper.mapEntityListToCamgenPlan()");
			planSummaryList = camgenPlanMapper.mapEntityListToCamgenPlan(camgenPlanPageList.getContent());
			planSummaryWithPagination = mapPlanSummaryList(camgenPlanPageList, planSummaryList);

		} catch (DataAccessException e) {
			LOGGER.error("Exception during getting getPlans {}", e);
			throw new MintBaseException(CamgenConstant.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		LOGGER.info(" << PlanRepositoryImpl : getPlans()");
		return planSummaryWithPagination;

	}

	/**
	 * Map plan summary list.
	 *
	 * @param planSummaryWithPaginationList
	 *            the plan summary with pagination list
	 * @param camgenPlanPageList
	 *            the camgen plan page list
	 * @param planSummaryList
	 *            the plan summary list
	 */
	private PlanSummaryWithPagination mapPlanSummaryList(Page<CamgenPlan> camgenPlanPageList,
			List<PlanSummary> planSummaryList) {
		PlanSummaryWithPagination planSummaryWithPagination = new PlanSummaryWithPagination();
		planSummaryWithPagination.setPlanSummary(planSummaryList);
		planSummaryWithPagination.setTotalCount(Integer.parseInt(String.valueOf(camgenPlanPageList.getTotalElements())));

		return planSummaryWithPagination;
	}

	/**
	 * Gets the page request.
	 *
	 * @param page
	 *            the page
	 * @param count
	 *            the count
	 * @param sortOrder
	 *            the sort order
	 * @param sortByField
	 *            the sort by field
	 * @return the page request
	 */
	private PageRequest getPageRequest(Integer page, Long count, String sortOrder, String sortByField) {
		Sort.Direction direction = Sort.Direction.ASC;
		if (null != sortOrder && "ASC".equalsIgnoreCase(sortOrder)) {
			direction = Sort.Direction.DESC;
		}
		return new PageRequest(page.intValue(), count.intValue(), direction,
				planSummaryUtil.getSortByField(sortByField));
	}

}
