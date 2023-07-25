package com.channel4.mint.automated.spot.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenDemandSupplyCondition;

/**
 * The interface CamgenDemandSupplyConditionJpaRepository service is a
 * CamgenDemandSupplyCondition repository.
 * 
 * @author HCL
 *
 */
@Repository
public interface CamgenDemandSupplyConditionJpaRepository extends JpaRepository<CamgenDemandSupplyCondition, Long> {

}
