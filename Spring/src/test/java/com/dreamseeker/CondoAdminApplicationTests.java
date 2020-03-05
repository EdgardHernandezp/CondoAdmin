package com.dreamseeker;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.assertThat;

import com.dreamseeker.models.dao.DwellingRepository;
import com.dreamseeker.models.entity.Dwelling;

@RunWith(SpringRunner.class)
@DataJpaTest
class CondoAdminApplicationTests {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private DwellingRepository repo;

	@Test
	public void whenGettingDwellingById() {
		Dwelling testDwelling = new Dwelling("Mamerto", "Ibarreto", "12345678-k", 5, "A", 50000);
		entityManager.persist(testDwelling);
		entityManager.flush();

		Dwelling dwelling = repo.findByApartmentID("A");

		assertThat(dwelling.getApartmentID()).isEqualTo(testDwelling.getApartmentID());
	}

	@Test
	public void whenGettingPersonByDni() {
		Dwelling testPerson = new Dwelling("Mamerto", "Ibarreto", "12345678-k", 5, "A", 50000);
		entityManager.persist(testPerson);
		entityManager.flush();

		Dwelling person = repo.findByDni("12345678-k");
		assertThat(person.getDni()).isEqualTo(testPerson.getDni());
	}

	@Test
	public void whenGettingPersonByNameAndLastName() {
		Dwelling testPerson1 = new Dwelling("Mamerto", "Ibarreto", "12345678-k", 5, "A", 50000);
		Dwelling testPerson2 = new Dwelling("Mamerto", "Ibarreto", "32165485-k", 5, "B", 10000);
		entityManager.persist(testPerson1);
		entityManager.persist(testPerson2);
		entityManager.flush();

		List<Dwelling> persons = repo.findByNameAndLastName("Mamerto", "Ibarreto");

		assertThat(persons, containsInAnyOrder(testPerson1, testPerson2));
	}
	
	@Test
	public void whenUpdatingTheDebt() {
		Dwelling testDwelling = new Dwelling("Mamerto", "Ibarreto", "12345678-k", 5, "A", 50000);
		entityManager.persist(testDwelling);
		entityManager.flush();
		
		Dwelling dwelling = repo.findByApartmentID("A");
		dwelling.setDebt(10000);
		repo.save(dwelling);
		
		assertThat(dwelling.getApartmentID()).isEqualTo(testDwelling.getApartmentID());
		assertThat(dwelling.getDebt()).isEqualTo(10000);
	}

}
