package com.proj2.gui;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TestApplication  {


    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        String date = formatter.format(calendar.getTime());

        System.out.println(date);
    }
}