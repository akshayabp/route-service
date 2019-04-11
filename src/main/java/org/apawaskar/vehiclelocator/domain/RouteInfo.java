package org.apawaskar.vehiclelocator.domain;

import java.io.Serializable;

public class RouteInfo  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String routeId;
	
	private Location source;
	
	private Location destination;
	
	private Vehicle vehicle;
	
	private Driver driver;

	public String getRouteId() {
		return routeId;
	}

	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}

	public Location getSource() {
		return source;
	}

	public void setSource(Location source) {
		this.source = source;
	}

	public Location getDestination() {
		return destination;
	}

	public void setDestination(Location destination) {
		this.destination = destination;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	@Override
	public String toString() {
		return "RouteInfo [routeId=" + routeId + ", source=" + source + ", destination=" + destination + ", vehicle="
				+ vehicle + ", driver=" + driver + "]";
	}
	
}
