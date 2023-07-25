package com.channel4.mint.automated.spot.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenDemandSupplyLevel;

/**
 * The interface CamgenDemandSupplyLevelJpaRepository service is a
 * CamgenDemandSupplyLevel repository.
 * 
 * @author HCL
 *
 */
@Repository
public interface CamgenDemandSupplyLevelJpaRepository extends JpaRepository<CamgenDemandSupplyLevel, Long> {

}
