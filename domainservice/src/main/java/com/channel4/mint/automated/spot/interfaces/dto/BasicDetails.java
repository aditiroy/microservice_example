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
 * BasicDetails.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-12-19T04:58:28.844Z")

public class BasicDetails   {
  
  /** The detail. */
  @JsonProperty("detail")
  private SimpleDetail detail = null;

  /** The demand supply. */
  @JsonProperty("demandSupply")
  private DemandSupply demandSupply = null;

  /**
   * Detail.
   *
   * @param detail the detail
   * @return the basic details
   */
  public BasicDetails detail(SimpleDetail detail) {
    this.detail = detail;
    return this;
  }

   /**
    * Get detail.
    *
    * @return detail
    */
  @ApiModelProperty(value = "")

  @Valid

  public SimpleDetail getDetail() {
    return detail;
  }

  /**
   * Sets the detail.
   *
   * @param detail the new detail
   */
  public void setDetail(SimpleDetail detail) {
    this.detail = detail;
  }

  /**
   * Demand supply.
   *
   * @param demandSupply the demand supply
   * @return the basic details
   */
  public BasicDetails demandSupply(DemandSupply demandSupply) {
    this.demandSupply = demandSupply;
    return this;
  }

   /**
    * Get demandSupply.
    *
    * @return demandSupply
    */
  @ApiModelProperty(value = "")

  @Valid

  public DemandSupply getDemandSupply() {
    return demandSupply;
  }

  /**
   * Sets the demand supply.
   *
   * @param demandSupply the new demand supply
   */
  public void setDemandSupply(DemandSupply demandSupply) {
    this.demandSupply = demandSupply;
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
    BasicDetails basicDetails = (BasicDetails) o;
    return Objects.equals(this.detail, basicDetails.detail) &&
        Objects.equals(this.demandSupply, basicDetails.demandSupply);
  }

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    return Objects.hash(detail, demandSupply);
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BasicDetails {\n");
    
    sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
    sb.append("    demandSupply: ").append(toIndentedString(demandSupply)).append("\n");
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

