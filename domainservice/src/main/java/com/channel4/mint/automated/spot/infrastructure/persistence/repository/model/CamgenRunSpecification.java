package com.channel4.mint.automated.spot.infrastructure.persistence.repository.model;

import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.joda.time.DateTime;
import org.springframework.data.jpa.domain.Specification;

public class CamgenRunSpecification implements Specification<CamgenRun> {

	private SearchCriteria criteria;

	public CamgenRunSpecification(SearchCriteria criteria) {
		this.criteria = criteria;
	}

	@Override
	public Predicate toPredicate(Root<CamgenRun> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
		query.distinct(true);
		if (criteria.getOperation().equalsIgnoreCase("[eq]")) {
			return getPredicateForEqualTo(root, query, builder);
		} else if ("[gt]".equalsIgnoreCase(criteria.getOperation())) {
			return getPredicateForGreaterThan(root, query, builder);
		} else if ("[lt]".equalsIgnoreCase(criteria.getOperation())) {
			return getPredicateForLeassThan(root, query, builder);
		}
		return null;
	}

	private Predicate getPredicateForEqualTo(Root<CamgenRun> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
		if ("runId".equalsIgnoreCase(criteria.getKey())) {
			return builder.equal(root.get("runId"), criteria.getValue());
		} if ("requestStatus".equalsIgnoreCase(criteria.getKey())) {
			return builder.equal(builder.upper(root.get("camgenRequest").get("status")), criteria.getValue().toString().toUpperCase());
		}if ("runStatus".equalsIgnoreCase(criteria.getKey())) {
			return builder.equal(root.get("status"), criteria.getValue());
		}


		return null;
	}

	private Predicate getPredicateForLeassThan(Root<CamgenRun> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
		if ("scheduleDateTime".equalsIgnoreCase(criteria.getKey())) {
			return builder.lessThanOrEqualTo(root.<Date> get("scheduleDateTime"),
					(new DateTime(criteria.getValue().toString()).toDate()));
		}

		return null;
	}

	private Predicate getPredicateForGreaterThan(Root<CamgenRun> root, CriteriaQuery<?> query,
			CriteriaBuilder builder) {

		if ("scheduleDateTime".equalsIgnoreCase(criteria.getKey())) {
			return builder.greaterThanOrEqualTo(root.<Date> get("scheduleDateTime"),
					(new DateTime(criteria.getValue().toString()).toDate()));

		}

		return null;
	}

}
