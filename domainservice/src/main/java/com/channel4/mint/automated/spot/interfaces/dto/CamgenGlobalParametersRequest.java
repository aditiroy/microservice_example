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
 * CamgenGlobalParametersRequest.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-12-19T04:58:28.844Z")

public class CamgenGlobalParametersRequest   {
  
  /** The camgen parameters. */
  @JsonProperty("CamgenParameters")
  private CamgenParameters camgenParameters = null;

  /** The camgen param extracts. */
  @JsonProperty("CamgenParamExtracts")
  private CamgenParamExtracts camgenParamExtracts = null;

  /** The camgen param station EI time bands. */
  @JsonProperty("CamgenParamStationEITimeBands")
  private CamgenParamStationEITimeBands camgenParamStationEITimeBands = null;

  /** The camgen param station time bands. */
  @JsonProperty("CamgenParamStationTimeBands")
  private CamgenParamStationTimeBands camgenParamStationTimeBands = null;

  /** The camgen param EI bands. */
  @JsonProperty("CamgenParamEIBands")
  private CamgenParamEIBands camgenParamEIBands = null;

  /** The camgen param aud group channels. */
  @JsonProperty("CamgenParamAudGroupChannels")
  private CamgenParamAudGroupChannels camgenParamAudGroupChannels = null;

  /**
   * Camgen parameters.
   *
   * @param camgenParameters the camgen parameters
   * @return the camgen global parameters request
   */
  public CamgenGlobalParametersRequest camgenParameters(CamgenParameters camgenParameters) {
    this.camgenParameters = camgenParameters;
    return this;
  }

   /**
    * Get camgenParameters.
    *
    * @return camgenParameters
    */
  @ApiModelProperty(value = "")

  @Valid

  public CamgenParameters getCamgenParameters() {
    return camgenParameters;
  }

  /**
   * Sets the camgen parameters.
   *
   * @param camgenParameters the new camgen parameters
   */
  public void setCamgenParameters(CamgenParameters camgenParameters) {
    this.camgenParameters = camgenParameters;
  }

  /**
   * Camgen param extracts.
   *
   * @param camgenParamExtracts the camgen param extracts
   * @return the camgen global parameters request
   */
  public CamgenGlobalParametersRequest camgenParamExtracts(CamgenParamExtracts camgenParamExtracts) {
    this.camgenParamExtracts = camgenParamExtracts;
    return this;
  }

   /**
    * Get camgenParamExtracts.
    *
    * @return camgenParamExtracts
    */
  @ApiModelProperty(value = "")

  @Valid

  public CamgenParamExtracts getCamgenParamExtracts() {
    return camgenParamExtracts;
  }

  /**
   * Sets the camgen param extracts.
   *
   * @param camgenParamExtracts the new camgen param extracts
   */
  public void setCamgenParamExtracts(CamgenParamExtracts camgenParamExtracts) {
    this.camgenParamExtracts = camgenParamExtracts;
  }

  /**
   * Camgen param station EI time bands.
   *
   * @param camgenParamStationEITimeBands the camgen param station EI time bands
   * @return the camgen global parameters request
   */
  public CamgenGlobalParametersRequest camgenParamStationEITimeBands(CamgenParamStationEITimeBands camgenParamStationEITimeBands) {
    this.camgenParamStationEITimeBands = camgenParamStationEITimeBands;
    return this;
  }

   /**
    * Get camgenParamStationEITimeBands.
    *
    * @return camgenParamStationEITimeBands
    */
  @ApiModelProperty(value = "")

  @Valid

  public CamgenParamStationEITimeBands getCamgenParamStationEITimeBands() {
    return camgenParamStationEITimeBands;
  }

  /**
   * Sets the camgen param station EI time bands.
   *
   * @param camgenParamStationEITimeBands the new camgen param station EI time bands
   */
  public void setCamgenParamStationEITimeBands(CamgenParamStationEITimeBands camgenParamStationEITimeBands) {
    this.camgenParamStationEITimeBands = camgenParamStationEITimeBands;
  }

  /**
   * Camgen param station time bands.
   *
   * @param camgenParamStationTimeBands the camgen param station time bands
   * @return the camgen global parameters request
   */
  public CamgenGlobalParametersRequest camgenParamStationTimeBands(CamgenParamStationTimeBands camgenParamStationTimeBands) {
    this.camgenParamStationTimeBands = camgenParamStationTimeBands;
    return this;
  }

