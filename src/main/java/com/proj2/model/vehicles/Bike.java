package com.proj2.model.vehicles;

public class Bike extends AbstractVehicle {

    private final String name = "Bike";
    private final double modifier = 0;

    @Override
    public double getModifier() {
        return 0;
    }
}
