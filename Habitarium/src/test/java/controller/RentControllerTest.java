package test.java.controller;

import main.java.dataUtils.DataUtil;
import org.junit.Ignore;

import java.util.Calendar;
import java.util.Date;

public class RentControllerTest {

    @Ignore
    public void test() {
        Date dataAtual = DataUtil.getDataMonthAndYear(new Date()); // 03
        int amoutPaid = 2;
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, 01, 01);
        calendar.add(Calendar.MONTH, amoutPaid); // 02/2020
        Date paidDateCurrent = DataUtil.getDataMonthAndYear(calendar.getTime());
        System.out.println(dataAtual);
        System.out.println(paidDateCurrent);
        if (paidDateCurrent.before(dataAtual)) {
            System.out.println("nao pago");
        } else {
            System.out.println("pago");
        }
    }

}