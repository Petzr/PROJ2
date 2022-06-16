package com.proj2.model.vehicles;

import com.proj2.model.abstraction.AbstractVehicle;

public class PublicTransport extends AbstractVehicle
{
    @Override
    public double getModifier() {
        return 12.5;
    }

    @Override
    public String getName()
    {
        return "Public Transport";
    }
}
