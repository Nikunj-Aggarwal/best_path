package com.lucidity.best_path.dto;

public class Location {
    double latitude;
    double longitude;

    public double getLatitude() {
        return latitude;
    }

    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return "Location{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
