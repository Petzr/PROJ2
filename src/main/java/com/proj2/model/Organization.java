package com.proj2.model;

import com.proj2.model.abstraction.AbstractPerson;
import com.proj2.model.person.Admin;

import java.util.ArrayList;
import java.util.Observable;

public class Organization extends Observable
{
    private final ArrayList<AbstractPerson> allUsers;
    private final ArrayList<Reward> rewards;

    public Organization() {
        this.allUsers = new ArrayList<>();
//        this.allUsers.add(new Admin("Admin", "admin@foo.bar", "Admin213!"));
        this.allUsers.add(new Admin("Admin", "admin@foo.bar", "123"));
        this.rewards = new ArrayList<>();
    }

    public Organization(AbstractPerson creator) {
        this.allUsers = new ArrayList<>();
        if (creator != null) this.allUsers.add(creator);
//        else this.allUsers.add(new Admin("Admin", "admin@foo.bar", "Admin213!"));
        else this.allUsers.add(new Admin("Admin", "admin@foo.bar", "123"));
        this.rewards = new ArrayList<>();
    }

    public ArrayList<AbstractPerson> getAllUsers() {
        return allUsers;
    }

    public AbstractPerson checkLogin(String email, String password) {
        for(AbstractPerson user : this.allUsers)
            if(!user.isLoggedIn())
                if (user.getEmail().equalsIgnoreCase(email))
                    if (user.comparePassword(password)) {
                        user.setLoggedIn(true);
                        return user;
                    }
        return null;
    }

    public void addUser(AbstractPerson user) { this.allUsers.add(user); }
    public void removeUser(AbstractPerson user) { this.allUsers.remove(user); }
    public ArrayList<Reward> getRewards() { return rewards; }
    public Reward getReward(String name) { for (Reward reward : rewards) { if (reward.getName().equalsIgnoreCase(name)) return reward; } return null; }
    public void addReward(Reward reward) { this.rewards.add(reward); }
    public void removeReward(Reward reward) { this.rewards.remove(reward); }
    public void removeUser(String email) { this.allUsers.removeIf(user -> user.getEmail().equalsIgnoreCase(email)); }
    public boolean userExists(AbstractPerson user) { return this.allUsers.contains(user); }

    public void updateObservers() {
        setChanged();
        notifyObservers();
    }
}