package com.proj2.model.person;

import com.proj2.model.Organization;
import com.proj2.model.abstraction.AbstractPerson;

public class Admin extends AbstractPerson {
    private Organization organization;

    public Admin(String name, String email, String password, Organization organization) {
        super(name, email, password);
        this.organization = organization;
    }

    public boolean addUser(String name, String email, String password) {
        boolean userExists = false;
        for (AbstractPerson user : organization.getAllUsers())
            if (user.getEmail().equalsIgnoreCase(email)) {
                userExists = true;
                break;
            }

        AbstractPerson user = new User(name, email, password);
        if (!userExists) organization.addUser(user);
        return organization.getAllUsers().contains(user);
    }
    public boolean removeUser(User user) {
        organization.removeUser(user);
        return !organization.getAllUsers().contains(user);
    }
}
