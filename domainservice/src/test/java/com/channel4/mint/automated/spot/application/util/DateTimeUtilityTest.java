package com.channel4.mint.automated.spot.application.util;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.sql.Timestamp;
import java.util.Date;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class DateTimeUtilityTest {

	@InjectMocks
	private DateTimeUtility dateTimeUtility;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetCurrentTimeStamp() {
		Timestamp timeStamp = dateTimeUtility.getCurrentTimeStamp();
		assertNotNull(timeStamp);
	}

	@Test
	public void testGetLocalDateFromString() {
		LocalDate timeStamp = dateTimeUtility.getLocalDateFromString("2015-12-12 06:06:06");
		assertNotNull(timeStamp);
	}

	@Test
	public void testGetLocalDateFromString1() {
		LocalDate timeStamp = dateTimeUtility.getLocalDateFromString(null);
		assertNull(timeStamp);
	}

	@Test
	public void testGetDateFromString() {
		Date timeStamp =  dateTimeUtility.getDateFromString("2015-12-12 06:06:06");
		assertNotNull(timeStamp);
	}
	
	
	@Test
	public void testGetTimeFromDate() {
		String timeStamp = dateTimeUtility.getTimeFromDate(new Date());
		assertNotNull(timeStamp);
	}

}
