package com.lucidity.best_path.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class Restaurant {

    private int restaurantId;
    private Location restaurantLocation;

    public Restaurant(Location restaurantLocation) {
        this.restaurantLocation = restaurantLocation;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantId=" + restaurantId +
                ", restaurantLocation=" + restaurantLocation +
                '}';
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Location getRestaurantLocation() {
        return restaurantLocation;
    }

    public void setRestaurantLocation(Location restaurantLocation) {
        this.restaurantLocation = restaurantLocation;
    }
}
