package com.Acme.utils;

import java.time.LocalDate;

/**
 * Created by AndyCr15 on 26/03/2017.
 */
public class HolidayOrdersNotAllowedException extends Exception {
    public HolidayOrdersNotAllowedException(LocalDate date) {
        super("Orders are not allowed to be created on: " + date);
    }
}
