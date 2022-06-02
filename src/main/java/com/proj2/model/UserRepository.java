package com.proj2.model;

import com.proj2.model.abstraction.AbstractPerson;
import com.proj2.model.abstraction.AbstractRepository;


public class UserRepository extends AbstractRepository<AbstractPerson> {

    private static UserRepository instance;

    public static synchronized UserRepository getInstance() {
        instance =  instance == null ? new UserRepository() : instance;
        return instance;
    }
}