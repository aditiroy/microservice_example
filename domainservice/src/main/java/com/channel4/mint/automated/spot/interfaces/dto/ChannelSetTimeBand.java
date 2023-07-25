/*
 * 
 */
package com.channel4.mint.automated.spot.interfaces.dto;

import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * ChannelSetTimeBand
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-14T09:04:29.792Z")

public class ChannelSetTimeBand {
	@JsonProperty("id")
	private Integer id = null;

	@JsonProperty("channelSetId")
	private Integer channelSetId = null;

	@JsonProperty("day")
	private String day = null;

	@JsonProperty("startTime")
	private String startTime = null;

	@JsonProperty("endTime")
	private String endTime = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("availability")
	private Double availability = null;

	public ChannelSetTimeBand id(Integer id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "")

	public Integer getId(){
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ChannelSetTimeBand channelSetId(Integer channelSetId) {
		this.channelSetId = channelSetId;
		return this;
	}

	/**
	 * Get channelSetId
	 * 
	 * @return channelSetId
	 **/
	@ApiModelProperty(value = "")

	public Integer getChannelSetId() {
		return channelSetId;
	}

	public void setChannelSetId(Integer channelSetId) {
		this.channelSetId = channelSetId;
	}

	public ChannelSetTimeBand day(String day) {
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

	public ChannelSetTimeBand startTime(String startTime) {
		this.startTime = startTime;
		return this;
	}

	/**
	 * Get startTime
	 * 
	 * @return startTime
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public ChannelSetTimeBand endTime(String endTime) {
		this.endTime = endTime;
		return this;
	}

	/**
	 * Get endTime
	 * 
	 * @return endTime
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public ChannelSetTimeBand name(String name) {
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

	public ChannelSetTimeBand availability(Double availability) {
		this.availability = availability;
		return this;
	}

	/**
	 * Get availability
	 * 
	 * @return availability
	 **/
	@ApiModelProperty(value = "")

	public Double getAvailability() {
		return availability;
	}

	public void setAvailability(Double availability) {
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
		ChannelSetTimeBand channelSetTimeBand = (ChannelSetTimeBand) o;
		return Objects.equals(this.id, channelSetTimeBand.id)
				&& Objects.equals(this.channelSetId, channelSetTimeBand.channelSetId)
				&& Objects.equals(this.day, channelSetTimeBand.day)
				&& Objects.equals(this.startTime, channelSetTimeBand.startTime)
				&& Objects.equals(this.endTime, channelSetTimeBand.endTime)
				&& Objects.equals(this.name, channelSetTimeBand.name)
				&& Objects.equals(this.availability, channelSetTimeBand.availability);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, channelSetId, day, startTime, endTime, name, availability);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ChannelSetTimeBand {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    channelSetId: ").append(toIndentedString(channelSetId)).append("\n");
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
