package com.proj2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    Vehicle vehicle = new Vehicle();

    @Test
    void calculatePoints() {
    }

    @Test
    void getPointsOfVehicle() {
        double points1 = vehicle.getPointsOfVehicle("fiets");
        double points2 = vehicle.getPointsOfVehicle("asdf");

        assertEquals(0.0, points1);
        assertEquals(-1.0, points2);
    }
}