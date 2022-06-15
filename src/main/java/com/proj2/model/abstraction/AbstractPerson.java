package com.proj2.model.abstraction;

import com.proj2.model.Reward;
import com.proj2.service.PasswordHash;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public abstract class AbstractPerson extends AbstractEntity {
    //methods relating to Person
    private String name;
    private final String email;
    private String password;
    private boolean loggedIn;

    public AbstractPerson(String name, String email, String password) {
        this.name = name;
        this.email = email;
        try
        {
            this.password = PasswordHash.createHash(password);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e)
        {
            throw new RuntimeException(e);
        }
        this.loggedIn = false;
    }
    public String getName() { return name; }
    public String getEmail() {
        return email;
    }
    public boolean isLoggedIn() { return loggedIn; }
    public void setLoggedIn(boolean loggedIn) { this.loggedIn = loggedIn; }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        try
        {
            this.password = PasswordHash.createHash(password);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e)
        {
            throw new RuntimeException(e);
        }
    }

    public boolean comparePassword(String password){
        try {
            return PasswordHash.validatePassword(password, this.password);
        } catch (Exception e) { return false; }
    }

    public boolean removeReward(Reward reward) {
        return false;
    }
}