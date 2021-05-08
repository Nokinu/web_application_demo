package com.czhang.web_application_demo.bom;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class Tomatoes {

	@JsonProperty("viewer")
	private Viewer viewer;
	@JsonProperty("lastUpdated")
	private Date lastUpdated;
}
