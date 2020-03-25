package entity;

public class Property {
    private Long id;
    private String neighbour; //bairro
    private String street;
    private String propertyNumber;
    private String condo;
    private String blockCondo; //bloco do condominio

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
