package com.czhang.web_application_demo.bom;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

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
	private List<String> genres = new ArrayList<>();
	@JsonProperty("runtime")
	private Integer runtime;
	@JsonProperty("cast")
	private List<String> cast = new ArrayList<>();
	@JsonProperty("num_mflix_comments")
	private Integer numMflixComments;
	@JsonProperty("title")
	private String title;
	@JsonProperty("fullplot")
	private String fullplot;
	@JsonProperty("countries")
	private List<String> countries = new ArrayList<>();
	@JsonProperty("released")
	private Date released;
	@JsonProperty("directors")
	private List<String> directors = new ArrayList<>();
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
	private Map<String, Object> additionalProperties = new HashMap<>();
}
