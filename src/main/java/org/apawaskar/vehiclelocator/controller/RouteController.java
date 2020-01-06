package org.apawaskar.vehiclelocator.controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apawaskar.vehiclelocator.domain.Log;
import org.apawaskar.vehiclelocator.domain.Route;
import org.apawaskar.vehiclelocator.domain.RouteInfo;
import org.apawaskar.vehiclelocator.domain.RouteSearchRequest;
import org.apawaskar.vehiclelocator.repos.RouteRepository;
import org.apawaskar.vehiclelocator.services.RouteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@Transactional
public class RouteController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RouteController.class);

	@Autowired
	private RouteRepository routeRepository;
	
	@Autowired
	private RouteService routeService;
	
	@RequestMapping(value="/route",  method=RequestMethod.POST, consumes="application/json")
	public String createRoute(@RequestBody Route route){
		String routeId = routeRepository.save(route);		
		LOGGER.info("Route created:{}"+ route);
		return routeId;
	}
	
	@RequestMapping("/route/{id}")
	public Route getRoute(@PathVariable("id") String routeId){			
		Route route =routeRepository.find(routeId);		
		return route;
	}
	
	@RequestMapping("/route/{id}/shortinfo")
	public Route getRouteInfo(@PathVariable("id") String routeId){
		Route savedRoute = routeRepository.getShortInfo(routeId);	
		LOGGER.info("Route info for route id {} : {}", routeId, savedRoute);
		return savedRoute;
	}
	
	
	@RequestMapping("/routes")
	public List<Route> getRoutes(@RequestParam(value="vehicleId", required=false) String vehicleId,
			@RequestParam(value="driverId", required=false) String driverId){
		
		RouteSearchRequest request = new RouteSearchRequest();
		
		long driverIdLong =getLong(driverId);
		request.setDriverId(driverIdLong);
		
		long vehicleIdLong = getLong(vehicleId);
		request.setVehiceId(vehicleIdLong);		
		
		return routeRepository.getRoutes(request);
	}
	
	@RequestMapping("/allroutes")
	public List<Route> getAllRoutes(){
		return routeRepository.getRoutes();
	}
	
	@RequestMapping(value="/route/{id}/log", method=RequestMethod.PUT, consumes="application/json")
	public Log updateLog(@PathVariable("id") String routeId, @RequestBody Log log){		
		routeRepository.addLog(routeId, log);
		LOGGER.info("Updated log to route id {}: {}", routeId, log);		
		return log;
	}
	
	private long getLong(String strValue){
		long longVal = 0l;
		
		if(StringUtils.isNumeric(strValue)){
			try{
				longVal = Long.parseLong(strValue);
			}catch(NumberFormatException e){
				
			}
			
		}
		
		return longVal;
	}
}
