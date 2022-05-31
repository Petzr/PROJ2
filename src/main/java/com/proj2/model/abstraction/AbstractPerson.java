package com.proj2.model.abstraction;

public abstract class AbstractPerson extends AbstractEntity {

    //methods relating to Person
    private String name;
    private String email;
    private String password;

    public AbstractPerson(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public boolean comparePassword(String password){
        return this.password.equals(password);
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}