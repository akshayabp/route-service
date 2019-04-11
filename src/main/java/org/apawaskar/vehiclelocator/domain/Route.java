package org.apawaskar.vehiclelocator.domain;

import java.util.Collection;
import java.util.LinkedHashSet;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Route {
	
	@Id
	private String routeId;
	
	private Location source;
	
	private Location destination;
	
	private Collection<Log> logs = new LinkedHashSet<Log>();
	
	private long driverId;
	
	private long vehcileId;

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

	public Collection<Log> getLogs() {
		return logs;
	}

	public void setLogs(Collection<Log> logs) {
		this.logs = logs;
	}

	public long getDriverId() {
		return driverId;
	}

	public void setDriverId(long driverId) {
		this.driverId = driverId;
	}

	public long getVehcileId() {
		return vehcileId;
	}

	public void setVehcileId(long vehcileId) {
		this.vehcileId = vehcileId;
	}

	public String getRouteId() {
		return routeId;
	}

	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}

	@Override
	public String toString() {
		return "Route [routeId=" + routeId + ", source=" + source + ", destination=" + destination + ", logs=" + logs
				+ ", driverId=" + driverId + ", vehcileId=" + vehcileId + "]";
	}

}
