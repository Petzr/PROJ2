package com.proj2.model;

import com.proj2.model.abstraction.AbstractVehicle;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Travel {
    private int points;
    private String date;

    public Travel(AbstractVehicle vehicle, int aantalKM) {
        // formule voor het berekenen van punten
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        this.date = formatter.format(calendar.getTime());

        points = (int) (aantalKM * vehicle.getModifier());
    }

    public int getPoints() {
        return points;
    }

    public String getDate()
    {
        return date;
    }
}
