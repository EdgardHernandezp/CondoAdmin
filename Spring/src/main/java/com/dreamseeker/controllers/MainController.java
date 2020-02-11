package com.dreamseeker.controllers;

import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@SuppressWarnings("restriction")
@Component
@FxmlView("CondoAdmin.fxml")
public class MainController {
	
	@Autowired
	FxWeaver fxWeaver;
	
	public void openConsultWindow() {
		Parent root = fxWeaver.loadView(ConsultFilterController.class);
	    Scene scene = new Scene(root);
	    Stage stage = new Stage();
	    stage.setScene(scene);
	    stage.show();
	}
}
