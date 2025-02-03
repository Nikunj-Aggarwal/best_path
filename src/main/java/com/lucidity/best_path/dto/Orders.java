package com.lucidity.best_path.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//Order details for rider
public class Orders {

    private Customer customer;
    private Restaurant restaurant;
    private double preparationTime;
    private boolean visitedCustomer = false;
    private boolean visitedRestaurant = false;

    public Customer getCustomer() {
        return customer;
    }

    public Orders(Customer customer, Restaurant restaurant, double preparationTime, boolean visitedCustomer, boolean visitedRestaurant) {
        this.customer = customer;
        this.restaurant = restaurant;
        this.preparationTime = preparationTime;
        this.visitedCustomer = visitedCustomer;
        this.visitedRestaurant = visitedRestaurant;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public double getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(double preparationTime) {
        this.preparationTime = preparationTime;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "customer=" + customer +
                ", restaurant=" + restaurant +
                ", preparationTime=" + preparationTime +
                ", visitedCustomer=" + visitedCustomer +
                ", visitedRestaurant=" + visitedRestaurant +
                '}';
    }

    public boolean isVisitedCustomer() {
        return visitedCustomer;
    }

    public void setVisitedCustomer(boolean visitedCustomer) {
        this.visitedCustomer = visitedCustomer;
    }

    public boolean isVisitedRestaurant() {
        return visitedRestaurant;
    }

    public void setVisitedRestaurant(boolean visitedRestaurant) {
        this.visitedRestaurant = visitedRestaurant;
    }
}
