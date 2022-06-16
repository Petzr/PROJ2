package com.proj2.model.person;

import com.proj2.model.Reward;
import com.proj2.service.Logic;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminTest
{

    @Test
    void addUser()
    {
        Admin admin = new Admin("Daner", "Daner@", "123");

        boolean actual = admin.addUser("Bilal", "Bilal@", "123");

        assertTrue(actual);
    }

    @Test
    void RemoveUser()
    {
        Admin admin = new Admin("Daner", "Daner@", "123");

        boolean user = admin.addUser("Bilal", "Bilal@", "123");

        boolean actual = admin.removeUser("Bilal@");

        assertTrue(actual);
    }

    @Test
    void addReward()
    {
        Admin admin = new Admin("Daner", "Daner@", "123");

        boolean actual = admin.addReward("PlayStation 7", 420);

        assertTrue(actual);
    }

    @Test
    void removeReward()
    {
        Admin admin = new Admin("Daner", "Daner@", "123");

        Reward expected = new Reward("PlayStation 7", 420);

        boolean rewardAdded = admin.addReward("PlayStation 7", 420);

        Reward actual = Logic.get_organization().getRewards().get(0);

        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getPoints(), actual.getPoints());



    }
}