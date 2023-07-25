/*
 * 
 */
package com.channel4.mint.automated.spot.interfaces.dto;

import java.util.Objects;

import javax.validation.Valid;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

// TODO: Auto-generated Javadoc
/**
 * BookedSpot.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-12-19T04:58:28.844Z")

public class BookedSpot   {
  
  /** The tx level. */
  @JsonProperty("txLevel")
  private String txLevel = null;

  /** The schedule type. */
  @JsonProperty("scheduleType")
  private String scheduleType = null;

  /** The product code. */
  @JsonProperty("productCode")
  private String productCode = null;

  /** The product name. */
  @JsonProperty("productName")
  private String productName = null;

  /** The cm ID. */
  @JsonProperty("cmID")
  private Long cmID = null;

  /** The tx lvel name. */
  @JsonProperty("txLvelName")
  private String txLvelName = null;

  /** The audience short name. */
  @JsonProperty("audienceShortName")
  private String audienceShortName = null;

  /** The break date time. */
  @JsonProperty("breakDateTime")
  private DateTime breakDateTime = null;

  /** The break length. */
  @JsonProperty("breakLength")
  private Long breakLength = null;

  /** The programme name. */
  @JsonProperty("programmeName")
  private String programmeName = null;

  /** The exclude. */
  @JsonProperty("exclude")
  private Boolean exclude = null;

  /**
   * Tx level.
   *
   * @param txLevel the tx level
   * @return the booked spot
   */
  public BookedSpot txLevel(String txLevel) {
    this.txLevel = txLevel;
    return this;
  }

   /**
    * Get txLevel.
    *
    * @return txLevel
    */
  @ApiModelProperty(value = "")


  public String getTxLevel() {
    return txLevel;
  }

  /**
   * Sets the tx level.
   *
   * @param txLevel the new tx level
   */
  public void setTxLevel(String txLevel) {
    this.txLevel = txLevel;
  }

  /**
   * Schedule type.
   *
   * @param scheduleType the schedule type
   * @return the booked spot
   */
  public BookedSpot scheduleType(String scheduleType) {
    this.scheduleType = scheduleType;
    return this;
  }

   /**
    * Get scheduleType.
    *
    * @return scheduleType
    */
  @ApiModelProperty(value = "")


  public String getScheduleType() {
    return scheduleType;
  }

  /**
   * Sets the schedule type.
   *
   * @param scheduleType the new schedule type
   */
  public void setScheduleType(String scheduleType) {
    this.scheduleType = scheduleType;
  }

  /**
   * Product code.
   *
   * @param productCode the product code
   * @return the booked spot
   */
  public BookedSpot productCode(String productCode) {
    this.productCode = productCode;
    return this;
  }

   /**
    * Get productCode.
    *
    * @return productCode
    */
  @ApiModelProperty(value = "")


  public String getProductCode() {
    return productCode;
  }

  /**
   * Sets the product code.
   *
   * @param productCode the new product code
   */
  public void setProductCode(String productCode) {
    this.productCode = productCode;
  }

  /**
   * Product name.
   *
   * @param productName the product name
   * @return the booked spot
   */
  public BookedSpot productName(String productName) {
    this.productName = productName;
    return this;
  }

   /**
    * Get productName.
    *
    * @return productName
    */
  @ApiModelProperty(value = "")


  public String getProductName() {
    return productName;
  }

  /**
   * Sets the product name.
   *
   * @param productName the new product name
   */
  public void setProductName(String productName) {
    this.productName = productName;
  }

  /**
   * Cm ID.
   *
   * @param cmID the cm ID
   * @return the booked spot
   */
  public BookedSpot cmID(Long cmID) {
    this.cmID = cmID;
    return this;
  }

   /**
    * Get cmID.
    *
    * @return cmID
    */
  @ApiModelProperty(value = "")


  public Long getCmID() {
    return cmID;
  }

  /**
   * Sets the cm ID.
   *
   * @param cmID the new cm ID
   */
  public void setCmID(Long cmID) {
    this.cmID = cmID;
  }

  /**
   * Tx lvel name.
   *
   * @param txLvelName the tx lvel name
   * @return the booked spot
   */
  public BookedSpot txLvelName(String txLvelName) {
    this.txLvelName = txLvelName;
    return this;
  }

   /**
    * Get txLvelName.
    *
    * @return txLvelName
    */
  @ApiModelProperty(value = "")


  public String getTxLvelName() {
    return txLvelName;
  }

  /**
   * Sets the tx lvel name.
   *
   * @param txLvelName the new tx lvel name
   */
  public void setTxLvelName(String txLvelName) {
    this.txLvelName = txLvelName;
  }

  /**
   * Audience short name.
   *
   * @param audienceShortName the audience short name
   * @return the booked spot
   */
  public BookedSpot audienceShortName(String audienceShortName) {
    this.audienceShortName = audienceShortName;
    return this;
  }

   /**
    * Get audienceShortName.
    *
    * @return audienceShortName
    */
  @ApiModelProperty(value = "")


  public String getAudienceShortName() {
    return audienceShortName;
  }

  /**
   * Sets the audience short name.
   *
   * @param audienceShortName the new audience short name
   */
  public void setAudienceShortName(String audienceShortName) {
    this.audienceShortName = audienceShortName;
  }

  /**
   * Break date time.
   *
   * @param breakDateTime the break date time
   * @return the booked spot
   */
  public BookedSpot breakDateTime(DateTime breakDateTime) {
    this.breakDateTime = breakDateTime;
    return this;
  }

   /**
    * Get breakDateTime.
    *
    * @return breakDateTime
    */
  @ApiModelProperty(value = "")

  @Valid

  public DateTime getBreakDateTime() {
    return breakDateTime;
  }

  /**
   * Sets the break date time.
   *
   * @param breakDateTime the new break date time
   */
  public void setBreakDateTime(DateTime breakDateTime) {
    this.breakDateTime = breakDateTime;
  }

  /**
   * Break length.
   *
   * @param breakLength the break length
   * @return the booked spot
   */
  public BookedSpot breakLength(Long breakLength) {
    this.breakLength = breakLength;
    return this;
  }

   /**
    * Get breakLength.
    *
    * @return breakLength
    */
  @ApiModelProperty(value = "")


  public Long getBreakLength() {
    return breakLength;
  }

  /**
   * Sets the break length.
   *
   * @param breakLength the new break length
   */
  public void setBreakLength(Long breakLength) {
    this.breakLength = breakLength;
  }

  /**
   * Programme name.
   *
   * @param programmeName the programme name
   * @return the booked spot
   */
  public BookedSpot programmeName(String programmeName) {
    this.programmeName = programmeName;
    return this;
  }

   /**
    * Get programmeName.
    *
    * @return programmeName
    */
  @ApiModelProperty(value = "")


  public String getProgrammeName() {
    return programmeName;
  }

  /**
   * Sets the programme name.
   *
   * @param programmeName the new programme name
   */
  public void setProgrammeName(String programmeName) {
    this.programmeName = programmeName;
  }

  /**
   * Exclude.
   *
   * @param exclude the exclude
   * @return the booked spot
   */
  public BookedSpot exclude(Boolean exclude) {
    this.exclude = exclude;
    return this;
  }

   /**
    * Get exclude.
    *
    * @return exclude
    */
  @ApiModelProperty(value = "")


  public Boolean getExclude() {
    return exclude;
  }

  /**
   * Sets the exclude.
   *
   * @param exclude the new exclude
   */
  public void setExclude(Boolean exclude) {
    this.exclude = exclude;
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
    BookedSpot bookedSpot = (BookedSpot) o;
    return Objects.equals(this.txLevel, bookedSpot.txLevel) &&
        Objects.equals(this.scheduleType, bookedSpot.scheduleType) &&
        Objects.equals(this.productCode, bookedSpot.productCode) &&
        Objects.equals(this.productName, bookedSpot.productName) &&
        Objects.equals(this.cmID, bookedSpot.cmID) &&
        Objects.equals(this.txLvelName, bookedSpot.txLvelName) &&
        Objects.equals(this.audienceShortName, bookedSpot.audienceShortName) &&
        Objects.equals(this.breakDateTime, bookedSpot.breakDateTime) &&
        Objects.equals(this.breakLength, bookedSpot.breakLength) &&
        Objects.equals(this.programmeName, bookedSpot.programmeName) &&
        Objects.equals(this.exclude, bookedSpot.exclude);
  }

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    return Objects.hash(txLevel, scheduleType, productCode, productName, cmID, txLvelName, audienceShortName, breakDateTime, breakLength, programmeName, exclude);
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BookedSpot {\n");
    
    sb.append("    txLevel: ").append(toIndentedString(txLevel)).append("\n");
    sb.append("    scheduleType: ").append(toIndentedString(scheduleType)).append("\n");
    sb.append("    productCode: ").append(toIndentedString(productCode)).append("\n");
    sb.append("    productName: ").append(toIndentedString(productName)).append("\n");
    sb.append("    cmID: ").append(toIndentedString(cmID)).append("\n");
    sb.append("    txLvelName: ").append(toIndentedString(txLvelName)).append("\n");
    sb.append("    audienceShortName: ").append(toIndentedString(audienceShortName)).append("\n");
    sb.append("    breakDateTime: ").append(toIndentedString(breakDateTime)).append("\n");
    sb.append("    breakLength: ").append(toIndentedString(breakLength)).append("\n");
    sb.append("    programmeName: ").append(toIndentedString(programmeName)).append("\n");
    sb.append("    exclude: ").append(toIndentedString(exclude)).append("\n");
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

