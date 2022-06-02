package com.proj2.service;

import com.proj2.model.Organization;
import com.proj2.model.abstraction.AbstractPerson;
import com.proj2.model.abstraction.AbstractVehicle;
import com.proj2.model.person.Admin;

public class Logic {
    private static AbstractPerson _loggedIn;
    private static Organization _organization;

    public Logic() {
        _organization = new Organization(_loggedIn);
    }

    public static double calculatePoints(AbstractVehicle vehicle, int km) {
        return vehicle.getModifier() * km;
    }
    public static boolean login(String email, String password) {
        if (_loggedIn == null) {
            _loggedIn = _organization.getUser(email, password);
            return _loggedIn != null;
        } return false;
    }

    public static boolean register(String name, String email, String password) {
        if (_loggedIn instanceof Admin) return ((Admin) _loggedIn).addUser(name, email, password);
        return false;
    }
}