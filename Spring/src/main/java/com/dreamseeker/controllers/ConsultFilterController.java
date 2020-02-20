package com.dreamseeker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dreamseeker.models.entity.Person;
import com.dreamseeker.models.services.DAOService;

import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import net.rgielen.fxweaver.core.FxmlView;

@SuppressWarnings("restriction")
@Component
@FxmlView("ConsultingFilters.fxml")
public class ConsultFilterController {
	
	@Autowired
	private DAOService daoService;
	
	@FXML
	private TextField name;
	
	@FXML
	private TextField lastName;
	
	@FXML
	private TextField apartmentId;
	
	@FXML
	private TextField dni;
	
    @FXML
    private Label test;
    
    @FXML
    private Label testDep;
    
    @FXML
    private Label testDNI;

	
	public void findPersonByName() {
		List<Person> persons = daoService.getPersonByName(name.getText(), lastName.getText());
		if (persons.size() > 0)
			test.setText("FOUND");
		else
			test.setText("NOT FOUND");
		
	}
	
	public void findPersonByApartmentId() {
		Person person = daoService.getPersonByApartmentId(apartmentId.getText());
		if (person != null)
			testDep.setText("FOUND");
		else
			testDep.setText("NOT FOUND");		
	}
	
	public void findPersonByDNI() {
		Person person = daoService.getPersonByDNI(dni.getText());
		if (person != null)
			testDNI.setText("FOUND");
		else
			testDNI.setText("NOT FOUND");		
	}
}
