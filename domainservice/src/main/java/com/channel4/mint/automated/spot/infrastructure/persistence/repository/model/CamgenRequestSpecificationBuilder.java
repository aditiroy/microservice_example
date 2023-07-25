package com.channel4.mint.automated.spot.infrastructure.persistence.repository.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.SearchCriteria;



public class CamgenRequestSpecificationBuilder {
    
    private final List<SearchCriteria> criterias;
 
    public CamgenRequestSpecificationBuilder() {
    	criterias = new ArrayList<SearchCriteria>();
    }
 
    public CamgenRequestSpecificationBuilder with(String key, String operation, Object value) {
    	criterias.add(new SearchCriteria(key, operation, value));
        return this;
    }
 
    public Specification<CamgenRequest> build() {
        if (criterias.size() == 0) {
            return null;
        }
 
        List<Specification<CamgenRequest>> specs = new ArrayList<Specification<CamgenRequest>>();
        for (SearchCriteria criteria : criterias) {
            specs.add(new CamgenRequestSpecification(criteria));
        }
 
        Specification<CamgenRequest> result = specs.get(0);
        for (int i = 1; i < specs.size(); i++) {
            result = Specifications.where(result).and(specs.get(i));
        }
        return result;
    }
}
