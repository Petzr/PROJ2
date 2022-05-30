package com.proj2.model.person;

import com.proj2.model.abstraction.AbstractPerson;

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
}
