package com.proj2.model.vehicles;

import com.proj2.model.abstraction.AbstractVehicle;

public class ElectricCar extends AbstractVehicle {

    @Override
    public double getModifier() {
        return 2;
    }
}
