package main.java.controller;

import main.java.dao.RentDAO;
import main.java.entity.Rent;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class RentController {

    public static void makePayment(Date date, Float value, Rent rent) {
        rent.getDatePaidAndValue().put(date, value);
    }

    public static List<Rent> rentalsToBePaidToday() {
        RentDAO rentDAO = new RentDAO();
        return rentDAO.getListToBePaidToday(dayOfMonth());
    }

    protected static int dayOfMonth() {
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }
}
