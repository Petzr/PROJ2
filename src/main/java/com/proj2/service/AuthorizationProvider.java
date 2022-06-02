package com.proj2.service;

//import com.proj2.model.UserRepository;

import com.proj2.model.Organization;
import com.proj2.model.abstraction.AbstractPerson;
import com.proj2.model.person.Admin;

public class AuthorizationProvider {
    //private final UserRepository userRepository = UserRepository.getInstance();

    public static AbstractPerson login(Organization organization, String email, String password) {
        return organization.getUser(email, password);
    }

    public static boolean register(AbstractPerson loggedIn, String name, String email, String password) {
        if (loggedIn instanceof Admin) return ((Admin) loggedIn).addUser(name, email, password);
        return false;
    }
}
