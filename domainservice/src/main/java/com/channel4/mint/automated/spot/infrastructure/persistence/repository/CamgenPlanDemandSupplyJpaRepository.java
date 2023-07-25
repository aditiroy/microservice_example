package com.channel4.mint.automated.spot.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenPlanDemandSupply;

/**
 * The Interface CamgenPlanDemandSupply JpaRepository.
 * 
 * @author HCL
 */
@Repository
public interface CamgenPlanDemandSupplyJpaRepository extends JpaRepository<CamgenPlanDemandSupply, Long> {
	/**
	 * Method to get camgen plan demand supply.
	 * 
	 * @param demandSupplyId
	 *            demand supply id
	 * @param planId
	 *            plan id
	 * @return CamgenPlanDemandSupply
	 */
	CamgenPlanDemandSupply findOneByDemandSupplyIdAndCamgenPlan_PlanId(Long demandSupplyId, Long planId);

}
