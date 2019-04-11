package org.apawaskar.vehiclelocator.repos;

import java.util.List;

import org.apawaskar.vehiclelocator.domain.Log;
import org.apawaskar.vehiclelocator.domain.Route;
import org.apawaskar.vehiclelocator.domain.RouteInfo;
import org.apawaskar.vehiclelocator.domain.RouteSearchRequest;

public interface RouteRepository {

	 String save(Route route);
	
	 Route find(String routeId);
	 
	 Route getShortInfo(String routeId);
	
	 void addLog(String route, Log log);
	 
	 List<Route> getRoutes();
	 
	 List<Route> getRoutes(RouteSearchRequest request);
	 
	 
	 
}
