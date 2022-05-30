package com.proj2.model.person;

import com.proj2.model.Travel;
import com.proj2.model.abstraction.AbstractPerson;
import com.proj2.model.abstraction.AbstractVehicle;

import java.util.ArrayList;

public class User extends AbstractPerson {

    private int points;

    public User(String name, String email, String password) {
        super(name, email, password);
        this.points = 0;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
  
    private ArrayList<Travel> travels;
    public void addPoints(){}

    public void newTravel(AbstractVehicle vehicle, int aantalKM) {
        Travel travel = new Travel(vehicle, aantalKM);
        points += travel.getPoints();
        travels.add(travel);
    }

}
