/*
 * 
 */
package com.channel4.mint.automated.spot.interfaces.dto;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * BatchTxLevel
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-14T09:04:29.792Z")

public class BatchTxLevel {
	 @JsonProperty("id")
	  private Integer id = null;

	  @JsonProperty("txLevelId")
	  private Long txLevelId = null;

	  @JsonProperty("batchTxLevelValue")
	  private Integer batchTxLevelValue = null;

	  public BatchTxLevel id(Integer id){
	    this.id = id;
	    return this;
	  }

	  /**
	   * Get id
	   * @return id
	  **/
	  @ApiModelProperty(value = "")


	  public Integer getId() {
	    return id;
	  }

	  public void setId(Integer id) {
	    this.id = id;
	  }

	  public BatchTxLevel txLevelId(Long txLevelId) {
	    this.txLevelId = txLevelId;
	    return this;
	  }

	  /**
	   * Get txLevelId
	   * @return txLevelId
	  **/
	  @ApiModelProperty(value = "")


	  public Long getTxLevelId() {
	    return txLevelId;
	  }

	  public void setTxLevelId(Long txLevelId) {
	    this.txLevelId = txLevelId;
	  }

	  public BatchTxLevel batchTxLevelValue(Integer batchTxLevelValue) {
	    this.batchTxLevelValue = batchTxLevelValue;
	    return this;
	  }

	  /**
	   * Get batchTxLevelValue
	   * @return batchTxLevelValue
	  **/
	  @ApiModelProperty(value = "")


	  public Integer getBatchTxLevelValue() {
	    return batchTxLevelValue;
	  }

	  public void setBatchTxLevelValue(Integer batchTxLevelValue) {
	    this.batchTxLevelValue = batchTxLevelValue;
	  }


	  @Override
	  public boolean equals(java.lang.Object o) {
	    if (this == o) {
	      return true;
	    }
	    if (o == null || getClass() != o.getClass()) {
	      return false;
	    }
	    BatchTxLevel batchTxLevel = (BatchTxLevel) o;
	    return Objects.equals(this.id, batchTxLevel.id) &&
	        Objects.equals(this.txLevelId, batchTxLevel.txLevelId) &&
	        Objects.equals(this.batchTxLevelValue, batchTxLevel.batchTxLevelValue);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(id, txLevelId, batchTxLevelValue);
	  }

	  @Override
	  public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("class BatchTxLevel {\n");
	    
	    sb.append("    id: ").append(toIndentedString(id)).append("\n");
	    sb.append("    txLevelId: ").append(toIndentedString(txLevelId)).append("\n");
	    sb.append("    batchTxLevelValue: ").append(toIndentedString(batchTxLevelValue)).append("\n");
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
