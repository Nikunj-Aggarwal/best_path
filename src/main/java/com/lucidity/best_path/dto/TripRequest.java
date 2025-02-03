package com.lucidity.best_path.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
//Request for trip for rider
public class TripRequest {
    private List<Orders> orders;
    Location currentLocation; //current Location of rider

    public List<Orders> getOrders() {
        return orders;
    }

    public TripRequest(List<Orders> orders, Location currentLocation) {
        this.orders = orders;
        this.currentLocation = currentLocation;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }
}
