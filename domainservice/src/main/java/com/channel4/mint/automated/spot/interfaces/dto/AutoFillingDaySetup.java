/*
 * 
 */
package com.channel4.mint.automated.spot.interfaces.dto;

import java.math.BigDecimal;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * AutoFillingDaySetup
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-14T09:04:29.792Z")

public class AutoFillingDaySetup {
	/**
	 * Gets or Sets runDay
	 */
	public enum RunDayEnum {
		MON("Mon"),

		TUE("Tue"),

		WED("Wed"),

		THU("Thu"),

		FRI("Fri"),

		SAT("Sat"),

		SUN("Sun");

		private String value;

		RunDayEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static RunDayEnum fromValue(String text) {
			for (RunDayEnum b : RunDayEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("runDay")
	private RunDayEnum runDay = null;

	@JsonProperty("offset")
	private Long offset = null;

	@JsonProperty("duration")
	private BigDecimal duration = null;

	@JsonProperty("startTime")
	private String startTime = null;

	public AutoFillingDaySetup runDay(RunDayEnum runDay) {
		this.runDay = runDay;
		return this;
	}

	/**
	 * Get runDay
	 * 
	 * @return runDay
	 **/
	@ApiModelProperty(value = "")

	public RunDayEnum getRunDay() {
		return runDay;
	}

	public void setRunDay(RunDayEnum runDay) {
		this.runDay = runDay;
	}

	public AutoFillingDaySetup offset(Long offset) {
		this.offset = offset;
		return this;
	}

	/**
	 * Get offset
	 * 
	 * @return offset
	 **/
	@ApiModelProperty(value = "")

	public Long getOffset() {
		return offset;
	}

	public void setOffset(Long offset) {
		this.offset = offset;
	}

	public AutoFillingDaySetup duration(BigDecimal duration) {
		this.duration = duration;
		return this;
	}

	/**
	 * Get duration
	 * 
	 * @return duration
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public BigDecimal getDuration() {
		return duration;
	}

	public void setDuration(BigDecimal duration) {
		this.duration = duration;
	}

	public AutoFillingDaySetup startTime(String startTime) {
		this.startTime = startTime;
		return this;
	}

	/**
	 * Get startTime
	 * 
	 * @return startTime
	 **/
	@ApiModelProperty(value = "")

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		AutoFillingDaySetup autoFillingDaySetup = (AutoFillingDaySetup) o;
		return Objects.equals(this.runDay, autoFillingDaySetup.runDay)
				&& Objects.equals(this.offset, autoFillingDaySetup.offset)
				&& Objects.equals(this.duration, autoFillingDaySetup.duration)
				&& Objects.equals(this.startTime, autoFillingDaySetup.startTime);
	}

	@Override
	public int hashCode() {
		return Objects.hash(runDay, offset, duration, startTime);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class AutoFillingDaySetup {\n");

		sb.append("    runDay: ").append(toIndentedString(runDay)).append("\n");
		sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
		sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
		sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
