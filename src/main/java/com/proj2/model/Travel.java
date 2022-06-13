package com.proj2.model;

import com.proj2.model.vehicles.AbstractVehicle;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Travel {
    private int points;
    private String date;

    public Travel(AbstractVehicle vehicle, int aantalKM) {
        // formule voor het berekenen van punten
        points = (int) (aantalKM * vehicle.getModifier());

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        this.date = formatter.format(calendar.getTime());
    }

    public int getPoints() {
        return points;
    }
}
