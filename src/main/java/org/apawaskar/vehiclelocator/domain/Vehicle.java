package org.apawaskar.vehiclelocator.domain;

import java.io.Serializable;


public class Vehicle implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;
	
	private String model;
	
	private String make;
	
	
	private String plate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", model=" + model + ", make=" + make + ", plate=" + plate + "]";
	}

	
}
