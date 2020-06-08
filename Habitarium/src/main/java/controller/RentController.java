package main.java.controller;

import main.java.entity.MonthPaid;
import main.java.entity.Rent;

import java.util.*;

public class RentController {

    public Rent copyRent(Rent rent) {
        return new Rent(rent.getId(), rent.getProperty(), rent.getLessor(), rent.getEntranceDate(), rent.getExitDate(),
                rent.getReadjustmentDate(), rent.getValue(), rent.getPayDay());
    }

    public boolean hasChangedDatesOrValue(Rent rent1, Rent rent2) {
        boolean hasDatesChanged = rent1.getEntranceDate().compareTo(rent2.getEntranceDate()) != 0 ||
                rent1.getExitDate().compareTo(rent2.getExitDate()) != 0;
        boolean hasPaydayChanged = rent1.getPayDay() != rent2.getPayDay();
        boolean hasValueChanged = rent1.getValue() != rent2.getValue();
        boolean hasReadjustmentChanged = rent1.getReadjustmentDate().compareTo(rent2.getReadjustmentDate()) != 0;

        return hasDatesChanged || hasPaydayChanged || hasValueChanged || hasReadjustmentChanged;
    }

    public List<String> compareAndReturnListDiferences(Rent rent1, Rent rent2) {
        List<String> attrChanged = new ArrayList<>();
        if (rent1.getEntranceDate().compareTo(rent2.getEntranceDate()) != 0) {
            attrChanged.add("entranceDate");
        }
        if (rent1.getExitDate().compareTo(rent2.getExitDate()) != 0) {
            attrChanged.add("exitDate");
        }
        if (rent1.getReadjustmentDate().compareTo(rent2.getReadjustmentDate()) != 0) {
            attrChanged.add("readjustmentDate");
        }
        if (rent1.getPayDay() != rent2.getPayDay()) {
            attrChanged.add("payDay");
        }
        if (rent1.getValue() != rent2.getValue()) {
            attrChanged.add("value");
        }
        return attrChanged;
    }

    public List<MonthPaid> setMonthsToPay(Rent rent) {
        if (rent.getEntranceDate() == null || rent.getExitDate() == null) {
            throw new NullPointerException("Rent object has no entranceDate or exitDate attribute set!");
        }
        List<MonthPaid> oldMonthPaidList;
        List<MonthPaid> monthPaidList = initMonthPaidList(rent.getValue(), rent.getPayDay(), rent.getEntranceDate(),
                rent.getExitDate(), rent);

        if (rent.getMonthPaidList() != null) {
            oldMonthPaidList = rent.getMonthPaidList();

            int size = Math.min(oldMonthPaidList.size(), monthPaidList.size());

            for (int i = 0; i < size; i++) {
                if (oldMonthPaidList.get(i).getDate().compareTo(monthPaidList.get(i).getDate()) == 0)
                    monthPaidList.get(i).setPaid(oldMonthPaidList.get(i).isPaid());
            }
        }

        return monthPaidList;
    }

    public List<MonthPaid> initMonthPaidList(float value, int day, Date start, Date end, Rent rent) {
        List<MonthPaid> monthsToBePaid = new ArrayList<>();
        Calendar entranceDate = Calendar.getInstance();
        Calendar exitDate = Calendar.getInstance();

        entranceDate.setTime(start);
        exitDate.setTime(end);

        while (entranceDate.before(exitDate)) {
            int month = entranceDate.get(Calendar.MONTH);
            int year = entranceDate.get(Calendar.YEAR);

            GregorianCalendar date = new GregorianCalendar(year, month, day);
            monthsToBePaid.add(new MonthPaid(date.getTime(), value, false, rent));
            entranceDate.add(Calendar.MONTH, 1);
        }
        // Hack-ish the while loop not include exitDate, so we have to add manually
        GregorianCalendar date = new GregorianCalendar(entranceDate.get(Calendar.YEAR),
                entranceDate.get(Calendar.MONTH), day);
        monthsToBePaid.add(new MonthPaid(date.getTime(), value, false, rent));
        return monthsToBePaid;
    }
}
