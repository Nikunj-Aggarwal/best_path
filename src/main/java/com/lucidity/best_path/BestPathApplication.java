package com.lucidity.best_path;

import com.lucidity.best_path.dto.*;
import com.lucidity.best_path.utils.DeliveryRouteOptimizer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class BestPathApplication {

	public static void main(String[] args) {
		//Testcase 1
		Restaurant restaurant1 = new Restaurant(new Location(0.0,1.0));
		Restaurant restaurant2 = new Restaurant(new Location(1.0,0.0));
		Customer customer2  = new Customer(new Location(2.0,1.0));
		Customer customer1 = new Customer(new Location(100.0,100.0));

		Orders order1 = new Orders(customer1, restaurant1, 1.0, false, false);
		Orders order2 = new Orders(customer2, restaurant2, 1.0, false, false);
		TripRequest tripRequest = new TripRequest(Arrays.asList(order1, order2), new Location(0.0, 0.0));
		DeliveryRouteOptimizer deliveryRouteOptimizer = new DeliveryRouteOptimizer();
		BestPathResponse bestPathResponse = deliveryRouteOptimizer.findBestPath(tripRequest);
		System.out.println("Total Time: "+bestPathResponse.getTotalTime());
		System.out.println("Best Path: "+bestPathResponse.getPath().toString());

		SpringApplication.run(BestPathApplication.class, args);
	}

}
