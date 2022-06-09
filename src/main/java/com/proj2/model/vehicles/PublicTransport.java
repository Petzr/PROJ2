package com.proj2.model.vehicles;

public class PublicTransport extends AbstractVehicle {

    private final String name = "Public Transport";
    private final double modifier = 0;
    @Override
    public double getModifier() {
        return 0;
    }
}
