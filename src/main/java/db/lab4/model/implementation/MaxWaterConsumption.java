package db.lab4.model.implementation;

import db.lab4.model.GeneralModelInterface;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "max_water_consumption", schema = "mydb", catalog = "")
public class MaxWaterConsumption implements GeneralModelInterface {
    private Integer id;
    private String time;
    private String power;
    private String litres;
    private Collection<Noozle> noozleById;

    public MaxWaterConsumption() {

    }

    public MaxWaterConsumption(Integer id, String time, String power, String litres) {
        this.id = id;
        this.time = time;
        this.power = power;
        this.litres = litres;
    }

    public MaxWaterConsumption(final Integer id, final String time, final String power, final String litres, final Collection<Noozle> noozleById) {
        this.id = id;
        this.time = time;
        this.power = power;
        this.litres = litres;
        this.noozleById = noozleById;
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
    @Column(name = "time")
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Basic
    @Column(name = "power")
    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    @Basic
    @Column(name = "litres")
    public String getLitres() {
        return litres;
    }

    public void setLitres(String litres) {
        this.litres = litres;
    }

    @OneToMany(mappedBy = "maxWaterConsumptionByMaxWaterConsumptionId")
    public Collection<Noozle> getNoozleById() {
        return noozleById;
    }

    public void setNoozleById(Collection<Noozle> noozleById) {
        this.noozleById = noozleById;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaxWaterConsumption that = (MaxWaterConsumption) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(time, that.time) &&
                Objects.equals(power, that.power) &&
                Objects.equals(litres, that.litres);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, time, power, litres);
    }

    @Override
    public String toString() {
        return "MaxWaterConsumption{" +
                "id=" + id +
                ", time='" + time + '\'' +
                ", power='" + power + '\'' +
                ", litres='" + litres + '\'' +
                '}';
    }
}
