package com.channel4.mint.automated.spot.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRunIteration;

/**
 * The Interface CamgenRunIteration JpaRepository.
 * 
 *  @author HCL
 */
@Repository
public interface CamgenRunIterationJpaRepository extends JpaRepository<CamgenRunIteration, Long> {

}
