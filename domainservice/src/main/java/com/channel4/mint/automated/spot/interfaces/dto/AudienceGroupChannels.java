/*
 * 
 */
package com.channel4.mint.automated.spot.interfaces.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

// TODO: Auto-generated Javadoc
/**
 * AudienceGroupChannels.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-12-19T04:58:28.844Z")

public class AudienceGroupChannels   {
  
  /** The audience group name. */
  @JsonProperty("audienceGroupName")
  private String audienceGroupName = null;

  /** The channel name. */
  @JsonProperty("channelName")
  private String channelName = null;

  /** The key audience name. */
  @JsonProperty("keyAudienceName")
  private String keyAudienceName = null;

  /** The target. */
  @JsonProperty("target")
  private String target = null;

  /**
   * Audience group name.
   *
   * @param audienceGroupName the audience group name
   * @return the audience group channels
   */
  public AudienceGroupChannels audienceGroupName(String audienceGroupName) {
    this.audienceGroupName = audienceGroupName;
    return this;
  }

   /**
    * Get audienceGroupName.
    *
    * @return audienceGroupName
    */
  @ApiModelProperty(value = "")


  public String getAudienceGroupName() {
    return audienceGroupName;
  }

  /**
   * Sets the audience group name.
   *
   * @param audienceGroupName the new audience group name
   */
  public void setAudienceGroupName(String audienceGroupName) {
    this.audienceGroupName = audienceGroupName;
  }

  /**
   * Channel name.
   *
   * @param channelName the channel name
   * @return the audience group channels
   */
  public AudienceGroupChannels channelName(String channelName) {
    this.channelName = channelName;
    return this;
  }

   /**
    * Get channelName.
    *
    * @return channelName
    */
  @ApiModelProperty(value = "")


  public String getChannelName() {
    return channelName;
  }

  /**
   * Sets the channel name.
   *
   * @param channelName the new channel name
   */
  public void setChannelName(String channelName) {
    this.channelName = channelName;
  }

  /**
   * Key audience name.
   *
   * @param keyAudienceName the key audience name
   * @return the audience group channels
   */
  public AudienceGroupChannels keyAudienceName(String keyAudienceName) {
    this.keyAudienceName = keyAudienceName;
    return this;
  }

   /**
    * Get keyAudienceName.
    *
    * @return keyAudienceName
    */
  @ApiModelProperty(value = "")


  public String getKeyAudienceName() {
    return keyAudienceName;
  }

  /**
   * Sets the key audience name.
   *
   * @param keyAudienceName the new key audience name
   */
  public void setKeyAudienceName(String keyAudienceName) {
    this.keyAudienceName = keyAudienceName;
  }

  /**
   * Target.
   *
   * @param target the target
   * @return the audience group channels
   */
  public AudienceGroupChannels target(String target) {
    this.target = target;
    return this;
  }

   /**
    * Get target.
    *
    * @return target
    */
  @ApiModelProperty(value = "")


  public String getTarget() {
    return target;
  }

  /**
   * Sets the target.
   *
   * @param target the new target
   */
  public void setTarget(String target) {
    this.target = target;
  }


  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AudienceGroupChannels audienceGroupChannels = (AudienceGroupChannels) o;
    return Objects.equals(this.audienceGroupName, audienceGroupChannels.audienceGroupName) &&
        Objects.equals(this.channelName, audienceGroupChannels.channelName) &&
        Objects.equals(this.keyAudienceName, audienceGroupChannels.keyAudienceName) &&
        Objects.equals(this.target, audienceGroupChannels.target);
  }

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    return Objects.hash(audienceGroupName, channelName, keyAudienceName, target);
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AudienceGroupChannels {\n");
    
    sb.append("    audienceGroupName: ").append(toIndentedString(audienceGroupName)).append("\n");
    sb.append("    channelName: ").append(toIndentedString(channelName)).append("\n");
    sb.append("    keyAudienceName: ").append(toIndentedString(keyAudienceName)).append("\n");
    sb.append("    target: ").append(toIndentedString(target)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   *
   * @param o the o
   * @return the string
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

