package com.proj2;

import java.util.HashMap;

public class Vehicle
{
    private HashMap<String, Double> vehicles = new HashMap<>();

    public Vehicle(HashMap<String, Double> vehicles) {
        this.vehicles = vehicles;
    }
    public Vehicle() {
        vehicles.put("auto", 1.0);
        vehicles.put("vliegtuig", 3.0);
        vehicles.put("helikopter", 3.0);
        vehicles.put("bus", 0.8);
        vehicles.put("fiets", 0.0);
        vehicles.put("tram", 0.3);
        vehicles.put("trein", 0.3);

    }

    public void addVehicle(String vehicleName, Double pointsOfVehicle) {
        vehicles.put(vehicleName, pointsOfVehicle);
    }

    public double calculatePoints() {
        return 5.0;

    }

    public double getPointsOfVehicle(String vehicleName) {
        try {
            return vehicles.get(vehicleName);
        } catch (Exception e) {
            return -1.0;
        }
    }
}
