package com.dreamseeker;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import org.springframework.test.context.junit4.SpringRunner;

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
		Dwelling testDwelling = new Dwelling(5, "A", 50000);
		entityManager.persist(testDwelling);
		entityManager.flush();
		
		Dwelling dwelling = repo.findByApartmentID("A");
		
		assertThat(dwelling.getApartmentID()).isEqualTo(testDwelling.getApartmentID());
	}

	
	

}
