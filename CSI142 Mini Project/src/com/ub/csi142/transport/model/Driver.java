package com.ub.csi142.transport.model;

public class Driver extends Person {
    private String licenceNumber;

    public Driver(String id, String fullName, String phone, String licenceNumber) {
        super(id, fullName, phone);
        if (licenceNumber == null || licenceNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("licenceNumber cannot be blank.");
        }
        this.licenceNumber = licenceNumber;
    }

    public String getLicenceNumber() { return licenceNumber; }

    @Override
    public String toString() {
        return "Driver: " + super.toString() + " | Licence: " + licenceNumber;
    }
}