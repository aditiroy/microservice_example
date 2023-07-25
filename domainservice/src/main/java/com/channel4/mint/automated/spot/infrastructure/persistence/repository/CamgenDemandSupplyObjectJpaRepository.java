package com.channel4.mint.automated.spot.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenDemandSupplyObject;

/**
 * The interface CamgenDemandSupplyObjectJpaRepository service is a
 * CamgenDemandSupplyObject repository.
 * 
 * @author HCL
 *
 */
@Repository
public interface CamgenDemandSupplyObjectJpaRepository extends JpaRepository<CamgenDemandSupplyObject, Long> {

}
