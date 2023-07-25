
package com.channel4.mint.automated.spot.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.RunStationTimeband;

/**
 * The Interface RunStationTimeband JpaRepository.
 * 
 *  @author HCL
 */
@Repository
public interface RunStationTimebandJpaRepository extends JpaRepository<RunStationTimeband, Long>{

}
