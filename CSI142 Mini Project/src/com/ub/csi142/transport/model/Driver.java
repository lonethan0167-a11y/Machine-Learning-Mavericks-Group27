package com.ub.csi142.transport.model;

public class Driver extends Person {
    private final String licenseNumber;

    public Driver(String id, String fullName, String phone, String licenseNumber) {
        super(id, fullName, phone);
        if (isBlank(licenseNumber)) {
            throw new IllegalArgumentException("License number cannot be blank.");
        }
        this.licenseNumber = licenseNumber;
    }

    public String getLicenseNumber() { return licenseNumber; }

    @Override
    public String toString() {
        return getFullName() + " (" + getId() + ") - License: " + licenseNumber;
    }

    private static boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }
}

