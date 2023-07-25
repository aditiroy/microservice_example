package com.channel4.mint.automated.spot.infrastructure.persistence.repository.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.http.HttpStatus;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenExclusionCategoryJPARepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenExclusionCategory;
import com.channel4.mint.automated.spot.interfaces.dto.ExclusionCategories;
import com.channel4.mint.automated.spot.test.util.TestUtil;
import com.channel4.mint.baseexception.MintBaseException;

public class CamgenExclusionCategoryRepositoryImplTest {

	@InjectMocks
	CamgenExclusionCategoryRepositoryImpl camgenExclusionCategoryRepositoryImpl;

	@Mock
	CamgenExclusionCategoryJPARepository camgenExclusionCategoryJPARepository;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	List<CamgenExclusionCategory> camgenExclusionCategoryList  = new ArrayList<>();
	CamgenExclusionCategory camgenExclusionCategory = new CamgenExclusionCategory();
	TestUtil testUtil = new TestUtil();

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);

		camgenExclusionCategory = testUtil.getCamgenExclusionCategory();
		camgenExclusionCategoryList.add(camgenExclusionCategory);
	}
	
	@Test
	public void getExclusionCategoriesSuccessTest() throws Exception {
		when(camgenExclusionCategoryJPARepository.findAll()).thenReturn(camgenExclusionCategoryList);
		ExclusionCategories response = camgenExclusionCategoryRepositoryImpl.getExclusionCategories();
	}

	@Test
	public void getExclusionCategoriesExceptionTest() throws Exception {
		DataRetrievalFailureException dataRetrievalFailureException = new DataRetrievalFailureException(
				"DataRetrivalFailureException");
		when(camgenExclusionCategoryJPARepository.findAll()).thenThrow(dataRetrievalFailureException);
		int exceptionCode = 0;
		try {
			camgenExclusionCategoryRepositoryImpl.getExclusionCategories();
		} catch (MintBaseException mintBaseException) {
			exceptionCode = mintBaseException.getCode();
		}
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), exceptionCode);
	}
	
	@Test
	public void getExclusionCategoriesDataNotFoundExceptionTest() throws Exception {
		when(camgenExclusionCategoryJPARepository.findAll()).thenReturn(null);
		int exceptionCode = 0;
		try {
			camgenExclusionCategoryRepositoryImpl.getExclusionCategories();
		} catch (MintBaseException mintBaseException) {
			exceptionCode = mintBaseException.getCode();
		}
		assertEquals(HttpStatus.NOT_FOUND.value(), exceptionCode);
	}
	


	
}
