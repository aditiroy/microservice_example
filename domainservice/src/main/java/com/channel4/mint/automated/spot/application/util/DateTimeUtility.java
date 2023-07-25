/*
 * 
 */
package com.channel4.mint.automated.spot.application.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.channel4.mint.baseexception.MintBaseException;

// TODO: Auto-generated Javadoc
/**
 * The Class Date Time Utility.
 */
@Component
public class DateTimeUtility {
	private static final Logger LOGGER = LoggerFactory.getLogger(DateTimeUtility.class);

	/**
	 * Gets the current time stamp.
	 *
	 * @return Timestamp
	 */
	public java.sql.Timestamp getCurrentTimeStamp() {
		return new java.sql.Timestamp(System.currentTimeMillis());
	}

	/**
	 * this method will convert String date.
	 *
	 * @param yearMonth
	 *            the year month
	 * @return LocalDate
	 */
	public LocalDate getLocalDateFromString(String yearMonth) {
		LocalDate localDate;
		final DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
		if (yearMonth == null) {
			localDate = null;
		} else {
			localDate = dtf.parseLocalDate(yearMonth);
		}
		return localDate;
	}

	/**
	 * this method will convert String date.
	 *
	 * @param yearMonth
	 *            the year month
	 * @return Date
	 */
	public Date getDateFromString(String yearMonth) {
		Date date = null;
		SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			if (yearMonth == null) {
				date = null;
			} else {
				date = dtf.parse(yearMonth);
			}
		} catch (Exception e) {
			LOGGER.error("Exception Dusring parse date");
			throw new MintBaseException("Internal Service error", HttpStatus.INTERNAL_SERVER_ERROR.value());
		}

		return date;
	}

	/**
	 * Gets the time from date.
	 *
	 * @param date
	 *            the date
	 * @return String
	 */
	public String getTimeFromDate(Date date) {
		SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm:ss");
		return localDateFormat.format(date);
	}

}
