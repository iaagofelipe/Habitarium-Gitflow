package com.habitarium;

import com.habitarium.dao.LessorDAO;
import com.habitarium.dao.PropertyDAO;
import com.habitarium.dao.RentDAO;
import com.habitarium.entity.Lessor;
import com.habitarium.entity.Property;
import com.habitarium.entity.Rent;
import com.habitarium.enuns.Gender;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException {
        createDB();
    }

    static void createDB() throws ParseException {
        Property property = createProperty();
        saveToDB(property);

        Rent rent = createRent();
        Lessor lessor = createLessor();
        rent.setLessor(lessor);
        lessor.setRent(rent);

        saveToDB(rent);

        // Link property to rent
        Rent r = getLastRent();
        Property p = getLastProperty();
        p.setRent(r);
        r.setProperty(p);
        saveToDB(r);
        saveToDB(p);
    }

    static Property createProperty() {
        Property property = new Property();
        property.setStreet("senador pompeu");
        property.setPropertyNumber("001");
        property.setNeighbour("Centro");
        property.setCondo("Alvorada");
        property.setBlockCondo("A");
        property.setApartment("AP UEUMMMM");
        property.setCity("New Metropole");
        return property;
    }

    static Lessor createLessor() {
        Lessor lessor = new Lessor();
        lessor.setName("Victor");
        lessor.setRg("0019229012");
        lessor.setCpf("029139091284");
        lessor.setGender(Gender.MALE);
        lessor.setTelOne("8540028922");
        lessor.setTelTwo("85997166764");
        return lessor;
    }

    static Rent createRent() throws ParseException {
        Rent rent = new Rent();
        rent.setValue(1000.0F);
        rent.setPayDay(10);

        String date = "03/04/2020";
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date dateFormated = format.parse(date);

        rent.setEntranceDate(dateFormated);
        rent.setExitDate(dateFormated);
        rent.setReadjustmentDate(dateFormated);
        return rent;
    }

    static void saveToDB(Object obj) {
        if (obj instanceof Rent) {
            RentDAO dao = new RentDAO();
            dao.save((Rent) obj);
        } else if (obj instanceof Lessor) {
            LessorDAO dao = new LessorDAO();
            dao.save((Lessor) obj);
        } else if (obj instanceof Property) {
            PropertyDAO dao = new PropertyDAO();
            if (((Property) obj).getRent() != null) {
                dao.update((Property) obj);
            } else {
                dao.save((Property) obj);
            }
        }
    }

    /**
     *
     * @return The last property added to the DB
     */
    static Property getLastProperty() {
        PropertyDAO dao = new PropertyDAO();
        return Collections.max(dao.getList(), Comparator.comparing(Property::getId));
    }

    static Rent getLastRent() {
        RentDAO dao = new RentDAO();
        return Collections.max(dao.getList(), Comparator.comparing(Rent::getId));
    }
}
