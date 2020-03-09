package com.dreamseeker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.rgielen.fxweaver.core.FxWeaver;

import com.dreamseeker.models.entity.Dwelling;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxmlView;

@SuppressWarnings("restriction")
@Component
@FxmlView("PersonResume.fxml")
public class SearchResultController {
	
	@Autowired
	FxWeaver fxWeaver;

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
		debt.setText(Float.toString(dwelling.getDebt())); // TODO factorize float to string, make it more readable
	}

	public void openPaymentWindow() {
		Parent root = fxWeaver.loadView(DebtPaymentController.class); // TODO test getting the bean from the Spring
		// context
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setScene(scene);

		stage.show();
	}

}
