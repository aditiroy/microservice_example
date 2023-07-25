/*
 * 
 */
package com.channel4.mint.automated.spot.interfaces.dto;

import java.util.Objects;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

// TODO: Auto-generated Javadoc
/**
 * CampaignMonth.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-12-19T04:58:28.844Z")

public class CampaignMonth   {
  
  /** The snapshot ID. */
  @JsonProperty("snapshotID")
  private Integer snapshotID = null;

  /** The channel set. */
  @JsonProperty("channelSet")
  private String channelSet = null;

  /** The channel group. */
  @JsonProperty("channelGroup")
  private String channelGroup = null;

  /** The product name. */
  @JsonProperty("productName")
  private String productName = null;

  /** The product code. */
  @JsonProperty("productCode")
  private String productCode = null;

  /** The audience. */
  @JsonProperty("audience")
  private String audience = null;

  /** The tx level. */
  @JsonProperty("txLevel")
  private String txLevel = null;

  /** The date. */
  @JsonProperty("date")
  private StartEndDate date = null;

  /** The budget. */
  @JsonProperty("Budget")
  private Long budget = null;

  /** The advertiser. */
  @JsonProperty("advertiser")
  private String advertiser = null;

  /** The agency. */
  @JsonProperty("agency")
  private String agency = null;

  /** The target CPT. */
  @JsonProperty("targetCPT")
  private String targetCPT = null;

  /** The amended impact target. */
  @JsonProperty("amendedImpactTarget")
  private Integer amendedImpactTarget = null;

  /** The amended TV rtarget. */
  @JsonProperty("amendedTVRtarget")
  private Integer amendedTVRtarget = null;

  /** The cm id. */
  @JsonProperty("cmId")
  private Integer cmId = null;

  /** The commodity name. */
  @JsonProperty("commodityName")
  private String commodityName = null;

  /** The camgen flag. */
  @JsonProperty("camgenFlag")
  private String camgenFlag = null;

  /** The tvr R cdelivered. */
  @JsonProperty("tvrRCdelivered")
  private String tvrRCdelivered = null;

  /** The tvr delivered. */
  @JsonProperty("tvrDelivered")
  private String tvrDelivered = null;

  /** The portfolio description. */
  @JsonProperty("portfolioDescription")
  private String portfolioDescription = null;

  /**
   * Snapshot ID.
   *
   * @param snapshotID the snapshot ID
   * @return the campaign month
   */
  public CampaignMonth snapshotID(Integer snapshotID) {
    this.snapshotID = snapshotID;
    return this;
  }

   /**
    * Get snapshotID.
    *
    * @return snapshotID
    */
  @ApiModelProperty(value = "")


  public Integer getSnapshotID() {
    return snapshotID;
  }

  /**
   * Sets the snapshot ID.
   *
   * @param snapshotID the new snapshot ID
   */
  public void setSnapshotID(Integer snapshotID) {
    this.snapshotID = snapshotID;
  }

  /**
   * Channel set.
   *
   * @param channelSet the channel set
   * @return the campaign month
   */
  public CampaignMonth channelSet(String channelSet) {
    this.channelSet = channelSet;
    return this;
  }

   /**
    * Get channelSet.
    *
    * @return channelSet
    */
  @ApiModelProperty(value = "")


  public String getChannelSet() {
    return channelSet;
  }

  /**
   * Sets the channel set.
   *
   * @param channelSet the new channel set
   */
  public void setChannelSet(String channelSet) {
    this.channelSet = channelSet;
  }

  /**
   * Channel group.
   *
   * @param channelGroup the channel group
   * @return the campaign month
   */
  public CampaignMonth channelGroup(String channelGroup) {
    this.channelGroup = channelGroup;
    return this;
  }

   /**
    * Get channelGroup.
    *
    * @return channelGroup
    */
  @ApiModelProperty(value = "")


  public String getChannelGroup() {
    return channelGroup;
  }

  /**
   * Sets the channel group.
   *
   * @param channelGroup the new channel group
   */
  public void setChannelGroup(String channelGroup) {
    this.channelGroup = channelGroup;
  }

  /**
   * Product name.
   *
   * @param productName the product name
   * @return the campaign month
   */
  public CampaignMonth productName(String productName) {
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
   * Product code.
   *
   * @param productCode the product code
   * @return the campaign month
   */
  public CampaignMonth productCode(String productCode) {
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
   * Audience.
   *
   * @param audience the audience
   * @return the campaign month
   */
  public CampaignMonth audience(String audience) {
    this.audience = audience;
    return this;
  }

   /**
    * Get audience.
    *
    * @return audience
    */
  @ApiModelProperty(value = "")


  public String getAudience() {
    return audience;
  }

  /**
   * Sets the audience.
   *
   * @param audience the new audience
   */
  public void setAudience(String audience) {
    this.audience = audience;
  }

  /**
   * Tx level.
   *
   * @param txLevel the tx level
   * @return the campaign month
   */
  public CampaignMonth txLevel(String txLevel) {
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
   * Date.
   *
   * @param date the date
   * @return the campaign month
   */
  public CampaignMonth date(StartEndDate date) {
    this.date = date;
    return this;
  }

   /**
    * Get date.
    *
    * @return date
    */
  @ApiModelProperty(value = "")

  @Valid

  public StartEndDate getDate() {
    return date;
  }

  /**
   * Sets the date.
   *
   * @param date the new date
   */
  public void setDate(StartEndDate date) {
    this.date = date;
  }

  /**
   * Budget.
   *
   * @param budget the budget
   * @return the campaign month
   */
  public CampaignMonth budget(Long budget) {
    this.budget = budget;
    return this;
  }

   /**
    * Get budget.
    *
    * @return budget
    */
  @ApiModelProperty(value = "")


  public Long getBudget() {
    return budget;
  }

  /**
   * Sets the budget.
   *
   * @param budget the new budget
   */
  public void setBudget(Long budget) {
    this.budget = budget;
  }

  /**
   * Advertiser.
   *
   * @param advertiser the advertiser
   * @return the campaign month
   */
  public CampaignMonth advertiser(String advertiser) {
    this.advertiser = advertiser;
    return this;
  }

   /**
    * Get advertiser.
    *
    * @return advertiser
    */
  @ApiModelProperty(value = "")


  public String getAdvertiser() {
    return advertiser;
  }

  /**
   * Sets the advertiser.
   *
   * @param advertiser the new advertiser
   */
  public void setAdvertiser(String advertiser) {
    this.advertiser = advertiser;
  }

  /**
   * Agency.
   *
   * @param agency the agency
   * @return the campaign month
   */
  public CampaignMonth agency(String agency) {
    this.agency = agency;
    return this;
  }

   /**
    * Get agency.
    *
    * @return agency
    */
  @ApiModelProperty(value = "")


  public String getAgency() {
    return agency;
  }

  /**
   * Sets the agency.
   *
   * @param agency the new agency
   */
  public void setAgency(String agency) {
    this.agency = agency;
  }

  /**
   * Target CPT.
   *
   * @param targetCPT the target CPT
   * @return the campaign month
   */
  public CampaignMonth targetCPT(String targetCPT) {
    this.targetCPT = targetCPT;
    return this;
  }

   /**
    * Get targetCPT.
    *
    * @return targetCPT
    */
  @ApiModelProperty(value = "")


  public String getTargetCPT() {
    return targetCPT;
  }

  /**
   * Sets the target CPT.
   *
   * @param targetCPT the new target CPT
   */
  public void setTargetCPT(String targetCPT) {
    this.targetCPT = targetCPT;
  }

  /**
   * Amended impact target.
   *
   * @param amendedImpactTarget the amended impact target
   * @return the campaign month
   */
  public CampaignMonth amendedImpactTarget(Integer amendedImpactTarget) {
    this.amendedImpactTarget = amendedImpactTarget;
    return this;
  }

   /**
    * Get amendedImpactTarget.
    *
    * @return amendedImpactTarget
    */
  @ApiModelProperty(value = "")


  public Integer getAmendedImpactTarget() {
    return amendedImpactTarget;
  }

  /**
   * Sets the amended impact target.
   *
   * @param amendedImpactTarget the new amended impact target
   */
  public void setAmendedImpactTarget(Integer amendedImpactTarget) {
    this.amendedImpactTarget = amendedImpactTarget;
  }

  /**
   * Amended TV rtarget.
   *
   * @param amendedTVRtarget the amended TV rtarget
   * @return the campaign month
   */
  public CampaignMonth amendedTVRtarget(Integer amendedTVRtarget) {
    this.amendedTVRtarget = amendedTVRtarget;
    return this;
  }

   /**
    * Get amendedTVRtarget.
    *
    * @return amendedTVRtarget
    */
  @ApiModelProperty(value = "")


  public Integer getAmendedTVRtarget() {
    return amendedTVRtarget;
  }

  /**
   * Sets the amended TV rtarget.
   *
   * @param amendedTVRtarget the new amended TV rtarget
   */
  public void setAmendedTVRtarget(Integer amendedTVRtarget) {
    this.amendedTVRtarget = amendedTVRtarget;
  }

  /**
   * Cm id.
   *
   * @param cmId the cm id
   * @return the campaign month
   */
  public CampaignMonth cmId(Integer cmId) {
    this.cmId = cmId;
    return this;
  }

   /**
    * Get cmId.
    *
    * @return cmId
    */
  @ApiModelProperty(value = "")


  public Integer getCmId() {
    return cmId;
  }

  /**
   * Sets the cm id.
   *
   * @param cmId the new cm id
   */
  public void setCmId(Integer cmId) {
    this.cmId = cmId;
  }

  /**
   * Commodity name.
   *
   * @param commodityName the commodity name
   * @return the campaign month
   */
  public CampaignMonth commodityName(String commodityName) {
    this.commodityName = commodityName;
    return this;
  }

   /**
    * Get commodityName.
    *
    * @return commodityName
    */
  @ApiModelProperty(value = "")


  public String getCommodityName() {
    return commodityName;
  }

  /**
   * Sets the commodity name.
   *
   * @param commodityName the new commodity name
   */
  public void setCommodityName(String commodityName) {
    this.commodityName = commodityName;
  }

  /**
   * Camgen flag.
   *
   * @param camgenFlag the camgen flag
   * @return the campaign month
   */
  public CampaignMonth camgenFlag(String camgenFlag) {
    this.camgenFlag = camgenFlag;
    return this;
  }

   /**
    * Get camgenFlag.
    *
    * @return camgenFlag
    */
  @ApiModelProperty(value = "")


  public String getCamgenFlag() {
    return camgenFlag;
  }

  /**
   * Sets the camgen flag.
   *
   * @param camgenFlag the new camgen flag
   */
  public void setCamgenFlag(String camgenFlag) {
    this.camgenFlag = camgenFlag;
  }

  /**
   * Tvr R cdelivered.
   *
   * @param tvrRCdelivered the tvr R cdelivered
   * @return the campaign month
   */
  public CampaignMonth tvrRCdelivered(String tvrRCdelivered) {
    this.tvrRCdelivered = tvrRCdelivered;
    return this;
  }

   /**
    * Get tvrRCdelivered.
    *
    * @return tvrRCdelivered
    */
  @ApiModelProperty(value = "")


  public String getTvrRCdelivered() {
    return tvrRCdelivered;
  }

  /**
   * Sets the tvr R cdelivered.
   *
   * @param tvrRCdelivered the new tvr R cdelivered
   */
  public void setTvrRCdelivered(String tvrRCdelivered) {
    this.tvrRCdelivered = tvrRCdelivered;
  }

  /**
   * Tvr delivered.
   *
   * @param tvrDelivered the tvr delivered
   * @return the campaign month
   */
  public CampaignMonth tvrDelivered(String tvrDelivered) {
    this.tvrDelivered = tvrDelivered;
    return this;
  }

   /**
    * Get tvrDelivered.
    *
    * @return tvrDelivered
    */
  @ApiModelProperty(value = "")


  public String getTvrDelivered() {
    return tvrDelivered;
  }

  /**
   * Sets the tvr delivered.
   *
   * @param tvrDelivered the new tvr delivered
   */
  public void setTvrDelivered(String tvrDelivered) {
    this.tvrDelivered = tvrDelivered;
  }

  /**
   * Portfolio description.
   *
   * @param portfolioDescription the portfolio description
   * @return the campaign month
   */
  public CampaignMonth portfolioDescription(String portfolioDescription) {
    this.portfolioDescription = portfolioDescription;
    return this;
  }

   /**
    * Get portfolioDescription.
    *
    * @return portfolioDescription
    */
  @ApiModelProperty(value = "")


  public String getPortfolioDescription() {
    return portfolioDescription;
  }

  /**
   * Sets the portfolio description.
   *
   * @param portfolioDescription the new portfolio description
   */
  public void setPortfolioDescription(String portfolioDescription) {
    this.portfolioDescription = portfolioDescription;
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
    CampaignMonth campaignMonth = (CampaignMonth) o;
    return Objects.equals(this.snapshotID, campaignMonth.snapshotID) &&
        Objects.equals(this.channelSet, campaignMonth.channelSet) &&
        Objects.equals(this.channelGroup, campaignMonth.channelGroup) &&
        Objects.equals(this.productName, campaignMonth.productName) &&
        Objects.equals(this.productCode, campaignMonth.productCode) &&
        Objects.equals(this.audience, campaignMonth.audience) &&
        Objects.equals(this.txLevel, campaignMonth.txLevel) &&
        Objects.equals(this.date, campaignMonth.date) &&
        Objects.equals(this.budget, campaignMonth.budget) &&
        Objects.equals(this.advertiser, campaignMonth.advertiser) &&
        Objects.equals(this.agency, campaignMonth.agency) &&
        Objects.equals(this.targetCPT, campaignMonth.targetCPT) &&
        Objects.equals(this.amendedImpactTarget, campaignMonth.amendedImpactTarget) &&
        Objects.equals(this.amendedTVRtarget, campaignMonth.amendedTVRtarget) &&
        Objects.equals(this.cmId, campaignMonth.cmId) &&
        Objects.equals(this.commodityName, campaignMonth.commodityName) &&
        Objects.equals(this.camgenFlag, campaignMonth.camgenFlag) &&
        Objects.equals(this.tvrRCdelivered, campaignMonth.tvrRCdelivered) &&
        Objects.equals(this.tvrDelivered, campaignMonth.tvrDelivered) &&
        Objects.equals(this.portfolioDescription, campaignMonth.portfolioDescription);
  }

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    return Objects.hash(snapshotID, channelSet, channelGroup, productName, productCode, audience, txLevel, date, budget, advertiser, agency, targetCPT, amendedImpactTarget, amendedTVRtarget, cmId, commodityName, camgenFlag, tvrRCdelivered, tvrDelivered, portfolioDescription);
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CampaignMonth {\n");
    
    sb.append("    snapshotID: ").append(toIndentedString(snapshotID)).append("\n");
    sb.append("    channelSet: ").append(toIndentedString(channelSet)).append("\n");
    sb.append("    channelGroup: ").append(toIndentedString(channelGroup)).append("\n");
    sb.append("    productName: ").append(toIndentedString(productName)).append("\n");
    sb.append("    productCode: ").append(toIndentedString(productCode)).append("\n");
    sb.append("    audience: ").append(toIndentedString(audience)).append("\n");
    sb.append("    txLevel: ").append(toIndentedString(txLevel)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    budget: ").append(toIndentedString(budget)).append("\n");
    sb.append("    advertiser: ").append(toIndentedString(advertiser)).append("\n");
    sb.append("    agency: ").append(toIndentedString(agency)).append("\n");
    sb.append("    targetCPT: ").append(toIndentedString(targetCPT)).append("\n");
    sb.append("    amendedImpactTarget: ").append(toIndentedString(amendedImpactTarget)).append("\n");
    sb.append("    amendedTVRtarget: ").append(toIndentedString(amendedTVRtarget)).append("\n");
    sb.append("    cmId: ").append(toIndentedString(cmId)).append("\n");
    sb.append("    commodityName: ").append(toIndentedString(commodityName)).append("\n");
    sb.append("    camgenFlag: ").append(toIndentedString(camgenFlag)).append("\n");
    sb.append("    tvrRCdelivered: ").append(toIndentedString(tvrRCdelivered)).append("\n");
    sb.append("    tvrDelivered: ").append(toIndentedString(tvrDelivered)).append("\n");
    sb.append("    portfolioDescription: ").append(toIndentedString(portfolioDescription)).append("\n");
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

