package main.java.main;
import main.java.dao.*;
import main.java.entity.*;
import main.java.enuns.Gender;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException {
//        Property property = new Property();
//        property.setStreet("senador pompeu");
//        property.setPropertyNumber("001");
//        property.setNeighbour("Centro");
//        property.setCondo("Alvorada");
//        property.setBlockCondo("A");
//
//        Rent rent = new Rent();
//        rent.setValue(1000.0F);
//        rent.setPayDay(10);
//
//        String date = "03/04/2020";
//        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//        Date dateFormated = format.parse(date);
//
//        rent.setEntranceDate(dateFormated);
//        rent.setExitDate(dateFormated);
//        rent.setReadjustmentDate(dateFormated);
//
//        rent.setProperty(property);
//        property.setRent(rent);
//
//        Lessor lessor = new Lessor();
//        lessor.setName("Victor");
//        lessor.setRg("0019229012");
//        lessor.setCpf("029139091284");
//        lessor.setGender(Gender.MALE);
//        lessor.setTelOne("8540028922");
//        lessor.setTelTwo("85997166764");
//        lessor.setRent(rent);
//        rent.setLessor(lessor);
//
//        PropertyDAO propertyDAO = new PropertyDAO();
//        propertyDAO.save(property);
//          RentDAO rentDAO = new RentDAO();
//          rentDAO.delete(5L);
        LessorDAO lessorDAO = new LessorDAO();
        lessorDAO.delete(15L);

    }
}