package com.dreamseeker.models.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamseeker.models.dao.DwellingRepository;
import com.dreamseeker.models.entity.Dwelling;

@Service
public class DwellingService {

	@Autowired
	DwellingRepository dwellingRepo;

	@Transactional
	public boolean addPerson(Dwelling dwelling) {
		return dwellingRepo.save(dwelling) != null;
	}

	@Transactional
	public long count() {
		return dwellingRepo.count();
	}

	@Transactional
	public List<Dwelling> getAll() {
		return (List<Dwelling>) dwellingRepo.findAll();
	}
	
	@Transactional
	public Dwelling getDwellingById(String id) {
		return dwellingRepo.findByApartmentID(id);
	}
}
