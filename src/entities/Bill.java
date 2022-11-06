package entities;

import java.sql.Timestamp;

public class Bill {
    private Integer id;
    private Timestamp datetime;
    private float total;

    public Bill() {
    }

    public Bill(Integer id, Timestamp datetime, float total) {
        this.id = id;
        this.datetime = datetime;
        this.total = total;
    }

    public Bill(Timestamp datetime, float total) {
        this.datetime = datetime;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
