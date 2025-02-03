package com.lucidity.best_path.dto;

import java.util.List;

public class BestPathResponse {
    private double totalTime;
    private List<String> path;

    public BestPathResponse(double totalTime, List<String> path) {
        this.totalTime = totalTime;
        this.path = path;
    }

    public double getTotalTime() {
        return totalTime;
    }

    public List<String> getPath() {
        return path;
    }
}
