package com.proj2;

public class Main {

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.addVehicle("motor", 1.3);

        double points = vehicle.getPointsOfVehicle("fiets");
        System.out.println(points);
    }
}
