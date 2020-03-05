package com.dreamseeker.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Edgar Hernández
 *
 */
@Entity
public class Dwelling implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	private String name;
	@Column(name = "lastname")
	private String lastName;
	private String dni;
	private int floor;
	private String apartmentID;
	private float debt;
	
	protected Dwelling() {}

	public Dwelling(String name, String lastName, String dni, int floor, String apartmentID, float debt) {
		this.name = name;
		this.lastName = lastName;
		this.dni = dni;
		this.floor = floor;
		this.apartmentID = apartmentID;
		this.debt = debt;
	}
	
    @Override
    public String toString() {
        return String.format(
                "Dwelling[name=%s, last name='%s', dni='%s', floor=%d, apartmentID='%s', debt='%s']", name, lastName, dni,
                floor, apartmentID, debt);
    }

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public String getLastName() {
		return lastName;
	}

	public String getDni() {
		return dni;
	}
	
	public int getFloor() {
		return floor;
	}

	public String getApartmentID() {
		return apartmentID;
	}

	public float getDebt() {
		return debt;
	}
	
	public void setDebt(float debt) {
		this.debt = debt;
	}
}
