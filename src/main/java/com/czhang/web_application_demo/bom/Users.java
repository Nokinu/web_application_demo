package com.czhang.web_application_demo.bom;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document(collection = "users")
public class Users {

	@Id
	private String id;

	private String name;

	private String email;

	private String password;
}
