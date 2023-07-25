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
 * DemandSupply.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-12-20T05:39:01.194Z")

public class DemandSupply   {
  
  /** The criterias. */
  @JsonProperty("criterias")
  private List<CriteriaLine> criterias = null;

  /** The groups. */
  @JsonProperty("groups")
  private List<DemandSupplyGroup> groups = null;

  /**
   * Criterias.
   *
   * @param criterias the criterias
   * @return the demand supply
   */
  public DemandSupply criterias(List<CriteriaLine> criterias) {
    this.criterias = criterias;
    return this;
  }

  /**
   * Adds the criterias item.
   *
   * @param criteriasItem the criterias item
   * @return the demand supply
   */
  public DemandSupply addCriteriasItem(CriteriaLine criteriasItem) {
    if (this.criterias == null) {
      this.criterias = new ArrayList<CriteriaLine>();
    }
    this.criterias.add(criteriasItem);
    return this;
  }

   /**
    * Get criterias.
    *
    * @return criterias
    */
  @ApiModelProperty(value = "")

  @Valid

  public List<CriteriaLine> getCriterias() {
    return criterias;
  }

  /**
   * Sets the criterias.
   *
   * @param criterias the new criterias
   */
  public void setCriterias(List<CriteriaLine> criterias) {
    this.criterias = criterias;
  }

  /**
   * Groups.
   *
   * @param groups the groups
   * @return the demand supply
   */
  public DemandSupply groups(List<DemandSupplyGroup> groups) {
    this.groups = groups;
    return this;
  }

  /**
   * Adds the groups item.
   *
   * @param groupsItem the groups item
   * @return the demand supply
   */
  public DemandSupply addGroupsItem(DemandSupplyGroup groupsItem) {
    if (this.groups == null) {
      this.groups = new ArrayList<DemandSupplyGroup>();
    }
    this.groups.add(groupsItem);
    return this;
  }

   /**
    * Get groups.
    *
    * @return groups
    */
  @ApiModelProperty(value = "")

  @Valid

  public List<DemandSupplyGroup> getGroups() {
    return groups;
  }

  /**
   * Sets the groups.
   *
   * @param groups the new groups
   */
  public void setGroups(List<DemandSupplyGroup> groups) {
    this.groups = groups;
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
    DemandSupply demandSupply = (DemandSupply) o;
    return Objects.equals(this.criterias, demandSupply.criterias) &&
        Objects.equals(this.groups, demandSupply.groups);
  }

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    return Objects.hash(criterias, groups);
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DemandSupply {\n");
    
    sb.append("    criterias: ").append(toIndentedString(criterias)).append("\n");
    sb.append("    groups: ").append(toIndentedString(groups)).append("\n");
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

