package com.dreamseeker.models.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamseeker.models.dao.DwellingRepository;
import com.dreamseeker.models.entity.Dwelling;

@Service
public class DAOService {

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
	public Dwelling getDwellingByApartmentId(String id) {
		return dwellingRepo.findByApartmentID(id);
	}
	
	@Transactional
	public Dwelling getDwellingByDNI(String dni) {
		return dwellingRepo.findByDni(dni);
	}
	
	@Transactional
	public ArrayList<Dwelling> getDwellingByName(String name, String lastName) {
		return dwellingRepo.findByNameAndLastName(name, lastName);
	}
	
	@Transactional
	public Dwelling updateDebt(float debt, String id) {		
		Dwelling dwellingToUpdate = getDwellingByApartmentId(id);
		dwellingToUpdate.setDebt(debt);
		return dwellingRepo.save(dwellingToUpdate);
	}
}
