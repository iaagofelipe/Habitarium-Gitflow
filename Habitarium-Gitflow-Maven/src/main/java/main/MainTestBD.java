package main.java.main;

import main.java.dao.PropertyDAO;
import main.java.dao.RentDAO;
import main.java.entity.Lessor;
import main.java.entity.Property;
import main.java.entity.Rent;
import main.java.enuns.Gender;

import java.util.Date;

public class MainTestBD {
    public static void main(String[] args) {
       // LEMBRAR DE ALTERAR OS ID
    }

    public static Rent createdRent() {
        Rent rent = new Rent();
        rent.setEntranceDate(new Date());
        rent.setExitDate(new Date());
        rent.setReadjustmentDate(new Date());
        rent.setPayDay(3);
        rent.setValue(300f);
        return rent;
    }

    public static Property createdProperty() {
        Property property = new Property();
        property.setBlockCondo("10");
        property.setCondo("Alvorada");
        property.setNeighbour("Benfica");
        property.setPropertyNumber("666");
        property.setStreet("rua 33");
        return property;
    }

    public static Lessor createdLessor() {
        Lessor lessor = new Lessor();
        lessor.setCpf("019");
        lessor.setGender(Gender.MALE);
        lessor.setName("iago Victor");
        lessor.setRg("20031234567");
        lessor.setTelOne("88888888");
        lessor.setTelTwo("99999999");
        return lessor;
    }


}
//        PASSO 1
//        PropertyDAO propertyDAO = new PropertyDAO();
//        Property property = createdProperty();
//        propertyDAO.save(property);

//        PASSO 2
//        PropertyDAO propertyDAO = new PropertyDAO();
//        Rent rent = createdRent();
//        RentDAO rentDAO = new RentDAO();
//
//        Property property = propertyDAO.findById(17L);
//        rent.setProperty(property);
//        Rent rent1 = rentDAO.save(rent);
//
//        property.setRent(rent1);
//        propertyDAO.update(property);

//        DELETE PASSO 3
//        RentDAO rentDAO = new RentDAO();
//        rentDAO.delete(20L);