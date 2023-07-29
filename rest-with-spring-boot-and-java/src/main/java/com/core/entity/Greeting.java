package com.core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Greeting {

	private Long id;
	private String content;
	
	public Greeting(Long id, String content) {
		this.id = id;
		this.content = content;
	}

}
