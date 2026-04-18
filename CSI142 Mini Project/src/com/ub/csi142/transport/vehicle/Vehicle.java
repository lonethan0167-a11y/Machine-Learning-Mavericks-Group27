package com.ub.csi142.transport.vehicle;

public class Vehicle {
    protected String regNumber;
    protected int seatCapacity;

    public Vehicle(String regNumber, int seatCapacity) {
        if (regNumber == null || regNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("regNumber cannot be blank.");
        }
        if (seatCapacity <= 0) {
            throw new IllegalArgumentException("seatCapacity must be > 0.");
        }
        this.regNumber = regNumber;
        this.seatCapacity = seatCapacity;
    }

    public String getRegNumber() { return regNumber; }
    public int getSeatCapacity() { return seatCapacity; }

    public String describe() {
        return "Vehicle " + regNumber + " | Seats: " + seatCapacity;
    }

    @Override
    public String toString() {
        return describe();
    }
}