package com.dreamseeker.controllers;

import javax.naming.event.EventContext;

import org.springframework.stereotype.Component;

import net.rgielen.fxweaver.core.FxmlView;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;

@SuppressWarnings("restriction")
@Component
@FxmlView("DebtPayment.fxml")
public class DebtPaymentController {

	@FXML
	private TextField totalDebtTxtField;

	@FXML
	private RadioButton paySpecifcAmountRadioBtn;

	@FXML
	private RadioButton payByMonthRadioBtn;

	public void updateDwellingData() {

	}

	public void setAmountRadioBtn() {
		paySpecifcAmountRadioBtn.setSelected(false);
	}
	
	public void setMonthRadioBtn() {
		payByMonthRadioBtn.setSelected(false);
	}
}
