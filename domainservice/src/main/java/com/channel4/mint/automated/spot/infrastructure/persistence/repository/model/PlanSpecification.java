package com.channel4.mint.automated.spot.infrastructure.persistence.repository.model;

import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.joda.time.LocalDate;
import org.springframework.data.jpa.domain.Specification;

public class PlanSpecification implements Specification<CamgenPlan> {
	private SearchCriteria criteria;

	public PlanSpecification(SearchCriteria criteria) {
		this.criteria = criteria;
	}

	@Override
	public Predicate toPredicate(Root<CamgenPlan> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
		if ("[eq]".equalsIgnoreCase(criteria.getOperation())) {
			return getPredicateForEqualTo(root, query, builder);
		} else if ("[gt]".equalsIgnoreCase(criteria.getOperation())) {
			return getPredicateForGreaterThan(root, query, builder);
		} else if ("[lt]".equalsIgnoreCase(criteria.getOperation())) {
			return getPredicateForLeassThan(root, query, builder);
		}

		return null;
	}

	private Predicate getPredicateForEqualTo(Root<CamgenPlan> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

		if ("planId".equalsIgnoreCase(criteria.getKey())) {
			return builder.equal(root.get("planId").as(String.class), criteria.getValue().toString());
		} else if ("runDay".equalsIgnoreCase(criteria.getKey())) {
			return builder.equal(builder.upper(root.join("camgenPlanAutofillingDays").get("runDay")), criteria.getValue().toString().toUpperCase());
		} else if ("status".equalsIgnoreCase(criteria.getKey())) {
			return builder.equal(builder.upper(root.get("status")), criteria.getValue().toString().toUpperCase());
		}

		return null;

	}

	private Predicate getPredicateForLeassThan(Root<CamgenPlan> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

		if ("startDate".equalsIgnoreCase(criteria.getKey())) {
			return builder.lessThanOrEqualTo(root.<Date> get("startDate"),
					(new LocalDate(criteria.getValue().toString()).toDate()));
		}

		return null;
	}

	private Predicate getPredicateForGreaterThan(Root<CamgenPlan> root, CriteriaQuery<?> query,
			CriteriaBuilder builder) {

		if ("endDate".equalsIgnoreCase(criteria.getKey())) {
			return builder.greaterThanOrEqualTo(root.<Date> get("endDate"),
					(new LocalDate(criteria.getValue().toString()).toDate()));

		}

		return null;
	}

}
