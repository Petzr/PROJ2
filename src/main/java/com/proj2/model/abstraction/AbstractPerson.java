package com.proj2.model.abstraction;

public abstract class AbstractPerson extends AbstractEntity {
    //methods relating to Person
    private final String name;
    private final String email;
    private final String password;

    public AbstractPerson(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public String getName() { return name; }
    public String getEmail() {
        return email;
    }
    public boolean comparePassword(String password){
        return this.password.equals(password);
    }
}