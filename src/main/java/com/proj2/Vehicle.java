package com.proj2;

import java.util.HashMap;

public class Vehicle
{
    private static HashMap<String, Integer> vehicles;

    public static double calculatePoints(String vehicle, double km) {
        for (String v : vehicles.keySet()) {
            if (v.equals(vehicle)) {
                return vehicles.get(vehicle) * km;
            }
        }
        return -1;
    }
}
