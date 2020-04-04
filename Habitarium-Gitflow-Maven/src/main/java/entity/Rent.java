package main.java.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "rent")
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private float value;

    @Temporal(TemporalType.DATE)
    @Column(name = "entrance_date")
    private Date entranceDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "exit_date")
    private Date exitDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "readjustment_date")
    private Date readjustmentDate; //reajuste

    private int payDay;

    @OneToOne
    private Property property;

    @OneToOne (cascade =  {CascadeType.REMOVE, CascadeType.PERSIST} , mappedBy = "rent")
    private Lessor lessor;

    public Lessor getLessor() {
        return lessor;
    }

    public void setLessor(Lessor lessor) {
        this.lessor = lessor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public Date getEntranceDate() {
        return entranceDate;
    }

    public void setEntranceDate(Date entranceDate) {
        this.entranceDate = entranceDate;
    }

    public Date getExitDate() {
        return exitDate;
    }

    public void setExitDate(Date exitDate) {
        this.exitDate = exitDate;
    }

    public Date getReadjustmentDate() {
        return readjustmentDate;
    }

    public void setReadjustmentDate(Date readjustmentDate) {
        this.readjustmentDate = readjustmentDate;
    }

    public int getPayDay() {
        return payDay;
    }

    public void setPayDay(int payDay) {
        this.payDay = payDay;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }
}
