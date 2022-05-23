package com.proj2.model.abstraction;

public class AbstractVehicle extends AbstractEntity{

    private String name;
    private double modifier;

    public AbstractVehicle(String name, double modifier) {
        this.name = name;
        this.modifier = modifier;
    }

    public String getName() {
        return name;
    }

    public double getModifier() {
        return modifier;
    }

}
