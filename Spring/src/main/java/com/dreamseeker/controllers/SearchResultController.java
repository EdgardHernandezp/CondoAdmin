package com.dreamseeker.controllers;

import org.springframework.stereotype.Component;

import com.dreamseeker.models.entity.Dwelling;
import com.dreamseeker.models.entity.Person;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;

@SuppressWarnings("restriction")
@Component
@FxmlView("PersonResume.fxml")
public class SearchResultController {
	
	@FXML
	private TextField name;
	
	@FXML
	private TextField lastname;
	
	@FXML
	private TextField dni;
	
	@FXML
	private TextField apartmentID;
	
	@FXML
	private TextField debt;

	public void initData(Person person, Dwelling dwelling) {
		name.setText(person.getName());
		lastname.setText(person.getLastName());
		dni.setText(person.getDNI());
		apartmentID.setText(dwelling.getApartmentID());
		debt.setText(Float.toString(dwelling.getDebt())); //TODO factorize float to string, make it more readable
	}
	
	
}
