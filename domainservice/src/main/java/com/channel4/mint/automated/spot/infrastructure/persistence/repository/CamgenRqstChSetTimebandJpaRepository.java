package com.channel4.mint.automated.spot.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRqstChSetTimeband;

/**
 * The Interface CamgenRqstChSetTimebandJpaRepository.
 * 
 *  @author HCL
 */
public interface CamgenRqstChSetTimebandJpaRepository extends JpaRepository<CamgenRqstChSetTimeband, Long> {
	
	@Modifying
	@Query("delete from CamgenRqstChSetTimeband t where t.camgenRqstChSetTimebandId = ?1")
	void delete(Long entityId);

}