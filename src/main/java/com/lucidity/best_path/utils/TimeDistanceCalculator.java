package com.lucidity.best_path.utils;

import com.lucidity.best_path.constants.Constants;
import com.lucidity.best_path.dto.Location;

import static com.lucidity.best_path.constants.Constants.SPEED;
import static java.lang.Math.*;
import static java.lang.Math.sqrt;

public class TimeDistanceCalculator {

    static double haversineDistance(Location location1, Location location2) {
        double dLat = toRadians(location2.getLatitude() - location1.getLatitude());
        double dLon = toRadians(location2.getLongitude() - location1.getLongitude());
        double a = sin(dLat / 2) * sin(dLat / 2) +
                cos(toRadians(location1.getLatitude())) * cos(toRadians(location2.getLatitude())) *
                        sin(dLon / 2) * sin(dLon / 2);
        double c = 2 * atan2(sqrt(a), sqrt(1 - a));
        return Constants.EARTH_RADIUS * c;
    }

    static double travelTime(Location loc1, Location loc2) {
        return haversineDistance(loc1, loc2) / SPEED;
    }
}
