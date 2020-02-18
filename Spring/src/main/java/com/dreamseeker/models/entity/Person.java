/**
 * 
 */
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
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	private String name;
	@Column(name = "lastname")
	private String lastName;
	private String dni;
	private String apartmentID;
	
	public Person() {
	}
	
	public Person(String name, String lastName, String dni, String apartmentID) {
		this.name = name;
		this.lastName = lastName;
		this.dni = dni;
		this.apartmentID = apartmentID;
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
	public String getDNI() {
		return dni;
	}
	public String getApartmentID() {
		return apartmentID;
	}

    @Override
    public String toString() {
        return String.format(
                "Person[name=%d, last name='%s', dni='%s', apartmentID='%s']",
                name, lastName, dni, apartmentID);
    }

}
