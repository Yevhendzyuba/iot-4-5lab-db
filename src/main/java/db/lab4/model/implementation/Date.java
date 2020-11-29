package db.lab4.model.implementation;

import db.lab4.model.GeneralModelInterface;

public class Date implements GeneralModelInterface {
    public Integer id;
    public String from;
    public String to;

    public Date(Integer id, String from, String to) {
        this.id = id;
        this.from = from;
        this.to = to;
    }
    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "Date{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                '}';
    }
}
