package com.proj2.model.vehicles;

import com.proj2.model.abstraction.AbstractVehicle;

public class DieselCar extends AbstractVehicle
{
    @Override
    public double getModifier() {
        return 3;
    }

    @Override
    public String getName()
    {
        return "Diesel Car";
    }
}
