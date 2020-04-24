package main.java.controller;

import main.java.entity.MonthPaid;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MonthPaidController {

    public boolean isCurrentMonthPaid(List<MonthPaid> months) {
        Calendar currMonth = Calendar.getInstance();
        Calendar targetMonth = Calendar.getInstance();
        currMonth.setTime(new Date());
        for (MonthPaid mp : months) {
            targetMonth.setTime(mp.getDate());
            if (currMonth.get(Calendar.MONTH) == targetMonth.get(Calendar.MONTH) &&
                    currMonth.get(Calendar.YEAR) == targetMonth.get(Calendar.YEAR)) {
                return true;
            }
        }
        return false;
    }

    public boolean isCurrentMonthLate(List<MonthPaid> months) {
        Calendar currMonth = Calendar.getInstance();
        currMonth.setTime(new Date());
        if (!isCurrentMonthPaid(months)) {
            for (MonthPaid mp : months) {
                if (mp.getRent().getPayDay() == currMonth.get(Calendar.DAY_OF_MONTH))
                    return true;
            }
        }
        return false;
    }
}
