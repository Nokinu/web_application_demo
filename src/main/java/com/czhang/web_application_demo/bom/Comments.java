package com.czhang.web_application_demo.bom;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Document(collection = "comments")
@NoArgsConstructor
@AllArgsConstructor
public class Comments {

	@Id
	private String id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("email")
	private String email;

	@JsonProperty("movie_id")
	@Field(name = "movie_id")
	private ObjectId movie_id;

	@JsonProperty("text")
	private String text;
	@JsonProperty("date")
	private Date date;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("email")
	public String getEmail() {
		return email;
	}

	@JsonProperty("email")
	public void setEmail(String email) {
		this.email = email;
	}

	@JsonProperty("movie_id")
	public String getMovieId() {
		return movie_id.toHexString();
	}

	@JsonProperty("movie_id")
	public void setMovieId(ObjectId movie_id) {
		this.movie_id = movie_id;
	}

	@JsonProperty("text")
	public String getText() {
		return text;
	}

	@JsonProperty("text")
	public void setText(String text) {
		this.text = text;
	}

	@JsonProperty("date")
	public Date getDate() {
		return date;
	}

	@JsonProperty("date")
	public void setDate(Date date) {
		this.date = date;
	}
}
