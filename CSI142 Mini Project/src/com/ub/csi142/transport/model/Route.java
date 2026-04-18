package com.ub.csi142.transport.model;

import com.ub.csi142.transport.vehicle.Combi;

public class Route {
    private String origin;
    private String destination;
    private double distanceKm;
    private double farePerKm;
    private Combi assignedCombi; // composition (Route has a Combi)

    public Route(String origin, String destination, double distanceKm, double farePerKm, Combi assignedCombi) {
        if (origin == null || origin.trim().isEmpty()) throw new IllegalArgumentException("origin cannot be blank.");
        if (destination == null || destination.trim().isEmpty()) throw new IllegalArgumentException("destination cannot be blank.");
        if (distanceKm <= 0) throw new IllegalArgumentException("distanceKm must be > 0.");
        if (farePerKm <= 0) throw new IllegalArgumentException("farePerKm must be > 0.");
        if (assignedCombi == null) throw new IllegalArgumentException("assignedCombi cannot be null.");

        this.origin = origin;
        this.destination = destination;
        this.distanceKm = distanceKm;
        this.farePerKm = farePerKm;
        this.assignedCombi = assignedCombi;
    }

    public double calculateFare() {
        return distanceKm * farePerKm;
    }

    public String getOrigin() { return origin; }
    public String getDestination() { return destination; }
    public Combi getAssignedCombi() { return assignedCombi; }

    @Override
    public String toString() {
        return origin + " -> " + destination + " (" + distanceKm + "km) | Fare: P" + String.format("%.2f", calculateFare());
    }
}