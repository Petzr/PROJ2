package com.proj2.model.person;

import com.proj2.model.Reward;
import com.proj2.model.Travel;
import com.proj2.model.abstraction.AbstractPerson;
import com.proj2.model.abstraction.AbstractVehicle;
import com.proj2.service.Logic;

import java.util.ArrayList;

public class User extends AbstractPerson {

    private final ArrayList<Travel> travels;
    private Integer points;
    private final ArrayList<Reward> claimedRewards;


    public User(String name, String email, String password) {
        super(name, email, password);
        this.points = 0;
        this.travels = new ArrayList<>();
        this.claimedRewards = new ArrayList<>();
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
        Logic.get_organization().updateObservers();
    }

    public ArrayList<Travel> getTravels()
    {
        return travels;
    }

    @Override
    public boolean removeReward(Reward reward) {
        if (Logic.get_organization().getRewards().contains(reward))
            if (this.points >= reward.getPoints()) {
                this.points -= reward.getPoints();
                Logic.get_organization().removeReward(reward);
                this.claimedRewards.add(reward);
                return true;
            }
        return false;
    }
}
