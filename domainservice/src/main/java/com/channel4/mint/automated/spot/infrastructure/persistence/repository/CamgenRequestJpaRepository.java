package com.channel4.mint.automated.spot.infrastructure.persistence.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRequest;

/**
 * The Interface CamgenRequest JpaRepository.
 * 
 * @author HCL
 */
@Repository
public interface CamgenRequestJpaRepository extends JpaRepository<CamgenRequest, Long> {
	/**
	 * Method to get all camgen request.
	 * 
	 * @param id
	 *            id
	 * @return CamgenRequest
	 */
	List<CamgenRequest> findAllByChannelSetId(BigDecimal id);

	List<CamgenRequest> findAll(Specification<CamgenRequest> specification);

}
