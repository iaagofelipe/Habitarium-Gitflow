package main.java.controller;

import main.java.entity.Rent;

import java.util.Date;

public class RentController {

    public void makePayment(Date date, Float value, Rent rent) {
        rent.getDatePaidAndValue().put(date, value);
    }
}
