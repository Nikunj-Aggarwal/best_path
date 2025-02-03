package com.lucidity.best_path.controllers;

import com.lucidity.best_path.dto.BestPathResponse;
import com.lucidity.best_path.dto.TripRequest;
import com.lucidity.best_path.services.OrderDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderDeliveryController {

    @Autowired
    OrderDeliveryService orderDeliveryService;

    @PostMapping("/get-best-path")
    public BestPathResponse getBestPath (@RequestBody TripRequest tripRequest) {
        return orderDeliveryService.findBestPath(tripRequest);
    }

}
