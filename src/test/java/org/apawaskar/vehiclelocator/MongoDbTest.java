package org.apawaskar.vehiclelocator;

import java.util.Arrays;
import java.util.List;

import org.apawaskar.vehiclelocator.config.AppTestConfig;
import org.apawaskar.vehiclelocator.domain.Route;
import org.apawaskar.vehiclelocator.repos.RouteRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes={ AppTestConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class MongoDbTest {

	

	@Autowired MongoOperations mongoOps;
	
	@Autowired
	private RouteRepository routeRepository;
	
	
	
	
	
	@Test
	public void testFindRoute(){
		Route savedRoute = routeRepository.find("5ab9b3644effa818a01e7b21");		
		Assert.assertNotNull(savedRoute);
	}
	
	@Test
	public void testFindAll(){
		List<Route> routes = routeRepository.getRoutes();
		Assert.assertNotNull(routes);
	}
	
	
	
	
	
}