package com.dreamseeker.controllers;

import org.springframework.stereotype.Component;

import com.dreamseeker.models.entity.Dwelling;

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

	public void initData(Dwelling dwelling) {
		name.setText(dwelling.getName());
		lastname.setText(dwelling.getLastName());
		dni.setText(dwelling.getDni());
		apartmentID.setText(dwelling.getApartmentID());
		debt.setText(Float.toString(dwelling.getDebt())); //TODO factorize float to string, make it more readable
	}
	
	
}
