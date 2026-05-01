package com.ub.csi142.transport.model;

public class Bookingcombi {
    private static int counter = 0;

    private String bookingId;
    private Passenger passenger;
    private Tripcombi trip;
    private int seats;

    public Bookingcombi(Passenger passenger, Tripcombi trip, int seats) {
        this.bookingId = "B" + (counter++);
        this.passenger = passenger;
        this.trip = trip;
        this.seats = seats;
    }

    public String getBookingId() { return bookingId; }
    public Passenger getPassenger() { return passenger; }
    public Tripcombi getTrip() { return trip; }
    public int getSeats() { return seats; }

    @Override
    public String toString() {
        return "Booking " + bookingId + " | " + passenger.getFullName()
                + " | Trip " + trip.getTripId() + " | Seats: " + seats;
    }
}