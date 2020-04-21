package main.java.controller;

import main.java.dataUtils.DataUtil;
import main.java.entity.Rent;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class RentController {

    public static void startRent(Rent rent) {
        Calendar entranceDate = Calendar.getInstance();
        Calendar exitDate = Calendar.getInstance();
        entranceDate.setTime(rent.getEntranceDate());
        exitDate.setTime(rent.getExitDate());

        while (entranceDate.before(exitDate)) {
            int payDay = rent.getPayDay();
            int month = DataUtil.getMonth(entranceDate);
            int year = DataUtil.getYear(entranceDate);

            GregorianCalendar date = new GregorianCalendar(year, month - 1, payDay);
            System.out.println(date.getTime());
            rent.setMonthToBePaid(date.getTime(), false);
            entranceDate.add(Calendar.MONTH, 1);
        }
    }

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
            boolean value = toBePaid.get(date);
            if (!value)
                notPaid.add(date);
        }
        return notPaid;
    }

    public static List<Date> monthsPaid(Rent rent) {
        List<Date> paid = new ArrayList<>();
        Map<Date, Boolean> toBePaid = rent.getMonthToBePaid();

        for (Date date : toBePaid.keySet()) {
            boolean value = toBePaid.get(date);
            if (value)
                paid.add(date);
        }
        return paid;
    }
}
