package com.channel4.mint.automated.spot.interfaces.dto;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Snapshots
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-23T05:21:13.942Z")

public class Snapshots   {
  @JsonProperty("camgenRequestId")
  private Long camgenRequestId = null;

  public Snapshots camgenRequestId(Long camgenRequestId) {
    this.camgenRequestId = camgenRequestId;
    return this;
  }

  /**
   * Get camgenRequestId
   * @return camgenRequestId
  **/
  @ApiModelProperty(value = "")


  public Long getCamgenRequestId() {
    return camgenRequestId;
  }

  public void setCamgenRequestId(Long camgenRequestId) {
    this.camgenRequestId = camgenRequestId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Snapshots snapshots = (Snapshots) o;
    return Objects.equals(this.camgenRequestId, snapshots.camgenRequestId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(camgenRequestId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Snapshots {\n");
    
    sb.append("    camgenRequestId: ").append(toIndentedString(camgenRequestId)).append("\n");
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

