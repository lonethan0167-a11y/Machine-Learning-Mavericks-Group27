package com.ub.csi142.transport.model;

public class Booking {
    private static int counter = 1;

    private String bookingId;
    private Passenger passenger;
    private Trip trip;
    private int seats;

    public Booking(Passenger passenger, Trip trip, int seats) {
        this.bookingId = "B" + (counter++);
        this.passenger = passenger;
        this.trip = trip;
        this.seats = seats;
    }

    public String getBookingId() { return bookingId; }
    public Passenger getPassenger() { return passenger; }
    public Trip getTrip() { return trip; }
    public int getSeats() { return seats; }

    @Override
    public String toString() {
        return "Booking " + bookingId + " | " + passenger.getFullName()
                + " | Trip " + trip.getTripId() + " | Seats: " + seats;
    }
}