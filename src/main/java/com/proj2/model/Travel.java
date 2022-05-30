package com.proj2.model;

import com.proj2.model.abstraction.AbstractVehicle;

public class Travel {
    private int points;

    public Travel(AbstractVehicle vehicle, int aantalKM) {
        // formule voor het berekenen van punten
        points = (int) (aantalKM * vehicle.getModifier());
    }

    public int getPoints() {
        return points;
    }
}
