package com.channel4.mint.automated.spot.application.util;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class PlanSummaryUtilTest {

	@InjectMocks
	private PlanSummaryUtil planSummaryUtil;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void testGetSortByFieldTest() {
		String res=planSummaryUtil.getSortByField("planid");
		assertNotNull(res);
	}
	@Test
	public void testGetSortByFieldTestFirst() {
		String res=planSummaryUtil.getSortByField("");
		assertNotNull(res);
	}

}
