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
 * File Name:  CamgenExclusionCategoryRepository.java
 * File created Date : 15-May-2018
 * 
 *
 * 
 *****************************************************************/
package com.channel4.mint.automated.spot.infrastructure.persistence.repository;

import com.channel4.mint.automated.spot.interfaces.dto.ExclusionCategories;


/**
 * The interface CamgenExclusionCategoryRepository is the repository interface for handling CamgenExclusionCategory requests.
 *
 * @author HCL
 */
public interface CamgenExclusionCategoryRepository {

	/**
	 * Gets the exclusion categories.
	 *
	 * @return ExclusionCategories
	 */
	ExclusionCategories getExclusionCategories();
}
