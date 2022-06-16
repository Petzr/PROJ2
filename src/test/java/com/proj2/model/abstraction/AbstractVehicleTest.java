package com.proj2.model.abstraction;

import com.proj2.model.vehicles.Bicycle;
import com.proj2.model.vehicles.DieselCar;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractVehicleTest {

    static AbstractVehicle bicycle;
    static AbstractVehicle dieselCar;

    @BeforeAll
    static void initVariable() {
        bicycle = new Bicycle();
        // modifier = 15

        dieselCar = new DieselCar();
        // modifier = 3
    }
    @Test
    void getModifier() {
        assertEquals(15, bicycle.getModifier());

        assertEquals(3, dieselCar.getModifier());
    }

    @Test
    void description() {
        // description of a vehicle: het voertuig ... heeft een modifier van ...
        String bicycleDescription = "het voertuig Bicycle heeft een modifier van 15,0";
        assertEquals(bicycleDescription, bicycle.description());

        String dieselCarDescription = "het voertuig Diesel Car heeft een modifier van 3,0";
        assertEquals(dieselCarDescription, dieselCar.description());

    }
}