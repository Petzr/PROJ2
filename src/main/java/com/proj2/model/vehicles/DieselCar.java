package com.proj2.model.vehicles;

public class DieselCar extends AbstractVehicle {

    private final String name = "Diesel Car";
    private final double modifier = 2;
    @Override
    public double getModifier() {
        return 2;
    }

    public String getName()
    {
        return name;
    }
}
