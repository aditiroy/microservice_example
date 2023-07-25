/*
 * 
 */
package com.channel4.mint.automated.spot.interfaces.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

// TODO: Auto-generated Javadoc
/**
 * CamgenParamEIBand.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-12-19T04:58:28.844Z")

public class CamgenParamEIBand {
	
	/** The id. */
	@JsonProperty("id")
	private Long id = null;

	/** The ei band. */
	@JsonProperty("eiBand")
	private Integer eiBand = null;

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
	 * Gets the ei band.
	 *
	 * @return the ei band
	 */
	public Integer getEiBand() {
		return eiBand;
	}

	/**
	 * Sets the ei band.
	 *
	 * @param eiBand the new ei band
	 */
	public void setEiBand(Integer eiBand) {
		this.eiBand = eiBand;
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
