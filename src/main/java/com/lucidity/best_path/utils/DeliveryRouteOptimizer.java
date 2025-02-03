package com.lucidity.best_path.utils;

import com.lucidity.best_path.dto.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.lucidity.best_path.utils.TimeDistanceCalculator.travelTime;

public class DeliveryRouteOptimizer {
    static class Result {
        double time;
        List<String> path;

        Result(double time, List<String> path) {
            this.time = time;
            this.path = path;
        }
    }

    static String getMemoKey(List<Orders> orders, boolean consume) {
        StringBuilder key = new StringBuilder();
        for (Orders order : orders) {
            key.append(order.isVisitedRestaurant() ? "1" : "0");
            key.append(order.isVisitedCustomer() ? "1" : "0");
        }
        return key.toString() + consume;
    }

    //
    static Result findOptimalPath(List<Orders> orders, double time, boolean isCustomer, Location previousLocation, List<String> currentPath, Map<String, DeliveryRouteOptimizer.Result> memo) {
        if (orders.stream().allMatch(order -> order.isVisitedCustomer() && order.isVisitedRestaurant())) {
            return new Result(time, new ArrayList<>(currentPath));
        }

        String memoKey = getMemoKey(orders, isCustomer);
        System.out.println(memo);
        if (memo.containsKey(memoKey)) {
            return memo.get(memoKey);
        }

        Result minResult = new Result(Double.MAX_VALUE, new ArrayList<>());

        for (Orders order : orders) {
            if (!order.isVisitedRestaurant()) {
                Location currentPoint = order.getRestaurant().getRestaurantLocation();
                double travelTime = previousLocation == null ? 0 : travelTime(
                        previousLocation,
                        currentPoint
                );

                double totalTime = time+travelTime;
                if (order.getPreparationTime() > totalTime) {
                    totalTime += (order.getPreparationTime()-totalTime);
                }

                order.setVisitedRestaurant(true);
                currentPath.add("Restaurant " + order.getRestaurant().toString());

                Result result = findOptimalPath(orders, totalTime, false, currentPoint, currentPath, memo);

                if (result.time < minResult.time) {
                    minResult = result;
                }

                currentPath.remove(currentPath.size() - 1);
                order.setVisitedRestaurant(false);
            }
        }

        // Deliver orders to customers
        for (Orders order : orders) {
            if (order.isVisitedRestaurant() && !order.isVisitedCustomer()) {
                Location currentPoint = order.getCustomer().getCustomerLocation();
                double travelTime = previousLocation == null ? 0 : travelTime(previousLocation, currentPoint);
                double totalTime = time + travelTime;

                order.setVisitedCustomer(true);
                currentPath.add("Customer " + order.getCustomer().toString());

                Result result = findOptimalPath(orders, totalTime, true, currentPoint, currentPath, memo);

                if (result.time < minResult.time) {
                    minResult = result;
                }

                currentPath.remove(currentPath.size() - 1);
                order.setVisitedCustomer(false);
            }
        }

        memo.put(memoKey, minResult);
        return minResult;
    }

    public BestPathResponse findBestPath(TripRequest tripRequest) {
        List<Orders> orders = tripRequest.getOrders();

        Double minMealPrepTime = Double.MAX_VALUE;
        int index = -1;

        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getPreparationTime() < minMealPrepTime) {
                minMealPrepTime = orders.get(i).getPreparationTime();
                index = i;
            }
        }

        Location nextPoint = orders.get(index).getRestaurant().getRestaurantLocation();
        List<String> currentPath = new ArrayList<>();
        Map<String, Result> memo = new HashMap<>();

        double time = travelTime(
                nextPoint,
                tripRequest.getCurrentLocation()
        ); // Start from the current Location to restaurant

        if (time < minMealPrepTime) {
            time += (minMealPrepTime-time); //waiting time for rider
        }
        Result result = findOptimalPath(orders, time, false, nextPoint, currentPath, memo);

        return new BestPathResponse(result.time, result.path);
    }
}