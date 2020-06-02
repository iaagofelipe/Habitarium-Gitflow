package main.java.controller;

import main.java.entity.MonthPaid;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MonthPaidController {
    public List<MonthPaid> lateMonthsInRange(List<MonthPaid> monthPaids, Date start, Date finish) {
        List<MonthPaid> out = new ArrayList<>();
        for (MonthPaid monthPaid : monthPaids) {
            Date month = monthPaid.getDate();
            if (!monthPaid.isPaid() &&
                    (month.compareTo(start) >= 0 && month.compareTo(finish) <= 0)) {
                out.add(monthPaid);
            }
        }
        return out;
    }
}
