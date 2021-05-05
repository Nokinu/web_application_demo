package com.czhang.web_application_demo.bom;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Viewer {

	@JsonProperty("rating")
	private Integer rating;
	@JsonProperty("numReviews")
	private Integer numReviews;
	@JsonProperty("meter")
	private Integer meter;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("rating")
	public Integer getRating() {
		return rating;
	}

	@JsonProperty("rating")
	public void setRating(Integer rating) {
		this.rating = rating;
	}

	@JsonProperty("numReviews")
	public Integer getNumReviews() {
		return numReviews;
	}

	@JsonProperty("numReviews")
	public void setNumReviews(Integer numReviews) {
		this.numReviews = numReviews;
	}

	@JsonProperty("meter")
	public Integer getMeter() {
		return meter;
	}

	@JsonProperty("meter")
	public void setMeter(Integer meter) {
		this.meter = meter;
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
