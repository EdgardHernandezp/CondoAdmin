package com.dreamseeker.models.dao;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.dreamseeker.models.entity.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {
	Person findByDni(String dni);
	ArrayList<Person> findByNameAndLastName(String name, String lastName);
	
}
