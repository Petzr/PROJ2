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

        boolean makeReward = admin.addReward("PlayStation 7", 420);

        Reward reward = Logic.get_organization().getRewards().get(0);

        boolean removeReward = admin.removeReward(reward);

        boolean actual = Logic.get_organization().getRewards().isEmpty();

        assertTrue(actual);
    }
}