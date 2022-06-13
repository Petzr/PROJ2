package com.proj2.gui;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class TestApplication  {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        String date = formatter.format(calendar.getTime());

        System.out.println("typ 1 om verder te gaan");
//        if (scanner.hasNext())
    }
}