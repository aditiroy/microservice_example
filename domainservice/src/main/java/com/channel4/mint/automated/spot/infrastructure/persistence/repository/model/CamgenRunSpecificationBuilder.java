package com.channel4.mint.automated.spot.infrastructure.persistence.repository.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

public class CamgenRunSpecificationBuilder {
	   private final List<SearchCriteria> criterias;
	   
	    public CamgenRunSpecificationBuilder() {
	    	criterias = new ArrayList<SearchCriteria>();
	    }
	 
	    public CamgenRunSpecificationBuilder with(String key, String operation, Object value) {
	    	criterias.add(new SearchCriteria(key, operation, value));
	        return this;
	    }
	 
	    public Specification<CamgenRun> build() {
	        if (criterias.size() == 0) {
	            return null;
	        }
	 
	        List<Specification<CamgenRun>> specs = new ArrayList<Specification<CamgenRun>>();
	        for (SearchCriteria criteria : criterias) {
	            specs.add(new CamgenRunSpecification(criteria));
	        }
	 
	        Specification<CamgenRun> result = specs.get(0);
	        for (int i = 1; i < specs.size(); i++) {
	            result = Specifications.where(result).and(specs.get(i));
	        }
	        return result;
	    }
	}
