package com.proj2.model;

import com.proj2.model.abstraction.AbstractPerson;

import java.util.ArrayList;

public class Organization
{
    private ArrayList<AbstractPerson> allUsers;

    public Organization(AbstractPerson creator) {
        ArrayList<AbstractPerson> allUsersTemp = new ArrayList<>();
        allUsersTemp.add(creator);
        this.allUsers = allUsersTemp;
    }

    public ArrayList<AbstractPerson> getAllUsers() {
        return allUsers;
    }

    public void addUser(AbstractPerson user) {
        this.allUsers.add(user);
    }

    public void removeUser(AbstractPerson user) {
        this.allUsers.remove(user);
    }
}
