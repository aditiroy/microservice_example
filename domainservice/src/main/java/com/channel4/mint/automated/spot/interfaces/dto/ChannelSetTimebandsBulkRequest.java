package com.channel4.mint.automated.spot.interfaces.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * ChannelSetTimebandsBulkRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-12-28T04:55:33.590Z")

public class ChannelSetTimebandsBulkRequest {
	@JsonProperty("created")
	private List<ChannelSetTimebandsBulkRequestCreated> created = null;

	@JsonProperty("modified")
	private List<ChannelSetTimebandsBulkRequestModified> modified = null;

	@JsonProperty("deleted")
	private List<ChannelSetTimebandsBulkRequestDeleted> deleted = null;

	@JsonProperty("createdBy")
	private String createdBy = null;

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public ChannelSetTimebandsBulkRequest created(List<ChannelSetTimebandsBulkRequestCreated> created) {
		this.created = created;
		return this;
	}

	public ChannelSetTimebandsBulkRequest addCreatedItem(ChannelSetTimebandsBulkRequestCreated createdItem) {
		if (this.created == null) {
			this.created = new ArrayList<ChannelSetTimebandsBulkRequestCreated>();
		}
		this.created.add(createdItem);
		return this;
	}

	/**
	 * Get created
	 * 
	 * @return created
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public List<ChannelSetTimebandsBulkRequestCreated> getCreated() {
		return created;
	}

	public void setCreated(List<ChannelSetTimebandsBulkRequestCreated> created) {
		this.created = created;
	}

	public ChannelSetTimebandsBulkRequest modified(List<ChannelSetTimebandsBulkRequestModified> modified) {
		this.modified = modified;
		return this;
	}

	public ChannelSetTimebandsBulkRequest addModifiedItem(ChannelSetTimebandsBulkRequestModified modifiedItem) {
		if (this.modified == null) {
			this.modified = new ArrayList<ChannelSetTimebandsBulkRequestModified>();
		}
		this.modified.add(modifiedItem);
		return this;
	}

	/**
	 * Get modified
	 * 
	 * @return modified
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public List<ChannelSetTimebandsBulkRequestModified> getModified() {
		return modified;
	}

	public void setModified(List<ChannelSetTimebandsBulkRequestModified> modified) {
		this.modified = modified;
	}

	public ChannelSetTimebandsBulkRequest deleted(List<ChannelSetTimebandsBulkRequestDeleted> deleted) {
		this.deleted = deleted;
		return this;
	}

	public ChannelSetTimebandsBulkRequest addDeletedItem(ChannelSetTimebandsBulkRequestDeleted deletedItem) {
		if (this.deleted == null) {
			this.deleted = new ArrayList<ChannelSetTimebandsBulkRequestDeleted>();
		}
		this.deleted.add(deletedItem);
		return this;
	}

	/**
	 * Get deleted
	 * 
	 * @return deleted
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public List<ChannelSetTimebandsBulkRequestDeleted> getDeleted() {
		return deleted;
	}

	public void setDeleted(List<ChannelSetTimebandsBulkRequestDeleted> deleted) {
		this.deleted = deleted;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ChannelSetTimebandsBulkRequest channelSetTimebandsBulkRequest = (ChannelSetTimebandsBulkRequest) o;
		return Objects.equals(this.created, channelSetTimebandsBulkRequest.created)
				&& Objects.equals(this.modified, channelSetTimebandsBulkRequest.modified)
				&& Objects.equals(this.deleted, channelSetTimebandsBulkRequest.deleted);
	}

	@Override
	public int hashCode() {
		return Objects.hash(created, modified, deleted);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ChannelSetTimebandsBulkRequest {\n");

		sb.append("    created: ").append(toIndentedString(created)).append("\n");
		sb.append("    modified: ").append(toIndentedString(modified)).append("\n");
		sb.append("    deleted: ").append(toIndentedString(deleted)).append("\n");
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
