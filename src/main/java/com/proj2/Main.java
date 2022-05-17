package com.proj2;

public class Main {

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.addVehicle("motor", 1.3);

        double points = vehicle.getPointsOfVehicle("fiets");
        System.out.println(points);
        double points1 = vehicle.getPointsOfVehicle("motor");
        System.out.println(points1);
        double points2 = vehicle.getPointsOfVehicle("asdf");
        System.out.println(points);
    }
}
