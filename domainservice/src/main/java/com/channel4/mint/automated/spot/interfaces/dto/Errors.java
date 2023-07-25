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
 * Errors.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-12-19T04:58:28.844Z")

public class Errors   {
  
  /** The id. */
  @JsonProperty("id")
  private Long id = null;

  /** The fields. */
  @JsonProperty("fields")
  private List<Fields> fields = null;

  /**
   * Id.
   *
   * @param id the id
   * @return the errors
   */
  public Errors id(Long id) {
    this.id = id;
    return this;
  }

   /**
    * Get id.
    *
    * @return id
    */
  @ApiModelProperty(value = "")


  public Long getId() {
    return id;
  }

  /**
   * Sets the id.
   *
   * @param id the new id
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Fields.
   *
   * @param fields the fields
   * @return the errors
   */
  public Errors fields(List<Fields> fields) {
    this.fields = fields;
    return this;
  }

  /**
   * Adds the fields item.
   *
   * @param fieldsItem the fields item
   * @return the errors
   */
  public Errors addFieldsItem(Fields fieldsItem) {
    if (this.fields == null) {
      this.fields = new ArrayList<Fields>();
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

  public List<Fields> getFields() {
    return fields;
  }

  /**
   * Sets the fields.
   *
   * @param fields the new fields
   */
  public void setFields(List<Fields> fields) {
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
    Errors errors = (Errors) o;
    return Objects.equals(this.id, errors.id) &&
        Objects.equals(this.fields, errors.fields);
  }

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    return Objects.hash(id, fields);
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Errors {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

