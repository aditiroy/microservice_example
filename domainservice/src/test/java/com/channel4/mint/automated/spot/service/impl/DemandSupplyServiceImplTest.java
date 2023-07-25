package com.channel4.mint.automated.spot.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.DemandSupplyRepository;
import com.channel4.mint.automated.spot.interfaces.dto.CriteriaLineNormalised;

public class DemandSupplyServiceImplTest {
	@InjectMocks
	private   DemandSupplyServiceImpl  demandSupplyServiceImpl;
	
	@Mock
	private DemandSupplyRepository demandSupplyRepository;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void testGetDemandSupplyGroupCriteriaLines() {
		Integer demandSupplyGroupId=1;
		List<CriteriaLineNormalised> criteriaLineNormalisedList=new ArrayList<>();
		CriteriaLineNormalised e=new CriteriaLineNormalised();
		e.setAttributeId(1L);
		e.setConditionId(1L);
		criteriaLineNormalisedList.add(e);
		when(demandSupplyRepository.getDemandSupplyGroupCriteriaLines(demandSupplyGroupId)).thenReturn(criteriaLineNormalisedList);
		List<CriteriaLineNormalised> criteriaLineNormalisedListRes = demandSupplyServiceImpl.getDemandSupplyGroupCriteriaLines(demandSupplyGroupId);
		assertEquals(criteriaLineNormalisedListRes.get(0).getAttributeId(), criteriaLineNormalisedList.get(0).getAttributeId());
	}

}
