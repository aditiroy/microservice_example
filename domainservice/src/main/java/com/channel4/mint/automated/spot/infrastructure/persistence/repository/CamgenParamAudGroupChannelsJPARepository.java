package com.channel4.mint.automated.spot.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenAudienceGroupChannel;

/**
 * The Interface CamgenParamAudGroupChannels JPARepository.
 * 
 *  @author HCL
 */
@Repository
public interface CamgenParamAudGroupChannelsJPARepository extends JpaRepository<CamgenAudienceGroupChannel, Long> {

}
