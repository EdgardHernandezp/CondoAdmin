package com.dreamseeker.controllers;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dreamseeker.models.entity.Dwelling;
import com.dreamseeker.models.entity.Person;
import com.dreamseeker.models.services.DAOService;

import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.collections.FXCollections;

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
	private TableView resultTable;

	@FXML
	private ListView<String> resultList = new ListView<>(); // TODO change it by a TableView()

	private List<Person> personsResult; // TODO find a better name for this

	public void findPersonByName() {
		personsResult = daoService.getPersonByName(name.getText(), lastName.getText()); // TODO pensar bien si debo
																						// instanciarlo en la
																						// declaracion

		if (personsResult.size() > 0) {
			List<String> personsString = new ArrayList<String>();
			for (Person person : personsResult) {
				personsString.add(person.toString());
			}
			ObservableList<String> results = FXCollections.observableArrayList(personsString);
			resultList.setItems(results);
		}

	}

	public void findPersonByApartmentId() {
		Person person = daoService.getPersonByApartmentId(apartmentId.getText());
		Dwelling dwelling = daoService.getDwellingByApartmentId(person.getApartmentID());

		openResultWindow();
	}

	public void findPersonByDNI() {
		Person person = daoService.getPersonByDNI(dni.getText());
		Dwelling dwelling = daoService.getDwellingByApartmentId(person.getApartmentID()); // TODO duplicated code,
																							// factorize

		openResultWindow();
	}

	public void openResultWindow() {

		int index = resultList.getSelectionModel().getSelectedIndex();
		if (index >= 0) {
			Person person = personsResult.get(index);
			Dwelling dwelling = daoService.getDwellingByApartmentId(person.getApartmentID());

			Parent root = fxWeaver.loadView(SearchResultController.class); // TODO test getting the bean from the Spring
																			// context
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);

			SearchResultController controller = fxWeaver.getBean(SearchResultController.class);
			controller.initData(person, dwelling);

			stage.show();
		}
	}
}
