/*
 * 
 */
package com.channel4.mint.automated.spot.interfaces.dto;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * CamgenRunParamAudGroupChannel
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-14T09:04:29.792Z")

public class CamgenRunParamAudGroupChannel   {
  @JsonProperty("runParameterAudienceGroupChannelId")
  private Integer runParameterAudienceGroupChannelId = null;

  @JsonProperty("audienceGroupId")
  private Integer audienceGroupId = null;

  @JsonProperty("channelId")
  private Integer channelId = null;

  @JsonProperty("keyAudienceId")
  private Integer keyAudienceId = null;

  @JsonProperty("targetPercentage")
  private String targetPercentage = null;

  public CamgenRunParamAudGroupChannel runParameterAudienceGroupChannelId(Integer runParameterAudienceGroupChannelId) {
    this.runParameterAudienceGroupChannelId = runParameterAudienceGroupChannelId;
    return this;
  }

  /**
   * Get runParameterAudienceGroupChannelId
   * @return runParameterAudienceGroupChannelId
  **/
  @ApiModelProperty(value = "")


  public Integer getRunParameterAudienceGroupChannelId() {
    return runParameterAudienceGroupChannelId;
  }

  public void setRunParameterAudienceGroupChannelId(Integer runParameterAudienceGroupChannelId) {
    this.runParameterAudienceGroupChannelId = runParameterAudienceGroupChannelId;
  }

  public CamgenRunParamAudGroupChannel audienceGroupId(Integer audienceGroupId) {
    this.audienceGroupId = audienceGroupId;
    return this;
  }

  /**
   * Get audienceGroupId
   * @return audienceGroupId
  **/
  @ApiModelProperty(value = "")


  public Integer getAudienceGroupId() {
    return audienceGroupId;
  }

  public void setAudienceGroupId(Integer audienceGroupId) {
    this.audienceGroupId = audienceGroupId;
  }

  public CamgenRunParamAudGroupChannel channelId(Integer channelId) {
    this.channelId = channelId;
    return this;
  }

  /**
   * Get channelId
   * @return channelId
  **/
  @ApiModelProperty(value = "")


  public Integer getChannelId() {
    return channelId;
  }

  public void setChannelId(Integer channelId) {
    this.channelId = channelId;
  }

  public CamgenRunParamAudGroupChannel keyAudienceId(Integer keyAudienceId) {
    this.keyAudienceId = keyAudienceId;
    return this;
  }

  /**
   * Get keyAudienceId
   * @return keyAudienceId
  **/
  @ApiModelProperty(value = "")


  public Integer getKeyAudienceId() {
    return keyAudienceId;
  }

  public void setKeyAudienceId(Integer keyAudienceId) {
    this.keyAudienceId = keyAudienceId;
  }

  public CamgenRunParamAudGroupChannel targetPercentage(String targetPercentage) {
    this.targetPercentage = targetPercentage;
    return this;
  }

  /**
   * Get targetPercentage
   * @return targetPercentage
  **/
  @ApiModelProperty(value = "")


  public String getTargetPercentage() {
    return targetPercentage;
  }

  public void setTargetPercentage(String targetPercentage) {
    this.targetPercentage = targetPercentage;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CamgenRunParamAudGroupChannel camgenRunParamAudGroupChannel = (CamgenRunParamAudGroupChannel) o;
    return Objects.equals(this.runParameterAudienceGroupChannelId, camgenRunParamAudGroupChannel.runParameterAudienceGroupChannelId) &&
        Objects.equals(this.audienceGroupId, camgenRunParamAudGroupChannel.audienceGroupId) &&
        Objects.equals(this.channelId, camgenRunParamAudGroupChannel.channelId) &&
        Objects.equals(this.keyAudienceId, camgenRunParamAudGroupChannel.keyAudienceId) &&
        Objects.equals(this.targetPercentage, camgenRunParamAudGroupChannel.targetPercentage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(runParameterAudienceGroupChannelId, audienceGroupId, channelId, keyAudienceId, targetPercentage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CamgenRunParamAudGroupChannel {\n");
    
    sb.append("    runParameterAudienceGroupChannelId: ").append(toIndentedString(runParameterAudienceGroupChannelId)).append("\n");
    sb.append("    audienceGroupId: ").append(toIndentedString(audienceGroupId)).append("\n");
    sb.append("    channelId: ").append(toIndentedString(channelId)).append("\n");
    sb.append("    keyAudienceId: ").append(toIndentedString(keyAudienceId)).append("\n");
    sb.append("    targetPercentage: ").append(toIndentedString(targetPercentage)).append("\n");
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

