package com.proj2.model.abstraction;

import java.util.Observable;

public abstract class AbstractVehicle extends Observable
{
    public abstract double getModifier();
    public String getName() {
        return String.valueOf(getClass()).substring(31);
    }
}
