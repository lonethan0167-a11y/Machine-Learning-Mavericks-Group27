package com.ub.csi142.transport.model;

public class Tripcombi {
    private String tripId;
    private Routecombi route;   // composition
    private Combi combi;   // composition
    private int seatsAvailable;

    public Tripcombi(String tripId, Routecombi route, Combi combi, int seatsAvailable) {
        if (tripId == null || tripId.trim().isEmpty()) throw new IllegalArgumentException("tripId cannot be blank.");
        if (route == null) throw new IllegalArgumentException("route cannot be null.");
        if (combi == null) throw new IllegalArgumentException("combi cannot be null.");
        if (seatsAvailable < 0) throw new IllegalArgumentException("seatsAvailable cannot be negative.");

        this.tripId = tripId;
        this.route = route;
        this.combi = combi;
        this.seatsAvailable = seatsAvailable;
    }

    public String getTripId() { return tripId; }
    public Routecombi getRoute() { return route; }
    public Combi getCombi() { return combi; }
    public int getSeatsAvailable() { return seatsAvailable; }

    public boolean bookSeats(int seats) {
        if (seats <= 0) return false;
        if (seats > seatsAvailable) return false;
        seatsAvailable -= seats;
        return true;
    }

    public void cancelSeats(int seats) {
        if (seats > 0) seatsAvailable += seats;
    }

    @Override
    public String toString() {
        return "Trip " + tripId + " | " + route + " | Seats left: " + seatsAvailable;
    }
}