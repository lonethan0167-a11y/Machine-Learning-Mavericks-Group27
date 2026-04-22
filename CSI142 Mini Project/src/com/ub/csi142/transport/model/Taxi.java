package com.ub.csi142.transport.model;

public class Taxi extends Vehicle{
    private Driver driver;
    String rankName;

    public Taxi(String regNumber, int seatCapacity, Driver driver, String rankName){
        super(regNumber, seatCapacity);
        if(driver == null) throw new IllegalArgumentException("driver cannot be null.");
        if(rankName == null || rankName.trim().isEmpty()) throw new IllegalArgumentException("rankName cannot be blank.");  
        this.driver = driver;
        this.rankName = rankName;
    }

    public Driver getDriver() { return driver; }
    public String getRankName() { return rankName; }

    @Override
    public String describe(){
        return "Taxi " + regNumber + " | Seats: " + seatCapacity + " | Driver: " + driver.getFullName();
    }

}
