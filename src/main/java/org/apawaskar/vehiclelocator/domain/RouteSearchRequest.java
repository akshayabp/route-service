package org.apawaskar.vehiclelocator.domain;

public class RouteSearchRequest {

	private long driverId;
	
	private long vehiceId;

	public long getDriverId() {
		return driverId;
	}

	public void setDriverId(long driverId) {
		this.driverId = driverId;
	}

	public long getVehiceId() {
		return vehiceId;
	}

	public void setVehiceId(long vehiceId) {
		this.vehiceId = vehiceId;
	}
}
