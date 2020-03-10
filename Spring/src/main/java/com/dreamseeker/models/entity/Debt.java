package com.dreamseeker.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Debts")
public class Debt implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "apartmentId")
	private String apartmentId;
	private float debt;
	private String month;

	public Debt(String apartmentID, float debt, String month) {
		this.apartmentId = apartmentID;
		this.debt = debt;
		this.month = month;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDwellingID() {
		return apartmentId;
	}

	public void setDwellingID(String apartmentId) {
		this.apartmentId = apartmentId;
	}

	public float getDebt() {
		return debt;
	}

	public void setDebt(float debt) {
		this.debt = debt;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}
}
