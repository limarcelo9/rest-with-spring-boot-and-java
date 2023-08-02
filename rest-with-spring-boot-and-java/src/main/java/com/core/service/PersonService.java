package com.core.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.core.controller.person.form.CreatePersonForm;
import com.core.entity.Person;

@Service
public class PersonService {
	
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonService.class.getName());
	private List<Person> peoples = new ArrayList<>();
	
	public Person findById(String id) {
		logger.info("Finding one person.");
		return peoples.stream().filter(pessoa -> pessoa.getId() == Integer.parseInt(id))
                .collect(Collectors.toList()).get(0);
	}
	
	public List<Person> findAll() {
		return peoples;
	}

	public Person createPerson(CreatePersonForm form) {
		logger.info("Creating one person.");
		peoples.add(Person.builder()
				.id(counter.incrementAndGet())
				.address(form.getAddress())
				.gender(form.getGender())
				.lastName(form.getLastName())
				.firstName(form.getFirstName()).build());
		 
		return peoples.get(peoples.size() - 1);
	}

	public Person editPerson(String id) {
		Person person = findById(id);
		return null;
	}
}
