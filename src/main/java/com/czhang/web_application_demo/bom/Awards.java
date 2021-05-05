package com.czhang.web_application_demo.bom;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Awards {

	@JsonProperty("wins")
	private Integer wins;
	@JsonProperty("nominations")
	private Integer nominations;
	@JsonProperty("text")
	private String text;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<>();

	@JsonProperty("wins")
	public Integer getWins() {
		return wins;
	}

	@JsonProperty("wins")
	public void setWins(Integer wins) {
		this.wins = wins;
	}

	@JsonProperty("nominations")
	public Integer getNominations() {
		return nominations;
	}

	@JsonProperty("nominations")
	public void setNominations(Integer nominations) {
		this.nominations = nominations;
	}

	@JsonProperty("text")
	public String getText() {
		return text;
	}

	@JsonProperty("text")
	public void setText(String text) {
		this.text = text;
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
