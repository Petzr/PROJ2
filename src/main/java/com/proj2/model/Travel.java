package com.proj2.model;

import com.proj2.model.vehicles.AbstractVehicle;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Travel {
    private int points;
    private SimpleDateFormat date;

    public void setDate()
    {
        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        this.date = formatter;
    }

    public Travel(AbstractVehicle vehicle, int aantalKM) {
        // formule voor het berekenen van punten
        points = (int) (aantalKM * vehicle.getModifier());
        setDate();
    }

    public int getPoints() {
        return points;
    }
}
