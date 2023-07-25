package com.channel4.mint.automated.spot.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenBatchTxLevel;

/**
 * The interface CamgenBatchTxLevelJpaRepository service is a
 * CampgenBatchTxLevel repository.
 * 
 * @author HCL
 *
 */
@Repository
public interface CamgenBatchTxLevelJpaRepository extends JpaRepository<CamgenBatchTxLevel, Long> {

}
