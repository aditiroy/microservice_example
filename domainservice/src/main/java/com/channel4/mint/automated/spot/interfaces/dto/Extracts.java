/*
 * 
 */
package com.channel4.mint.automated.spot.interfaces.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

// TODO: Auto-generated Javadoc
/**
 * Extracts.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-12-19T04:58:28.844Z")

public class Extracts   {
  
  /** The parameters. */
  @JsonProperty("parameters")
  private String parameters = null;

  /**
   * Parameters.
   *
   * @param parameters the parameters
   * @return the extracts
   */
  public Extracts parameters(String parameters) {
    this.parameters = parameters;
    return this;
  }

   /**
    * Get parameters.
    *
    * @return parameters
    */
  @ApiModelProperty(value = "")


  public String getParameters() {
    return parameters;
  }

  /**
   * Sets the parameters.
   *
   * @param parameters the new parameters
   */
  public void setParameters(String parameters) {
    this.parameters = parameters;
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
    Extracts extracts = (Extracts) o;
    return Objects.equals(this.parameters, extracts.parameters);
  }

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    return Objects.hash(parameters);
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Extracts {\n");
    
    sb.append("    parameters: ").append(toIndentedString(parameters)).append("\n");
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

