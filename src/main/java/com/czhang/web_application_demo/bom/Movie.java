package com.czhang.web_application_demo.bom;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Document(collection = "movies")
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
	private Integer year;
	@JsonProperty("imdb")
	private Imdb imdb;
	@JsonProperty("type")
	private String type;
	@JsonProperty("tomatoes")
	private Tomatoes tomatoes;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("plot")
	public String getPlot() {
		return plot;
	}

	@JsonProperty("plot")
	public void setPlot(String plot) {
		this.plot = plot;
	}

	@JsonProperty("genres")
	public List<String> getGenres() {
		return genres;
	}

	@JsonProperty("genres")
	public void setGenres(List<String> genres) {
		this.genres = genres;
	}

	@JsonProperty("runtime")
	public Integer getRuntime() {
		return runtime;
	}

	@JsonProperty("runtime")
	public void setRuntime(Integer runtime) {
		this.runtime = runtime;
	}

	@JsonProperty("cast")
	public List<String> getCast() {
		return cast;
	}

	@JsonProperty("cast")
	public void setCast(List<String> cast) {
		this.cast = cast;
	}

	@JsonProperty("num_mflix_comments")
	public Integer getNumMflixComments() {
		return numMflixComments;
	}

	@JsonProperty("num_mflix_comments")
	public void setNumMflixComments(Integer numMflixComments) {
		this.numMflixComments = numMflixComments;
	}

	@JsonProperty("title")
	public String getTitle() {
		return title;
	}

	@JsonProperty("title")
	public void setTitle(String title) {
		this.title = title;
	}

	@JsonProperty("fullplot")
	public String getFullplot() {
		return fullplot;
	}

	@JsonProperty("fullplot")
	public void setFullplot(String fullplot) {
		this.fullplot = fullplot;
	}

	@JsonProperty("countries")
	public List<String> getCountries() {
		return countries;
	}

	@JsonProperty("countries")
	public void setCountries(List<String> countries) {
		this.countries = countries;
	}

	@JsonProperty("released")
	public Date getReleased() {
		return released;
	}

	@JsonProperty("released")
	public void setReleased(Date released) {
		this.released = released;
	}

	@JsonProperty("directors")
	public List<String> getDirectors() {
		return directors;
	}

	@JsonProperty("directors")
	public void setDirectors(List<String> directors) {
		this.directors = directors;
	}

	@JsonProperty("rated")
	public String getRated() {
		return rated;
	}

	@JsonProperty("rated")
	public void setRated(String rated) {
		this.rated = rated;
	}

	@JsonProperty("awards")
	public Awards getAwards() {
		return awards;
	}

	@JsonProperty("awards")
	public void setAwards(Awards awards) {
		this.awards = awards;
	}

	@JsonProperty("lastupdated")
	public String getLastupdated() {
		return lastupdated;
	}

	@JsonProperty("lastupdated")
	public void setLastupdated(String lastupdated) {
		this.lastupdated = lastupdated;
	}

	@JsonProperty("year")
	public Integer getYear() {
		return year;
	}

	@JsonProperty("year")
	public void setYear(Integer year) {
		this.year = year;
	}

	@JsonProperty("imdb")
	public Imdb getImdb() {
		return imdb;
	}

	@JsonProperty("imdb")
	public void setImdb(Imdb imdb) {
		this.imdb = imdb;
	}

	@JsonProperty("type")
	public String getType() {
		return type;
	}

	@JsonProperty("type")
	public void setType(String type) {
		this.type = type;
	}

	@JsonProperty("tomatoes")
	public Tomatoes getTomatoes() {
		return tomatoes;
	}

	@JsonProperty("tomatoes")
	public void setTomatoes(Tomatoes tomatoes) {
		this.tomatoes = tomatoes;
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
