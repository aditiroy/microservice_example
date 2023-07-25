package com.channel4.mint.automated.spot.infrastructure.persistence.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenChannelSetTimeband;

/**
 * The interface CamgenChannelSetTimebandJpaRepository service is a
 * CamgenChannelSetTimeband repository.
 * 
 * @author HCL
 *
 */
@Repository
public interface CamgenChannelSetTimebandJpaRepository extends JpaRepository<CamgenChannelSetTimeband, Long> {
	/**
	 * Method to get all camgen channel set timeband.
	 * 
	 * @param channelSetId
	 *            channel set id
	 * @return CamgenChannelSetTimeband
	 */
	List<CamgenChannelSetTimeband> findAllByChannelSetId(BigDecimal channelSetId);

}
