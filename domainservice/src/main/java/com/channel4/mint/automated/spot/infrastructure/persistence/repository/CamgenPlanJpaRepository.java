package com.channel4.mint.automated.spot.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenPlan;

/**
 * The Interface CamgenPlan JpaRepository.
 * 
 *  @author HCL
 */
@Repository
public interface CamgenPlanJpaRepository extends JpaRepository<CamgenPlan, Long> ,JpaSpecificationExecutor<CamgenPlan>{

}
