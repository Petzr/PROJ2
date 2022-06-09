package com.proj2.model.vehicles;

import com.proj2.model.abstraction.AbstractEntity;

public abstract class AbstractVehicle extends AbstractEntity
{


    public double calculatePoint() {
        return getModifier();
    }
    public abstract double getModifier();


}
