package com.proj2.model.abstraction;

import java.util.Observable;

public abstract class AbstractVehicle extends Observable
{
    public abstract double getModifier();
    public abstract String getName();


    // Template Method Pattern wordt hier toegepast.
    public String description()
    {
        return String.format("de voertuig %s heeft een modifier van %.1f", getName(), getModifier());
    }
}
