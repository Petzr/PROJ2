package com.proj2.service;

import com.proj2.model.abstraction.AbstractVehicle;

public class Logic {
    public static double calculatePoints(AbstractVehicle vehicle, int km) {
        return vehicle.getModifier() * km;
    }
}