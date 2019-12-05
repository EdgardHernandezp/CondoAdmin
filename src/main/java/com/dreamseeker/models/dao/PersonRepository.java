package com.dreamseeker.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dreamseeker.models.entity.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {
	Person findByDni(String dni);
	List<Person> findByNameAndLastName(String name, String lastName);
	
}
