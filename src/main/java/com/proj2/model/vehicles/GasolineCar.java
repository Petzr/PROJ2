package com.proj2.model.vehicles;

import com.proj2.model.abstraction.AbstractVehicle;

public class GasolineCar extends AbstractVehicle
{
    @Override
    public double getModifier() {
        return 5;
    }

    @Override
    public String getName()
    {
        return "Gasoline Car";
    }
}
