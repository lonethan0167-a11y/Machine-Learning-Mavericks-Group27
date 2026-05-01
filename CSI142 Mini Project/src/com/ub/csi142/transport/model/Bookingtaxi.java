package com.ub.csi142.transport.model;

public class Bookingtaxi {
    public static int counter = 1;

    private String bookingId;
    private Passenger passenger;
    private Triptaxi trip;
    private int seats;

    public Bookingtaxi(Passenger passenger, Triptaxi trip, int seats) {
        this.bookingId = "BT" + (counter++);
        this.passenger = passenger;
        this.trip = trip;
        this.seats = seats;
    } 
    
    public String getBookingId() { return bookingId;}
    public Passenger getPassenger() { return passenger; }   
    public Triptaxi getTrip() { return trip; }
    public int getSeats() { return seats; }

    @Override
    public String toString() {
        return "Booking " + bookingId + " | " + passenger.getFullName()
                + " | Trip " + trip.getTripId() + " | Seats: " + seats;
    }

}
