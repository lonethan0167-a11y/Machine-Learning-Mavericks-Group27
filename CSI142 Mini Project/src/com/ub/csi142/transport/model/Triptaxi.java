package com.ub.csi142.transport.model;

public class Triptaxi {
    private String tripId;
    private Taxi taxi; // composition (Trip has a Taxi)
    private Routetaxi route;
    private int seatsAvailable;

    public Triptaxi(String tripId, Routetaxi route, Taxi taxi, int seatsAvailable) {
        if(tripId == null || tripId.trim().isEmpty()) throw new IllegalArgumentException("tripId cannot be blank.");
        if (taxi == null) throw new IllegalArgumentException("taxi cannot be null.");
        if (route == null) throw new IllegalArgumentException("route cannot be null.");
        if(seatsAvailable < 0) throw new IllegalArgumentException("seatsAvailable cannot be negative.");

        this.tripId = tripId;
        this.taxi = taxi;
        this.route = route;
        this.seatsAvailable = seatsAvailable;
    }

     public String getTripId() { return tripId; }
    public Routetaxi getRoute() { return route; }
    public Taxi getTaxi() { return taxi; }
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
