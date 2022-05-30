package com.proj2.model;

import com.proj2.model.abstraction.AbstractVehicle;

public class Travel {
    private double points;

    public Travel(AbstractVehicle vehicle, double aantalKM) {
        // formule voor het berekenen van punten
        points = aantalKM * vehicle.getModifier();
    }

    public double getPoints() {
        return points;
    }
}
