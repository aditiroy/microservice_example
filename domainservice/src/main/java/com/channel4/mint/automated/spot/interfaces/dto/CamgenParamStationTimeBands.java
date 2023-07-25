/*
 * 
 */
package com.channel4.mint.automated.spot.interfaces.dto;

import java.util.ArrayList;
import java.util.Objects;

// TODO: Auto-generated Javadoc
/**
 * CamgenParamStationTimeBands.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-12-19T04:58:28.844Z")

public class CamgenParamStationTimeBands extends ArrayList<CamgenParamStationTimeBand>  {

  /* (non-Javadoc)
   * @see java.util.AbstractList#equals(java.lang.Object)
   */
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    return true;
  }

  /* (non-Javadoc)
   * @see java.util.AbstractList#hashCode()
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode());
  }

  /* (non-Javadoc)
   * @see java.util.AbstractCollection#toString()
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CamgenParamStationTimeBands {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
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

