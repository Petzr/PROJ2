package com.proj2;

public class User extends Person {

    private double points;

    public User(String name, String email, String password, String residence, int points) {
        super(name, email, password, residence, points);
    }

    public void distanceTravelled(String vehicle, double km) { // int or void?

        points = Vehicle.calculatePoints(vehicle, km);

    }
}
