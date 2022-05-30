package com.proj2.model.person;

import com.proj2.model.abstraction.AbstractPerson;

public class Admin extends AbstractPerson {

    public Admin(String name, String email, String password) {
        super(name, email, password);
    }

    public void addUser(){}
    public void removeUser(){}
}
