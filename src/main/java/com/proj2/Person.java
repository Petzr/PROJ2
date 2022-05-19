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
}



