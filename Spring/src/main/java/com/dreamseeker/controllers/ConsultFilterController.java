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
    private Label test;
	
	public void findPersonByName() {
		List<Person> persons = daoService.getPersonByName(name.getText(), lastName.getText());
		if (persons.size() > 0)
			test.setText("FOUND");
		else
			test.setText("NOT FOUND");
		
	}
}
