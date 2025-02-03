package com.lucidity.best_path.services;

import com.lucidity.best_path.dto.BestPathResponse;
import com.lucidity.best_path.dto.TripRequest;
import com.lucidity.best_path.utils.DeliveryRouteOptimizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDeliveryService {

    @Autowired
    DeliveryRouteOptimizer deliveryRouteOptimizer;
    public BestPathResponse findBestPath(TripRequest tripRequest) {
        return deliveryRouteOptimizer.findBestPath(tripRequest);
    }
}
