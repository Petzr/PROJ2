package com.proj2.model.person;

import com.proj2.model.Travel;
import com.proj2.model.abstraction.AbstractPerson;
import com.proj2.model.vehicles.AbstractVehicle;

import java.util.ArrayList;

public class User extends AbstractPerson {

    private final ArrayList<Travel> travels;
    private Integer points;


    public User(String name, String email, String password) {
        super(name, email, password);
        this.points = 0;
        this.travels = new ArrayList<>();
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public void newTravel(AbstractVehicle vehicle, int aantalKM) {
        Travel travel = new Travel(vehicle, aantalKM);
        points += travel.getPoints();
        travels.add(travel);
        updateObservers();
    }

    private void updateObservers() {
        setChanged();
        notifyObservers();
    }

}
