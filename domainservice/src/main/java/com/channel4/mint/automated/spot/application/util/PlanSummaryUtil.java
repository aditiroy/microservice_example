package com.channel4.mint.automated.spot.application.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class PlanSummaryUtil {

	/** The sort string map. */
	Map<String, String> sortStringMap = getSortStringMap();
	
	/**
	 * This method returns the Map for SortBy fields.
	 *
	 * @return Map<String, String>
	 */
	private Map<String, String> getSortStringMap() {
		sortStringMap = new HashMap<>();
		sortStringMap.put("default","planId");
		sortStringMap.put("planid","planId");
		sortStringMap.put("runstartdate","startDate");
		sortStringMap.put("runenddate","endDate");
		sortStringMap.put("iteration","totalIteration");
		sortStringMap.put("run","isRun");
		sortStringMap.put("slot","isSlot");
		sortStringMap.put("createdby", "createdBy");
		sortStringMap.put("status", "status");
		return sortStringMap;
		
	}
	
	/**
	 * Method return sort column.
	 *
	 * @param sortByField the sort by field
	 * @return String
	 */
	public String getSortByField(String sortByField) {

		if (null == sortByField || "".equalsIgnoreCase(sortByField.trim())) {

			return sortStringMap.get("default");
		} else {
			return sortStringMap.get(sortByField.toLowerCase());
		}

	}

}
