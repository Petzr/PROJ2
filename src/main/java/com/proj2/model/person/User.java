package com.proj2.model.person;

import com.proj2.model.Travel;
import com.proj2.model.abstraction.AbstractPerson;
import com.proj2.model.abstraction.AbstractVehicle;

import java.util.ArrayList;

public class User extends AbstractPerson {

    private int points;
    private ArrayList<Travel> travels;
    public void addPoints(){}

    public void newTravel(AbstractVehicle vehicle, int aantalKM) {
        Travel travel = new Travel(vehicle, aantalKM);
        points += travel.getPoints();
        travels.add(travel);
    }

}
