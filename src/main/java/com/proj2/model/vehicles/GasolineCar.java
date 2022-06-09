package com.proj2.model.vehicles;

public class GasolineCar extends AbstractVehicle {

    private final String name = "Gasoline Car";
    private final double modifier = 2;
    @Override
    public double getModifier() {
        return 2;
    }
}
