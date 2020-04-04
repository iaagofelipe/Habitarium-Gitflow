package main.java.entity;

import javax.persistence.*;

@Entity
@Table (name = "property")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String neighbour; //bairro
    private String street;
    private String propertyNumber;
    private String condo;
    private String blockCondo; //bloco do condominio

    @OneToOne
    private Rent rent;

    @OneToOne (cascade = CascadeType.ALL, mappedBy = "property")
    private Lessor lessor;

    public Lessor getLessor() {
        return lessor;
    }

    public void setLessor(Lessor lessor) {
        this.lessor = lessor;
    }

    public Rent getRent() {
        return rent;
    }

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNeighbour() {
        return neighbour;
    }

    public void setNeighbour(String neighbour) {
        this.neighbour = neighbour;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPropertyNumber() {
        return propertyNumber;
    }

    public void setPropertyNumber(String propertyNumber) {
        this.propertyNumber = propertyNumber;
    }

    public String getCondo() {
        return condo;
    }

    public void setCondo(String condo) {
        this.condo = condo;
    }

    public String getBlockCondo() {
        return blockCondo;
    }

    public void setBlockCondo(String blockCondo) {
        this.blockCondo = blockCondo;
    }
}
