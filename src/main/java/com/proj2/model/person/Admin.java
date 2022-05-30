package com.proj2.model.person;

import com.proj2.model.Organization;
import com.proj2.model.abstraction.AbstractPerson;

public class Admin extends AbstractPerson {
    private Organization organization;

    public Admin(String name, String email, String password, Organization organization) {
        super(name, email, password);
        this.organization = organization;
    }

    public void addUser(String name, String email, String password) {
        organization.addUser(new User(name, email, password));
    }
    public void removeUser(User user) {
        organization.removeUser(user);
    }
}
