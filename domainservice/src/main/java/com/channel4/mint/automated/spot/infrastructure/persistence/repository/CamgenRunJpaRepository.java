package com.channel4.mint.automated.spot.infrastructure.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRun;

/**
 * The Interface CamgenRun JpaRepository.
 * 
 *  @author HCL
 */
@Repository
public interface CamgenRunJpaRepository extends JpaRepository<CamgenRun, Long> {

	/**
	 * find One method for camgenRun
	 * runId the run ID
	 * @return CamgenRun
	 */
	List<CamgenRun> findAll(Specification<CamgenRun> specification);
}
