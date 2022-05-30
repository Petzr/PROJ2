package com.proj2.model.abstraction;

public abstract class AbstractPerson extends AbstractEntity {

    //methods relating to Person
    private String name;
    private String email;
    private String password;

    public boolean comparePassword(String password){
        return false;
    }

}