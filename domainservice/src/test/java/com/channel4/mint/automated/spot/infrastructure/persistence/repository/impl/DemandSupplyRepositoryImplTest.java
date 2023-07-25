package com.channel4.mint.automated.spot.infrastructure.persistence.repository.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.http.HttpStatus;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenPlanDemandSupplyJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenPlan;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenPlanDemandSupply;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.PlanDemandSupplyCriteria;
import com.channel4.mint.automated.spot.interfaces.dto.CriteriaLineNormalised;
import com.channel4.mint.automated.spot.test.util.TestUtil;
import com.channel4.mint.baseexception.MintBaseException;

public class DemandSupplyRepositoryImplTest {
	@InjectMocks
	private   DemandSupplyRepositoryImpl  demandSupplyRepositoryImpl;
	
	@Mock
	private CamgenPlanDemandSupplyJpaRepository camgenPlanDemandSupplyJpaRepository;
	
	TestUtil testUtil = new TestUtil();
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void testGetDemandSupplyGroupCriteriaLines() {
		Integer demandSupplyGroupId=1;
		CamgenPlanDemandSupply value= testUtil.getCamgenPlanDemandSupply();  //new CamgenPlanDemandSupply();
		CamgenPlan camgenPlan=new CamgenPlan();
		value.setCamgenPlan(camgenPlan);
		
		value.setDemandSupplyId(1L);
		value.setName("name");
		List<PlanDemandSupplyCriteria> planDemandSupplyCriteriasList=new ArrayList<>();
		PlanDemandSupplyCriteria planDemandSupplyCriteria= testUtil.getPlanDemandSupplyCriteria(); //getPlanDemandSupplyCriteria //new PlanDemandSupplyCriteria();
		
		planDemandSupplyCriteriasList.add(planDemandSupplyCriteria);
		value.setPlanDemandSupplyCriterias(planDemandSupplyCriteriasList);
		when(camgenPlanDemandSupplyJpaRepository.findOne(new Long(demandSupplyGroupId))).thenReturn(value);
		List<CriteriaLineNormalised> criteriaLineNormalisedList = demandSupplyRepositoryImpl.getDemandSupplyGroupCriteriaLines(demandSupplyGroupId);
		assertNotNull(value);
		assertNotNull(criteriaLineNormalisedList);
		assertEquals(criteriaLineNormalisedList.get(0).getValue(), value.getPlanDemandSupplyCriterias().get(0).getValue());
	}

	@Test
	public void getDemandSupplyGroupCriteriaLinesExceptionTest(){
		Integer demandSupplyGroupId=1;
		when(camgenPlanDemandSupplyJpaRepository.findOne(new Long(demandSupplyGroupId))).thenReturn(null);
		int exc = 0;
		try {
			demandSupplyRepositoryImpl.getDemandSupplyGroupCriteriaLines(demandSupplyGroupId);
		} catch (MintBaseException e) {
			exc = e.getCode();
		}
		assertEquals(exc, HttpStatus.NOT_FOUND.value());
	}
	
	@Test
	public void getDemandSupplyGroupCriteriaLinesExceptionFromDatabase(){
		Integer demandSupplyGroupId=1;
		when(camgenPlanDemandSupplyJpaRepository.findOne(new Long(demandSupplyGroupId))).thenThrow(new DataRetrievalFailureException("Exception from database"));
		int exc = 0;
		try {
			demandSupplyRepositoryImpl.getDemandSupplyGroupCriteriaLines(demandSupplyGroupId);
		} catch (MintBaseException e) {
			exc = e.getCode();
		}
		assertEquals(exc, HttpStatus.INTERNAL_SERVER_ERROR.value());
	}


}
