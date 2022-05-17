package com.proj2;

public abstract class Person
{
    private String name;
    private String email;
    private String password;
    private String residence;
    private int points;

    public Person(String name, String email, String password, String residence, int points) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.residence = residence;
        this.points = points;
    }

    public int som(int getal, int getal2) {
        return getal - getal2;
    }
    public int min (int getal, int getal2) {
        return getal + getal2;
    }
}



