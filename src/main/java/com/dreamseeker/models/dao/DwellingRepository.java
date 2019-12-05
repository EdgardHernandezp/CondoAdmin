/**
 * 
 */
package com.dreamseeker.models.dao;


import org.springframework.data.repository.CrudRepository;

import com.dreamseeker.models.entity.Dwelling;

/**
 * @author Edgar Hernández
 *
 */
public interface DwellingRepository extends CrudRepository<Dwelling, Long> {
	Dwelling findByApartmentID(String id);
}
