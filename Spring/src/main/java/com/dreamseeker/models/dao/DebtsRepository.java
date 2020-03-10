package com.dreamseeker.models.dao;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.dreamseeker.models.entity.Debt;


public interface DebtsRepository extends CrudRepository<Debt, Long>{

	ArrayList<Debt> findAllByApartmentId(String id);

}
