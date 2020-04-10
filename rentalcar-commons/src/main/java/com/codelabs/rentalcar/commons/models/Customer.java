package com.codelabs.rentalcar.commons.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Customer {
	@Id
	@GeneratedValue
	private int id;
	private String firstName;
	private String lastName;
	private String dlNumber;
	private String zipCode;
}
