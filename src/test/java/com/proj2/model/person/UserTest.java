package com.proj2.model.person;

import com.proj2.model.Reward;
import com.proj2.model.vehicles.Bicycle;
import com.proj2.model.vehicles.GasolineCar;
import com.proj2.service.Logic;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

   // @ParameterizedTest
    //@ValueSource(ints = {20, 30, 40})
    @Test
    void puntenNewTravelTest() {
        User test = new User("bilal", "test@test.nl", "test");
        // modifier fiets = 15
        test.newTravel(new Bicycle(), 20);
        assertEquals(300, test.getPoints());
        // 300 + 5x60
        test.newTravel(new GasolineCar(), 60);
        assertEquals(600, test.getPoints());
    }

    @Test
    void newTravelTestTravelsArray() {
        User test = new User("bilal", "test@test.nl", "test");
        test.newTravel(new Bicycle(), 10);
        assertEquals(1, test.getTravels().size());
    }

    @Test
    void removeRewardTest() {
        Admin ad = new Admin("daner", "test@test.nl", "test");
        User test = new User("bilal", "test@test.nl", "test");

        test.newTravel(new Bicycle(), 10); // user heeft nu 150punten
        ad.addReward("Coupon Bol.com", 100);
        Reward reward = Logic.get_organization().getRewards().get(0);
        test.removeReward(reward);
        assertEquals(50, test.getPoints());
        assertTrue(Logic.get_organization().getRewards().isEmpty());

    }
}