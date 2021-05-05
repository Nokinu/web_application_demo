package com.czhang.web_application_demo.bom;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Tomatoes {

	@JsonProperty("viewer")
	private Viewer viewer;
	@JsonProperty("lastUpdated")
	private Date lastUpdated;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("viewer")
	public Viewer getViewer() {
		return viewer;
	}

	@JsonProperty("viewer")
	public void setViewer(Viewer viewer) {
		this.viewer = viewer;
	}

	@JsonProperty("lastUpdated")
	public Date getLastUpdated() {
		return lastUpdated;
	}

	@JsonProperty("lastUpdated")
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}
}
