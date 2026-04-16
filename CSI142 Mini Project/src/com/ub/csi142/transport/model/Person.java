package com.ub.csi142.transport.model;

public abstract class Person {
    private String name;
    public Person(String name){
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public abstract String getRole();
}
