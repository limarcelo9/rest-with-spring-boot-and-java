package com.core.entity;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@Builder
public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String firstName;
	private String lastName;
	private String gender;
	private String address;
}
