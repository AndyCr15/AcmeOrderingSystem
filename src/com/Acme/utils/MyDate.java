package com.Acme.utils;

import java.time.LocalDate;

public class MyDate {  // Member/instance variables (a.k.a. fields/properties/attributes)
    private byte day;
    private byte month;
    private short year;
    private static LocalDate[] holidays;

    static {
        holidays = new LocalDate[6];
        holidays[0] = LocalDate.of(2016, 1, 1);
        holidays[1] = LocalDate.of(2016, 9, 5);
        holidays[2] = LocalDate.of(2016, 5, 30);
        holidays[3] = LocalDate.of(2016, 11, 24);
        holidays[4] = LocalDate.of(2016, 7, 4);
        holidays[5] = LocalDate.of(2016, 12, 25);
    }

    public static void listHolidays() {
        System.out.println("the holidays are:");
        for (int x = 0; x < holidays.length; x++) {
            System.out.println(holidays[x]);
        }
    }

    public static LocalDate[] getHolidays() {
        return holidays;
    }
    // Constructors:  //   1. Same name as the class  //  2. No return type

    //The no-args constructor
    public MyDate() {
        this(1, 1, 1990);
    }

    //Constructor that takes 3 arguments
    public MyDate(int m, int d, int y) {
        setDate(m, d, y);
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (valid(day, month, year)) {
            this.day = (byte) day;
        }
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (valid(day, month, year)) {
            this.month = (byte) month;
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (valid(day, month, year)) {
            this.year = (short) year;
        }
    }


    //Methods

    public boolean equals(Object o) {
        if (o instanceof MyDate) {
            MyDate d = (MyDate) o;
            if ((d.day == day) && (d.month == month) && (d.year == year)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return month + "/" + day + "/" + year;
    }

    public void setDate(int m, int d, int y) {
        day = (byte) d;
        year = (short) y;
        month = (byte) m;
    }

    public static void leapYears() {
        int year = 1752;
        for (int j = 1752; j < 2021; j = j + 4) {
            if ((j % 100 != 0) || (j % 400 == 0))
                System.out.println("The year " + j + " is a leap year");
        }
    }

    public boolean valid(int day, int month, int year) {
        if (day > 31 || day < 1 || month > 12 || month < 1) {
            System.out.println("Attempting to create a non-valid date " + month + "/" + day + "/" + year);
            return false;
        }
        switch (month) {
            case 4:
            case 6:
            case 9:
            case 11:
                return (day <= 30);
            case 2:
                return day <= 28 || (day == 29 && year % 4 == 0);
        }
        return true;
    }
}
