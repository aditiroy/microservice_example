/*
 * 
 */
package com.channel4.mint.automated.spot.application.util;

import java.util.HashMap;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class CamgenConstant.
 */
public class CamgenConstant {
	
	/** The Constant INTERNAL_SERVER_ERROR. */
	public static final String INTERNAL_SERVER_ERROR = "Internal Server Error";
	
	/** The Constant DATA_NOT_FOUND. */
	public static final String DATA_NOT_FOUND = "Data Not Found";
	
	/** The Constant DAY_OF_WEEK. */
	public static final Map<Integer, String> DAY_OF_WEEK = getDaysOfWeek();

	/**
	 * Gets the days of week.
	 *
	 * @return the days of week
	 */
	private static Map<Integer, String> getDaysOfWeek() {
		Map<Integer, String> dayMap = new HashMap<>();
		
		dayMap.put(1, "MON");
		dayMap.put(2, "TUE");
		dayMap.put(3, "WED");
		dayMap.put(4, "THU");
		dayMap.put(5, "FRI");
		dayMap.put(6, "SAT");
		dayMap.put(7, "SUN");

		return dayMap;

	}

	/**
	 * Instantiates a new camgen constant.
	 */
	private CamgenConstant() {

	}

}
