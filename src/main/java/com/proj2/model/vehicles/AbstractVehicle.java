package com.proj2.model.vehicles;

import com.proj2.model.abstraction.AbstractEntity;

public abstract class AbstractVehicle extends AbstractEntity
{
    public abstract double getModifier();
    public String getName() {
        return String.valueOf(getClass()).substring(31);
    }
}
