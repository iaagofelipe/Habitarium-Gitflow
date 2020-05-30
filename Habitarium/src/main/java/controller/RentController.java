package main.java.controller;

import main.java.dao.RentDAO;
import main.java.dataUtils.DataUtil;
import main.java.entity.Rent;

import java.util.ArrayList;
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

    public static List<Rent> checkIfYouPaid() {
        RentDAO rentDAO = new RentDAO();
        List<Rent> rentListDAO = rentDAO.getList();
        Date currentDate = DataUtil.getDataMonthAndYear(new Date());

        List<Rent> rentListNotPaid = new ArrayList<>();
        for (Rent rent : rentListDAO) {
            int amountPaid = rent.getAmountPaidMonth();
            Date entrance = rent.getEntranceDate();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(entrance);
            calendar.add(Calendar.MONTH, amountPaid);
            Date lastDatePaid = DataUtil.getDataMonthAndYear(calendar.getTime());

            if (lastDatePaid.before(currentDate) || lastDatePaid.equals(currentDate)) {
                rentListNotPaid.add(rent);
            }
        }
        return rentListNotPaid;
    }

    public static int dayOfMonth() {
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

}
