package com.proj2.model.person;

import com.proj2.model.Organization;
import com.proj2.model.abstraction.AbstractPerson;
import com.proj2.service.Logic;

public class Admin extends AbstractPerson {
    public Admin(String name, String email, String password) { super(name, email, password); }

    public boolean addUser(String name, String email, String password) {
        boolean userExists = false;
        for (AbstractPerson user : Logic.get_organization().getAllUsers())
            if (user.getEmail().equalsIgnoreCase(email)) {
                userExists = true;
                break;
            }

        AbstractPerson user = new User(name, email, password);
        if (!userExists) Logic.get_organization().addUser(user);
        return Logic.get_organization().getAllUsers().contains(user);
    }
    public boolean removeUser(User user) {
        Logic.get_organization().removeUser(user);
        return !Logic.get_organization().getAllUsers().contains(user);
    }

    public boolean removeUser(String email) {
        Logic.get_organization().removeUser(email);
        for(AbstractPerson user : Logic.get_organization().getAllUsers()) if(user.getEmail().equalsIgnoreCase(email)) return false;
        return true;
    }
}
