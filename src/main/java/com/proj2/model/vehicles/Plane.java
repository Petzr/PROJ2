package com.proj2.model.vehicles;

public class Plane extends AbstractVehicle {

    private final String name = "Plane";
    private final double modifier = 8;
    @Override
    public double getModifier() {
        return 8;
    }
}
