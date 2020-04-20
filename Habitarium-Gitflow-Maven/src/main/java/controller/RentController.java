package main.java.controller;

import main.java.dao.RentDAO;
import main.java.dataUtils.DataUtil;
import main.java.entity.Rent;

import java.time.LocalDate;
import java.util.*;

public class RentController {

    public static void makePayment(Rent rent, Date date, Float value) {
        rent.setDatePaidAndValue(date, value);
        rent.setMonthToBePaid(date, true);
    }

    public static boolean isPaid(Rent rent) {
        LocalDate date = LocalDate.now();
        GregorianCalendar calendar = new GregorianCalendar(date.getYear(), date.getMonthValue() - 1, rent.getPayDay());
        return rent.getMonthToBePaid().get(calendar.getTime());
    }

    public static List<Date> monthsNotPaid(Rent rent) {
        List<Date> notPaid = new ArrayList<>();
        Map<Date, Boolean> toBePaid = rent.getMonthToBePaid();

        for (Date date : toBePaid.keySet()) {
            boolean paid = toBePaid.get(date);
            if (!paid)
                notPaid.add(date);
        }
        return notPaid;
    }
}
