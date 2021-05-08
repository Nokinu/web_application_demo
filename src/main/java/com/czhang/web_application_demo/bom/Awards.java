package com.czhang.web_application_demo.bom;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Awards {

	@JsonProperty("wins")
	private Integer wins;
	@JsonProperty("nominations")
	private Integer nominations;
	@JsonProperty("text")
	private String text;

}
