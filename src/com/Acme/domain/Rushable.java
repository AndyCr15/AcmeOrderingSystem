package com.Acme.domain;

import java.time.LocalDate;

/**
 * Created by AndyCr15 on 21/03/2017.
 */
public interface Rushable {
    public abstract boolean isRushable(LocalDate orderDate, double amount);
}
