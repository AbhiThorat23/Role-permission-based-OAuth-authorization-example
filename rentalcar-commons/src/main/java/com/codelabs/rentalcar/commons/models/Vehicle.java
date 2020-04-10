package com.codelabs.rentalcar.commons.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Vehicle {
	@Id
	@GeneratedValue
	private int id;
	private String make;
	private String model;
	private String type;
	private int year;

}
