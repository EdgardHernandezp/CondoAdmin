package com.dreamseeker;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.AbstractStringAssert;
import org.assertj.core.api.IntPredicateAssert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.assertThat;

import com.dreamseeker.models.dao.DwellingRepository;
import com.dreamseeker.models.dao.PersonRepository;
import com.dreamseeker.models.entity.Dwelling;
import com.dreamseeker.models.entity.Person;

@RunWith(SpringRunner.class)
@DataJpaTest
class CondoAdminApplicationTests {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private DwellingRepository repo;

	@Autowired
	private PersonRepository personRepo;

	@Test
	public void whenGettingDwellingById() {
		Dwelling testDwelling = new Dwelling(5, "A", 50000);
		entityManager.persist(testDwelling);
		entityManager.flush();

		Dwelling dwelling = repo.findByApartmentID("A");

		assertThat(dwelling.getApartmentID()).isEqualTo(testDwelling.getApartmentID());
	}

	@Test
	public void whenGettingPersonByDni() {
		Person testPerson = new Person("Mamerto", "Ibarreto", "12345678-k", "A");
		entityManager.persist(testPerson);
		entityManager.flush();

		Person person = personRepo.findByDni("12345678-k");
		assertThat(person.getDNI()).isEqualTo(testPerson.getDNI());
	}

	@Test
	public void whenGettingPersonByNameAndLastName() {
		Person testPerson1 = new Person("Mamerto", "Ibarreto", "12345678-k", "A");
		Person testPerson2 = new Person("Mamerto", "Ibarreto", "32345678-k", "B");
		entityManager.persist(testPerson1);
		entityManager.persist(testPerson2);
		entityManager.flush();

		List<Person> persons = personRepo.findByNameAndLastName("Mamerto", "Ibarreto");

		assertThat(persons, containsInAnyOrder(testPerson1, testPerson2));
	}

}
