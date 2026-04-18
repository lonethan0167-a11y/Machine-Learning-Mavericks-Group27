package com.ub.csi142.transport.vehicle;

import com.ub.csi142.transport.model.Driver;

public class Taxi extends Combi {

    public Taxi(String regNumber, int seatCapacity, Driver driver, String rankName) {
        super(regNumber, seatCapacity, driver, rankName);
    }

    @Override
    public String describe() {
        return "Taxi " + regNumber + " | Seats: " + seatCapacity + " | Driver: " + getDriver().getFullName();
    }
    
}