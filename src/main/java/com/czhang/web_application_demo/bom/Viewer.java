package com.czhang.web_application_demo.bom;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Viewer {

	@JsonProperty("rating")
	private Integer rating;
	@JsonProperty("numReviews")
	private Integer numReviews;
	@JsonProperty("meter")
	private Integer meter;
}
