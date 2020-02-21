package com.dreamseeker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dreamseeker.models.entity.Dwelling;
import com.dreamseeker.models.entity.Person;
import com.dreamseeker.models.services.DAOService;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;

@SuppressWarnings("restriction")
@Component
@FxmlView("ConsultingFilters.fxml")
public class ConsultFilterController {
	
	@Autowired
	FxWeaver fxWeaver;
	
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

		
	}
	
	public void findPersonByApartmentId() {
		Person person = daoService.getPersonByApartmentId(apartmentId.getText());
		Dwelling dwelling = daoService.getDwellingByApartmentId(person.getApartmentID());
		
		openResultWindow(person, dwelling);
	}
	
	public void findPersonByDNI() {
		Person person = daoService.getPersonByDNI(dni.getText());
		Dwelling dwelling = daoService.getDwellingByApartmentId(person.getApartmentID()); //TODO duplicated code, factorize
		
		openResultWindow(person, dwelling);
	}
	
	public void openResultWindow(Person person, Dwelling dwelling) {
		Parent root = fxWeaver.loadView(SearchResultController.class); //TODO test getting the bean from the Spring context
	    Scene scene = new Scene(root);
	    Stage stage = new Stage();
	    stage.setScene(scene);
	    
		SearchResultController controller = fxWeaver.getBean(SearchResultController.class);
		controller.initData(person, dwelling);
	    
	    stage.show();
	}
}
