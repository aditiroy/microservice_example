package com.channel4.mint.automated.spot.interfaces.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * ChannelSetTimebandsBulkRequestModified
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-12-28T04:55:33.590Z")

public class ChannelSetTimebandsBulkRequestModified {

	@JsonProperty("channelSetId")
	private Integer channelSetId = null;

	@JsonProperty("timebands")
	private List<ChannelSetTimebandsBulkRequestTimebands> timebands = null;

	public Integer getChannelSetId() {
		return channelSetId;
	}

	public void setChannelSetId(Integer channelSetId) {
		this.channelSetId = channelSetId;
	}

	public List<ChannelSetTimebandsBulkRequestTimebands> getTimebands() {
		return timebands;
	}

	public void setTimebands(List<ChannelSetTimebandsBulkRequestTimebands> timebands) {
		this.timebands = timebands;
	}

}
