package db.lab4.model.implementation;

import db.lab4.model.GeneralModelInterface;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "location", schema = "mydb", catalog = "")
public class Location implements GeneralModelInterface {
    private Integer id;
    private String section;
    private String number;
    private String subscription;
    private Collection<SensorData> sensorDataById;

    public Location() {

    }

    public Location(Integer id, String section, String number, String subscription) {
        this.id = id;
        this.section = section;
        this.number = number;
        this.subscription = subscription;

    }

    public Location(final Integer id, final String section, final String number, final String subscription, final Collection<SensorData> sensorDataById) {
        this.id = id;
        this.section = section;
        this.number = number;
        this.subscription = subscription;
        this.sensorDataById = sensorDataById;

    }

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "section")
    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    @Basic
    @Column(name = "number")
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Basic
    @Column(name = "subscription")
    public String getSubscription() {
        return subscription;
    }

    public void setSubscription(String subscription) {
        this.subscription = subscription;
    }

    @OneToMany(mappedBy = "locationByLocationId")
    public Collection<SensorData> getSensorDataById() {
        return sensorDataById;
    }

    public void setSensorDataById(Collection<SensorData> sensorDataById) {
        this.sensorDataById = sensorDataById;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location that = (Location) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(section, that.section) &&
                Objects.equals(number, that.number) &&
                Objects.equals(subscription, that.subscription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, section, number, subscription);
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
