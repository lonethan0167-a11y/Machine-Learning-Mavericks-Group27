package com.ub.csi142.transport.model;

public class Routetaxi {
    private String origin;
    private String destination;
    private double distance;
    private double fare;
    private Taxi assignedTaxi;

    public Routetaxi(String origin, String destination, double distance, double fare, Taxi assignedTaxi){
        if(origin == null || origin.trim().isEmpty()) throw new IllegalArgumentException("origin cannot be blank.");
        if(destination == null || destination.trim().isEmpty()) throw new IllegalArgumentException("destination cannot be blank.");
        if(distance <= 0) throw new IllegalArgumentException("distance must be greater than 0.");
        if(fare <= 0) throw new IllegalArgumentException("fare must be greater than 0.");
        if(assignedTaxi == null) throw new IllegalArgumentException("assignedTaxi cannot be blank.");

        this.origin = origin;
        this.destination = destination;
        this.distance = distance;
        this.fare = fare;
        this.assignedTaxi = assignedTaxi;
    }

    public String getOrigin(){ return origin;}
    public String getDestination(){ return destination;}
    public double getDistance(){ return distance;}
    public double getFare(){ return fare;}
    public Taxi getAssignedTaxi(){ return assignedTaxi;}

    @Override
    public String toString() {
        return origin + " -> " + destination + "( " + distance + "km)" + " | Fare: P" + String.format("%.2f", fare);
    }

}
