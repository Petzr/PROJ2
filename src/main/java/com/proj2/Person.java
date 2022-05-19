package com.proj2;

public abstract class Person
{
    private String name;
    private String email;
    private String password;
    private String residence;

    public Person(String name, String email, String password, String residence) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.residence = residence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

}



