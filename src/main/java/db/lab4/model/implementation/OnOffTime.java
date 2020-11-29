package db.lab4.model.implementation;

import db.lab4.model.GeneralModelInterface;

public class OnOffTime implements GeneralModelInterface {
    private Integer id;
    private String onTime;
    private String offTime;

    public OnOffTime(Integer id, String onTime, String offTime) {
        this.id = id;
        this.onTime = onTime;
        this.offTime = offTime;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOnTime() {
        return onTime;
    }

    public void setOnTime(String onTime) {
        this.onTime = onTime;
    }

    public String getOffTime() {
        return offTime;
    }

    public void setOffTime(String offTime) {
        this.offTime = offTime;
    }

    @Override
    public String toString() {
        return "OnOffTime{" +
                "id=" + id +
                ", onTime='" + onTime + '\'' +
                ", offTime='" + offTime + '\'' +
                '}';
    }
}
