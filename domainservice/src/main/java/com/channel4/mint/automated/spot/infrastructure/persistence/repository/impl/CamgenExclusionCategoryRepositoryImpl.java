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
 * File Name:  CamgenExclusionCategoryRepositoryImpl.java
 * File created Date : 15-May-2018
 * 
 *
 * 
 *****************************************************************/
package com.channel4.mint.automated.spot.infrastructure.persistence.repository.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.channel4.mint.automated.spot.application.util.AutomatedSpotConstants;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenExclusionCategoryJPARepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenExclusionCategoryRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenExclusionCategory;
import com.channel4.mint.automated.spot.interfaces.dto.ExclusionCategories;
import com.channel4.mint.automated.spot.interfaces.dto.ExclusionCategory;
import com.channel4.mint.baseexception.MintBaseException;


/**
 * The class CamgenExclusionCategoryRepositoryImpl is the repository implementation for handling CamgenExclusionCategory requests.
 *
 * @author HCL
 */
@Repository
public class CamgenExclusionCategoryRepositoryImpl implements CamgenExclusionCategoryRepository {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(CamgenExclusionCategoryRepositoryImpl.class);

	/** The camgen exclusion category JPA repository. */
	@Autowired
	private CamgenExclusionCategoryJPARepository camgenExclusionCategoryJPARepository;

	/* (non-Javadoc)
	 * @see com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenExclusionCategoryRepository#getExclusionCategories()
	 */
	@Override
	public ExclusionCategories getExclusionCategories() {
		List<CamgenExclusionCategory> camgenExclusionCategoryList = null;

		try {
			LOGGER.info(">> CamgenExclusionCategoryRepositoryImpl.getExclusionCategories(");
			camgenExclusionCategoryList = camgenExclusionCategoryJPARepository.findAll();
			if (CollectionUtils.isEmpty(camgenExclusionCategoryList)) {
				LOGGER.error(AutomatedSpotConstants.DATA_NOT_FOUND);
				throw new MintBaseException(AutomatedSpotConstants.DATA_NOT_FOUND, HttpStatus.NOT_FOUND.value());
			}

		} catch (DataAccessException e) {
			LOGGER.error("Exception during get all camgen audience group channel {}", e);
			throw new MintBaseException(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE,
					HttpStatus.INTERNAL_SERVER_ERROR.value());
		}

		return mapCamgenExclusionCategory(camgenExclusionCategoryList);
	}
	
	/**
	 * Map camgen exclusion category.
	 *
	 * @param camgenExclusionCategoryList the camgen exclusion category list
	 * @return ExclusionCategories
	 */
	private ExclusionCategories mapCamgenExclusionCategory(
			List<CamgenExclusionCategory> camgenExclusionCategoryList) {
		ExclusionCategories exclusionCategories = new ExclusionCategories();
		camgenExclusionCategoryList.forEach(item -> {
			ExclusionCategory exclusionCategory = new ExclusionCategory();
			exclusionCategory.setCategoryId(item.getCategoryId().toString());
			exclusionCategory.setCategoryName(item.getCategoryName());

			exclusionCategories.add(exclusionCategory);
		});

		return exclusionCategories;
	}

	
}
