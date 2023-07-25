/*
 * 
 */
package com.channel4.mint.automated.spot.application.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

// TODO: Auto-generated Javadoc
/**
 * The Class SnapshotSummaryUtil.
 */
@Component
public class SnapshotSummaryUtil {

	/** The sort string map. */
	Map<String, String> sortStringMapShanpShot = getsortStringMapShanpShotSnapShot();
	
	/**
	 * This method returns the Map for SortBy fields.
	 *
	 * @return Map<String, String>
	 */
	private Map<String, String> getsortStringMapShanpShotSnapShot() {
		sortStringMapShanpShot = new HashMap<>();
		sortStringMapShanpShot.put("default","createdOn");
		sortStringMapShanpShot.put("channelsetid","channelSetId");
		sortStringMapShanpShot.put("day","startDate");
		sortStringMapShanpShot.put("fillingenddate","camgenPlan.endDate");
		sortStringMapShanpShot.put("fillingstartdate","camgenPlan.startDate");
		sortStringMapShanpShot.put("requestid","requestId");
		sortStringMapShanpShot.put("requesttype","requestType");
		sortStringMapShanpShot.put("run","camgenPlan.isRun");
		sortStringMapShanpShot.put("slot","camgenPlan.isSlot");
		sortStringMapShanpShot.put("schedulerdate","camgenRuns.scheduleDateTime");  
		sortStringMapShanpShot.put("snapshotid","requestId");
		sortStringMapShanpShot.put("starttime", "startDate");
		sortStringMapShanpShot.put("status", "status");
		
		return sortStringMapShanpShot;
	}
	
	/**
	 * Method return sort column.
	 *
	 * @param sortByField the sort by field
	 * @return String
	 */
	public String getSortByField(String sortByField) {

		if (null == sortByField || "".equalsIgnoreCase(sortByField.trim())) {

			return sortStringMapShanpShot.get("default");
		} else {
			return sortStringMapShanpShot.get(sortByField.toLowerCase());
		}

	}

}
