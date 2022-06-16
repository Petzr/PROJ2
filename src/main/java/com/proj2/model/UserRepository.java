package com.proj2.model;

import com.proj2.model.abstraction.AbstractPerson;


public class UserRepository {
    private static UserRepository instance;

    public static synchronized UserRepository getInstance() {
        instance =  instance == null ? new UserRepository() : instance;
        return instance;
    }
}