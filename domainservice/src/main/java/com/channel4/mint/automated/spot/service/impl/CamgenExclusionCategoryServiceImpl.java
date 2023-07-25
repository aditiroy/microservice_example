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
 * File Name:  CamgenExclusionCategoryServiceImpl.java
 * File created Date : 15-May-2018
 * 
 *
 * 
 *****************************************************************/
package com.channel4.mint.automated.spot.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenExclusionCategoryRepository;
import com.channel4.mint.automated.spot.interfaces.dto.ExclusionCategories;
import com.channel4.mint.automated.spot.service.CamgenExclusionCategoryService;

/**
 * The class CamgenExclusionCategoryServiceImpl is the service implementation for handling CamgenExclusionCategory requests.
 *
 * @author HCL
 */
@Service
public class CamgenExclusionCategoryServiceImpl implements CamgenExclusionCategoryService{
	private static final Logger LOGGER = LoggerFactory.getLogger(CamgenExclusionCategoryServiceImpl.class);

	@Autowired
	private CamgenExclusionCategoryRepository camgenExclusionCategoryRepository;
	
	/* (non-Javadoc)
	 * @see com.channel4.mint.automated.spot.service.CamgenExclusionCategoryService#getCamgenExclusionCategoryService()
	 */
	@Override
	public ExclusionCategories getCamgenExclusionCategoryService() {
		LOGGER.info(">> Service CamgenExclusionCategoryServiceImpl method getCamgenExclusionCategoryService");
		return camgenExclusionCategoryRepository.getExclusionCategories();
	
	}

}
