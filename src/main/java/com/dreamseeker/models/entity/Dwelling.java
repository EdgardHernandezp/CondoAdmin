package com.dreamseeker.models.entity;

import java.io.Serializable;

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
	private int floor;
	private String apartmentID;
	private float debt;
	
	protected Dwelling() {}

	public Dwelling(int floor, String apartmentID, float debt) {
		this.floor = floor;
		this.apartmentID = apartmentID;
		this.debt = debt;
	}
	
    @Override
    public String toString() {
        return String.format(
                "Dwelling[floor=%d, apartmentID='%s', debt='%s']",
                floor, apartmentID, debt);
    }

	public Long getId() {
		return id;
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
	

}
