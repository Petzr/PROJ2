package com.proj2.model;

import com.proj2.model.abstraction.AbstractPerson;

import java.util.ArrayList;

public class Organization
{
    private final ArrayList<AbstractPerson> allUsers;

    public Organization() {
        this.allUsers = new ArrayList<>();
    }

    public Organization(AbstractPerson creator) {
        ArrayList<AbstractPerson> allUsersTemp = new ArrayList<>();
        if (creator != null) allUsersTemp.add(creator);
        this.allUsers = allUsersTemp;
    }

    public ArrayList<AbstractPerson> getAllUsers() {
        return allUsers;
    }

    public AbstractPerson getUser(String email, String password) {
        for(AbstractPerson user : allUsers) if(user.getEmail().equalsIgnoreCase(email)) if(user.comparePassword(password)) return user;
        return null;
    }

    public void addUser(AbstractPerson user) {
        this.allUsers.add(user);
    }

    public void removeUser(AbstractPerson user) {
        this.allUsers.remove(user);
    }
}
