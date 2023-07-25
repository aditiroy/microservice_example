/*
 * 
 */
package com.channel4.mint.automated.spot.interfaces.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

// TODO: Auto-generated Javadoc
/**
 * Error.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-12-19T04:58:28.844Z")

public class Error   {
  
  /** The code. */
  @JsonProperty("code")
  private Integer code = null;

  /** The message. */
  @JsonProperty("message")
  private String message = null;

  /** The fields. */
  @JsonProperty("fields")
  private List<Field> fields = null;

  /**
   * Code.
   *
   * @param code the code
   * @return the error
   */
  public Error code(Integer code) {
    this.code = code;
    return this;
  }

   /**
    * Get code.
    *
    * @return code
    */
  @ApiModelProperty(value = "")


  public Integer getCode() {
    return code;
  }

  /**
   * Sets the code.
   *
   * @param code the new code
   */
  public void setCode(Integer code) {
    this.code = code;
  }

  /**
   * Message.
   *
   * @param message the message
   * @return the error
   */
  public Error message(String message) {
    this.message = message;
    return this;
  }

   /**
    * Get message.
    *
    * @return message
    */
  @ApiModelProperty(value = "")


  public String getMessage() {
    return message;
  }

  /**
   * Sets the message.
   *
   * @param message the new message
   */
  public void setMessage(String message) {
    this.message = message;
  }

  /**
   * Fields.
   *
   * @param fields the fields
   * @return the error
   */
  public Error fields(List<Field> fields) {
    this.fields = fields;
    return this;
  }

  /**
   * Adds the fields item.
   *
   * @param fieldsItem the fields item
   * @return the error
   */
  public Error addFieldsItem(Field fieldsItem) {
    if (this.fields == null) {
      this.fields = new ArrayList<Field>();
    }
    this.fields.add(fieldsItem);
    return this;
  }

   /**
    * Get fields.
    *
    * @return fields
    */
  @ApiModelProperty(value = "")

  @Valid

  public List<Field> getFields() {
    return fields;
  }

  /**
   * Sets the fields.
   *
   * @param fields the new fields
   */
  public void setFields(List<Field> fields) {
    this.fields = fields;
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
    Error error = (Error) o;
    return Objects.equals(this.code, error.code) &&
        Objects.equals(this.message, error.message) &&
        Objects.equals(this.fields, error.fields);
  }

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    return Objects.hash(code, message, fields);
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Error {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    fields: ").append(toIndentedString(fields)).append("\n");
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

