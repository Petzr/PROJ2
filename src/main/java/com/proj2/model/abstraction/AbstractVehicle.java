package com.proj2.model.abstraction;

public abstract class AbstractVehicle extends AbstractEntity{

    public double calculatePoint() {
        return getModifier();
    }
    public abstract double getModifier();

}
