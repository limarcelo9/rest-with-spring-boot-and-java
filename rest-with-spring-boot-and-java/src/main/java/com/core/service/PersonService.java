package com.core.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.core.exceptions.ResourceNotFoundException;
import com.core.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.core.controller.person.form.CreatePersonForm;
import com.core.entity.Person;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;
	private final AtomicLong counter = new AtomicLong();
	private final Logger logger = Logger.getLogger(PersonService.class.getName());

	public Person findById(String id) {
		logger.info("Finding one person.");
		return repository.findById(Long.parseLong(id))
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
	}
	
	public List<Person> findAll() {
		logger.info("Finding one person.");
		return repository.findAll();
	}

	public Person createPerson(CreatePersonForm form) {
		List<Person> list = new ArrayList<>();
		logger.info("Creating one person.");
		for (int i=0; i < 10000; i++) {
			Person newPerson = Person.builder()
					.id(counter.incrementAndGet())
					.address(form.getAddress())
					.gender(form.getGender())
					.lastName(form.getLastName())
					.firstName(form.getFirstName() + " - " + i).build();
			repository.save(newPerson);
			System.out.println(newPerson.getFirstName() + i);
			list.add(newPerson);
		}
		return list.get(0);
	}

	public Person editPerson(String id) {
		return null;
	}
}