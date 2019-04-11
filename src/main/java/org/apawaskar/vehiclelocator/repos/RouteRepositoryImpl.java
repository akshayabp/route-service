package org.apawaskar.vehiclelocator.repos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apawaskar.vehiclelocator.domain.Log;
import org.apawaskar.vehiclelocator.domain.Route;
import org.apawaskar.vehiclelocator.domain.RouteInfo;
import org.apawaskar.vehiclelocator.domain.RouteSearchRequest;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class RouteRepositoryImpl implements RouteRepository {

	@Autowired
	private MongoOperations mongo;

	@Override
	public String save(Route route) {
		mongo.save(route);
		return route.getRouteId();
	}

	@Override
	public Route find(String routeId) {
		Route route = mongo.findById(routeId, Route.class);
		return route;
	}

	@Override
	public void addLog(String routeId, Log log) {

		Criteria findCriteria = Criteria.where("_id").is(new ObjectId(routeId));

		Update update = new Update();
		update.push("logs", log);
		mongo.updateFirst(Query.query(findCriteria), update, Route.class);

	}

	@Override
	public List<Route> getRoutes() {

		Query query = new Query();

		query.fields().include("routeId");
		query.fields().include("source");
		query.fields().include("destination");
		query.fields().include("driverId");
		query.fields().include("vehcileId");
		List<Route> routes = mongo.find(query, Route.class);
		return routes;
	}

	@Override
	public List<Route> getRoutes(RouteSearchRequest request) {
		Query query = new Query();

		query.fields().include("routeId");
		query.fields().include("source");
		query.fields().include("destination");
		query.fields().include("driverId");
		query.fields().include("vehcileId");

		Map<String, Object> queryParams = new HashMap<String, Object>();

		if (request.getDriverId() != 0l) {
			queryParams.put("driverId", request.getDriverId());
		}

		if (request.getVehiceId() != 0l) {
			queryParams.put("vehcileId", request.getVehiceId());
		}

		Criteria queryCriteria = null;

		for (String queryParamKey : queryParams.keySet()) {
			Object queryParamValue = queryParams.get(queryParamKey);

			if (queryCriteria == null) {
				queryCriteria = Criteria.where(queryParamKey).is(queryParamValue);
			} else {
				queryCriteria = queryCriteria.and(queryParamKey).is(queryParamValue);
			}

		}

		query.addCriteria(queryCriteria);

		List<Route> routes = mongo.find(query, Route.class);
		return routes;
	}

	@Override
	public Route getShortInfo(String routeId) {
		Query query = new Query();

		query.fields().include("routeId");
		query.fields().include("source");
		query.fields().include("destination");
		query.fields().include("driverId");
		query.fields().include("vehcileId");

		Map<String, Object> queryParams = new HashMap<String, Object>();
		
		queryParams.put("routeId", routeId);

		Criteria queryCriteria = null;

		for (String queryParamKey : queryParams.keySet()) {
			Object queryParamValue = queryParams.get(queryParamKey);

			if (queryCriteria == null) {
				queryCriteria = Criteria.where(queryParamKey).is(queryParamValue);
			} else {
				queryCriteria = queryCriteria.and(queryParamKey).is(queryParamValue);
			}

		}

		query.addCriteria(queryCriteria);
		
		List<Route> routes = mongo.find(query, Route.class);

		Route route = null;
		
		if(CollectionUtils.isNotEmpty(routes)){
			route= routes.get(0);
		}
		
		return route;
	}

}
