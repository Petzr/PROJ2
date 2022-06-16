package com.proj2.model.abstraction;

import com.proj2.model.person.Admin;
import com.proj2.model.person.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractPersonTest
{

    @Test
    void comparePassword()
    {
        User user = new User("Daner", "Daner@", "DanersWachtwoord");

        boolean falseTest = user.getPassword().equals("DanersWachtwoord");

        boolean actualTrueTest = user.comparePassword("DanersWachtwoord");

        // de test hieronder werkt niet omdat de validatePassword method niet wordt gebruikt.
        assertFalse(falseTest);
        // de test hieronder werkt wel omdat de validatePassword method in comparePassword wordt gebruikt.
        assertTrue(actualTrueTest);
    }
}