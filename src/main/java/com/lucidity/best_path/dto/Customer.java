package com.lucidity.best_path.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
public class Customer {

    int customerId;

    public Location getCustomerLocation() {
        return customerLocation;
    }

    public void setCustomerLocation(Location customerLocation) {
        this.customerLocation = customerLocation;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerLocation=" + customerLocation +
                '}';
    }

    Location customerLocation;
    public Customer(Location customerLocation) {
        this.customerLocation = customerLocation;
    }
}
