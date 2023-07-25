package com.channel4.mint.automated.spot.application.util;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class SnapshotSummaryUtilTest {

	@InjectMocks
	private SnapshotSummaryUtil snapshotSummaryUtil;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void testGetSortByFieldTest() {
		String res=snapshotSummaryUtil.getSortByField("channelsetid");
		assertNotNull(res);
	}
	@Test
	public void testGetSortByFieldTestFirst() {
		String res=snapshotSummaryUtil.getSortByField("");
		assertNotNull(res);
	}

}
