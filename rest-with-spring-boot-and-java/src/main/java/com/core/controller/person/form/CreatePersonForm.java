package com.core.controller.person.form;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreatePersonForm {
	
	private String firstName;
	private String lastName;
	private String gender;
	private String address;
}
