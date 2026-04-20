package com.ub.csi142.transport.model;

public class Person {
    private final String id;
    private final String fullName;
    private final String phone;

    public Person(String id, String fullName, String phone) {
        if (isBlank(id) || isBlank(fullName) || isBlank(phone)) {
            throw new IllegalArgumentException("id, fullName, and phone cannot be blank.");
        }
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
    }

    public String getId() { return id; }
    public String getFullName() { return fullName; }
    public String getPhone() { return phone; }

    private static boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }

    @Override
    public String toString() {
        return fullName + " (" + id + ")";
    }
}
