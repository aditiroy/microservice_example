package com.channel4.mint.automated.spot.interfaces.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * ChannelSetTimebandsBulkRequestDeleted
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-12-28T04:55:33.590Z")

public class ChannelSetTimebandsBulkRequestDeleted   {
  @JsonProperty("timebandId")
  private Integer timebandId = null;

  public ChannelSetTimebandsBulkRequestDeleted timebandId(Integer timebandId) {
    this.timebandId = timebandId;
    return this;
  }

   /**
   * Get timebandId
   * @return timebandId
  **/
  @ApiModelProperty(value = "")


  public Integer getTimebandId() {
    return timebandId;
  }

  public void setTimebandId(Integer timebandId) {
    this.timebandId = timebandId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChannelSetTimebandsBulkRequestDeleted channelSetTimebandsBulkRequestDeleted = (ChannelSetTimebandsBulkRequestDeleted) o;
    return Objects.equals(this.timebandId, channelSetTimebandsBulkRequestDeleted.timebandId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(timebandId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChannelSetTimebandsBulkRequestDeleted {\n");
    
    sb.append("    timebandId: ").append(toIndentedString(timebandId)).append("\n");
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

