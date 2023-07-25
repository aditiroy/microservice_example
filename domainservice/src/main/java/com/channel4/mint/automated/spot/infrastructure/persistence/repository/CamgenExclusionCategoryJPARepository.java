/*****************************************************************
 * Copy right (c) Channel4 , All rights reserved.
 * 
 * 
 * Application Name: automated-spot-domain-service
 * 
 * This application is used for managing add sales of C4.
 * Which is a public media company of UK.
 * 
 * 
 * File Name:  CamgenExclusionCategoryJPARepository.java
 * File created Date : 15-May-2018
 * 
 *
 * 
 *****************************************************************/
package com.channel4.mint.automated.spot.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenExclusionCategory;

/**
 * The interface CamgenExclusionCategoryJPARepository is the repository interface for handling CamgenExclusionCategoryJPA requests.
 *
 * @author HCL
 */
public interface CamgenExclusionCategoryJPARepository extends JpaRepository<CamgenExclusionCategory, Long>{

}
