package com.proj2.model.vehicles;

import com.proj2.model.abstraction.AbstractVehicle;

public class Motorcycle extends AbstractVehicle {

    @Override
    public double getModifier() {
        return 13;
    }

    @Override
    public String getName() {
        return null;
    }
}
