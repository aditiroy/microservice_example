package com.channel4.mint.automated.spot.interfaces.dto;

import java.math.BigDecimal;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * ChannelSetTimeBandResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-14T09:04:29.792Z")

public class ChannelSetTimeBandResponse {
	@JsonProperty("timeBandId")
	private Integer timeBandId = null;

	@JsonProperty("day")
	private String day = null;

	@JsonProperty("startTime")
	private String startTime = null;

	@JsonProperty("endTime")
	private String endTime = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("availability")
	private BigDecimal availability = null;

	public ChannelSetTimeBandResponse timeBandId(Integer timeBandId) {
		this.timeBandId = timeBandId;
		return this;
	}

	/**
	 * Get timeBandId
	 * 
	 * @return timeBandId
	 **/
	@ApiModelProperty(value = "")

	public Integer getTimeBandId() {
		return timeBandId;
	}

	public void setTimeBandId(Integer timeBandId) {
		this.timeBandId = timeBandId;
	}

	public ChannelSetTimeBandResponse day(String day) {
		this.day = day;
		return this;
	}

	/**
	 * Get day
	 * 
	 * @return day
	 **/
	@ApiModelProperty(value = "")

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public ChannelSetTimeBandResponse startTime(String startTime) {
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

	public ChannelSetTimeBandResponse endTime(String endTime) {
		this.endTime = endTime;
		return this;
	}

	/**
	 * Get endTime
	 * 
	 * @return endTime
	 **/
	@ApiModelProperty(value = "")

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public ChannelSetTimeBandResponse name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Get name
	 * 
	 * @return name
	 **/
	@ApiModelProperty(value = "")

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ChannelSetTimeBandResponse availability(BigDecimal availability) {
		this.availability = availability;
		return this;
	}

	/**
	 * Get availability
	 * 
	 * @return availability
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public BigDecimal getAvailability() {
		return availability;
	}

	public void setAvailability(BigDecimal availability) {
		this.availability = availability;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ChannelSetTimeBandResponse channelSetTimeBandResponse = (ChannelSetTimeBandResponse) o;
		return Objects.equals(this.timeBandId, channelSetTimeBandResponse.timeBandId)
				&& Objects.equals(this.day, channelSetTimeBandResponse.day)
				&& Objects.equals(this.startTime, channelSetTimeBandResponse.startTime)
				&& Objects.equals(this.endTime, channelSetTimeBandResponse.endTime)
				&& Objects.equals(this.name, channelSetTimeBandResponse.name)
				&& Objects.equals(this.availability, channelSetTimeBandResponse.availability);
	}

	@Override
	public int hashCode() {
		return Objects.hash(timeBandId, day, startTime, endTime, name, availability);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ChannelSetTimeBandResponse {\n");

		sb.append("    timeBandId: ").append(toIndentedString(timeBandId)).append("\n");
		sb.append("    day: ").append(toIndentedString(day)).append("\n");
		sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
		sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    availability: ").append(toIndentedString(availability)).append("\n");
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
