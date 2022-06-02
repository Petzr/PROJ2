package com.proj2.service;

import com.proj2.model.Organization;
import com.proj2.model.abstraction.AbstractPerson;
import com.proj2.model.abstraction.AbstractVehicle;
import com.proj2.model.person.Admin;
import com.proj2.model.person.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Logic {
    private static final Organization _organization = new Organization();

    public static double calculatePoints(AbstractVehicle vehicle, int km) {
        return vehicle.getModifier() * km;
    }

    public static ArrayList<User> sortUsersByPoints(ArrayList<User> users, boolean ascending) {
        if (ascending) users.sort(new AscendingComparator());
        else users.sort(new DescendingComparator());
        return users;
    }

    public static Organization get_organization() {
        return _organization;
    }
}

class AscendingComparator implements Comparator<User> {
    @Override
    public int compare(User user1, User user2) {
        return user1.getPoints().compareTo(user2.getPoints());
    }
}

class DescendingComparator implements Comparator<User> {
    @Override
    public int compare(User user1, User user2) {
        return user2.getPoints().compareTo(user1.getPoints());
    }
}