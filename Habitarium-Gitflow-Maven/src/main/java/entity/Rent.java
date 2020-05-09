package main.java.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "rent")
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.REMOVE, mappedBy = "rent")
    private Property property;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "rent")
    private Lessor lessor;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rent")
    private List<MonthPaid> monthPaidList;

    @Temporal(TemporalType.DATE)
    @Column(name = "entrance_date")
    private Date entranceDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "exit_date")
    private Date exitDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "readjustment_date")
    private Date readjustmentDate;

    private float value;
    private int payDay;
    private int amountPaidMonth = 0;

    @ElementCollection
    private Map<Date, Float> DatePaidAndValue;

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

    public Lessor getLessor() {
        return lessor;
    }

    public void setLessor(Lessor lessor) {
        this.lessor = lessor;
    }

    public Map<Date, Float> getDatePaidAndValue() {
        return DatePaidAndValue;
    }

    public void setDatePaidAndValue(Map<Date, Float> datePaidAndValue) {
        DatePaidAndValue = datePaidAndValue;
    }

    public int getAmountPaidMonth() {
        return amountPaidMonth;
    }

    public void setAmountPaidMonth(int amountPaidMonth) {
        this.amountPaidMonth = amountPaidMonth;
    }

    public List<MonthPaid> getMonthPaidList() {
        return monthPaidList;
    }

    public void setMonthPaidList(List<MonthPaid> monthPaidList) {
        this.monthPaidList = monthPaidList;
    }

    @Override
    public String toString() {
        String out = "Rent{\n" +
                "id=" + id +
                ", \nvalue=" + value +
                ", \nentranceDate=" + entranceDate +
                ", \nexitDate=" + exitDate +
                ", \nreadjustmentDate=" + readjustmentDate +
                ", \npayDay=" + payDay +
                ", \namountPaidMonth=" + amountPaidMonth +
                ", \nDatePaidAndValue=" + DatePaidAndValue;
        if (property != null && lessor != null) {
            out += ", \npropertyId=" + property.getId() + ", \nlessorID=" + lessor.getId();
        } else {
            out += ", \npropertyId= NULL, \nlessorId= NULL";
        }
        out +=  '}';
        return out;
    }
}
