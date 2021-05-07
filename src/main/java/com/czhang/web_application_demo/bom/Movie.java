package com.czhang.web_application_demo.bom;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Document(collection = "movies")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

	@Id
	private String id;

	@JsonProperty("plot")
	private String plot;
	@JsonProperty("genres")
	private List<String> genres = new ArrayList<String>();
	@JsonProperty("runtime")
	private Integer runtime;
	@JsonProperty("cast")
	private List<String> cast = new ArrayList<String>();
	@JsonProperty("num_mflix_comments")
	private Integer numMflixComments;
	@JsonProperty("title")
	private String title;
	@JsonProperty("fullplot")
	private String fullplot;
	@JsonProperty("countries")
	private List<String> countries = new ArrayList<String>();
	@JsonProperty("released")
	private Date released;
	@JsonProperty("directors")
	private List<String> directors = new ArrayList<String>();
	@JsonProperty("rated")
	private String rated;
	@JsonProperty("awards")
	private Awards awards;
	@JsonProperty("lastupdated")
	private String lastupdated;
	@JsonProperty("year")
	private String year;
	@JsonProperty("imdb")
	private Imdb imdb;
	@JsonProperty("type")
	private String type;
	@JsonProperty("tomatoes")
	private Tomatoes tomatoes;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}
}