   /**
    * Get camgenParamStationTimeBands.
    *
    * @return camgenParamStationTimeBands
    */
  @ApiModelProperty(value = "")

  @Valid

  public CamgenParamStationTimeBands getCamgenParamStationTimeBands() {
    return camgenParamStationTimeBands;
  }

  /**
   * Sets the camgen param station time bands.
   *
   * @param camgenParamStationTimeBands the new camgen param station time bands
   */
  public void setCamgenParamStationTimeBands(CamgenParamStationTimeBands camgenParamStationTimeBands) {
    this.camgenParamStationTimeBands = camgenParamStationTimeBands;
  }

  /**
   * Camgen param EI bands.
   *
   * @param camgenParamEIBands the camgen param EI bands
   * @return the camgen global parameters request
   */
  public CamgenGlobalParametersRequest camgenParamEIBands(CamgenParamEIBands camgenParamEIBands) {
    this.camgenParamEIBands = camgenParamEIBands;
    return this;
  }

   /**
    * Get camgenParamEIBands.
    *
    * @return camgenParamEIBands
    */
  @ApiModelProperty(value = "")

  @Valid

  public CamgenParamEIBands getCamgenParamEIBands() {
    return camgenParamEIBands;
  }

  /**
   * Sets the camgen param EI bands.
   *
   * @param camgenParamEIBands the new camgen param EI bands
   */
  public void setCamgenParamEIBands(CamgenParamEIBands camgenParamEIBands) {
    this.camgenParamEIBands = camgenParamEIBands;
  }

  /**
   * Camgen param aud group channels.
   *
   * @param camgenParamAudGroupChannels the camgen param aud group channels
   * @return the camgen global parameters request
   */
  public CamgenGlobalParametersRequest camgenParamAudGroupChannels(CamgenParamAudGroupChannels camgenParamAudGroupChannels) {
    this.camgenParamAudGroupChannels = camgenParamAudGroupChannels;
    return this;
  }

   /**
    * Get camgenParamAudGroupChannels.
    *
    * @return camgenParamAudGroupChannels
    */
  @ApiModelProperty(value = "")

  @Valid

  public CamgenParamAudGroupChannels getCamgenParamAudGroupChannels() {
    return camgenParamAudGroupChannels;
  }

  /**
   * Sets the camgen param aud group channels.
   *
   * @param camgenParamAudGroupChannels the new camgen param aud group channels
   */
  public void setCamgenParamAudGroupChannels(CamgenParamAudGroupChannels camgenParamAudGroupChannels) {
    this.camgenParamAudGroupChannels = camgenParamAudGroupChannels;
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
    CamgenGlobalParametersRequest camgenGlobalParametersRequest = (CamgenGlobalParametersRequest) o;
    return Objects.equals(this.camgenParameters, camgenGlobalParametersRequest.camgenParameters) &&
        Objects.equals(this.camgenParamExtracts, camgenGlobalParametersRequest.camgenParamExtracts) &&
        Objects.equals(this.camgenParamStationEITimeBands, camgenGlobalParametersRequest.camgenParamStationEITimeBands) &&
        Objects.equals(this.camgenParamStationTimeBands, camgenGlobalParametersRequest.camgenParamStationTimeBands) &&
        Objects.equals(this.camgenParamEIBands, camgenGlobalParametersRequest.camgenParamEIBands) &&
        Objects.equals(this.camgenParamAudGroupChannels, camgenGlobalParametersRequest.camgenParamAudGroupChannels);
  }

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    return Objects.hash(camgenParameters, camgenParamExtracts, camgenParamStationEITimeBands, camgenParamStationTimeBands, camgenParamEIBands, camgenParamAudGroupChannels);
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CamgenGlobalParametersRequest {\n");
    
    sb.append("    camgenParameters: ").append(toIndentedString(camgenParameters)).append("\n");
    sb.append("    camgenParamExtracts: ").append(toIndentedString(camgenParamExtracts)).append("\n");
    sb.append("    camgenParamStationEITimeBands: ").append(toIndentedString(camgenParamStationEITimeBands)).append("\n");
    sb.append("    camgenParamStationTimeBands: ").append(toIndentedString(camgenParamStationTimeBands)).append("\n");
    sb.append("    camgenParamEIBands: ").append(toIndentedString(camgenParamEIBands)).append("\n");
    sb.append("    camgenParamAudGroupChannels: ").append(toIndentedString(camgenParamAudGroupChannels)).append("\n");
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

