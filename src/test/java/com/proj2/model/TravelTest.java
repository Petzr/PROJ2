package com.proj2.model;

import com.proj2.model.vehicles.Bicycle;
import com.proj2.model.vehicles.DieselCar;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TravelTest {

    static Travel tripDieselCar2km;
    static Travel tripDieselCar15km;
    static Travel tripBicycle2km;
    static Travel tripBicycle15km;

    @BeforeAll
    static void initVariables() {

        tripDieselCar2km = new Travel(new DieselCar(), 2);      // points = 2 * modifier(3)
        tripDieselCar15km = new Travel(new DieselCar(), 15);    // points = 15 * modifier(3)
        tripBicycle2km = new Travel(new Bicycle(), 2);          // points = 2 * modifier(15)
        tripBicycle15km = new Travel(new Bicycle(), 15);        // points = 15 * modifier(15)
    }

    @Test
    void getPoints() {
        assertEquals(6, tripDieselCar2km.getPoints());
        assertEquals(45, tripDieselCar15km.getPoints());

        assertEquals(30, tripBicycle2km.getPoints());
        assertEquals(225, tripBicycle15km.getPoints());
    }

    @Test
    void getDate() {
        // date is niet te controller omdat elke second telt
    }
}