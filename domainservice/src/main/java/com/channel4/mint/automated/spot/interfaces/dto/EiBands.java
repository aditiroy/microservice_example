/*
 * 
 */
package com.channel4.mint.automated.spot.interfaces.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

// TODO: Auto-generated Javadoc
/**
 * EiBands.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-12-19T04:58:28.844Z")

public class EiBands   {
  
  /** The bands. */
  @JsonProperty("bands")
  private String bands = null;

  /**
   * Bands.
   *
   * @param bands the bands
   * @return the ei bands
   */
  public EiBands bands(String bands) {
    this.bands = bands;
    return this;
  }

   /**
    * Get bands.
    *
    * @return bands
    */
  @ApiModelProperty(value = "")


  public String getBands() {
    return bands;
  }

  /**
   * Sets the bands.
   *
   * @param bands the new bands
   */
  public void setBands(String bands) {
    this.bands = bands;
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
    EiBands eiBands = (EiBands) o;
    return Objects.equals(this.bands, eiBands.bands);
  }

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    return Objects.hash(bands);
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EiBands {\n");
    
    sb.append("    bands: ").append(toIndentedString(bands)).append("\n");
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

