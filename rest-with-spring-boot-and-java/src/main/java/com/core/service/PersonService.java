package com.core.service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.core.entity.Person;

@Service
public class PersonService {
	
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonService.class.getName());
	
	public Person findById(String id) {
		logger.info("Finding one person.");
		return Person.builder()
			.id(counter.incrementAndGet())
			.address("Asa Sul")
			.gender("Male")
			.lastName("Lima")
			.firstName("Marcelo").build();
	}
}
