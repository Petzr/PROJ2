package com.proj2.model.vehicles;

import com.proj2.model.abstraction.AbstractVehicle;

public class Bicycle extends AbstractVehicle
{
    @Override
    public double getModifier() {
        return 15;
    }

    @Override
    public String getName()
    {
        return "Bicycle";
    }
}
