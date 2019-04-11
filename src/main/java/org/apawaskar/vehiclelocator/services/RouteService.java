package org.apawaskar.vehiclelocator.services;

import org.apawaskar.vehiclelocator.domain.RouteInfo;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

public interface RouteService {

	//@Cacheable("routeCache")
	RouteInfo getRouteInfo(String routeId);
	
	//@CacheEvict("routeCache")
	void removeRouteInfo(String routeId);
	
}
