package com.channel4.mint.automated.spot.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenExclusionCategoryRepository;
import com.channel4.mint.automated.spot.interfaces.dto.ExclusionCategories;
import com.channel4.mint.automated.spot.test.util.TestUtil;

public class CamgenExclusionCategoryServiceImplTest {	
	
	@InjectMocks
	private   CamgenExclusionCategoryServiceImpl  camgenExclusionCategoryServiceImpl;
	
	@Mock
	private CamgenExclusionCategoryRepository camgenExclusionCategoryRepository;
	
	ExclusionCategories mockExclusionCategories ;
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		TestUtil util = new TestUtil();
		mockExclusionCategories = util.getExclusionCategories();
	}

	@Test
	public void testgetCamgenExclusionCategoryService() {
		when(camgenExclusionCategoryRepository.getExclusionCategories()).thenReturn(mockExclusionCategories);
		ExclusionCategories response = camgenExclusionCategoryServiceImpl.getCamgenExclusionCategoryService();
		assertEquals(response.get(0).getCategoryId(), mockExclusionCategories.get(0).getCategoryId());
		assertEquals(response.get(0).getCategoryName(), mockExclusionCategories.get(0).getCategoryName());
	}

}
