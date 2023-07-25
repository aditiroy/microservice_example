/*
 * 
 */
package com.channel4.mint.automated.spot.interfaces.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

// TODO: Auto-generated Javadoc
/**
 * CamgenParam.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-12-19T04:58:28.844Z")

public class CamgenParam {
	
	/** The id. */
	@JsonProperty("id")
	private Long id = null;

	/** The parameter. */
	@JsonProperty("parameter")
	private String parameter = null;

	/** The standardvalue. */
	@JsonProperty("standardvalue")
	private String standardvalue = null;

	/** The value. */
	@JsonProperty("value")
	private String value = null;

	/** The view order. */
	@JsonProperty("viewOrder")
	private Integer viewOrder = null;

	/** The remarks. */
	@JsonProperty("remarks")
	private String remarks = null;

	/** The created by. */
	@JsonProperty("createdBy")
	private String createdBy = null;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
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
	 * Gets the parameter.
	 *
	 * @return the parameter
	 */
	public String getParameter() {
		return parameter;
	}

	/**
	 * Sets the parameter.
	 *
	 * @param parameter the new parameter
	 */
	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	/**
	 * Gets the standardvalue.
	 *
	 * @return the standardvalue
	 */
	public String getStandardvalue() {
		return standardvalue;
	}

	/**
	 * Sets the standardvalue.
	 *
	 * @param standardvalue the new standardvalue
	 */
	public void setStandardvalue(String standardvalue) {
		this.standardvalue = standardvalue;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 *
	 * @param value the new value
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * Gets the view order.
	 *
	 * @return the view order
	 */
	public Integer getViewOrder() {
		return viewOrder;
	}

	/**
	 * Sets the view order.
	 *
	 * @param viewOrder the new view order
	 */
	public void setViewOrder(Integer viewOrder) {
		this.viewOrder = viewOrder;
	}

	/**
	 * Gets the remarks.
	 *
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * Sets the remarks.
	 *
	 * @param remarks the new remarks
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * Gets the created by.
	 *
	 * @return the created by
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * Sets the created by.
	 *
	 * @param createdBy the new created by
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

}
