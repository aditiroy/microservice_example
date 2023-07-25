package com.channel4.mint.automated.spot.infrastructure.persistence.repository.model;

import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.joda.time.LocalDate;
import org.springframework.data.jpa.domain.Specification;



public class CamgenRequestSpecification implements Specification<CamgenRequest>{

	private SearchCriteria criteria;

	public CamgenRequestSpecification(SearchCriteria criteria) {
		this.criteria = criteria;
	}

	@Override
	public Predicate toPredicate(Root<CamgenRequest> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
		query.distinct(true);
		if (criteria.getOperation().equalsIgnoreCase("[eq]")) {
			return getPredicateForEqualTo(root, query, builder);
		}
		return null;
	}
	private Predicate getPredicateForEqualTo(Root<CamgenRequest> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
		if ("snapshotId".equalsIgnoreCase(criteria.getKey())) {
			return builder.equal(root.get("requestId"), criteria.getValue());
		}  if ("scheduledDate".equalsIgnoreCase(criteria.getKey())) {
			return builder.equal(root.<Date> get("scheduleDateTime"),(new LocalDate(criteria.getValue().toString()).toDate()));
		}
		else if ("scheduledStartTime".equalsIgnoreCase(criteria.getKey())) {
			return builder.greaterThanOrEqualTo(root.<Date> get("startDate"),
					(new LocalDate(criteria.getValue().toString()).toDate()));
		}
		else if ("scheduledEndTime".equalsIgnoreCase(criteria.getKey())) {
			return builder.lessThanOrEqualTo(root.<Date> get("endDate"),
					(new LocalDate(criteria.getValue().toString()).toDate()));
		} else if ("status".equalsIgnoreCase(criteria.getKey())) {
			return builder.equal(builder.upper(root.get("status")), criteria.getValue().toString().toUpperCase());
		}
		return null;
	}
	 
}
