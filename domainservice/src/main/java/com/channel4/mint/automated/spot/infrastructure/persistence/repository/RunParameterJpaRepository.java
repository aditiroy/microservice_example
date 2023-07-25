package com.channel4.mint.automated.spot.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.RunParameter;

/**
 * The Interface RunParameter JpaRepository.
 * 
 * @author HCL
 */
public interface RunParameterJpaRepository extends JpaRepository<RunParameter, Long> {

}
