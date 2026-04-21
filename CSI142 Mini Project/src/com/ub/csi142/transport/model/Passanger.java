package com.ub.csi142.transport.model;

public class Passenger extends Person {
    private final String destination;
    private final boolean isStudent;

    public Passenger(String id, String fullName, String phone, String destination, boolean isStudent) {
        super(id, fullName, phone);
        if (isBlank(destination)) {
            throw new IllegalArgumentException("Destination cannot be blank.");
        }
        this.destination = destination;
        this.isStudent = isStudent;
    }

    public String getDestination() { return destination; }
    public boolean isStudent() { return isStudent; }

    @Override
    public String toString() {
        return getFullName() + " (" + getId() + ") -> " + destination +
               (isStudent ? " [Student]" : "");
    }

    private static boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }
}

