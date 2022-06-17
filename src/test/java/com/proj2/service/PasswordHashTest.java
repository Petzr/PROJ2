package com.proj2.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordHashTest {

    @Test
    void passwordHashTest() {
        try
        {
            // Test password validation
            boolean failure = false;

            for(int i = 0; i < 100; i++)
            {
                String password = ""+i;
                String hash = PasswordHash.createHash(password);
                String secondHash = PasswordHash.createHash(password);
                if(hash.equals(secondHash)) {
                    System.out.println("FAILURE: TWO HASHES ARE EQUAL!");
                    failure = true;
                }
                String wrongPassword = ""+(i+1);
                if(PasswordHash.validatePassword(wrongPassword, hash)) {
                    System.out.println("FAILURE: WRONG PASSWORD ACCEPTED!");
                    failure = true;
                }
                if(!PasswordHash.validatePassword(password, hash)) {
                    System.out.println("FAILURE: GOOD PASSWORD NOT ACCEPTED!");
                    failure = true;
                }
            }

            assertFalse(failure);
        }
        catch(Exception ex)
        {
            System.out.println("ERROR: " + ex);
        }
    }

}