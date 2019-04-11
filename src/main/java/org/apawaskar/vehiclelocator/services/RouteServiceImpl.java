package org.apawaskar.vehiclelocator.services;

import org.apawaskar.vehiclelocator.domain.Driver;
import org.apawaskar.vehiclelocator.domain.Route;
import org.apawaskar.vehiclelocator.domain.RouteInfo;
import org.apawaskar.vehiclelocator.domain.Vehicle;
import org.apawaskar.vehiclelocator.repos.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RouteServiceImpl implements RouteService {

	@Autowired
	private RouteRepository routeRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public RouteInfo getRouteInfo(String routeId) {

		System.out.println("Getting route info from db");

		RouteInfo routeInfo = new RouteInfo();

		Route route = routeRepository.find(routeId);

		routeInfo.setSource(route.getSource());
		routeInfo.setDestination(route.getDestination());

		Vehicle vehicle = getVehicle(route.getVehcileId());
		Driver driver = getDriver(route.getDriverId());

		routeInfo.setVehicle(vehicle);
		routeInfo.setDriver(driver);

		return routeInfo;
	}
	
	private Vehicle getVehicle(long vehicleId){
		Vehicle vehicle = null;
		
		 ResponseEntity<Vehicle> restExchange =
	                restTemplate.exchange(
	                        "http://vehicle-locator-management-service/vehicle/{id}",
	                        HttpMethod.GET,
	                        null, Vehicle.class, vehicleId);
		 
		 vehicle = restExchange.getBody();
		
		return vehicle;
	}
	
	private Driver getDriver(long driverId){
		ResponseEntity<Driver> restExchange =
                restTemplate.exchange(
                        "http://vehicle-locator-management-service/driver/{id}",
                        HttpMethod.GET,
                        null, Driver.class, driverId);
	 
	
	return restExchange.getBody();
	}

	@Override
	public void removeRouteInfo(String routeId) {
		// TODO Auto-generated method stub

	}

}
