package com.cm.med_app.model;

import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="users")
public class User {

	@Id
	private String id;
	private String userName;
	private String emailId;
	private String mobileNo;
	private String password;
	private Boolean enabled=true;
	private Set<Role> roles;
	
}
