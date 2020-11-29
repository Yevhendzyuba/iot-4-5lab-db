package db.lab4.model.implementation;

import db.lab4.model.GeneralModelInterface;

public class Location implements GeneralModelInterface {
    private Integer id;
    private String section;
    private String number;
    private String subscription;

    public Location(Integer id, String section, String number, String subscription) {
        this.id = id;
        this.section = section;
        this.number = number;
        this.subscription = subscription;

    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSubscription() {
        return subscription;
    }

    public void setSubscription(String subscription) {
        this.subscription = subscription;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", section='" + section + '\'' +
                ", number='" + number + '\'' +
                ", subscription='" + subscription + '\'' +
                '}';
    }
}
