package main.java.controller;

import main.java.entity.MonthPaid;
import main.java.entity.Rent;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class RentController {
    private Rent rent;

    public RentController(Rent rent) {
        this.rent = rent;
    }

    public List<MonthPaid> setMonthsToPay() {
        if (rent.getEntranceDate() == null || rent.getExitDate() == null) {
            throw new NullPointerException("Rent object has no entranceDate or exitDate attribute set!");
        }

        List<MonthPaid> toPay = new ArrayList<>();

        Calendar entranceDate = Calendar.getInstance();
        Calendar exitDate = Calendar.getInstance();

        entranceDate.setTime(rent.getEntranceDate());
        exitDate.setTime(rent.getExitDate());

        while (entranceDate.before(exitDate)) {
            int payDay = rent.getPayDay();
            int month = entranceDate.get(Calendar.MONTH);
            int year = entranceDate.get(Calendar.YEAR);

            GregorianCalendar date = new GregorianCalendar(year, month - 1, payDay);
            toPay.add(new MonthPaid(date.getTime(), rent.getValue(), false, rent));
            entranceDate.add(Calendar.MONTH, 1);
        }
        return toPay;
    }
}
