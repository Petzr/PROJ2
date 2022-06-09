package com.proj2.model.vehicles;

public class ElectricCar extends AbstractVehicle {

    private final String name = "Electric Car";
    private final double modifier = 2;
    @Override
    public double getModifier() {
        return 2;
    }
}
