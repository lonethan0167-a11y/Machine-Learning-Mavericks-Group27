package com.ub.csi142.transport.model;

public class Passenger extends Person {
    private boolean student;

    public Passenger(String id, String fullName, String phone, boolean student) {
        super(id, fullName, phone);
        this.student = student;
    }

    public boolean isStudent() { return student; }

    @Override
    public String toString() {
        return "Passenger: " + super.toString() + (student ? " [Student]" : "");
    }
}