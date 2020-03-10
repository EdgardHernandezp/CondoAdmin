package com.dreamseeker.models.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamseeker.models.dao.DebtsRepository;
import com.dreamseeker.models.entity.Debt;

@Service
public class DAODebtService {
	@Autowired
	DebtsRepository debtsRepo;
	
	public ArrayList<Debt> findDebtsByApartmentId(String id) {
		return debtsRepo.findAllByApartmentId(id);
	}
}
