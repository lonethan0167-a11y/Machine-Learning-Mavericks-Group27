package com.ub.csi142.transport.model;

import java.util.ArrayList;
import java.util.List;

public class Vehicle {
    private final String id;
    private final String type; // e.g., "Taxi" or "Combi"
    private final int capacity;
    private final Driver driver;
    private final List<Passenger> passengers;

    public Vehicle(String id, String type, int capacity, Driver driver) {
        if (isBlank(id) || isBlank(type)) {
            throw new IllegalArgumentException("id and type cannot be blank.");
        }
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive.");
        }
        if (driver == null) {
            throw new IllegalArgumentException("Driver cannot be null.");
        }
        this.id = id;
        this.type = type;
        this.capacity = capacity;
        this.driver = driver;
        this.passengers = new ArrayList<>();
    }

    public String getId() { return id; }
    public String getType() { return type; }
    public int getCapacity() { return capacity; }
    public Driver getDriver() { return driver; }
    public List<Passenger> getPassengers() { return passengers; }

    public boolean addPassenger(Passenger passenger) {
        if (passengers.size() < capacity) {
            return passengers.add(passenger);
        }
        return false; // vehicle is full
    }

    public boolean removePassenger(Passenger passenger) {
        return passengers.remove(passenger);
    }

    public int getAvailableSeats() {
        return capacity - passengers.size();
    }

    @Override
    public String toString() {
        return type + " (" + id + ") driven by " + driver.getFullName() +
               " | Capacity: " + capacity +
               " | Occupied: " + passengers.size();
    }

    private static boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }
}
